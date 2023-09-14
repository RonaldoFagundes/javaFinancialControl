package model;

import controll.ReceitasBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author RFagundes
 */



public class ReceitasData {
   
    
    
  private  Connection conn ;
  private  PreparedStatement pst;
  private  ResultSet rs ;
  private  String sql ;

  Dao dao = new Dao();
    
    
  
  
    
  
    public void insertEntradas(ReceitasBeans rb){
       
       sql = "call pro_devolucao (?,?,?,?,?,?,?)"; 
        
        try{
           
           conn = dao.getConn();
           pst = conn.prepareStatement(sql);
           
           pst.setString(1, rb.getData());
           pst.setString(2, rb.getFonte());
           pst.setBigDecimal(3, rb.getValor());
           pst.setString(4, rb.getFormaPgto());
           pst.setString(5, rb.getConta());
           pst.setString(6, rb.getTipo());
           pst.setString(7, rb.getComents());
          
            if ( pst.execute() ) {
               JOptionPane.showMessageDialog(null, " entradas no valor de R$ "+rb.getValor()+" referente a "+rb.getTipo()+" lançado com sucesso!"); 
            }else {
                System.out.println(" error ao lancar entradas  "); 
            }
            
          }catch(Exception ex){
            throw new RuntimeException("ERRO no metodo insertEntradas "+ex.getMessage(),ex);
        }finally{
           dao.closeConnPst(conn, pst);
      }
         
   }
    
    
    
    
    
    
    
    
    
}
