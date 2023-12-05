package View;
import Controller.ServicioController;
import Model.Servicio;
import Model.Soporte;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class AdminSoporte extends javax.swing.JFrame {
     DefaultTableModel dtmSer = new DefaultTableModel();
     ServicioController oser = new ServicioController();
    
    public AdminSoporte() {
        initComponents();
        llenarTablaSer();
        llenarListaSer();
        setLocationRelativeTo(null);
    }

   public void llenarTablaSer(){
        dtmSer.addColumn("CODIGO");
        dtmSer.addColumn("SERVICIO");
        dtmSer.addColumn("MONTO");
        this.tServicio.setModel(dtmSer);
    }
    
    public void llenarListaSer(){
        List<Servicio> lst = oser.getLstServicioController();
        dtmSer.setRowCount(0);
        for(int i=0;i<lst.size();i++) {
            Object[] vec=new Object[3];
            vec[0] = lst.get(i).getIDServicio();
            vec[1] = lst.get(i).getDesServicio();
            vec[2] = lst.get(i).getPreServicio();
            dtmSer.addRow(vec);
        }
        this.tServicio.setModel(dtmSer);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tServicio = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        txtSer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Servicios de Soporte Técnico");

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tServicio);

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Servicio:");

        btnSiguiente.setBackground(new java.awt.Color(95, 108, 221));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Tabla de solicitudes");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Monto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(txtSer))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGrabar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnSiguiente)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGrabar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int msg = JOptionPane.showConfirmDialog(this,"Deseas Modificar el Servicio","Modificar",JOptionPane.YES_NO_OPTION);
        if(msg==JOptionPane.YES_OPTION){
            Servicio objSer = new Servicio();
            //objSer.setIDServicio(Integer.parseInt(txtCodigoS.getText()));
            objSer.setDesServicio(this.txtSer.getText());
            objSer.setPreServicio(Double.parseDouble(this.txtMonto.getText()));
            oser.updateServicioControl(objSer);
            JOptionPane.showMessageDialog(this,"Servicio Actualizado!!!","Mensaje",1);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"No se encontro!!!","Mensaje",3);
        }
        llenarListaSer();
        limpiar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int msg = JOptionPane.showConfirmDialog(this,"Deseas Eliminar el Registro","Eliminar",JOptionPane.YES_NO_OPTION);
        if(msg == JOptionPane.YES_OPTION){
            Servicio objSer = new Servicio();
            //objSer.setIDServicio(Integer.parseInt(txtCodigoS.getText()));
            llenarListaSer();
            oser.removeServicioControl(objSer);
            JOptionPane.showMessageDialog(this, "Registro Eliminado satisfactoriamente!");
        }
        else
        {
            return;
        }
        llenarListaSer();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        /*txtCodigo.setEnabled(true);
        if(txtCodigo.getText().equals("")){
            txtCodigo.requestFocus();
        }
        else
        {
            int msg = JOptionPane.showConfirmDialog(this,"Deseas Buscar el Registro","Buscar",JOptionPane.YES_NO_OPTION);
            if(msg == JOptionPane.YES_OPTION){
                alumno a = oalu.buscarAlumno(getCodigo());
                if(a == null){
                    JOptionPane.showMessageDialog(this,"No se encuentro!!!");
                    this.txtCodigo.requestFocus();
                }
                else{
                    txtCodigo.setText("" + a.getCod());
                    txtnombre.setText(a.getNom());
                    cboTipo.setSelectedItem(a.getTip());
                    txtpension.setText("" + a.getPen());
                }
            }
        }*/
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        int msg = JOptionPane.showConfirmDialog(this,"Deseas Agregar el servicio?","Agregar",JOptionPane.YES_NO_OPTION);
        if(msg==JOptionPane.YES_OPTION){
            Servicio objSer = new Servicio();
            //objSer.setIDServicio(Integer.parseInt(txtCodigoS.getText()));
            objSer.setDesServicio(this.txtSer.getText());
            objSer.setPreServicio(Double.parseDouble(this.txtMonto.getText()));
            oser.addServicioControl(objSer);
            JOptionPane.showMessageDialog(this, "Registro Grabado satisfactoriamente!");
        }
        else
        {
            txtSer.requestFocus();
        }
        llenarListaSer();
        limpiar();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        AdminTabla AT = new AdminTabla();
        this.dispose();
        AT.setVisible(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(AdminSoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminSoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminSoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminSoporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminSoporte().setVisible(true);
            }
        });
    }
    
    public void limpiar()
    {
        this.txtSer.setText("");
        this.txtMonto.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tServicio;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtSer;
    // End of variables declaration//GEN-END:variables
}