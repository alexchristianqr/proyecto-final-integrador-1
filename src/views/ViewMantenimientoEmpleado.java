package views;

import controllers.EmpleadoController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Empleado;

public class ViewMantenimientoEmpleado extends javax.swing.JInternalFrame {

    EmpleadoController empleadoController = new EmpleadoController();
    Empleado empleado, oEmpleado;
    String accion = null;
    DefaultTableModel modelo;

    public ViewMantenimientoEmpleado() {
        initComponents();
        listarEmpleados();
        deshabilitarFormulario();
    }

    protected final void controlAccionFormulario() {
        switch (accion) {
            case "GUARDAR":
                lblIdEmpleado.setVisible(false);
                txtIdEmpleado.setVisible(false);
                txtIdEmpleado.setEnabled(false);
                btnGuardar.setText("Guardar");
                break;
            case "ACTUALIZAR":
                lblIdEmpleado.setVisible(true);
                txtIdEmpleado.setVisible(true);
                txtIdEmpleado.setEnabled(false);
                btnGuardar.setText("Actualizar");
                break;
            default:
                throw new Error("Error en la acción del formulario");
        }
    }

    protected final void deshabilitarFormulario() {

        lblIdEmpleado.setVisible(false);
        txtIdEmpleado.setVisible(false);
        txtIdEmpleado.setEnabled(false);

        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtNroDocumento.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEdad.setEnabled(false);
        rbnFemenino.setEnabled(false);
        rbnMasculino.setEnabled(false);
        cbxEstado.setEnabled(false);
        cbxIdPerfil.setEnabled(false);
        cbxTipoDocumento.setEnabled(false);
        txtSueldo.setEnabled(false);
        // --
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtNroDocumento.setText(null);
        txtTelefono.setText(null);
        txtEdad.setText(null);

        // --
        btnNuevo.setEnabled(true);// Habilitar boton nuevo
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    protected final void habilitarFormulario() {

        txtNombre.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtNroDocumento.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEdad.setEnabled(true);
        rbnFemenino.setEnabled(true);
        rbnMasculino.setEnabled(true);
        cbxEstado.setEnabled(true);
        cbxIdPerfil.setEnabled(true);
        cbxTipoDocumento.setEnabled(true);
        txtSueldo.setEnabled(true);

        // --
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtNroDocumento.setText(null);
        txtTelefono.setText(null);
        txtEdad.setText(null);

        // --
        btnNuevo.setEnabled(false);// Deshabilitar boton nuevo
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    protected final void listarEmpleados() {
        // Obtener modelo de controlador
        modelo = empleadoController.listarEmpleados("");

        // Cargar modelo en dialog
        DialogListadoEmpleados.modelo = modelo;

        tblListado.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblIdEmpleado = new javax.swing.JLabel();
        lblDniEmpleado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        txtNroDocumento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        rbnFemenino = new javax.swing.JRadioButton();
        rbnMasculino = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoDocumento = new javax.swing.JComboBox<>();
        cbxIdPerfil = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empleados");
        setPreferredSize(new java.awt.Dimension(1200, 640));

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado"));

        lblIdEmpleado.setText("Código:");

        lblDniEmpleado.setText("Nro documento:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Sexo:");

        jLabel6.setText("Edad:");

        jLabel7.setText("Teléfono:");

        txtIdEmpleado.setText("E001");

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnFemenino);
        rbnFemenino.setText("F");

        buttonGroup1.add(rbnMasculino);
        rbnMasculino.setSelected(true);
        rbnMasculino.setText("M");

        jLabel1.setText("Perfil");

        jLabel2.setText("Sueldo:");

        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));

        jLabel8.setText("Estado:");

        jLabel9.setText("Tipo documento:");

        cbxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC", "PASAPORTE", "CARNET DE EXTRANJERIA" }));
        cbxTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoDocumentoActionPerformed(evt);
            }
        });

        cbxIdPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "recepcionista" }));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCerrar1.setText("Cerrar");
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtApellidos)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbnFemenino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbnMasculino)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSueldo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono)
                            .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEdad)
                            .addComponent(cbxIdPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(lblDniEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdEmpleado)
                            .addComponent(txtNroDocumento)
                            .addComponent(cbxTipoDocumento, 0, 202, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEmpleado)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDniEmpleado)
                    .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2))
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnFemenino)
                    .addComponent(rbnMasculino)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnCerrar1))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        // TODO add your handling code here:

        accion = "ACTUALIZAR";
        controlAccionFormulario();
        habilitarFormulario();

        int fila = tblListado.rowAtPoint(evt.getPoint());

        txtIdEmpleado.setText(tblListado.getValueAt(fila, 0).toString());
        txtNombre.setText(tblListado.getValueAt(fila, 1).toString());
        txtApellidos.setText(tblListado.getValueAt(fila, 2).toString());
        cbxTipoDocumento.setSelectedItem(tblListado.getValueAt(fila, 3).toString());
        txtNroDocumento.setText(tblListado.getValueAt(fila, 4).toString());
        txtSueldo.setText(tblListado.getValueAt(fila, 5).toString());
        int indexIdPerfil = Integer.parseInt(tblListado.getValueAt(fila, 6).toString()) - 1;
        cbxIdPerfil.setSelectedIndex(indexIdPerfil);
        txtEdad.setText(tblListado.getValueAt(fila, 7).toString());
        String sexo = tblListado.getValueAt(fila, 8).toString();
        if (sexo.equalsIgnoreCase("F")) {
            rbnFemenino.setSelected(true);
        } else if (sexo.equalsIgnoreCase("M")) {
            rbnMasculino.setSelected(true);
        }
        txtTelefono.setText(tblListado.getValueAt(fila, 9).toString());
        cbxEstado.setSelectedItem(tblListado.getValueAt(fila, 10).toString());
    }//GEN-LAST:event_tblListadoMouseClicked

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void cbxTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoDocumentoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        accion = "GUARDAR";
        controlAccionFormulario();
        habilitarFormulario();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        empleado = new Empleado();
        empleado.setNroDocumento(txtNroDocumento.getText());
        empleado.setNombre(txtNombre.getText());
        empleado.setApellidos(txtApellidos.getText());
        empleado.setEdad(txtEdad.getText());
        empleado.setTelefono(txtTelefono.getText());
        empleado.setEstado(cbxEstado.getSelectedItem().toString());
        String sexo;
        if (rbnFemenino.isSelected() == true) {
            sexo = "F";
        } else {
            sexo = "M";
        }
        empleado.setSexo(sexo);
        empleado.setIdPerfil(cbxIdPerfil.getSelectedIndex() + 1);// 1/2
        empleado.setSueldo((Double.parseDouble(txtSueldo.getText())));

        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaActual = LocalDateTime.now().format(formatoDeFecha);
        empleado.setFechaCreado(fechaActual);
        empleado.setFechaActualizado(fechaActual);

        if (accion.equals("GUARDAR")) {
            // Guardar cliente
            empleadoController.crearEmpleado(empleado);

            // Notificar mensaje
            JOptionPane.showMessageDialog(rootPane, "Guardado con éxito");

            // Listar registros
            listarEmpleados();

            // Reiniciar formulario
            deshabilitarFormulario();
        } else if (accion.equals("ACTUALIZAR")) {
            // Obtener ID guardado
            empleado.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));

            // Actualizar habitación
            empleadoController.actualizarEmpleado(empleado);

            // Notificar mensaje
            JOptionPane.showMessageDialog(rootPane, "Actualizado con éxito");

            // Listar registros
            listarEmpleados();

            // Reiniciar formulario
            deshabilitarFormulario();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        accion = "GUARDAR";
        controlAccionFormulario();
        deshabilitarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        // TODO add your handling code here:

        dispose();
    }//GEN-LAST:event_btnCerrar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxIdPerfil;
    private javax.swing.JComboBox<String> cbxTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDniEmpleado;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JRadioButton rbnFemenino;
    private javax.swing.JRadioButton rbnMasculino;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
