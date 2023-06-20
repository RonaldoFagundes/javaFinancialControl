
package model;

import java.sql.Connection;
import java.sql.DriverManager;



public class Dao {

 private Connection conn = null ;

 private final String DRIVER = "com.mysql.cj.jdbc.Driver";
 private final String DB     = "db_banco_eletronico";
 private final String URL    = "jdbc:mysql://localhost:3306/"+DB+"?useTimezone=true&serverTimezone=UTC";
 public  final String USER   = "";
 public  final String PASS   = "";
 
    
    public Connection getConnect(){
        
        try{          
            Class.forName(DRIVER);            
            return DriverManager.getConnection(URL, USER, PASS);            
        }catch(Exception ex){
            System.out.println(" get connect error "+ex);            
            return null;
        }        
      
    }
    
        
    
    public void closeConnect(Connection conn){
       
         try{
             if (conn != null){
               conn.close();
               System.out.println(" close connect db "+DB+" success!!  ");
              }
         }catch(Exception ex){             
              System.out.println(" close connect db "+DB+" error "+ex);             
         }
        
     }    
    
    
    
    
    
    
}
