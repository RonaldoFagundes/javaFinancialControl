
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Dao {

 private Connection conn = null ;

 private final String DRIVER = "com.mysql.cj.jdbc.Driver";
 private final String DB     = "";
 private final String URL    = "jdbc:mysql://localhost:3306/"+DB+"?useTimezone=true&serverTimezone=UTC";
 public  final String USER   = "";
 public  final String PASS   = "";
 
    
 
    public Connection getConn(){
        
        try{          
            Class.forName(DRIVER);            
            return DriverManager.getConnection(URL, USER, PASS);            
        }catch(Exception ex){
            System.out.println(" get connect error "+ex);            
            return null;
        }        
      
    }
    
        
    
    public void closeConn(Connection conn){
       
         try{
             if (conn != null){
               conn.close();
               System.out.println(" close connect db "+DB+" closed success!!  ");
              }
         }catch(Exception ex){             
              System.out.println(" close connect db "+DB+" error "+ex);             
         }
        
     }   
    
    
    
    public void closeConnPst(Connection conn, PreparedStatement pst){
       
         try{
             if (conn != null){
               conn.close();
               System.out.println(" close connect db "+DB+" closed success!!  ");
              }
             
             if(pst != null){
               pst.close();
               System.out.println(" pst db "+DB+" closed success!!  ");
            }
             
         }catch(Exception ex){             
              System.out.println(" close connect db/pst "+DB+" error "+ex);             
         }
        
     }    
    
    
    
    
    public void closeConnPstRs(Connection conn, PreparedStatement pst, ResultSet rs){
       
         try{
             if (conn != null){
               conn.close();
               System.out.println(" close connect db "+DB+" closed success!!  ");
              }
             
             if(pst != null){
               pst.close();
               System.out.println(" pst db "+DB+" closed success!!  ");
            }
             
              if(rs != null){
               rs.close();
               System.out.println(" rs db "+DB+" closed success!!  ");
            }
             
         }catch(Exception ex){             
              System.out.println(" close connect db/pst/rs "+DB+" error "+ex);             
         }
        
     }    
    
    
    
    
    
    
}
