
package view;

import controll.CartaoCreditoBeans;
import controll.DespesasBeans;
import java.math.BigDecimal;
import model.CartaoCreditoData;
import model.DespesasData;





public class TestPost {
    
    
    
    // variaveis de despesas
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
    
    // instancias de despesas
      DespesasBeans db = new DespesasBeans();
      DespesasData  dd = new DespesasData();
      
      
      
    // variaveis de cc
    private String contaNumero;
    private String despesas;
    private int id_despesa ;
    private int id_conta ;
      
     // instancias de cc
      CartaoCreditoBeans ccb = new CartaoCreditoBeans();
      CartaoCreditoData  ccd = new CartaoCreditoData();
    
      
      
      /*
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
                       
        //  db.setData(data);
       //   db.setDataF(dataF);
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
      */
      
      
      
      
      /*
         public void lancarCC(){ 
          
          contaNumero = "8831";
          valor = new BigDecimal(99.99);
          despesas  = "Neyde" ;
          coments = "Globo-play";          
          dataF = "2023-06-15";
          id_despesa = 0;
          id_conta = 1;
                   
          ccb.setNumero("8831");
          ccb.setValor(valor);
          ccb.setDespesa(despesas);
          ccb.setComents(coments);
          ccb.setData(dataF);
          ccb.setId_desp(id_despesa);
          ccb.setId_conta(id_conta);
          ccd.insertCartaoCredito(ccb);                
          
      }
       */
      
      
      
      
      
}
