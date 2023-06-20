
package model;

import controll.DespesasBeans;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/*
import java.util.List;
import java.util.Arrays;
import java.math.BigDecimal;
import java.util.Date;
*/




public class DespesasData {
    
    
    private Connection conn = null ;
    private PreparedStatement pst = null;
    
    
    private String sql ;
    
    
    Dao dao = new Dao(); 
    
    
    
    
    /*
    private String categoria ;
    private String tipo ;
    private String comentarios ;
    private Date data;
    private BigDecimal valor;    
    private List <String> dataDespesas ;
      
    DespesasBeans despesas = new DespesasBeans();   
  
    public void postData(){        
     despesas.setCategoria("Alimentação");
     despesas.setTipo("Mercado");
     despesas.setComentarios("guanabara piedade");
     despesas.setData( new Date());
     despesas.setValor(new BigDecimal (47.98) );     
     }
    
    
    public List<String> getData(){        
     categoria = despesas.getCategoria();
     tipo = despesas.getTipo();
     comentarios = despesas.getComentarios();        
     dataDespesas =  Arrays.asList(categoria,tipo,comentarios);            
       return dataDespesas;
    } 
     
    public BigDecimal getValor(){
        return  valor = despesas.getValor();
    }
    
    public Date getDataDespesa(){
      return   data = despesas.getData();
    }
    */
    
    
    
    
    
    
    public void insertDespesas(DespesasBeans db){
        
       sql = "call pro_lancar_despesas(?,?,?,?,?,?,?,?,?,?,?)";
       
          try{
              conn = dao.getConnect();
              pst  = conn.prepareStatement(sql);
              
              pst.setString(1,db.getData());        
              pst.setString(2,db.getDataF());
              pst.setString(3,db.getFonte());
              pst.setString(4,db.getCategoria());
              pst.setString(5,db.getTipo());
              pst.setString(6,db.getFormaPgto());
              pst.setString(7,db.getContaPgto());
              pst.setBoolean(8, db.getAddConta());
              pst.setString(9,db.getComents());
              pst.setBigDecimal(10, db.getValor());
              pst.setBigDecimal(11, db.getTotal());                       
              
                  if(pst.execute()){
                      System.out.println(" lançamento ok "); 
                    }else{
                      System.out.println(" erro de lançamento  "); 
                    }
                  
            }catch(Exception ex){
              throw new RuntimeException("ERRO ao lançar despesa "+ex.getMessage(),ex); 
          }finally{
                dao.closeConnect(conn);
       }
       
    }
    
    
    
    
    
    
    
}
