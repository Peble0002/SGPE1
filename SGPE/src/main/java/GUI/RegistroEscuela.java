/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import conexionBD.EscuelaOAreaAcademicaBD;
import logicadenegocios.EscuelaOAreaAcademica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LUIS LEITON
 */
public class RegistroEscuela extends javax.swing.JFrame {
  EscuelaOAreaAcademicaBD conexion = new EscuelaOAreaAcademicaBD();
    /**
     * Creates new form RegistroEscuela
     */
    public RegistroEscuela() {
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

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    tbNombre = new javax.swing.JTextField();
    tbCodigo = new javax.swing.JTextField();
    btnRegistrarEscuela = new javax.swing.JButton();
    btnLimpiarCampos = new javax.swing.JButton();
    btnRegresar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("REGISTRO DE ESCUELA O ÁREA ACADÉMICA");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel2.setText("Nombre:");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel3.setText("Código:");

    btnRegistrarEscuela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnRegistrarEscuela.setText("Registrar");
    btnRegistrarEscuela.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegistrarEscuelaActionPerformed(evt);
      }
    });

    btnLimpiarCampos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnLimpiarCampos.setText("Limpiar Campos");

    btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnRegresar.setText("Regresar");
    btnRegresar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegresarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnRegresar))
          .addGroup(layout.createSequentialGroup()
            .addGap(94, 94, 94)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel3))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistrarEscuela)
                .addGap(115, 115, 115)
                .addComponent(btnLimpiarCampos))
              .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)))
            .addGap(0, 28, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(24, 24, 24)
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(51, 51, 51)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(tbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnRegistrarEscuela)
          .addComponent(btnLimpiarCampos))
        .addGap(26, 26, 26)
        .addComponent(btnRegresar)
        .addGap(6, 6, 6))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
      Principal nPrincipal = new Principal();
      nPrincipal.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

  private void btnRegistrarEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEscuelaActionPerformed
    String nombre = tbNombre.getText();
    String codigo = tbCodigo.getText();
    
    EscuelaOAreaAcademica escuela = new EscuelaOAreaAcademica(nombre, codigo);
    
    conexion.insertarEscuela(escuela);
  }//GEN-LAST:event_btnRegistrarEscuelaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegistroEscuela().setVisible(true);
//            }
//        });
//    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnLimpiarCampos;
  private javax.swing.JButton btnRegistrarEscuela;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField tbCodigo;
  private javax.swing.JTextField tbNombre;
  // End of variables declaration//GEN-END:variables
}