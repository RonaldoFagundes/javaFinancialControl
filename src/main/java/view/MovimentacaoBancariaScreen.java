package view;

import controll.MovimentacaoBancariaBeans;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.MovimentacaoBancariaData;

/**
 *
 * @author RFagundes
 */
public class MovimentacaoBancariaScreen extends javax.swing.JFrame {

   
   private String  dataBRL , dtf , operacao , contaN , place , coments ;
    
   private  int idCnt , year , month ;
   
   private  BigDecimal valor = new BigDecimal(0.00);    
   
   private  BigDecimal saldo = new BigDecimal(0.00);    
    
   private  LocalDate dataF ; 
     
   private  DateTimeFormatter formatDB = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

   private ArrayList<String> listContas = new ArrayList<String>();
   
  
   MovimentacaoBancariaBeans mbb ;
   MovimentacaoBancariaData mbd ;
   
    HomeScrem home ;
    
    
    
    
    
    public MovimentacaoBancariaScreen() {
        initComponents();
        btnPost.setEnabled(false);
        
        cbxConta.addItem("Conta nº:");
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox<>();
        cbxConta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaComents = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        btnPost = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        txtSaldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPlace = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHead.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimentaçao Bancária");

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo:", " ", "Debito", "Investimento", "Pagamento", "Pix", "Saque", "Transferência", " " }));

        cbxConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxContaMouseClicked(evt);
            }
        });
        cbxConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxContaActionPerformed(evt);
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

        txtSaldo.setBackground(new java.awt.Color(0, 0, 102));
        txtSaldo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        txtSaldo.setForeground(new java.awt.Color(0, 255, 255));
        txtSaldo.setText("0.00");

        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Local");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlace)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Saldo");

        javax.swing.GroupLayout panelHeadLayout = new javax.swing.GroupLayout(panelHead);
        panelHead.setLayout(panelHeadLayout);
        panelHeadLayout.setHorizontalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeadLayout.setVerticalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void btnPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPostMouseClicked
       lancar();
    }//GEN-LAST:event_btnPostMouseClicked

    private void areaComentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaComentsMouseClicked
       validation();
    }//GEN-LAST:event_areaComentsMouseClicked

    private void cbxContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxContaActionPerformed
      
           saldo();
        
    }//GEN-LAST:event_cbxContaActionPerformed

    
    
    
    
    private void cbxContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxContaMouseClicked
       
         mbb = new MovimentacaoBancariaBeans();
         mbd = new MovimentacaoBancariaData();
         
         mbd.listContas(mbb);
         
         listContas =  mbb.getListConta();
         
         DefaultComboBoxModel modelContas = (DefaultComboBoxModel) cbxConta.getModel();
         cbxConta.setModel(modelContas);
         
           try{
               
              modelContas.removeAllElements();
              
               for(int i =0; i < listContas.size() ; i++ ){
                  
                    modelContas.addElement(listContas.get(i));
               }
               
               
           }catch(Exception ex){
              
               System.out.println(" erro combobox list contas ");
               
                modelContas.removeAllElements();
           }
           
           
    }//GEN-LAST:event_cbxContaMouseClicked

    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(MovimentacaoBancariaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoBancariaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoBancariaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimentacaoBancariaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimentacaoBancariaScreen().setVisible(true);
            }
        });
    }
    
    
    
    
    
  
    private void saldo (){
         
      mbb = new MovimentacaoBancariaBeans();
      mbd = new MovimentacaoBancariaData();
      
      contaN   = ((String)cbxConta.getSelectedItem());
      
      mbb.setContaN(contaN);
      
      try{
      
        mbd.selectSaldoContaBancaria(mbb);
      
        saldo = mbb.getSaldo();
      
        txtSaldo.setText( " R$ " +saldo.toString());
      
      
      }catch(Exception ex){
           
         txtSaldo.setText( new BigDecimal(0.00).toString()  );
      } 
      
      
      
    }
    
    
    
    private void validation(){
        
        dataBRL  = txtDate.getText();
        contaN   = ((String)cbxConta.getSelectedItem());
        operacao = cbxTipo.getSelectedItem().toString();
        place    = txtPlace.getText();
        
         if(                    
                dataBRL.isEmpty()          ||   
                contaN.contains("Conta:")  ||
                operacao.contains("Tipo:") || 
                place.isEmpty()            ||
                txtValor.getText().isEmpty()
              ){               
                btnPost.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!"); 
                /*
                 System.out.println(
                         " error data     "+dataBRL+
                         " error conta    "+contaN+
                         " error operacao "+operacao+
                         " erro valor     "+txtValor.getText()        
                        );
                */
             }else{
             
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
                        " data     "+dataBRL+
                        " dataf    "+dtf+
                        " operação "+operacao+
                        " conta    "+contaN+
                        " valor    "+valor
                        );            
                */
            }
        
        
    }
    
    
    
    
    
    
    private void lancar(){
        
        coments  = areaComents.getText(); 
        
        switch (operacao) {
            
            case "Saque" :
               JOptionPane.showMessageDialog(null, operacao); 
               sacar();
            break;  
            
            case "Pagamento" :
                JOptionPane.showMessageDialog(null, operacao);
            break;  
        }
        
         
    }
    
    
    
    
    
    
    
    private void sacar(){
        
      mbb = new MovimentacaoBancariaBeans();
      mbd = new MovimentacaoBancariaData();
        
      mbb.setValor(valor);
      mbb.setComents(coments);
      mbb.setData(dataBRL);
      mbb.setDataF(dtf);
      mbb.setPlace(place);
      mbb.setContaN(contaN);
            
      mbd.selectIdConta(mbb);
      
      idCnt = mbb.getIdConta(); 
            
      mbd.insertSaque(mbb);
      
      /*
      System.out.println(
       " valor     =  "+mbb.getValor()+
       " /coments  =  "+mbb.getComents()+
       " /data     =  "+mbb.getData()+
       " /dataf    =  "+mbb.getDataF()+
       " /local    =  "+mbb.getPlace()+
       " /valor    =  "+mbb.getValor()+    
       " /id conta =  "+mbb.getIdConta()+
       " /conta    =  "+mbb.getContaN()
      );
      */
      
      
     
      
      try{
      
        mbd.selectSaldoContaBancaria(mbb);
      
        saldo = mbb.getSaldo();
      
        txtSaldo.setText( " R$ " +saldo.toString());
      
      
      }catch(Exception ex){
           
         txtSaldo.setText( new BigDecimal(0.00).toString()  );
      } 
      
      limparCampos();
      
     int close =  JOptionPane.showConfirmDialog(null," Gostaria de realizar outra transação ? ", " Encerrar ", JOptionPane.YES_OPTION);
     
        if (close == JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null, "Continuar lançado ! "); 
            
        }else{
            this.dispose(); 
            home = new HomeScrem();
            home.setVisible(true);
        }
        
    }
    
    
    
    
     public void limparCampos(){
     
        cbxConta.setSelectedItem("Conta:");
         
        txtDate.setText("");
      
        cbxTipo.setSelectedItem("Tipo:");
        
        txtValor.setText("");        
      
        txtPlace.setText("");
         
        areaComents.setText("");
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaComents;
    private javax.swing.JButton btnPost;
    private javax.swing.JComboBox<String> cbxConta;
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
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
