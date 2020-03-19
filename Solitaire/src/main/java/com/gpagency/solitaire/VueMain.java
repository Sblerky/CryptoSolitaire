/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.solitaire;

/**
 *
 * @author Jules
 */
public class VueMain extends javax.swing.JFrame {

    private Paquet paquet;
    private PaquetUses p_use;
    private Operations o_code;
    private Operations o_decode;
    private String message;
    /**
     * Creates new form VueMain
     */
    public VueMain() {
        paquet=new Paquet();
        p_use = new PaquetUses(paquet);
        initComponents();
        TexteOrdre.setText(paquet.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        TextCodeScroll = new javax.swing.JScrollPane();
        TextCode = new javax.swing.JTextArea();
        PanelUser = new javax.swing.JPanel();
        LabelOrdre = new javax.swing.JLabel();
        OrdreScroll = new javax.swing.JScrollPane();
        TexteOrdre = new javax.swing.JTextArea();
        BoutonPaquets = new javax.swing.JButton();
        LabelText = new javax.swing.JLabel();
        TextMessageScroll = new javax.swing.JScrollPane();
        TextMessage = new javax.swing.JTextArea();
        BoutonLaunch = new javax.swing.JButton();
        TextDecodeScroll = new javax.swing.JScrollPane();
        TextDecode = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        Fichier = new javax.swing.JMenu();
        OpenFich = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMain.setLayout(new java.awt.GridLayout(1, 3));

        TextCode.setEditable(false);
        TextCode.setColumns(20);
        TextCode.setRows(5);
        TextCodeScroll.setViewportView(TextCode);

        PanelMain.add(TextCodeScroll);

        PanelUser.setLayout(new java.awt.GridLayout(6, 1));

        LabelOrdre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelOrdre.setText("Ordre :");
        LabelOrdre.setToolTipText("");
        LabelOrdre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelUser.add(LabelOrdre);

        TexteOrdre.setEditable(false);
        TexteOrdre.setColumns(20);
        TexteOrdre.setRows(5);
        OrdreScroll.setViewportView(TexteOrdre);

        PanelUser.add(OrdreScroll);

        BoutonPaquets.setText("Voir les paquets uilisés");
        BoutonPaquets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonPaquetsActionPerformed(evt);
            }
        });
        PanelUser.add(BoutonPaquets);

        LabelText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelText.setText("Tapez votre message :");
        PanelUser.add(LabelText);

        TextMessage.setColumns(20);
        TextMessage.setRows(5);
        TextMessageScroll.setViewportView(TextMessage);

        PanelUser.add(TextMessageScroll);

        BoutonLaunch.setText("Lancer le test");
        BoutonLaunch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonLaunchActionPerformed(evt);
            }
        });
        PanelUser.add(BoutonLaunch);

        PanelMain.add(PanelUser);

        TextDecode.setEditable(false);
        TextDecode.setColumns(20);
        TextDecode.setRows(5);
        TextDecodeScroll.setViewportView(TextDecode);

        PanelMain.add(TextDecodeScroll);

        Fichier.setText("File");

        OpenFich.setText("Charger un fichier");
        OpenFich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFichActionPerformed(evt);
            }
        });
        Fichier.add(OpenFich);

        jMenuBar1.add(Fichier);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonLaunchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonLaunchActionPerformed
        // TODO add your handling code here:
        paquet.shuffle();
        //tester si le paquet a déjà été fait
        if(!p_use.isUsed(new Paquet(paquet.getJeu()))){
            p_use.add(new Paquet(paquet.getJeu()));
            TexteOrdre.setText(paquet.toString());
        
            o_code=new Operations(TextMessage.getText(), paquet);


            o_code.code();
            String text_code="Message : "+TextMessage.getText()+"\n\n////////////\n\nFlux : \n"+o_code.fluxToString()+"////////////\n\nCode : \n"+o_code.getMessage_trans();
            TextCode.setText(text_code);

            o_decode=new Operations(o_code.getMessage_trans(), paquet);
            o_decode.decode();

            String text_decode="Message : "+o_code.getMessage_trans()+"\n\n////////////\n\nFlux : \n"+o_decode.fluxToString()+"////////////\n\nDecode : \n"+o_decode.getMessage_trans();
            TextDecode.setText(text_decode);
        }
        else{
            TextCode.setText("Cet ordre a déjà été utilisé");
        }
        
        
        
        
        
    }//GEN-LAST:event_BoutonLaunchActionPerformed

    private void BoutonPaquetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonPaquetsActionPerformed
        // TODO add your handling code here:
        VueUses vu=new VueUses(p_use);
        vu.setVisible(true);
        
    }//GEN-LAST:event_BoutonPaquetsActionPerformed

    private void OpenFichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFichActionPerformed
        // TODO add your handling code here:
        VueFichier vf=new VueFichier(paquet);
        vf.setVisible(true);
    }//GEN-LAST:event_OpenFichActionPerformed

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
            java.util.logging.Logger.getLogger(VueMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonLaunch;
    private javax.swing.JButton BoutonPaquets;
    private javax.swing.JMenu Fichier;
    private javax.swing.JLabel LabelOrdre;
    private javax.swing.JLabel LabelText;
    private javax.swing.JMenuItem OpenFich;
    private javax.swing.JScrollPane OrdreScroll;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelUser;
    private javax.swing.JTextArea TextCode;
    private javax.swing.JScrollPane TextCodeScroll;
    private javax.swing.JTextArea TextDecode;
    private javax.swing.JScrollPane TextDecodeScroll;
    private javax.swing.JTextArea TextMessage;
    private javax.swing.JScrollPane TextMessageScroll;
    private javax.swing.JTextArea TexteOrdre;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
