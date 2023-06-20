
package controll;

import java.math.BigDecimal;
import java.util.Date;


public class DespesasBeans {
    
    
    private int id ;
    private String fonte;
    private String categoria;
    private String tipo;
    private String formaPgto;
    private String coments;
    private String contaPgto;
    private BigDecimal valor;
    private BigDecimal total;
    private String data;
    private String dataF;
    private boolean addConta;

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
    public boolean getAddConta() {
        return addConta;
    }

    public void setAddConta(boolean addConta) {
        this.addConta = addConta;
    }
    
    
    
    
    
    

    
    
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

           
    
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    
    
    public String getFonte() {
        return fonte;
    }    
    
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    
    
      
    
    
    
    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    
    
    
    
    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    
    
    
    public String getContaPgto() {
        return contaPgto;
    }

    public void setContaPgto(String contaPgto) {
        this.contaPgto = contaPgto;
    }

    
    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

       
    
    
    
    public String getComentarios() {
        return coments;
    }

    public void setComentarios(String coments) {
        this.coments = coments;
    }

    
    
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
    
    
    
    
    
    
    
}
