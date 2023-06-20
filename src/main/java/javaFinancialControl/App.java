
package javaFinancialControl;

import java.sql.Connection;
import model.Dao;
import model.DespesasData;
import view.HomeScrem;
import view.TestPost;



public class App {
    
    
    
    static HomeScrem home = new HomeScrem();
    
    static Connection conn = null ;
    
    
   /*
     public void getGreeting() {
       home.setVisible(true);      
    }
   */
    
    
    public static void main(String[] args) {
        
        //System.out.println(new App().getGreeting());        
        // new App().getGreeting();
        
        // home.setVisible(true);        
        
                
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
          
          
          
          TestPost start = new TestPost();
          start.lancarDespesa();         
          
    }
    
    
    
}
