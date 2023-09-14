
package controll;

import java.math.BigDecimal;
import java.util.ArrayList;

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
    private BigDecimal saldo;
    private BigDecimal total;
    private String data;
    private String dataF;
    private int year;
    private int month;
    private boolean addConta;
    
    private ArrayList<String> listFonte     = new ArrayList<String>();
    private ArrayList<String> listCategoria = new ArrayList<String>() ;
    private ArrayList<String> listTipo      = new ArrayList<String>();
   
    
    
    /*
    public DespesasBeans(int id, String fonte, String categoria, String tipo, String formaPgto, String coments, String contaPgto, BigDecimal valor, BigDecimal total, String data, String dataF, boolean addConta) {
        this.id = id;
        this.fonte = fonte;
        this.categoria = categoria;
        this.tipo = tipo;
        this.formaPgto = formaPgto;
        this.coments = coments;
        this.contaPgto = contaPgto;
        this.valor = valor;
        this.total = total;
        this.data = data;
        this.dataF = dataF;
        this.addConta = addConta;
    }
     */
    
    
    public DespesasBeans(){}
    
    
     public void setListFonte(ArrayList listFonte){
        this.listFonte = listFonte;        
    }
    
    public ArrayList getListFonte(){
        return this.listFonte;
    }
    
    public void setListCategorias(ArrayList listCategoria){
        this.listCategoria = listCategoria;
    }
    
    public ArrayList getListCategorias(){
        return this.listCategoria;
    } 
    
    
    public void setListTipo(ArrayList listTipo){
        this.listTipo = listTipo;        
    }
    
    public ArrayList getListTipo(){
        return this.listTipo;
    }
    
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
    
    
    
    
    public String getDataF() {
        return dataF;
    }

    public void setDataF(String dataF) {
        this.dataF = dataF;
    }
    
    
    
    
    
     public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
    
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    
    
    
    
      public String getFonte() {
        return fonte;
    }    
    
    public void setFonte(String fonte) {
        this.fonte = fonte;
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

    
    
    
    
    
    
    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    
    
    
     public boolean getAddConta() {
        return addConta;
    }

    public void setAddConta(boolean addConta) {
        this.addConta = addConta;
    }
    
    
    
    
      public String getContaPgto() {
        return contaPgto;
    }

      
    public void setContaPgto(String contaPgto) {
        this.contaPgto = contaPgto;
    }

    
    
    
    
    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    
    
    
  
    
    
    
   /* 
    public String getComentarios() {
        return coments;
    }

    public void setComentarios(String coments) {
        this.coments = coments;
    }
    */
    
    
    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
    
    
    
    
    
    
   
    
    
    
    
    
    
}
