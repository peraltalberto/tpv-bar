/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar;

import es.tpv_bar.gui.administracion.dialogs.HistoricoTickets;
import es.tpv_bar.gui.botones.BTCategoria;
import es.tpv_bar.gui.botones.BTLineas;
import es.tpv_bar.gui.botones.BTProducto;
import es.tpv_bar.gui.botones.BTTickets;
import es.tpv_bar.gui.renderes.ComboBoxImgRenderer;
import es.tpv_bar.gui.ventanas.*;
import es.tpv_bar.persistencia.modelos.*;
import es.tpv_bar.persistencia.pojos.*;
import es.tpv_bar.prints.Print;
import es.tpv_bar.prints.TicketCierre;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class VentanaTPV extends javax.swing.JFrame {

    /**
     * Variables de los modelos de datos
     */
    VentanaTPV instanceOf;
    VentanaMesas mesa;
    CategoriaModel categorias = new CategoriaModel();
    ProductosModel productos = new ProductosModel();
    AtipicasModel atipicas = new AtipicasModel();
    BloqueUbicacionModel bloques = new BloqueUbicacionModel();
    CajaModel caja = new CajaModel();
    CabezeraModel cabezeras = new CabezeraModel();
    ConfiguracionModel conf = new ConfiguracionModel();
    Print impresora = new Print();
    //CamareroModel camareros = new CamareroModel();
    Camarero camarero;
    public LineaModel lineas = new LineaModel();
    NumberFormat nf = new DecimalFormat("0.00");

    /**
     * Creates new form VentanaTPV
     */
    public VentanaTPV() {
        instanceOf = this;
        initComponents();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.conf.getValue("imagen")).getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
         lbTitulo.setIcon(imageIcon);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);

        this.toFront();
        this.setAlwaysOnTop(true);
        cargarBloques();
        cargarCategorias();
        
        this.lbTitulo.setText(conf.getValue("nombre"));
        this.jTabbedPane1.setIconAt(0, new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/addCafe.png")));
        this.jTabbedPane1.setIconAt(1, new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/ticketCafe.png")));
        this.cargaTickets();
    }

    private void cargarCategorias() {
        ArrayList<Categoria> cat = categorias.getLista();
        for (int i = 0; i < cat.size(); i++) {
            if (!cat.get(i).isActivo()) {
                continue;
            }

            final BTCategoria bt = new BTCategoria(cat.get(i));
            bt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    cargarProductos(bt.getCategoria());
                }
            });
            this.pCategorias.add(bt);
        }
    }
    ArrayList<Bloqueubicacion> b;

    private void cargarBloques() {
        b = bloques.getLista();

        ComboBoxImgRenderer renderer = new ComboBoxImgRenderer(b);
        this.cbBloques.removeAllItems();
        for (int i = 0; i < b.size(); i++) {
            this.cbBloques.addItem(i);
        }
        this.cbBloques.setRenderer(renderer);

    }

    private void cargarProductos(Categoria cat) {
        this.pProductos.removeAll();
        ArrayList<Productos> prod = (ArrayList<Productos>) productos.busquedaDatos("categoria", cat);
        for (int i = 0; i < prod.size(); i++) {
            if (!prod.get(i).isActivo()) {
                continue;
            }
            final BTProducto bt = new BTProducto(prod.get(i));

            bt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (ubicacion != null) {
                        Atipicas ati = atipicas.getAtipica(ubicacion.getBloqueubicacion(), bt.getProducto());

                        double mul = Double.valueOf(multiplicador.getText());
                        //for (int i = 0; i < mul; i++) {
                            BTLineas btl = new BTLineas(bt.getProducto(), instanceOf);
                            panelLineas.add(btl);
                            if (ati != null) {
                                btl.setNewPrecio(ati.getPrecio());
                                //total += ati.getPrecio();  
                            } 
                            btl.setCantidad(mul);
                            total += btl.getTotal();
                       // }
                        multiplicador.setText("1");
                    }
                    txTotal.setText(nf.format(total));
                    panelLineas.updateUI();
                }
            });
            this.pProductos.add(bt);
        }
        this.pProductos.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jToolBar2 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        lbUbicacion = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        cbBloques = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        jButton12 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelLineas = new javax.swing.JPanel();
        jToolBar8 = new javax.swing.JToolBar();
        jButton11 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jToolBar6 = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        txTotal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        pCategorias = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pProductos = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        multiplicador = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar2.setFloatable(false);

        jToolBar3.setFloatable(false);

        jPanel4.setMaximumSize(new java.awt.Dimension(400, 32767));
        jPanel4.setName(""); // NOI18N

        lbUbicacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor24.png"))); // NOI18N
        lbUbicacion.setText("Ubicacion");

        lbTitulo.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(26, 0, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/leo.png"))); // NOI18N
        lbTitulo.setText("La Tasca de leo");
        lbTitulo.setToolTipText("");

        jToolBar1.setFloatable(false);

        cbBloques.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        cbBloques.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBloquesItemStateChanged(evt);
            }
        });
        cbBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBloquesActionPerformed(evt);
            }
        });
        jToolBar1.add(cbBloques);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334673090_Log Out.png"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToolBar4.setFloatable(false);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1339319752_search_blue.png"))); // NOI18N
        jButton12.setToolTipText("");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton12);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jToolBar7.setFloatable(false);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335698153_select.png"))); // NOI18N
        jButton10.setText("Sel.Todo");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton10);

        panelLineas.setLayout(new javax.swing.BoxLayout(panelLineas, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelLineas);

        jToolBar8.setFloatable(false);

        jButton11.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335695322_java_src.png"))); // NOI18N
        jButton11.setText("Imp. y cobrar");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar8.add(jButton11);

        jButton5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335695322_java_src.png"))); // NOI18N
        jButton5.setText("Ticket");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar8.add(jButton5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("En Mesa", jPanel2);

        jPanel1.setAutoscrolls(true);

        jToolBar5.setFloatable(false);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/32money.png"))); // NOI18N
        jButton8.setText("Cobrar");
        jButton8.setFocusable(false);
        jButton8.setHideActionText(true);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335698153_select.png"))); // NOI18N
        jButton9.setText("Sel.Todo");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton9);

        jToolBar6.setFloatable(false);

        jButton7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335695344_cup_delete.png"))); // NOI18N
        jButton7.setText("Anular");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton7);

        jPanel3.setAutoscrolls(true);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tickets", jPanel1);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334848821_cashbox.png"))); // NOI18N
        jButton6.setText("Abrir Caja");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txTotal.setEditable(false);
        txTotal.setBackground(new java.awt.Color(1, 1, 1));
        txTotal.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txTotal.setForeground(new java.awt.Color(255, 51, 0));
        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0.0");
        txTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbUbicacion)
                                        .addGap(235, 235, 235))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTitulo)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(lbUbicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pCategorias.setLayout(new java.awt.GridLayout(0, 3));
        jScrollPane2.setViewportView(pCategorias);

        jSplitPane1.setLeftComponent(jScrollPane2);

        pProductos.setLayout(new java.awt.GridLayout(0, 3, 3, 3));
        jScrollPane3.setViewportView(pProductos);

        jSplitPane1.setRightComponent(jScrollPane3);

        jPanel6.setLayout(new java.awt.GridLayout());

        multiplicador.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        multiplicador.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        multiplicador.setText("1");
        multiplicador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplicadorMouseClicked(evt);
            }
        });
        multiplicador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                multiplicadorKeyPressed(evt);
            }
        });
        jPanel6.add(multiplicador);

        jButton2.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton2.setText("1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jButton19.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton19.setText("2");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton19);

        jButton3.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton4.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);

        jButton14.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton14.setText("5");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton14);

        jButton15.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton15.setText("6");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15);

        jButton16.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton16.setText("7");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton16);

        jButton17.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton17.setText("8");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton17);

        jButton18.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton18.setText("9");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton18);

        jButton13.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton13.setText("10");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton13);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    double totalCab = 0.0;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new VentanaCamareros(this, true).setVisible(true);
        totalCab = 0.0;
        Component[] c = this.panelLineas.getComponents();
        Cabezera cab = new Cabezera();
        cab.setCamarero(camarero);
        cab.setCod(conf.getCod());
        cab.setFecha(new Date());
        cab.setEstado(0);

        cabezeras.saveDato(cab);
        for (int i = 0; i < c.length; i++) {
            BTLineas bt = (BTLineas) c[i];
            if (bt.isSelect()) {
                totalCab += bt.getLinea().getTotal();
                bt.getLinea().setCabezera(cab);
                bt.getLinea().setCobrado(1);
                lineas.saveDato(bt.getLinea());
                panelLineas.remove(bt);
            }
        }
        cab.setTotal(totalCab);
        cabezeras.saveDato(cab);

        impresora.setImpresora(((Configuracion) conf.busquedaDato(1)).getValue());
        impresora.setEtiqueta("C:\\tpv\\jaspers\\ticket.jasper");
        impresora.setCabezera(cab);
        impresora.setUbi(ubicacion);
        impresora.startPrint();
        this.panelLineas.updateUI();
        cargaTickets();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            /*
             * Create an array of PrintServices
             */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /*
             * Scan found services to see if anyone suits our needs
             */
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals(((Configuracion) conf.busquedaDato(2)).getValue())) {
                    /*
                     * If the service is named as what we are querying we select
                     * it
                     */
                    selectedService = i;
                    break;
                }
            }
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            char[] a = {0x1b, 0x70, 0x00, 0x19, 0xff};

            String zplCommand = "";
            for (int i = 0; i < a.length; i++) {
                zplCommand += a[i];
            }

            // convertimos el comando a bytes
            byte[] by = zplCommand.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);

            // creamos el printjob
            DocPrintJob job = printService.createPrintJob();

            // imprimimos
            job.print(doc, null);
            /**
             * impresora.setImpresora(((Configuracion)conf.busquedaDato(2)).getValue());
             * impresora.setEtiqueta("C:\\tpv\\jaspers\\enBlanco.jasper");
             * //impresora.setCabezera(cab); //impresora.setUbi(ubicacion);
             * impresora.abrirCaja(); *
             */
        } catch (PrintException ex) {
            Logger.getLogger(VentanaTPV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if (new VentanaAcceso(this, true).getAcceso()) {
            new AnularTicket(this, true).setVisible(true);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void txTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Component[] c = this.jPanel3.getComponents();
        Cabezera[] cab = new Cabezera[c.length];
        CabezeraModel cm = new CabezeraModel();
        for (int i = 0; i < c.length; i++) {
            BTTickets bt = (BTTickets) c[i];
            if (bt.isSelect()) {
                cab[i] = bt.getCab();
            }
        }
        if (new VentanaCobro(this, true, cab).HelpCambio()) {

            for (int i = 0; i < cab.length; i++) {
                BTTickets bt = (BTTickets) c[i];
                if (bt.isSelect()) {
                    cab[i].setEstado(1);
                    cm.saveDato(cab[i]);
                    this.jPanel3.remove(bt);
                }

            }
        }
        this.jPanel3.updateUI();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Component[] c = this.jPanel3.getComponents();
        for (int i = 0; i < c.length; i++) {
            BTTickets bt = (BTTickets) c[i];
            bt.setSelect(true);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        Component[] c = this.panelLineas.getComponents();
        for (int i = 0; i < c.length; i++) {
            BTLineas bt = (BTLineas) c[i];
            bt.setSelect(true);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new VentanaCamareros(this, true).setVisible(true);
        totalCab = 0.0;
        Component[] c = this.panelLineas.getComponents();
        Cabezera cab = new Cabezera();
        cab.setCamarero(camarero);
        cab.setCod(conf.getCod());
        cab.setFecha(new Date());
        cab.setEstado(1);

        cabezeras.saveDato(cab);
        for (int i = 0; i < c.length; i++) {
            BTLineas bt = (BTLineas) c[i];
            if (bt.isSelect()) {
                totalCab += bt.getLinea().getTotal();
                bt.getLinea().setCabezera(cab);
                bt.getLinea().setCobrado(1);
                lineas.saveDato(bt.getLinea());
                panelLineas.remove(bt);
            }
        }
        cab.setTotal(totalCab);
        cabezeras.saveDato(cab);

        impresora.setImpresora(((Configuracion) conf.busquedaDato(1)).getValue());
        impresora.setEtiqueta("C:\\tpv\\jaspers\\ticket.jasper");
        impresora.setCabezera(cab);
        impresora.setUbi(ubicacion);
        impresora.startPrint();

        Caja movimiento = new Caja();
        movimiento.setCajaPago(0); //Efectivo
        movimiento.setCamarero(camarero);
        movimiento.setCabezera(cab);
        movimiento.setFecha(new Date());
        movimiento.setMovimiento(cab.getTotal());
        movimiento.setSaldo(caja.getSaldo(0) + cab.getTotal());
        caja.saveDato(movimiento);

        this.panelLineas.updateUI();
        cargaTickets();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void multiplicadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_multiplicadorKeyPressed

    }//GEN-LAST:event_multiplicadorKeyPressed

    private void multiplicadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplicadorMouseClicked
        new VentanaTeclado(this, true, this.multiplicador).setVisible(true);
    }//GEN-LAST:event_multiplicadorMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new HistoricoTickets(this, true).setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void cbBloquesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBloquesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBloquesItemStateChanged

    private void cbBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBloquesActionPerformed
        try {
            System.out.println(this.cbBloques.getSelectedItem());
            System.out.println(this.b.get((int) this.cbBloques.getSelectedItem()).getNombre());
            mesa = new VentanaMesas(this, true, this.b.get((int) this.cbBloques.getSelectedItem()).getId());

            if (this.ubicacion == null) {
                this.setUbicacion(mesa.getDefault());
            } else {
                mesa.setVisible(true);
            }
            lbUbicacion.setIcon(new javax.swing.ImageIcon(this.b.get((int) this.cbBloques.getSelectedItem()).getImagen()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbBloquesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.multiplicador.setText(((JButton)evt.getSource()).getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaTPV().setVisible(true);
            }
        });
    }

    public void setUbicacion(Ubicacion ubicacion) {

        this.panelLineas.removeAll();
        this.ubicacion = ubicacion;
        this.lbUbicacion.setText(ubicacion.getNombre());
        this.lineasUbi = (ArrayList<Linea>) lineas.getLineasUbicacion(ubicacion);
        System.out.println("Ubicacion: " + this.lineasUbi.size());
        total = 0.0;
        for (int i = 0; i < lineasUbi.size(); i++) {
            Linea l = lineasUbi.get(i);
            panelLineas.add(new BTLineas(l, instanceOf));
            total += l.getTotal();
        }
        this.panelLineas.updateUI();
        this.txTotal.setText(nf.format(total));
    }

    public void cargaTickets() {
        this.jPanel3.removeAll();
        this.tickets = (ArrayList<Cabezera>) cabezeras.getTicketsSC();
        System.out.println("Tickets: " + this.tickets.size());
        total = 0.0;
        for (int i = 0; i < tickets.size(); i++) {
            Cabezera l = tickets.get(i);
            jPanel3.add(new BTTickets(instanceOf, l));

        }
        this.jPanel3.updateUI();

    }

    public void removeTicket(BTTickets btCab) {
        this.jPanel3.remove(btCab);
        this.jPanel3.updateUI();
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void eliminarLinea(Linea l) {
        LineaModel lineas = new LineaModel();
        Linea li = (Linea) lineas.busquedaDato(l.getIdLinea());
        lineas.removeDato(li);
        this.setUbicacion(ubicacion);
    }

    public void actualizarLinea(Linea l) {
        System.out.println(l.isInvitacion());
        lineas.saveDato(l);
        l = (Linea) lineas.busquedaDato(l.getIdLinea());
        System.out.println(l.isInvitacion());
        this.setUbicacion(ubicacion);
    }
    ArrayList<Cabezera> tickets;
    ArrayList<Linea> lineasUbi;
    Ubicacion ubicacion = null;
    Double total = 0.0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbBloques;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUbicacion;
    private javax.swing.JTextField multiplicador;
    private javax.swing.JPanel pCategorias;
    private javax.swing.JPanel pProductos;
    private javax.swing.JPanel panelLineas;
    private javax.swing.JTextField txTotal;
    // End of variables declaration//GEN-END:variables

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }
}
