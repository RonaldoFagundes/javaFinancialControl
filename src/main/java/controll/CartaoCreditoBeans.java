package controll;

import java.math.BigDecimal;
import java.util.ArrayList;




public class CartaoCreditoBeans {
    
    
    
    private String numero ;
    private BigDecimal valor ;
    private String despesa ;
    private String coments ;
    private String data ;
    private int idDesp;
    private int idCartao;
    private BigDecimal total ;
    private int month ;
    private int year ;

    private ArrayList<String> listConta = new ArrayList<String>();  

    
    
    
    
    public int getIdDesp() {
        return idDesp;
    }

    public void setIdDesp(int idDesp) {
        this.idDesp = idDesp;
    }

    
    
    
    
    public ArrayList<String> getListConta() {
        return listConta;
    }

    public void setListConta(ArrayList<String> listConta) {
        this.listConta = listConta;
    }
    
    

    
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    
    
    
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
    
    
    
    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
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

    
    
    
    public int getIDdesp() {
        return idDesp;
    }

    public void setIDdesp(int idDesp) {
        this.idDesp = idDesp;
    }
    
    
    
    

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }
    
    
    
    
    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
    
     public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
