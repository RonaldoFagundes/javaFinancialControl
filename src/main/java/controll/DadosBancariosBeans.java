
package controll;

import java.math.BigDecimal;

/**
 *
 * @author RFagundes
 */
public class DadosBancariosBeans {
    
   private int idConta; 
   private String instituicao;
   private String conta;
   private String coments;  
   private BigDecimal saldo;

   
   
   
   
    public int getIdConta() {
        return idConta;
    }

    
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

   
   
    
   
   
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    
    
    
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    
    
    
    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

   
    
    
    
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
   
   
      
}
