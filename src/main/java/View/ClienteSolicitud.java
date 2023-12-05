package View;
import Controller.ClienteController;
import Controller.EquipoController;
import Controller.ServicioController;
import Controller.SoporteController;
import Model.Cliente;
import Model.Equipo;
import Model.Servicio;
import Model.Soporte;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;

public class ClienteSolicitud extends javax.swing.JFrame {
    
    DefaultListModel dlm = new DefaultListModel();
    EquipoController cEquipo = new EquipoController();
    ClienteController cCliente = new ClienteController();
    ServicioController cServicio = new ServicioController();
    SoporteController cSoporte = new SoporteController();
    private static Soporte objSop = new Soporte();
    public ClienteSolicitud() {
        initComponents();
        MostrarSolicitud();
        setLocationRelativeTo(null);
    }
    
    public void SetEquipo(int ID){
        objSop.setIDEquipo(ID);
    }
    public void SetCliente(int ID){
        objSop.setIDCliente(ID);
    }
    public void SetServicio(int ID){
        objSop.setIDServicio(ID);
    }
    public void SetDescripcion(String Des){
        objSop.setDescripcion(Des);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSolicitud = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Label1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Label1.setText("Solicitud de Soporte Técnico");

        btnAceptar.setBackground(new java.awt.Color(95, 108, 221));
        btnAceptar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(95, 108, 221));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lstSolicitud.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstSolicitud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(Label1)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        JOptionPane.showMessageDialog(this,"Solicitud Enviada, Muchas gracias!","Mensaje",1);
        objSop.setEstado("Vigente");
        objSop.setSolucion("A ESPERA DE SOLUCIÓN");
        cSoporte.addSopControl(objSop);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int msg = JOptionPane.showConfirmDialog(this,"Desea cancelar la Solicitud?","Cancelar",JOptionPane.YES_NO_OPTION);
       if(msg == JOptionPane.YES_OPTION){
           this.dispose();
       }
    }//GEN-LAST:event_btnCancelarActionPerformed
    public void MostrarSolicitud(){
        Equipo objE = cEquipo.busquedaEquibyID(String.valueOf(objSop.getIDEquipo()));
        Cliente objC = cCliente.busquedaClibyID(String.valueOf(objSop.getIDCliente()));
        Servicio objS = cServicio.busquedaClibyID(String.valueOf(objSop.getIDServicio()));
        objSop.setMonto(objS.getPreServicio());
        lstSolicitud.setModel(dlm);
        dlm.addElement("Cliente: " + objC.getNomCliente() + " " + objC.getApeCliente());
        dlm.addElement("Equipo: " + objE.getDesEquipo());
        dlm.addElement("Servicio: " + objS.getDesServicio());
        dlm.addElement("Monto: " + objS.getPreServicio());
        dlm.addElement("Problema: " + objSop.getDescripcion());
        dlm.addElement("Estado: VIGENTE ");
        dlm.addElement("Solución: A ESPERA DE SOLUCIÓN ");       
    }

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
            java.util.logging.Logger.getLogger(ClienteSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteSolicitud().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstSolicitud;
    // End of variables declaration//GEN-END:variables
}
