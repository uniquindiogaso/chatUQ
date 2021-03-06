/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.gui;

import co.edu.uniquindio.client.Client;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * Ventana Principal de ejecucion Chat Modo Cliente * 
 * @author Gustavo Salgado | Juan Gabriel Carvajal Hernandez
 */
public class Ventana extends javax.swing.JFrame {

    Client cliente;
    Color color;
    public StyleContext sc;
    public DefaultStyledDocument doc;

    public Ventana() {
        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        initComponents();
        setLocationRelativeTo(null);
        this.setBounds(242, 240, 590, 460);
        bEnviar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btConectar = new javax.swing.JButton();
        cNombreUsuario = new javax.swing.JTextField();
        bEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btColor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMensajes = new javax.swing.JTextPane();
        cMsj = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });
        getContentPane().add(btConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, -1));
        getContentPane().add(cNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 148, -1));

        bEnviar.setText("Enviar");
        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(bEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 70, 30));

        jLabel1.setText("Escribe tu nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setText("Elige un color");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btColorActionPerformed(evt);
            }
        });
        getContentPane().add(btColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 150, 30));

        jScrollPane1.setViewportView(listaMensajes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 530, 250));
        getContentPane().add(cMsj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 460, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        conectar();
    }//GEN-LAST:event_btConectarActionPerformed

    private void bEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarActionPerformed
        enviarMensaje();
    }//GEN-LAST:event_bEnviarActionPerformed

    private void btColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btColorActionPerformed
        selectColor();
    }//GEN-LAST:event_btColorActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEnviar;
    private javax.swing.JButton btColor;
    private javax.swing.JButton btConectar;
    private javax.swing.JTextField cMsj;
    private javax.swing.JTextField cNombreUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane listaMensajes;
    // End of variables declaration//GEN-END:variables

    /**
     * Recibe la informacion de un nuevo mensaje y la prepara para ser enviada a
     * el panel
     *
     * @param t Cadena que contiene la informacion del usuario|mensaje|color
     */
    public void actualizarChar(String t) {
        System.out.println("msj recibido desde gui " + t + "|");
        if (t.isEmpty()) {
            return;
        }
        String msj[] = t.split("\\|");
        try {
            Color colorusuario = new Color(Integer.parseInt(msj[1]));
            String mensaje = msj[0].toUpperCase() + " : " + msj[2];
            actualizarChats(listaMensajes, mensaje, colorusuario);
        } catch (Exception e) {
            System.out.println("Error Enviando Informacion a Panel ...");
        }

    }

    /**
     * Agrega al panel de chats un nuevo mensaje
     *
     * @param tp Panel de texto que contiene los mensajes
     * @param msg Mensaje a agregar
     * @param c Color que se empleara en el msj nuevo
     * @see https://goo.gl/nkJpMq
     */
    private void actualizarChats(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

    /**
     * Permite conecta a la Sala de Chat por defecto
     */
    private void conectar() {
        if (cNombreUsuario.getText().isEmpty() || color == null) {
            JOptionPane.showMessageDialog(null, "Te faltaron campos!!");
        } else {
            cliente = new Client(cNombreUsuario.getText(), color, this);
            bEnviar.setVisible(true);
            btConectar.setVisible(false);
        }
    }

    /**
     * Enviar Mensaje a sala de Chat
     */
    private void enviarMensaje() {
        if (cMsj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escribe un mensaje");
        } else {
            cliente.enviar(cMsj.getText());
            cMsj.setText(null);
        }
    }

    /**
     * Lanzar pop-up para seleccionar color que se empleara en chat
     */
    private void selectColor() {
        color = JColorChooser.showDialog(rootPane, "Por favor selecciona un color", btColor.getBackground());
        btColor.setBackground(color);
    }
}
