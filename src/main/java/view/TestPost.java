
package view;

import controll.DespesasBeans;
import java.math.BigDecimal;
import model.DespesasData;





public class TestPost {
    
    
    private String data;
    private String dataF;    
    private String fonte;
    private String categoria;
    private String tipo;
    private String formaPgto;
    private String contaPgto;
    private boolean addConta;    
    private String coments;
    private BigDecimal valor;
    private BigDecimal total;
    
    
      DespesasBeans db = new DespesasBeans();
      DespesasData  dd = new DespesasData();
    
    
    
      public void lancarDespesa(){
          
          
          
          data  = "15/06/2023" ;
          dataF = "2023-06-15";
          fonte = "";
          categoria = "Transporte";
          tipo = "Condução";
          formaPgto = "especie";
          contaPgto = "0";
          addConta = false;
          coments = "SP Sto amaroXBarra Funda";
          valor = new BigDecimal(4.40);
          total = new BigDecimal(0.00);
            
          
          
          
          
          db.setData(data);
          db.setDataF(dataF);
          db.setFonte(fonte);
          db.setCategoria(categoria);
          db.setTipo(tipo);
          db.setFormaPgto(formaPgto);
          db.setContaPgto(contaPgto);
          db.setAddConta(addConta);
          db.setComents(coments);
          db.setValor(valor);
          db.setTotal(total);
          dd.insertDespesas(db);
          
      }
}
