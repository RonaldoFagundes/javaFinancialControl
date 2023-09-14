
package view;

import controll.CartaoCreditoBeans;
import controll.DespesasBeans;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.CartaoCreditoData;
import model.DespesasData;

/**
 *
 * @author RFagundes
 */





public class CartaoCreditoScreen extends javax.swing.JFrame {

   
    
    
    private String  dataBRL , dtf , cartaoN , fonte , tipo , categoria, formaPgto,  coments , transation  ;
    
    private int year , month , idCartao , idDesp ;
    
    private BigDecimal valor = new BigDecimal(0.00);    
    
    private BigDecimal total = new BigDecimal(0.00); 
    
    private LocalDate dataF ; 
     
    private DateTimeFormatter formatDB = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    
    CartaoCreditoBeans  ccb  ;
    CartaoCreditoData   ccd  ;
            
    DespesasBeans db ;
    DespesasData dd ;
    
    HomeScrem home ;
    
    private ArrayList<String> listCartao     = new ArrayList<String>(); 
    private ArrayList<String> listTipo       = new ArrayList<String>();
    private ArrayList<String> listCategorias = new ArrayList<String>();
    private ArrayList<String> listFonte      = new ArrayList<String>();
    
    
    
    
     public CartaoCreditoScreen() {
        initComponents();
        startCbx();
      }
     
     
     
     
     
     private void showTotal(){
         
         ccb = new CartaoCreditoBeans();
         ccd = new CartaoCreditoData();
         
         dataBRL   = txtDate.getText();
          
         cartaoN = ((String)cbxCartao.getSelectedItem());
         
         try{
           
            dataF = LocalDate.parse(dataBRL, formatDB);
            
            }catch(Exception ex){             
                System.out.println("error"+ex);           
         }
        
         
            year  = dataF.getYear();
            month = dataF.getMonthValue() + 1;           
            
            ccb.setNumero(cartaoN);
            ccb.setYear(year);
            ccb.setMonth(month);   
            ccd.selectTotal(ccb);
            
            total = ccb.getTotal();
            
             if (total == null){
                txtTotal.setText(" R$ "+0.00 ); 
             }else {
               txtTotal.setText(" R$ "+total);  
             }
            
      }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     private void validation(){
         
         ccb = new CartaoCreditoBeans();
         ccd = new CartaoCreditoData();
         
        dataBRL   = txtDate.getText();
        cartaoN   = ((String)cbxCartao.getSelectedItem());
        tipo      = ((String)cbxTipo.getSelectedItem());
        fonte     = ((String)cbxFonte.getSelectedItem());
        categoria = ((String)cbxCategoria.getSelectedItem());
        
         
           if ( 
                dataBRL.isEmpty()              ||                 
                cartaoN.contains("Cartao nº:") ||                
               // tipo.contains("Tipo:")         ||               
                txtValor.getText().isEmpty()   ||
                transation.isEmpty()
             ){
                  
             JOptionPane.showMessageDialog(null, "Preencha os campos necessarios !!!"); 
             
             
                 if(transation == "pessoal"){
                     
                     
                     
                    if( fonte.contains("Fonte:") || categoria.contains("Categoria:") ){
                         
                       JOptionPane.showMessageDialog(null, "Preencha os campos para lançamento pessoal!!!"); 
                        
                     }
                 }
              
                 
                 
                 
           }else {
                 
               
             try{
           
              dataF = LocalDate.parse(dataBRL, formatDB);
              valor = new BigDecimal (txtValor.getText().replace(",", "."));
            
              }catch(Exception ex){             
                System.out.println("error"+ex);           
            }
                     
            year  = dataF.getYear();
            month = dataF.getMonthValue();           
            
            ccb.setYear(year);
            ccb.setMonth(month);        
            
           // ccd.selectTotal(ccb);         
           // total = ccb.getTotal();            
           // txtTotal.setText(" R$ "+total.toString());
            
            btnPost.setEnabled(true);
            
            System.out.println(" mês "+ccb.getMonth()+"  ano "+ccb.getYear() ); 
            
            
      }
           
  }
    
    
     
     
      private void startCbx(){
          
          cbxFonte.setEnabled(true);
          cbxCategoria.setEnabled(true);
          cbxTipo.setEnabled(true);
          
         cbxFonte.removeAllItems();
         cbxFonte.addItem("Fonte:");
         
         cbxCategoria.removeAllItems();
         cbxCategoria.addItem("Categoria:");
         
         cbxTipo.removeAllItems();
         cbxTipo.addItem("Tipo:"); 
         
         cbxCartao.addItem("Cartao nº:");
      }
     
     
     
      
      
