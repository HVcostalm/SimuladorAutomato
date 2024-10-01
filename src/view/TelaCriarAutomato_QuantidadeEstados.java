/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.AutomatoFinitoDeterministico;
import model.Estado;

/**
 *
 * @author heito
 */
public class TelaCriarAutomato_QuantidadeEstados extends javax.swing.JFrame {

    private List<AutomatoFinitoDeterministico> automatosRecebidos;
    private AutomatoFinitoDeterministico automatoRecebido = new AutomatoFinitoDeterministico();
    private List<Estado> estados = new ArrayList<>();
    private String verificarVazioQuantidade, verificarVazioEstado, verificarVazioFinal;
    private int numeroEstados;
    private int contadorEstados = 1;

    /**
     * Creates new form TelaCriarAutomato_Estados
     */

    public TelaCriarAutomato_QuantidadeEstados(List<AutomatoFinitoDeterministico> automatos, AutomatoFinitoDeterministico automato) {
        this.automatosRecebidos = automatos;
        this.automatoRecebido = automato;
        initComponents();
    }

    public TelaCriarAutomato_QuantidadeEstados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        perguntaNumeroEstados = new javax.swing.JLabel();
        txtQuantidadeEstados = new javax.swing.JTextField();
        botaoConfimarNumeroEstados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        perguntaNumeroEstados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        perguntaNumeroEstados.setText("Quantos estados o Automato ter�?");

        txtQuantidadeEstados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeEstadosKeyPressed(evt);
            }
        });

        botaoConfimarNumeroEstados.setText("Confirmar Numero Estados");
        botaoConfimarNumeroEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfimarNumeroEstadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidadeEstados)
                            .addComponent(perguntaNumeroEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(botaoConfimarNumeroEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(perguntaNumeroEstados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(txtQuantidadeEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(botaoConfimarNumeroEstados)
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void informarQuantidadeEstados() {
        verificarVazioQuantidade = txtQuantidadeEstados.getText();
        if (verificarVazioQuantidade.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Campo Vazio!!! Digite a quantidade de estados");
        } else {
            numeroEstados = Integer.parseInt(verificarVazioQuantidade);
            if (numeroEstados <= 0 || numeroEstados == 1) {
                JOptionPane.showMessageDialog(null, "Estados Insuficientes!!! Digite uma quantidade maior");
            } else {
                TelaCriarAutomato_Estado telaCriarAutomatoEstado = new TelaCriarAutomato_Estado(automatosRecebidos, automatoRecebido, numeroEstados);
                telaCriarAutomatoEstado.setVisible(true);
                this.dispose();
            }
        }
    }
    private void botaoConfimarNumeroEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfimarNumeroEstadosActionPerformed
        // TODO add your handling code here:
        informarQuantidadeEstados();
    }//GEN-LAST:event_botaoConfimarNumeroEstadosActionPerformed

    private void txtQuantidadeEstadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeEstadosKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            informarQuantidadeEstados();
        }
    }//GEN-LAST:event_txtQuantidadeEstadosKeyPressed

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
            java.util.logging.Logger.getLogger(TelaCriarAutomato_QuantidadeEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarAutomato_QuantidadeEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarAutomato_QuantidadeEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarAutomato_QuantidadeEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCriarAutomato_QuantidadeEstados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfimarNumeroEstados;
    private javax.swing.JLabel perguntaNumeroEstados;
    private javax.swing.JTextField txtQuantidadeEstados;
    // End of variables declaration//GEN-END:variables
}
