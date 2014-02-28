/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.persim.view;

import br.ufu.facom.frameworkpim.control.AbstractFactory;
import br.ufu.facom.frameworkpim.view.MainWindowFrame;
import br.ufu.facom.persim.control.ConcreteFactory;
import br.ufu.facom.persim.control.DatabaseConfigControl;
import javax.swing.JOptionPane;

/**
 *
 * @author Hugo
 */
public class Persim extends MainWindowFrame {

    private javax.swing.JMenu periodoMenu = new javax.swing.JMenu();
    private javax.swing.JMenuItem novoPeriodoMenuItem = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem estatisticaMenu = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem disciplinaMenu = new javax.swing.JMenuItem();
    private CadastroDisciplina cadDisc;

    public Persim(AbstractFactory factory) {
        super(factory);
        initComponents();
    }

    private void initComponents() {
        periodoMenu.setText("Periodo");
        novoPeriodoMenuItem.setText("Novo Periodo");
        novoPeriodoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoPeriodoMenuItemActionPerformed(evt);
            }
        });
        periodoMenu.add(novoPeriodoMenuItem);

        estatisticaMenu.setText("Estatísticas");
        estatisticaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        periodoMenu.add(estatisticaMenu);

        disciplinaMenu.setText("Disciplina");
        disciplinaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinaMenuActionPerformed(evt);
            }
        });
        periodoMenu.add(disciplinaMenu);
        this.menuBar.add(periodoMenu);
    }

    private void novoPeriodoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        int resp = JOptionPane.showConfirmDialog(this, "Deseja começar um novo período?"
                + " Você irá perder todos os dados deste período.", "Novo período",
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
        if (resp == 0) {
            DatabaseConfigControl.resetDB();
            this.desktopPane.removeAll();
            this.setDesktopConfigurations();
            this.desktopPane.repaint();
        }
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Não implementado para versão gratuita!", "Ops!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void disciplinaMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.cadDisc = new CadastroDisciplina();
        this.desktopPane.add(this.cadDisc);
        this.cadDisc.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(Persim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Persim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Persim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Persim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Persim(new ConcreteFactory()).setVisible(true);
            }
        });
    }

}
