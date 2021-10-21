/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.*;
import conexionBD.*;

/**
 *
 * @author LUIS LEITON
 */
public class ConsultarCursoPlanEstudio extends javax.swing.JFrame {
  Curso_PlanEstudioBD conexion = new Curso_PlanEstudioBD();

    /**
     * Creates new form ConsultarCursoPlanEstudio
     */
    public ConsultarCursoPlanEstudio() {
        initComponents();
    }
    
    private void cargarTabla(Curso pCurso) throws SQLException{
      DefaultTableModel modeloTabla = (DefaultTableModel) tablaPlanEstudios.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs = conexion.consultarPlanesEstudioCurso(pCurso);
      ResultSet consulta = conexion.consultarPlanesEstudioCurso(pCurso);
      int columnas = rs.getMetaData().getColumnCount();
      
      if(!consulta.next()){
        JOptionPane.showMessageDialog(null, "No existe el curso " + pCurso.getIdCursos() + " o no está relacionado a ningún plan de estudio.");
        return;
      }
      
      try{
        while(rs.next()){
        Object[] fila = new Object[columnas];
        for(int indice = 0; indice < columnas; indice++){
          fila[indice] = rs.getObject(indice+1);
        }
        modeloTabla.addRow(fila);
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
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
    jLabel4 = new javax.swing.JLabel();
    tbCodigoCurso = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaPlanEstudios = new javax.swing.JTable();
    btnRegresar = new javax.swing.JButton();
    btnConsultar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("CONSULTAR PLANES DE ESTUDIO CON UN CURSO ESPECÍFICO");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel4.setText("Código del curso: ");

    tbCodigoCurso.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tbCodigoCursoActionPerformed(evt);
      }
    });

    tablaPlanEstudios.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Código carrera", "Nombre carrera", "Código plan"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaPlanEstudios);
    if (tablaPlanEstudios.getColumnModel().getColumnCount() > 0) {
      tablaPlanEstudios.getColumnModel().getColumn(0).setMinWidth(100);
      tablaPlanEstudios.getColumnModel().getColumn(0).setPreferredWidth(100);
      tablaPlanEstudios.getColumnModel().getColumn(0).setMaxWidth(110);
      tablaPlanEstudios.getColumnModel().getColumn(1).setMinWidth(550);
      tablaPlanEstudios.getColumnModel().getColumn(1).setPreferredWidth(550);
      tablaPlanEstudios.getColumnModel().getColumn(1).setMaxWidth(560);
      tablaPlanEstudios.getColumnModel().getColumn(2).setMinWidth(110);
      tablaPlanEstudios.getColumnModel().getColumn(2).setPreferredWidth(110);
      tablaPlanEstudios.getColumnModel().getColumn(2).setMaxWidth(120);
    }

    btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnRegresar.setText("Regresar");
    btnRegresar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegresarActionPerformed(evt);
      }
    });

    btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnConsultar.setText("Consultar");
    btnConsultar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(143, 143, 143)
            .addComponent(jLabel1))
          .addGroup(layout.createSequentialGroup()
            .addGap(382, 382, 382)
            .addComponent(btnRegresar))
          .addGroup(layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(tbCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(btnConsultar)))))
        .addContainerGap(40, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(jLabel1)
        .addGap(26, 26, 26)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(tbCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnConsultar)))
        .addGap(31, 31, 31)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(26, 26, 26)
        .addComponent(btnRegresar)
        .addContainerGap(28, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void tbCodigoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCodigoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCodigoCursoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Principal nPrincipal = new Principal();
        nPrincipal.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

  private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
    Curso curso = new Curso(tbCodigoCurso.getText());
      try {
        cargarTabla(curso);
      } catch (SQLException ex) {
        Logger.getLogger(ConsultarCursoPlanEstudio.class.getName()).log(Level.SEVERE, null, ex);
      }
  }//GEN-LAST:event_btnConsultarActionPerformed

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
//            java.util.logging.Logger.getLogger(ConsultarCursoPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultarCursoPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultarCursoPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultarCursoPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultarCursoPlanEstudio().setVisible(true);
//            }
//        });
//    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnConsultar;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tablaPlanEstudios;
  private javax.swing.JTextField tbCodigoCurso;
  // End of variables declaration//GEN-END:variables
}
