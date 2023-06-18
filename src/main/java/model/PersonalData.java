
package model;

import controll.PersonalBeans;


public class PersonalData {
   
   
    PersonalBeans pb = new PersonalBeans();
    
      private String id;
      private String user; 
    
    
      
      
      
        public String logar (){
            
            pb.setId("nu7894321mJ");
            pb.setName("Nikola Tesla");
            
            id = pb.getId();
            user = pb.getName();
            
            return " id nº = "+id+" user name = "+user;
        }
        
        
        
        
        
        
    
}
