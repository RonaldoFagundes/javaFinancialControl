package model;

import controll.CartaoCreditoBeans;
import controll.DadosBancariosBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;




public class CartaoCreditoData {
    
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null ; 
    private String sql ;
    
    
     Dao dao = new Dao();
    
     
     private ArrayList<String> listConta = new ArrayList<String>();  
   
     
    
    public void getIdRegisterCartao(CartaoCreditoBeans ccb ){
        
     sql = "select id_rcc from tb_register_cartao_credito where numero_rcc = ?" ;

        try{
          conn = dao.getConn();
          pst = conn.prepareStatement(sql);
          
          pst.setString(1, ccb.getNumero());
          
          rs = pst.executeQuery();
          
           if(rs.next()){
               
               ccb.setIdCartao(rs.getInt("id_rcc"));
           }else{
               
               System.out.println(" id Conta não encontrado! "); 
           }
            
        }catch(Exception ex){
            
         throw new RuntimeException("error no metodo getIdRegisterConta  "+ex.getMessage(),ex);
      
        }finally{
             dao.closeConnPstRs(conn , pst , rs);
         }
    }
     
 
    
    
     
     
     
     
    
     
     public void listConta (CartaoCreditoBeans ccb){
      
         sql = "select distinct numero_cc from tb_cartao_credito";
         
         try{
             
            conn = dao.getConn();
            pst  = conn.prepareStatement(sql);
            rs   = pst.executeQuery();
             
             while(rs.next()){
                
                 listConta.add(rs.getString(1));
             }
            
            
         }catch(Exception ex){
             
             throw new RuntimeException("error no metodo listConta  "+ex.getMessage(),ex);
         }
         
            ccb.setListConta(listConta);
     }
     
     
     
     
     
     
     
    
    
    public void selectTotal(CartaoCreditoBeans ccb){
 
    sql = "select sum(valor_cc) as total from tb_cartao_credito where year(data_vencimento_cc) = ?  &&  month(data_vencimento_cc) = ? && numero_cc = ?  ";
      
        try{
            
          conn = dao.getConn();
          pst  = conn.prepareStatement(sql);
           
          pst.setInt(1,ccb.getYear());
          pst.setInt(2,ccb.getMonth());
          pst.setString(3, ccb.getNumero());
          
          rs   = pst.executeQuery();
          
             if (rs.next()){
                 
               ccb.setTotal(rs.getBigDecimal("total"));
               
             } else {
                
                 System.out.println(" error no metodo select total "); 
             }
            
            
        }catch(Exception ex){
          throw new RuntimeException("error no metodo insertCartaoCredito  "+ex.getMessage(),ex);
      
        }finally{
             dao.closeConnPstRs(conn , pst , rs);
         }
        
    }
    
            
    
    
    
    
    
            
  
    public void insertCartaoCredito(CartaoCreditoBeans ccb){
        
        sql = "call  pro_cartao_credito  ( ?, ?, ?, ?, ?, ?, ?)"; 
         
         try{
           conn = dao.getConn();
           pst  = conn.prepareStatement(sql);
           
           pst.setString(1, ccb.getNumero());
           pst.setBigDecimal(2, ccb.getValor());
           pst.setString(3,ccb.getDespesa());
           pst.setString(4, ccb.getComents());
           pst.setString(5,ccb.getData());
           
            if (ccb.getIDdesp() == 0){
                 pst.setNull(6, 0);
            }else {
                pst.setInt(6, ccb.getIDdesp());
            }
            
           pst.setInt(7, ccb.getIdCartao());
           
          
           
           if ( pst.execute() ){
             // System.out.println(ccb.getDespesa()+" no valor de R$ "+ccb.getValor()+" lançado com sucesso");
             JOptionPane.showMessageDialog(null, " despesas no valor de R$ "+ccb.getValor()+" referente a "+ccb.getDespesa()+" lançado com sucesso!");
           }else{
              System.out.println(" error ao lancar cc  "); 
           }             
         }catch(Exception ex){
             throw new RuntimeException("error no metodo insertCartaoCredito  "+ex.getMessage(),ex);
         }finally{
             dao.closeConnPst(conn , pst);
         }
     
    }
    
 
    
    
    
    
}