    private void lancarCartaoCredito(){
         
         db = new DespesasBeans();
         dd = new DespesasData();
        
         ccb = new CartaoCreditoBeans();
         ccd = new CartaoCreditoData(); 
         
         
          coments = areaComents.getText(); 
          dtf     = dataF.toString();
            
          ccb.setNumero(cartaoN);
          ccd.getIdRegisterCartao(ccb);
             
          idCartao = ccb.getIdCartao();
          
          
          if (transation == "pessoal"){
             
              db.setData(dataBRL);
              db.setDataF(dtf);
              db.setFonte(fonte);
              db.setCategoria(categoria);
              db.setTipo(tipo);
              db.setFormaPgto(formaPgto);
              db.setContaPgto(cartaoN);
              db.setAddConta(false);
              db.setComents(coments);
              db.setValor(valor);       
              db.setTotal(new BigDecimal(0.00));
        
              dd.insertDespesas(db);
       
             System.out.println(                
                " Data "+db.getData()+
                " DataFormat  "+db.getDataF()+
                " Fonte "+db.getFonte()+
                " Categoria "+db.getCategoria()+
                " Tipo "+db.getTipo()+
                " Forma pgto  "+db.getFormaPgto()+
                " Conta nº "+db.getContaPgto()+   
                " add conta "+db.getAddConta() +
                " coments "+db.getComents()+
                " valor "+db.getValor()+
                " total "+db.getTotal()           
                
              );
              
          }else {
              
          ccb.setNumero(cartaoN);
          ccb.setValor(valor);
          ccb.setDespesa(transation);
          ccb.setComents(coments);
          ccb.setData(dtf);
          ccb.setIDdesp(idDesp);
          ccb.setIdCartao(idCartao);
           
          ccd.insertCartaoCredito(ccb);
           
          System.out.println(
                " Conta nº   "+ccb.getNumero()+
                " valor      "+ccb.getValor()+
                " Despesa    "+ccb.getDespesa()+            
                " coments    "+ccb.getComents()+
                " Data       "+ccb.getData()+
                " id despesa "+ccb.getIDdesp()+
                " id conta   "+ccb.getIdCartao()
           );
             
       } 
          
          
          int close = JOptionPane.showConfirmDialog(null," Gostaria de realizar outra transação ? ", "Encerrar", JOptionPane.YES_OPTION);
          
             if (close == JOptionPane.YES_OPTION){
                
                  JOptionPane.showMessageDialog(null, "Continuar lançado ! ");
                  limparCampos();
                  startCbx();                  
                  showTotal();
             }else {
                  limparCampos();
                  startCbx();
                  this.dispose();
                  home = new HomeScrem();
                  home.setVisible(true);
             }    
             
          
          
    }
    
    
    
    
    private void limparCampos(){
       
      txtDate.setText("");
      txtValor.setText("");
      areaComents.setText("");
        
      
    }
    
    
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTransacao = new javax.swing.ButtonGroup();
        panelHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxCartao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaComents = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        btnPost = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        rbPessoal = new javax.swing.JRadioButton();
        rbOutros = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cbxFonte = new javax.swing.JComboBox<>();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHead.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cartão de Credito");

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        cbxCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCartaoMouseClicked(evt);
            }
        });

        areaComents.setColumns(20);
        areaComents.setRows(5);
        areaComents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areaComentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(areaComents);

        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Comentários");

        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("Data");

        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        btnPost.setBackground(new java.awt.Color(0, 51, 51));
        btnPost.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnPost.setForeground(new java.awt.Color(0, 255, 255));
        btnPost.setText("Lançar");
        btnPost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPost.setEnabled(false);
        btnPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPostMouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Valor");

        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Total");

        txtTotal.setBackground(new java.awt.Color(0, 0, 51));
        txtTotal.setForeground(new java.awt.Color(0, 255, 255));

        buttonGroupTransacao.add(rbPessoal);
        rbPessoal.setText("Pessoal");
        rbPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoalActionPerformed(evt);
            }
        });

        buttonGroupTransacao.add(rbOutros);
        rbOutros.setText("Outros");
        rbOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOutrosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Transação");

        cbxFonte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxFonteMouseClicked(evt);
            }
        });

        cbxCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCategoriaMouseClicked(evt);
            }
        });
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        cbxTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxTipoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCartao, 0, 152, Short.MAX_VALUE)
                            .addComponent(txtDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPessoal)
                            .addComponent(rbOutros))
                        .addGap(5, 5, 5)
                        .addComponent(cbxFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelHeadLayout = new javax.swing.GroupLayout(panelHead);
        panelHead.setLayout(panelHeadLayout);
        panelHeadLayout.setHorizontalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelHeadLayout.setVerticalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPostMouseClicked
        lancarCartaoCredito();
    }//GEN-LAST:event_btnPostMouseClicked

    private void areaComentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaComentsMouseClicked
        validation();
    }//GEN-LAST:event_areaComentsMouseClicked

    private void rbPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPessoalActionPerformed
        transation = "pessoal";
        formaPgto  = "Cartao";
    }//GEN-LAST:event_rbPessoalActionPerformed

   
    private void rbOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOutrosActionPerformed
     
        transation = JOptionPane.showInputDialog(null, " Informe o usuário !");
         idDesp = 0 ;
         
         cbxFonte.setEnabled(false);
          cbxCategoria.setEnabled(false);
          cbxTipo.setEnabled(false);
    }//GEN-LAST:event_rbOutrosActionPerformed

    
    
    
    private void cbxCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCartaoMouseClicked
        
       dataBRL   = txtDate.getText(); 
        
       if (dataBRL.isEmpty()){
           
             JOptionPane.showMessageDialog(null, "Informe a data antes de selecionar o cartão !"); 
             
         }else{
         
         ccb = new CartaoCreditoBeans();
         ccd = new CartaoCreditoData();
        
         ccd.listConta(ccb);
         
         listCartao = ccb.getListConta();
        
        DefaultComboBoxModel contaModel = (DefaultComboBoxModel) cbxCartao.getModel();
        cbxCartao.setModel(contaModel);
        
        
         try{
             
            contaModel.removeAllElements();
            
              for(int i =0; i < listCartao.size() ; i++ ){
                  
                     contaModel.addElement(listCartao.get(i));
              }
            
         }catch(Exception ex){
             
              System.out.println(" erro combobox list contas ");
               
               contaModel.removeAllElements();
         }
         
         showTotal();
         
         }
         
    }//GEN-LAST:event_cbxCartaoMouseClicked

    
    
    
    private void cbxTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoMouseClicked
        /*
         db = new DespesasBeans();
         dd = new DespesasData();
         
          dd.listTipo(db);           
          listTipo = db.getListTipo();
         */
        DefaultComboBoxModel modelTipo = (DefaultComboBoxModel) cbxTipo.getModel();
          cbxTipo.setModel(modelTipo);
          
            try{
                
                modelTipo.removeAllElements();
                
                for(int i = 0; i < listTipo.size(); i++ ){
                    
                    modelTipo.addElement(listTipo.get(i));
                }
                
            }catch(Exception ex ){
              
                 modelTipo.removeAllElements();
                System.out.println(" erro combobox listTipo ");
            }
    }//GEN-LAST:event_cbxTipoMouseClicked

    
    
    
    
    private void cbxFonteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxFonteMouseClicked
          dd = new DespesasData();
          db = new DespesasBeans();
          
          dd.listFonte(db);           
          listFonte = db.getListFonte();
          
          DefaultComboBoxModel modelFonte = (DefaultComboBoxModel) cbxFonte.getModel();
          cbxFonte.setModel(modelFonte);
          
            try{
                
                modelFonte.removeAllElements();
                
                for(int i = 0; i < listFonte.size(); i++ ){
                    
                    modelFonte.addElement(listFonte.get(i));
                }
                
            }catch(Exception ex ){
              
                 modelFonte.removeAllElements();
                System.out.println(" erro combobox listFonte ");
            }
    }//GEN-LAST:event_cbxFonteMouseClicked

    
    
    
    private void cbxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaMouseClicked
          dd = new DespesasData();          
          db = new DespesasBeans();
           
           dd.listCategorias(db);
           listCategorias = db.getListCategorias();
          
          DefaultComboBoxModel  modelCategoria = (DefaultComboBoxModel) cbxCategoria.getModel();
          cbxCategoria.setModel(modelCategoria);
          
           try{
               
                modelCategoria.removeAllElements();
                
                for(int i = 0; i < listCategorias.size();  i++ ){
                    
                   modelCategoria.addElement(listCategorias.get(i));                  
                  
                }
               
               
           }catch(Exception ex){
               
               modelCategoria.removeAllElements();
                
               System.out.println(" erro combobox list ");
           }
    }//GEN-LAST:event_cbxCategoriaMouseClicked

    
    
    
    
    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        dd = new DespesasData();
        db = new DespesasBeans();
        
        categoria = ((String)cbxCategoria.getSelectedItem());         
        db.setCategoria(categoria);
       // System.out.println(db.getCategoria());
        
        dd.listTipo(db);           
        listTipo = db.getListTipo(); 
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CartaoCreditoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartaoCreditoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartaoCreditoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartaoCreditoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartaoCreditoScreen().setVisible(true);
            }
        });
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaComents;
    private javax.swing.JButton btnPost;
    private javax.swing.ButtonGroup buttonGroupTransacao;
    private javax.swing.JComboBox<String> cbxCartao;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxFonte;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelHead;
    private javax.swing.JRadioButton rbOutros;
    private javax.swing.JRadioButton rbPessoal;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
