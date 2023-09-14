
package javaFinancialControl;

import controll.DespesasBeans;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import model.Dao;
import model.DespesasData;
import view.HomeScrem;
import view.TestPost;



public class App {
    
    
    
    static HomeScrem home = new HomeScrem();
    
  //  static Connection conn = null ;
    
    
   /*
     public void getGreeting() {
       home.setVisible(true);      
    }
   */
    
    
    public static void main(String[] args) {
        
        //System.out.println(new App().getGreeting());        
        // new App().getGreeting();
        
        
         home.setVisible(true);        
        
        
        
        /*
         DespesasBeans db = new DespesasBeans();
         DespesasData  dd = new DespesasData();
         
         
         dd.selectSaldo(db);
          System.out.println("saldo "+db.getSaldo());
          
          
         
         
       
         List <DespesasBeans> dbl = dd.selectDespesas(db,2023,7);
                 
                 
         for ( DespesasBeans dep : dbl )  {
            
             System.out.println(" --------------------------------- ");
             
             System.out.println(" id : "+dep.getId());
             System.out.println(" data : "+dep.getData());
             System.out.println(" dataF : "+dep.getDataF());
             System.out.println(" fonte : "+dep.getFonte());
             System.out.println(" categoria : "+dep.getCategoria());
             System.out.println(" tipo  : "+dep.getTipo());
             System.out.println(" formaPgto : "+dep.getFormaPgto());
             System.out.println(" conta  : "+dep.getContaPgto());
             System.out.println(" addConta : "+dep.getAddConta());
             System.out.println(" valor R$  : "+dep.getValor());
             System.out.println(" coments R$  : "+dep.getComents());
             System.out.println(" total R$  : "+dep.getTotal());
             
             System.out.println(" --------------------------------- ");
           
        } 
                     
           System.out.println(" total de posts  "+dbl.size());   
          
         */
         
        
        /*
        teste connect
        Dao dao = new Dao();
        conn = dao.getConnect();
        if (conn != null ){
        System.out.println(" conexão estabelicida retorno "+conn);
        dao.closeConnect(conn);
        }else{
        System.out.println(" erro ao conectar ");
        }
         */ 
        
        
        /*
        DespesasData despesas = new DespesasData();
        despesas.postData();
        despesas.getData().stream().forEach(System.out::println);
        System.out.println(" data "+despesas.getDataDespesa()+" valor  R$ "+despesas.getValor());
         */ 
        
        
        // TestPost start = new TestPost();
        //lançar despesas
        // start.lancarDespesa();
        //lançar cc
        //start.lancarCC();
          
          
          
    }
    
    
    
}
