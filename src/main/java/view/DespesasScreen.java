package view;

import controll.DespesasBeans;
import controll.MovimentacaoBancariaBeans;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.DespesasData;
import model.MovimentacaoBancariaData;





/**
 *
 * @author RFagundes
 */
public class DespesasScreen extends javax.swing.JFrame  {
                                                      // implements ActionListener 
    //    SimpleDateFormat formatBRL   = new SimpleDateFormat("dd/MM/yyyy"); 
    
    
    
   private String  dataBRL , dtf , fonte , categoria , tipo , formaPgto , contaN , contaPgto , coments ;
    
   private  int year , month ;
   
   private BigDecimal saldo , valor = new BigDecimal(0.00);    
    
   private LocalDate dataF ; 
     
   private DateTimeFormatter formatDB = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

       
   private List<DespesasBeans> listDespesas = new ArrayList<>();     
   
     
   
   
   private ArrayList<String> listFonte      = new ArrayList<String>();
   private ArrayList<String> listCategorias = new ArrayList<String>();
   private ArrayList<String> listTipos      = new ArrayList<String>();
   
   private ArrayList<String> listContas     = new ArrayList<String>();
 
     
    MovimentacaoBancariaBeans mbb ;
    MovimentacaoBancariaData mbd ;
            
    DespesasBeans db ;
    DespesasData  dd ;
     
    HomeScrem home ;
    
   
    
    public DespesasScreen() {
        initComponents(); 
        btnPost.setEnabled(false);
        
        startCbx();
        showSaldoEspecie();
        //btnPost.addActionListener(this);
                
       }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupFormaPgto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cbxFonte = new javax.swing.JComboBox<>();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxTipo = new javax.swing.JComboBox<>();
        radioEspecie = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        radioDebito = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaComents = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        btnPost = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSaldoEspecie = new javax.swing.JTextField();
        panelHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

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

        radioEspecie.setBackground(new java.awt.Color(0, 0, 102));
        GroupFormaPgto.add(radioEspecie);
        radioEspecie.setForeground(new java.awt.Color(0, 255, 255));
        radioEspecie.setText("Dinheiro");
        radioEspecie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEspecieMouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Forma de Pagamento");

