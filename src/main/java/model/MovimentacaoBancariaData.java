
package model;

import controll.MovimentacaoBancariaBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RFagundes
 */


public class MovimentacaoBancariaData {
    
    private Connection conn = null ;
    private PreparedStatement pst = null;    
    private ResultSet rs = null ;
    private String sql ;
    
    Dao dao = new Dao();
    
    
    private ArrayList<String> listConta = new ArrayList<String>(); 
    
    
    
    
    public void listContas ( MovimentacaoBancariaBeans mbb ){
        
        sql = "select distinct numero_cnt from tb_contas where status_cnt = 'Ativa' && tipo_cnt = 'Conta Corrente' || tipo_cnt = 'poupanca' " ;
        
        
        try{
          
            conn = dao.getConn();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
             
                listConta.add(rs.getString(1));
            }
            
        }catch(Exception ex){
          
           throw new RuntimeException("error no metodo insertSaque "+ex.getMessage(),ex);
           
        }finally{
        
             dao.closeConnPstRs(conn , pst, rs);
       }
        
        
         mbb.setListConta(listConta);
        
    }
    
    
    
    
    
    
    public void selectSaldoContaBancaria( MovimentacaoBancariaBeans mbb ){
      
        sql ="select saldo_cnt as saldo from tb_contas where numero_cnt = ? ";
        
        
        try{
            
            
        conn = dao.getConn();
        
        pst = conn.prepareStatement(sql);
        
        pst.setString(1,mbb.getContaN());
        
        rs = pst.executeQuery();
        
          if(rs.next()){
              
            mbb.setSaldo(rs.getBigDecimal("saldo"));
              
            }
         
         }catch(Exception ex){
            
           throw new RuntimeException("error no metodo insertSaque "+ex.getMessage(),ex); 
       
      }finally{
            dao.closeConnPstRs(conn , pst, rs);
    }
        
        
 }
    
    
    
   
    public void selectIdConta(MovimentacaoBancariaBeans mbb){

        sql = "select id_cnt from tb_contas where numero_cnt = ? ";

        try{
          conn = dao.getConn();
          pst = conn.prepareStatement(sql);
          pst.setString(1,mbb.getContaN());
          
         rs = pst.executeQuery();
        
         
          if(rs.next()){
              
              mbb.setIdConta(rs.getInt("id_cnt"));
           }
            
         }catch(Exception ex){
            
          throw new RuntimeException("error no metodo insertSaque "+ex.getMessage(),ex); 
       
      }finally{
            dao.closeConnPstRs(conn , pst , rs);
    }
        
 }
    
    
    
    
    
    
    
    
    public void insertSaque (MovimentacaoBancariaBeans mbb){
    
        sql = "call pro_sacar (?, ?, ?, ?, ? ,? )";
        
         try{
           conn = dao.getConn();
           pst = conn.prepareStatement(sql);
           
           pst.setBigDecimal(1, mbb.getValor());
           pst.setString(2, mbb.getComents());
           pst.setString(3, mbb.getData());
           pst.setString(4, mbb.getDataF() );
           pst.setString(5, mbb.getPlace());
           pst.setInt(6, mbb.getIdConta());
           
            if(pst.execute()) {
                
                JOptionPane.showMessageDialog(null, " saque no valor de R$ "+mbb.getValor()+
                        " na conta nº "+mbb.getContaN()+" lançado com sucesso !! ");
              }else{
                
                JOptionPane.showMessageDialog(null, " erro ao realizar saque entre em contato com suporte! ");
            }
                
            
           
        }catch(Exception ex){
            
         throw new RuntimeException("error no metodo insertSaque "+ex.getMessage(),ex); 
       
         }finally{
            dao.closeConnPst(conn , pst);
        }
        
        
        
    }
    
    
    
    
    
    
    
    
}
