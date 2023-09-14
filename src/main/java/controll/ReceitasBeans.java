
package controll;

import java.math.BigDecimal;

/**
 *
 * @author RFagundes
 */



public class ReceitasBeans {
    
    private int id ;
    
    private String data   ;
    private String fonte  ;
    private BigDecimal valor ;
    private String formaPgto  ;
    private String conta  ;
    private String tipo  ;       
    private String coments ;

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    

    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }
    
    
   
   
    
    
    
    public void setFonte(String fonte){
        this.fonte = fonte;
    }
    
    public String getFonte(){
        return this.fonte;
    }
    
    
    
    
}
