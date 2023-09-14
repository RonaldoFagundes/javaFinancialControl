package controll;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author RFagundes
 */


public class MovimentacaoBancariaBeans {
      
       private BigDecimal valor ;
       private String coments;
       private String data;
       private String dataF;
       private String place;
       private int idConta;
       private String contaN ; 
       private BigDecimal saldo;

   
       private ArrayList<String>  listConta = new ArrayList<String>();
  
   
       
       
   
   public void setListConta(ArrayList listConta){
       this.listConta = listConta;
   }
    
   public  ArrayList getListConta(){
     return this.listConta;
   }  
   
   
    public BigDecimal getValor() {
        return valor;
    }

    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    
   
    
     public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    
    
    
    
    
    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    
    
    
      public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
    public String getDataF() {
        return dataF;
    }

    public void setDataF(String dataF) {
        this.dataF = dataF;
    }

    
    
    
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    
    
   public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
       
    
       
      public String getContaN() {
        return contaN;
    }

    public void setContaN(String contaN) {
        this.contaN = contaN;
    }
    
       
}
