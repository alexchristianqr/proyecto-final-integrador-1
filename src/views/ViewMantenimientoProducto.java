package views;

import models.Producto;
import controllers.ProductoController;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewMantenimientoProducto extends javax.swing.JInternalFrame {

    ProductoController productoController = new ProductoController();
    Producto producto;
    String accion = null;

    public ViewMantenimientoProducto() {
        initComponents();
        listarProductos();
        deshabilitarFormulario();
    }

    protected final void listarProductos() {
        DefaultTableModel modelo = productoController.listarProductos("");
        tblListado.setModel(modelo);
    }

    protected final void deshabilitarFormulario() {

        lblIdProducto.setVisible(false);
        txtIdProducto.setVisible(false);
        txtIdProducto.setEnabled(false);

        txtNombre.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtCantidad.setEnabled(false);
        // --
        txtNombre.setText(null);
        txtPrecio.setText(null);
        txtCantidad.setText(null);

        // --
        btnNuevo.setEnabled(true);// Habilitar boton nuevo
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    protected final void habilitarFormulario() {

        txtNombre.setEnabled(true);
        txtPrecio.setEnabled(true);
        txtCantidad.setEnabled(true);

        // --
        txtNombre.setText(null);
        txtPrecio.setText(null);
        txtCantidad.setText(null);

        // --
        btnNuevo.setEnabled(false);// Deshabilitar boton nuevo
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    protected final void controlAccionFormulario() {
        switch (accion) {
            case "GUARDAR":
                lblIdProducto.setVisible(false);
                txtIdProducto.setVisible(false);
                txtIdProducto.setEnabled(false);
                btnGuardar.setText("Guardar");
                break;
            case "ACTUALIZAR":
                lblIdProducto.setVisible(true);
                txtIdProducto.setVisible(true);
                txtIdProducto.setEnabled(false);
                btnGuardar.setText("Actualizar");
                break;
            default:
                throw new Error("Error en la acción del formulario");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar1 = new javax.swing.JButton();
        lblIdProducto = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar Productos");
        setPreferredSize(new java.awt.Dimension(1200, 402));

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Precio:");

        jLabel3.setText("Cantidad:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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

        lblIdProducto.setText("Código:");

        txtIdProducto.setText("E001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrar1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdProducto)
                            .addComponent(txtPrecio)
                            .addComponent(txtNombre)
                            .addComponent(txtCantidad))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdProducto)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCerrar1)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de productos"));

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Importe"
            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        String descripcion = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidadStock = Integer.parseInt(txtCantidad.getText());

        producto = new Producto();
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidadStock(cantidadStock);

        if (accion.equals("GUARDAR")) {
            // Guardar
            productoController.crearProducto(producto);

            // Notificar mensaje
            JOptionPane.showMessageDialog(rootPane, "Guardado con éxito");

            // Listar registros
            listarProductos();

            // Reiniciar formulario
            deshabilitarFormulario();
        } else if (accion.equals("ACTUALIZAR")) {
            // Obtener ID guardado
            producto.setIdProducto(Integer.parseInt(txtIdProducto.getText()));

            // Actualizar habitación
            productoController.actualizarProducto(producto);

            // Notificar mensaje
            JOptionPane.showMessageDialog(rootPane, "Actualizado con éxito");

            // Listar registros
            listarProductos();

            // Reiniciar formulario
            deshabilitarFormulario();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Obtén la fila seleccionada de la tabla
        int selectedRow = tblListado.getSelectedRow();

        // Verifica si se ha seleccionado alguna fila
        if (selectedRow >= 0) {
            // Obtén el código del producto a eliminar
            int codigo = (int) tblListado.getValueAt(selectedRow, 0);

            producto.setIdProducto(codigo);
            productoController.eliminarProducto(producto);

        } else {
            // Muestra un mensaje si no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        accion = "GUARDAR";
        controlAccionFormulario();
        habilitarFormulario();
    }//GEN-LAST:event_btnNuevoActionPerformed

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

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        // TODO add your handling code here:

        accion = "ACTUALIZAR";
        controlAccionFormulario();
        habilitarFormulario();

        int fila = tblListado.rowAtPoint(evt.getPoint());

        txtIdProducto.setText(tblListado.getValueAt(fila, 0).toString());
        txtNombre.setText(tblListado.getValueAt(fila, 1).toString());
        txtPrecio.setText(tblListado.getValueAt(fila, 2).toString());
        txtCantidad.setText(tblListado.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tblListadoMouseClicked
    void actualizarTabla() {
//    DefaultTableModel tabla = (DefaultTableModel) this.tblProductos.getModel();

        producto = new Producto();
        producto.setDescripcion(txtNombre.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
        producto.setCantidadStock(Integer.parseInt(txtCantidad.getText()));

        productoController.actualizarProducto(producto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdProducto;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
