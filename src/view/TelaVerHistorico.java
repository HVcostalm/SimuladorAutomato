/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AutomatoFinitoDeterministico;

/**
 *
 * @author heito
 */
public class TelaVerHistorico extends javax.swing.JFrame {
    private List<AutomatoFinitoDeterministico> automatosRecebidos;
    private AutomatoFinitoDeterministico automato;
    private final DefaultTableModel modelo;
    /**
     * Creates new form TelaVerHistorico
     */
    public TelaVerHistorico(List<AutomatoFinitoDeterministico> automatos) {
        this.automatosRecebidos = automatos;
        initComponents();
        modelo = (DefaultTableModel) tbl_automatos.getModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Estados");
        modelo.addColumn("Alfabeto");

    }

    public TelaVerHistorico() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_automatos = new javax.swing.JTable();
        AutomatosCriados = new javax.swing.JLabel();
        botaoVoltarTelaPrincipal = new javax.swing.JButton();
        botaoVerificarCadeiaAutomato = new javax.swing.JButton();
        botaoCriarAutomato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_automatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_automatos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_automatosFocusGained(evt);
            }
        });
        tbl_automatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_automatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_automatos);

        AutomatosCriados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AutomatosCriados.setText("Automatos Criados:");

        botaoVoltarTelaPrincipal.setText("Voltar Tela Principal");
        botaoVoltarTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarTelaPrincipalActionPerformed(evt);
            }
        });

        botaoVerificarCadeiaAutomato.setText("Verificar Cadeia");
        botaoVerificarCadeiaAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerificarCadeiaAutomatoActionPerformed(evt);
            }
        });

        botaoCriarAutomato.setText("Criar Automato");
        botaoCriarAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarAutomatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoVoltarTelaPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoVerificarCadeiaAutomato)
                        .addGap(84, 84, 84)
                        .addComponent(botaoCriarAutomato))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AutomatosCriados)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(AutomatosCriados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltarTelaPrincipal)
                    .addComponent(botaoVerificarCadeiaAutomato)
                    .addComponent(botaoCriarAutomato))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void preencherTabela(){
        ((DefaultTableModel) tbl_automatos.getModel()).setRowCount(0);
        for(AutomatoFinitoDeterministico automato: automatosRecebidos){
            modelo.addRow(new Object[]{automato.getNome(), automato.getEstados(), automato.getAlfabeto()});
        }
    }
    
    private void escolherAutomatoVerificarCadeia(){
        try {
            String nomeAutomato = (String) tbl_automatos.getValueAt(tbl_automatos.getSelectedRow(), 0);
            for (AutomatoFinitoDeterministico automato : automatosRecebidos) {
                if (nomeAutomato.equalsIgnoreCase(automato.getNome())) {
                    this.automato = automato;
                    break;
                }
            }
            TelaVerificarCadeia telaVerificarCadeia = new TelaVerificarCadeia(automatosRecebidos, automato);
            telaVerificarCadeia.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar uma linha da tabela");
        }  
    }
    
    private void voltarTelaPrincipal(){
        Object[] opcao = {"Sim", "N�o"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente voltar para tela principal?", "Aviso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
        if (opcaoSelecionada == 0) {
            TelaPrincipal telaPrincipal = new TelaPrincipal(automatosRecebidos);
            telaPrincipal.setVisible(true);
            this.dispose();
        }
    }
    
    
    
    private void tbl_automatosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_automatosFocusGained
        // TODO add your handling code here:
        preencherTabela();
    }//GEN-LAST:event_tbl_automatosFocusGained

    private void botaoVoltarTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarTelaPrincipalActionPerformed
        // TODO add your handling code here:
        voltarTelaPrincipal();
    }//GEN-LAST:event_botaoVoltarTelaPrincipalActionPerformed

    private void botaoVerificarCadeiaAutomatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerificarCadeiaAutomatoActionPerformed
        // TODO add your handling code here:
        escolherAutomatoVerificarCadeia();
    }//GEN-LAST:event_botaoVerificarCadeiaAutomatoActionPerformed

    private void botaoCriarAutomatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarAutomatoActionPerformed
        // TODO add your handling code here:
        TelaCriarAutomato_Nome telaCriarAutomatoNome = new TelaCriarAutomato_Nome(automatosRecebidos);
        telaCriarAutomatoNome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoCriarAutomatoActionPerformed

    private void tbl_automatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_automatosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tbl_automatosMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(TelaVerHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVerHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVerHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVerHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVerHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AutomatosCriados;
    private javax.swing.JButton botaoCriarAutomato;
    private javax.swing.JButton botaoVerificarCadeiaAutomato;
    private javax.swing.JButton botaoVoltarTelaPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_automatos;
    // End of variables declaration//GEN-END:variables
}
