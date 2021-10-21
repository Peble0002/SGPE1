/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import conexionBD.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS LEITON
 */
public class ConsultarPlanEstudio extends javax.swing.JFrame {
  PlanDeEstudioBD conexion = new PlanDeEstudioBD();
  EscuelaOAreaAcademicaBD conexionEscuela = new EscuelaOAreaAcademicaBD();
  EscuelaPlanEstudioBD conexionPlanEscuela = new EscuelaPlanEstudioBD();

    /**
     * Creates new form ConsultarPlanEstudio
     */
    public ConsultarPlanEstudio() {
        initComponents();
        cargarComboBoxEscuelas();
    }
    
    private void cargarTabla() throws SQLException{
      String info = (String) cbEscuelaPropietaria.getSelectedItem();
      //String escuela = info.substring(0, info.indexOf("-")-1);
      String codigo = info.substring(info.indexOf(":")+2, info.length());
      
      //tbVigenciaPlan.setText(conexion.obtenerFechaVigencia(codigo).toString());
      
      DefaultTableModel modeloTabla = (DefaultTableModel) tablaPlanEstudios.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs = conexion.consultarPlanEstudio(codigo);
      int columnas = rs.getMetaData().getColumnCount();
      
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
    
    private void cargarComboBoxEscuelas(){
      //ResultSet rs = conexionEscuela.consultarEscuelas();
      ResultSet rs = conexionPlanEscuela.consultarEscuelaPlan();
      
      try{
        while(rs.next()){
          cbEscuelaPropietaria.addItem(rs.getString("Nombre") + " - Plan de estudio: " + rs.getString("NumeroPlan"));
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

    btnGenerarPDFYCorreo = new javax.swing.JButton();
    tbVigenciaPlan = new javax.swing.JTextField();
    btnRegresar = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    cbEscuelaPropietaria = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaPlanEstudios = new javax.swing.JTable();
    btnRealizarBusqueda = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    btnGenerarPDFYCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnGenerarPDFYCorreo.setText("Generar PDF y enviar por correo");

    tbVigenciaPlan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tbVigenciaPlanActionPerformed(evt);
      }
    });

    btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnRegresar.setText("Regresar");
    btnRegresar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegresarActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("CONSULTAR PLAN DE ESTUDIO");

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setText("Vigencia del plan de estudios: ");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel2.setText("Escuela propietaria del curso: ");

    tablaPlanEstudios.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Código del curso", "Nombre del curso", "Bloque", "Horas de la clase", "Créditos"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaPlanEstudios);

    btnRealizarBusqueda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnRealizarBusqueda.setText("Buscar plan de Estudios");
    btnRealizarBusqueda.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRealizarBusquedaActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(756, 756, 756)
        .addComponent(btnRegresar)
        .addContainerGap(35, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cbEscuelaPropietaria, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(tbVigenciaPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(btnRealizarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(90, 90, 90)
            .addComponent(btnGenerarPDFYCorreo)
            .addGap(35, 35, 35))))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(253, 253, 253)
          .addComponent(jLabel1)
          .addContainerGap(352, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(70, 70, 70)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(cbEscuelaPropietaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2))
        .addGap(32, 32, 32)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tbVigenciaPlan))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGenerarPDFYCorreo)
          .addComponent(btnRealizarBusqueda))
        .addGap(19, 19, 19)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnRegresar)
        .addContainerGap())
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(18, 18, 18)
          .addComponent(jLabel1)
          .addContainerGap(502, Short.MAX_VALUE)))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void tbVigenciaPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbVigenciaPlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbVigenciaPlanActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
      Principal nPrincipal = new Principal();
      nPrincipal.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

  private void btnRealizarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarBusquedaActionPerformed
    try {
      cargarTabla();
    } catch (SQLException ex) {
      Logger.getLogger(ConsultarPlanEstudio.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnRealizarBusquedaActionPerformed

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
//            java.util.logging.Logger.getLogger(ConsultarPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultarPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultarPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultarPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultarPlanEstudio().setVisible(true);
//            }
//        });
//    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnGenerarPDFYCorreo;
  private javax.swing.JButton btnRealizarBusqueda;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JComboBox<String> cbEscuelaPropietaria;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tablaPlanEstudios;
  private javax.swing.JTextField tbVigenciaPlan;
  // End of variables declaration//GEN-END:variables
}