        radioDebito.setBackground(new java.awt.Color(0, 0, 102));
        GroupFormaPgto.add(radioDebito);
        radioDebito.setForeground(new java.awt.Color(0, 255, 255));
        radioDebito.setText("Debito");
        radioDebito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioDebitoMouseClicked(evt);
            }
        });

        areaComents.setColumns(20);
        areaComents.setRows(5);
        areaComents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaComentsKeyReleased(evt);
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

        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Saldo Espécie");

        txtSaldoEspecie.setBackground(new java.awt.Color(0, 0, 51));
        txtSaldoEspecie.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        txtSaldoEspecie.setForeground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 244, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipo, 0, 152, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCategoria, 0, 152, Short.MAX_VALUE)
                                    .addComponent(cbxFonte, 0, 152, Short.MAX_VALUE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addGap(9, 9, 9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioDebito)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cbxFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioDebito)
                            .addComponent(radioEspecie)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaldoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panelHead.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Despesas");

        javax.swing.GroupLayout panelHeadLayout = new javax.swing.GroupLayout(panelHead);
        panelHead.setLayout(panelHeadLayout);
        panelHeadLayout.setHorizontalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeadLayout.setVerticalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void validation(){
       
        dataBRL   = txtDate.getText();
        fonte     = ((String)cbxFonte.getSelectedItem());
        categoria = ((String)cbxCategoria.getSelectedItem());
        tipo      = cbxTipo.getSelectedItem().toString();
        coments   = areaComents.getText(); 
        
         if ( 
                dataBRL.isEmpty()               ||               
                fonte.contains("Fonte")         ||
                categoria.contains("Categoria") || 
                tipo.contains("Tipo")           ||
                txtValor.getText().isEmpty()
             ){
            
              btnPost.setEnabled(false);
              JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!"); 
              /* 
              System.out.println(
                         " error data      "+dataBRL+
                         " error fonte     "+fonte+
                         " error categoria "+categoria+
                         " error tipo      "+tipo+
                         " erro valor      "+txtValor.getText()        
                        );
             */
           }else {
           
             
               try{
                   
                 dataF = LocalDate.parse(dataBRL, formatDB);
                 valor = new BigDecimal (txtValor.getText().replace(",", "."));           
                               
              }catch(Exception ex){             
                   System.out.println(" error LocalDate/BigDecimal "+ex);           
                }
             
                 dtf   = dataF.toString();
                 btnPost.setEnabled(true); 
                 /*                
                System.out.println(
                         " data        "+dataBRL+
                         " data locale "+dataF+
                         " dataf       "+dtf+
                         " fonte       "+fonte+
                         " categoria   "+categoria+
                         " tipo        "+tipo+
                         " valor       "+valor      
                        );
                */
           }
        
        
    }
  
    
    
    
    
    private void showSaldoEspecie(){
        
        db = new DespesasBeans();
        dd = new DespesasData();
        
        dd.selectSaldo(db);        
        saldo = db.getSaldo();
        
        txtSaldoEspecie.setText(" R$ "+saldo);
        
    }
    
    
    
    
    
    
    private void lancarDespesas(){
        /*
        System.out.println(
                         " data        "+dataBRL+
                         " data locale "+dataF+
                         " dataf       "+dtf+
                         " fonte       "+fonte+
                         " categoria   "+categoria+
                         " tipo        "+tipo+
                         " valor       "+valor      
                        );
        */
           
        db = new DespesasBeans();
        dd = new DespesasData();
        
        db.setData(dataBRL);
        db.setDataF(dtf);        
        db.setYear(year);
        db.setMonth(month);               
        
        db.setFonte(fonte);        
        db.setCategoria(categoria); 
       
        db.setTipo(tipo);        
        db.setFormaPgto(formaPgto);
        db.setContaPgto(contaPgto);
        db.setAddConta(false);
        db.setComents(coments);       
        db.setValor(valor);       
        db.setTotal(new BigDecimal(0.00));
        
        dd.insertDespesas(db);
           
        
        /* 
        dd.selectSaldo(db);        
        saldo = db.getSaldo();
        txtValor.setText(" R$ "+saldo);
        */
        
         
          System.out.println(                
                " Data "+db.getData()+
                " DataFormat  "+db.getDataF()+
                " Fonte "+db.getFonte()+
                " Categoria "+db.getCategoria()+
                " Tipo "+db.getTipo()+
                " Forma pgto  "+db.getFormaPgto()+
                " Conta nº "+db.getContaPgto()+                        
                " coments "+db.getComents()+
                " valor "+db.getValor()+
                " total "+db.getTotal()+           
                " add conta "+db.getAddConta() 
           );
             JOptionPane.showMessageDialog(null," todos os campos preenchidos ");   
            
                  
           limparCampos();
           listarDespesas();
           showSaldoEspecie();
           
       
       int close =  JOptionPane.showConfirmDialog(null," Gostaria de realizar outra transação ? ", " Encerrar ", JOptionPane.YES_OPTION);
     
        if (close == JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null, "Continuar lançado ! "); 
            
        }else{
           
            this.dispose(); 
            home = new HomeScrem();
            home.setVisible(true);
                
        }
     
  }
    
    
    
    
    
    
    
      private void startCbx(){
         cbxFonte.addItem("Fonte:");
         cbxCategoria.addItem("Categoria:");
         cbxTipo.addItem("Tipo:");
      }
    
    
      
      
      
    
    private void limparCampos(){
        txtDate.setText("");
        
        cbxFonte.removeAllItems();
        cbxFonte.addItem("Fonte:");
        
       cbxCategoria.removeAllItems();
       cbxCategoria.addItem("Categoria:");
       
       cbxTipo.removeAllItems();
       cbxTipo.addItem("Tipo:");
       
        txtValor.setText("");
        areaComents.setText(""); 
    }
    
    
    
    
    private void listarDespesas(){
        
        db = new DespesasBeans();
        dd = new DespesasData();
        
        year  = dataF.getYear();
        month = dataF.getMonthValue();   
        
        db.setYear(year);
        db.setMonth(month);
        
        listDespesas =  dd.selectDespesas(db);
          
        System.out.println(" Lista de despesas do mês "+month);
        
        for( DespesasBeans dep : listDespesas ){
             
           System.out.println(" --------------------------------- ");
              
             System.out.println(" id   : "+dep.getId());
             System.out.println(" data : "+dep.getData());
             System.out.println(" dataF : "+dep.getDataF());
             System.out.println(" fonte : "+dep.getFonte());
             System.out.println(" categoria : "+dep.getCategoria());
             System.out.println(" tipo  : "+dep.getTipo());
             System.out.println(" formaPgto : "+dep.getFormaPgto());
             System.out.println(" conta : "+dep.getContaPgto());
             System.out.println(" addConta : "+dep.getAddConta());
             System.out.println(" valor R$ : "+dep.getValor());
             System.out.println(" coments  : "+dep.getComents());
             System.out.println(" total R$ : "+dep.getTotal());
             
           System.out.println(" --------------------------------- ");
         }
        
          System.out.println(" total de posts  "+listDespesas.size()); 
          
          System.out.println(" saldo especie R$ : "+saldo);       
        
    }
    
    
    
    
    
    
    
    
    private void btnPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPostMouseClicked
       lancarDespesas();
    }//GEN-LAST:event_btnPostMouseClicked

    
    
    
    private void radioEspecieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEspecieMouseClicked
        formaPgto = "especie";
        contaN = "0";               
    }//GEN-LAST:event_radioEspecieMouseClicked

    
    
    
      int idConta ;
      
    
    
    private void radioDebitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDebitoMouseClicked
     
        formaPgto = "Debito";  
         
         mbb = new MovimentacaoBancariaBeans();
         mbd = new MovimentacaoBancariaData();
         
         mbd.listContas(mbb);
         
         listContas =  mbb.getListConta();
        
         contaN = (String) JOptionPane.showInputDialog(null," Escolha a Conta ! "," Conta ", JOptionPane.QUESTION_MESSAGE,
                  null, listContas.toArray(), listContas);
         
         mbb.setContaN(contaN);
         mbd.selectIdConta(mbb);
         
         idConta = mbb.getIdConta();
         
         contaPgto = String.valueOf(idConta);
         
         System.out.println("  "+contaN+"  "+contaPgto);
         
         /*
         DefaultComboBoxModel modelContas = (DefaultComboBoxModel) jComboBox1.getModel();
         jComboBox1.setModel(modelContas);
         
           try{
               
              modelContas.removeAllElements();
              
               for(int i =0; i < listContas.size() ; i++ ){
                  
                    modelContas.addElement(listContas.get(i));
               }
               
           }catch(Exception ex){
              
               System.out.println(" erro combobox list contas ");
               
                modelContas.removeAllElements();
           }
         */
         
         
        
    }//GEN-LAST:event_radioDebitoMouseClicked

    
    
    
    
    
    
    
    
    private void areaComentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaComentsKeyReleased
       validation();
    }//GEN-LAST:event_areaComentsKeyReleased

    
    
    
    
    
    
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

    
    
    
    
    private void cbxTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoMouseClicked
         // dd = new DespesasData();
         // db = new DespesasBeans();
          
         //  dd.listTipo(db);           
         //  listTipos = db.getListTipo();
          
          DefaultComboBoxModel modelTipo = (DefaultComboBoxModel) cbxTipo.getModel();
          cbxTipo.setModel(modelTipo);
          
            try{
                
                modelTipo.removeAllElements();
                
                for(int i = 0; i < listTipos.size(); i++ ){
                    
                    modelTipo.addElement(listTipos.get(i));
                }
                
            }catch(Exception ex ){
              
                 modelTipo.removeAllElements();
                System.out.println(" erro combobox listTipo ");
            }
    }//GEN-LAST:event_cbxTipoMouseClicked

    
    
    
    
    
    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        dd = new DespesasData();
        db = new DespesasBeans();
        
        categoria = ((String)cbxCategoria.getSelectedItem());         
        db.setCategoria(categoria);
       // System.out.println(db.getCategoria());
        
        dd.listTipo(db);           
        listTipos = db.getListTipo(); 
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
            java.util.logging.Logger.getLogger(DespesasScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DespesasScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DespesasScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DespesasScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DespesasScreen().setVisible(true);
            }
        });
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupFormaPgto;
    private javax.swing.JTextArea areaComents;
    private javax.swing.JButton btnPost;
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
    private javax.swing.JRadioButton radioDebito;
    private javax.swing.JRadioButton radioEspecie;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtSaldoEspecie;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    
    
    
   
    
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == btnPost ){
            home = new HomeScrem();
            home.txtSaldoEspecie.setText(" R$ "+saldo);  
          
            limparCampos();
            this.dispose(); 
        }
    }
   */
    
}
