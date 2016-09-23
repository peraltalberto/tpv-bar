/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;

import es.tpv_bar.VentanaTPV;
import es.tpv_bar.gui.DlTecladoNum;
import es.tpv_bar.persistencia.modelos.LineaModel;
import es.tpv_bar.persistencia.pojos.Linea;
import es.tpv_bar.persistencia.pojos.Productos;
import es.tpv_bar.util.TPVUtil;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author aperalta
 */
public class BTLineas extends javax.swing.JPanel {

    /**
     * Creates new form BTLineas
     */
    public BTLineas() {
        initComponents();
    }
    Productos producto;
    VentanaTPV parent;
    Linea linea;

    public BTLineas(Productos producto, VentanaTPV parent) {
        this();
        this.parent = parent;
        this.producto = producto;

        this.linea = new Linea();

        addProducto();

    }

    public BTLineas(Linea linea, VentanaTPV parent) {
        this();
        this.parent = parent;
        this.producto = linea.getProductos();
        this.linea = linea;
        if (linea.isInvitacion()) {
            this.txPrecio.setForeground(Color.green);
            System.out.println("Invitación");
            this.txPrecio.updateUI();
        }
        this.lbProducto.setText(this.producto.getNombre());
        this.txPrecio.setText(this.linea.getPrecio().toString());
        this.txCantidad.setText(this.linea.getCatidad().toString());
        this.lbTotal.setText(this.linea.getTotal().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txPrecio1 = new javax.swing.JTextField();
        lbProducto = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txCantidad = new javax.swing.JTextField();
        lbTotal = new javax.swing.JLabel();

        txPrecio1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txPrecio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPrecio1.setText("0.0");
        txPrecio1.setToolTipText("");

        setMaximumSize(new java.awt.Dimension(700, 26));
        setName(""); // NOI18N

        lbProducto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbProducto.setText("Producto");
        lbProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbProductoMouseClicked(evt);
            }
        });

        jCheckBox1.setSelected(true);

        txPrecio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPrecio.setText("0.0");
        txPrecio.setToolTipText("");
        txPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPrecioFocusGained(evt);
            }
        });
        txPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txPrecioMouseClicked(evt);
            }
        });
        txPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrecioActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334646224_list-remove.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        txCantidad.setBackground(new java.awt.Color(204, 204, 204));
        txCantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCantidad.setText("001");
        txCantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txCantidadFocusGained(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("999.99");
        lbTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addGap(8, 8, 8)
                .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txCantidad)))
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    DlTecladoNum tld;
    private void txPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txPrecioMouseClicked
        // numeros();
    }//GEN-LAST:event_txPrecioMouseClicked
    private void numeros(final JTextField jt) {
       
        tld = new DlTecladoNum(parent, true, jt);
        tld.setVisible(true);
        tld.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Escribiendo....");

                linea.setPrecio(Double.parseDouble(txPrecio.getText()));
                linea.setCatidad(Double.parseDouble(txCantidad.getText()));
                linea.setTotal(TPVUtil.round(Double.parseDouble(txPrecio.getText())*Double.parseDouble(txCantidad.getText())));
                lbTotal.setText(linea.getTotal().toString());
                if (tld.isInvita()) {
                    
                    linea.setInvitacion(true);
                    linea.setTotal(0.0);
                    lbTotal.setText(linea.getTotal().toString());
                    txPrecio.setText("0.0");
                    System.out.print("yo invito");
                }
                parent.actualizarLinea(linea);
                System.out.println(linea.getPrecio());
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

    }
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (JOptionPane.showConfirmDialog(parent, "¿Esta seguro de eliminar este producto?") == 0) {
            this.parent.eliminarLinea(linea);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProductoMouseClicked
        if (this.jCheckBox1.isSelected()) {
            this.jCheckBox1.setSelected(false);
        } else {
            this.jCheckBox1.setSelected(true);
        }
    }//GEN-LAST:event_lbProductoMouseClicked

    private void txPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPrecioFocusGained
        this.txPrecio.transferFocus();
        numeros(this.txPrecio);
        
    }//GEN-LAST:event_txPrecioFocusGained

    private void txCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCantidadFocusGained
       //this.txCantidad.transferFocus();
        this.jCheckBox1.grabFocus();
       numeros(this.txCantidad);
    }//GEN-LAST:event_txCantidadFocusGained

    private void txPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbProducto;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTextField txCantidad;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txPrecio1;
    // End of variables declaration//GEN-END:variables

    private void addProducto() {
        this.lbProducto.setText(this.producto.getNombre());
        this.txPrecio.setText(this.producto.getPrecio().toString());
        this.linea.setPrecio(TPVUtil.round(this.producto.getPrecio()));
        this.linea.setCatidad(TPVUtil.round(Double.valueOf(this.txCantidad.getText())));
        this.linea.setProductos(producto);
        this.linea.setUbicacion(this.parent.getUbicacion());
        this.linea.setTotal(TPVUtil.round(this.producto.getPrecio()*Double.valueOf(this.txCantidad.getText())));
        lbTotal.setText(linea.getTotal().toString());
        this.parent.lineas.saveDato(this.linea);
    }

    public boolean isSelect() {
        return this.jCheckBox1.isSelected();
    }

    public void setSelect(boolean select) {
        this.jCheckBox1.setSelected(select);
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public void setNewPrecio(Double precio) {
                linea.setPrecio(precio);
                linea.setTotal(TPVUtil.round(precio*Double.valueOf(this.txCantidad.getText())));
                lbTotal.setText(linea.getTotal().toString());
                this.txPrecio.setText(precio.toString());
                parent.actualizarLinea(linea);
                lbProducto.grabFocus();
    }
    public void setCantidad(Double cantidad){
                linea.setCatidad(cantidad);
                linea.setTotal(TPVUtil.round(linea.getPrecio()*cantidad));
                lbTotal.setText(linea.getTotal().toString());
                parent.actualizarLinea(linea);
                lbProducto.grabFocus();
    }
    public double getTotal(){
        return linea.getTotal();
    }
}
