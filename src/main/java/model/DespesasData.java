
package model;

import controll.DespesasBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.HomeScrem;






public class DespesasData {
    
    
    
    
    private Connection conn = null ;
    private PreparedStatement pst = null;    
    private ResultSet rs = null ;
    private String sql ;
    
    private final ArrayList<String> listFonte      = new ArrayList<String>();
    private final ArrayList<String> listCategorias = new ArrayList<String>();
    private final ArrayList<String> listTipo       = new ArrayList<String>();
    
    Dao dao = new Dao(); 
    
    
   // HomeScrem home;
    
    
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
    
    
    
    
    public void selectSaldo(DespesasBeans db){
       
        sql = " select \n" +
              "( select sum(valor_ent) from tb_entradas) - \n" +
              "( select sum(valor_dep) from tb_despesas where forma_pgto_dep ='especie' )\n" +
              " as saldo ";  
        
        try{
            conn = dao.getConn();
            pst = conn.prepareStatement(sql);
            rs  = pst.executeQuery();
            
              if(rs.next()){
                  
                   db.setSaldo(rs.getBigDecimal("saldo"));
              }
            
        }catch(Exception ex){
           
            throw new RuntimeException("ERRO no metodo selectDespesas "+ex.getMessage(),ex);
           
       }finally{
               
              dao.closeConnPstRs(conn , pst , rs);   
        }
        
    }
    
    
    
    
    
   
    public List<DespesasBeans> selectDespesas(DespesasBeans db){
        
        sql = "select * from tb_despesas where year(dataf_dep)=? and month(dataf_dep)=? order by dataf_dep ";
               
        ArrayList <DespesasBeans> listDespesas = new ArrayList<>();
        
       try{
           
         conn = dao.getConn();
         pst  = conn.prepareStatement(sql);
         
         pst.setInt(1, db.getYear());
         pst.setInt(2, db.getMonth());
         
         rs   = pst.executeQuery();
                    
         
         while(rs.next()){
             
             db = new DespesasBeans();
             
             db.setId(rs.getInt("id_dep"));
             db.setData(rs.getString("data_dep"));
             db.setDataF(rs.getString("dataf_dep"));
             db.setFonte(rs.getString("fonte_dep"));
             db.setCategoria(rs.getString("categoria_dep"));
             db.setTipo(rs.getString("tipo_dep"));
             db.setFormaPgto(rs.getString("forma_pgto_dep"));
             db.setContaPgto(rs.getString("conta_pgto_dep"));
             db.setAddConta(rs.getBoolean("add_dep"));
             db.setComents(rs.getString("comentarios_dep"));             
             db.setValor(rs.getBigDecimal("valor_dep"));
             db.setTotal(rs.getBigDecimal("total_dep"));
             
             listDespesas.add(db);
         }
           
       }catch(Exception ex){
           
           throw new RuntimeException("ERRO no metodo selectDespesas "+ex.getMessage(),ex);
           
       }finally{
            
           dao.closeConnPstRs(conn , pst , rs);
       }
        
         return listDespesas ;
    }
  
    
    
    
    
    
    public void insertDespesas(DespesasBeans db){
        
       sql = "call pro_lancar_despesas(?,?,?,?,?,?,?,?,?,?,?)";
       
          try{
              conn = dao.getConn();
              pst  = conn.prepareStatement(sql);
              
              pst.setString(1,db.getData() );        
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
                  System.out.println(db.getCategoria()+" no valor de R$ "+db.getValor()+" lançamento com sucesso! "); 
                   JOptionPane.showMessageDialog(null, " despesas no valor de R$ "+db.getValor()+" referente a "+db.getTipo()+" lançado com sucesso!");
              }else{
                  System.out.println(" error ao lancar despesas  "); 
                 }
                  
            }catch(Exception ex){
              throw new RuntimeException("error no metodo insertDespeas"+ex.getMessage(),ex); 
          }finally{
                dao.closeConnPst(conn , pst);
       }
       
    }

      
    
    
    
    
    
        public void listFonte(DespesasBeans db){
            sql = "select distinct fonte_dep from tb_despesas"; 
            
            try{
              
                 conn = dao.getConn();
                 pst = conn.prepareStatement(sql);
                 rs = pst.executeQuery();
                 
                   while (rs.next()){
                     listFonte.add(rs.getString(1));
                   }
                
                                       
            }catch(Exception ex){
               
                 throw new RuntimeException("error no metodo listCategorias "+ex.getMessage(),ex);  
                 
            }finally{
                
                dao.closeConnPstRs(conn, pst, rs);
            }
            
               db.setListFonte(listFonte);
        }    
    
     
    
        
        
     
     
        // public ArrayList  listCategorias(){
             public void  listCategorias(DespesasBeans db){
          sql = "select distinct categoria_dep from tb_despesas";   
             
            try{
               conn = dao.getConn();
               pst  = conn.prepareStatement(sql);
               rs   = pst.executeQuery();
               
                 while (rs.next()){
                   listCategorias.add(rs.getString(1));
                 }
                
            }catch(Exception ex){
               
                 throw new RuntimeException("error no metodo listCategorias "+ex.getMessage(),ex);  
                 
            }finally{
                
                dao.closeConnPstRs(conn, pst, rs);
            }
          
          
             // return list; 
             
             db.setListCategorias(listCategorias);
         }
    
    
    
    
       
             public void listTipo(DespesasBeans db){
                 sql = "select distinct tipo_dep from tb_despesas where categoria_dep = ?  ";  
                 
                 try{
                     conn = dao.getConn();
                     pst = conn.prepareStatement(sql);
                     pst.setString(1, db.getCategoria());
                     rs = pst.executeQuery();
                     
                      while (rs.next()){
                         listTipo.add(rs.getString(1)); 
                      }
                      
                 }catch(Exception ex){
               
                 throw new RuntimeException("error no metodo listCategorias "+ex.getMessage(),ex);  
                 
            }finally{
                
                dao.closeConnPstRs(conn, pst, rs);
            }
                 
               db.setListTipo(listTipo);
       }
     
    
    
    
    
    
}
