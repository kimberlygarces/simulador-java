package vista;


import Simulador.GestionarJSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Simulador.Proceso;
import java.awt.Frame;
import java.io.FileWriter;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laura
 * @author Kimberly
 *
 *
 */
public class Simulacion1 extends javax.swing.JFrame {

    DefaultTableModel modelo;
    DefaultTableModel modelo2;
     DefaultTableModel modelo3;
    
    private int tiempo;
    private String[][] datos = {};

    int Contador =0;
    int ContarLlegada = 0;
    int tllegada;
    String NombreP;
    int RafagaProceso = 0;
    int QuantumProceso = 2;
    int ResiduoRafagaProceso = 0;
    int TiempoProceso = 0;
    int ValorBarra;
    int CantidadProcesos;
    int Prioridad;
    boolean IterarProceso;

    public Simulacion1() {
        initComponents();
        mostrardatos("");
        mostrardatosEjecucion("");
        mostrardatosNoExclusivos("");
       // InformeNoExclusivos(WIDTH);

    }

    void mostrardatos(String valor) {

        String[] cabeceraCola = {"T LLEGADA", "RAFAGA", "QUANTUN", "RESIDUO RAFAGA", "ESTADO", "PRIORIDAD", "NOMBRE"};

        modelo = new DefaultTableModel(datos, cabeceraCola);

        TEjecucion.setModel(modelo);
        TEjecucion.setEnabled(false);
        jLabelE.setText("");
        try {
            modelo.setRowCount(0);// Limpiamos la tabla

            String json = GestionarJSON.realizarPeticion();

            System.out.print("Json : " + json);

            Proceso[] procesos = GestionarJSON.parseToProceso(json);

            for (Proceso proceso : procesos) {

                Contador ++;
                Object[] fila = new Object[]{
                    Contador,
                    proceso.calcularRafaga(),
                    QuantumProceso,
                    proceso.calcularRafaga(),
                    "LISTO",
                    proceso.getPrioridad(),
                    proceso.getNombre()
                };

                modelo.addRow(fila);
            }

        } catch (IOException ex) {
            jLabelE.setText("Error al realizar la peticion web");

            System.out.print("La petición fallo");
            Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void mostrardatosEjecucion(String valor) {

        String[] cabeceraCola = {"N°", "NOMBRE", "T LLEGADA", "RAFAGA", "QUANTUN", "T FINAL", "ESTAD0" };

        modelo2 = new DefaultTableModel(datos, cabeceraCola);

        TablaTerminados.setModel(modelo2);
        TablaTerminados.setEnabled(false);// para que no se pueda editar
    }
    
     void mostrardatosNoExclusivos(String valor) {

        String[] cabeceraCola = {"N°", "NOMBRE", "T LLEGADA","RAFAGA", "QUANTUN", "T FINAL", "ESTAD0"};

        modelo3 = new DefaultTableModel(datos, cabeceraCola);

        TablaNoExclusivos.setModel(modelo3);
        TablaNoExclusivos.setEnabled(false);// para que no se pueda editar
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelE = new javax.swing.JLabel();
        ProgresoProceso = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TEjecucion = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        Biniciar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaTerminados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaNoExclusivos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JLporcentajeProceso = new javax.swing.JLabel();
        BarraProgreso = new javax.swing.JProgressBar();
        TiempoProcesos = new javax.swing.JLabel();
        NumerosProcesos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Bitstream Charter", 3, 24)); // NOI18N
        jLabel1.setText("SIMULACION ROUND ROBIN");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Logo.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 344, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 293, Short.MAX_VALUE)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 325, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 980, 120));
        getContentPane().add(jLabelE, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 675, 90, -1));
        getContentPane().add(ProgresoProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 674, 105, 1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TEjecucion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TEjecucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TEjecucion);

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 3, 12)); // NOI18N
        jLabel7.setText("PROCESOS");

        Biniciar.setBackground(new java.awt.Color(204, 204, 204));
        Biniciar.setText("Iniciar");
        Biniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiniciarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 646, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(Biniciar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(298, 298, 298)
                        .add(jLabel7)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel7)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(417, 417, 417))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(48, 48, 48)
                        .add(Biniciar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        TablaTerminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(TablaTerminados);

        jLabel5.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        jLabel5.setText("Listado de ejecución");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel5)
                .add(217, 217, 217))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setToolTipText("");

        TablaNoExclusivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(TablaNoExclusivos);

        jLabel6.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        jLabel6.setText("Procesos No Exclusivos");

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel6)
                .add(209, 209, 209))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(58, 58, 58))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        jLabel4.setText("Ejecución");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(BarraProgreso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(JLporcentajeProceso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(82, 82, 82)
                .add(NumerosProcesos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(TiempoProcesos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(233, 233, 233))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(NumerosProcesos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(TiempoProcesos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jLabel4))
                            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, JLporcentajeProceso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, BarraProgreso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carga.gif"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reducido.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dustismo Roman", 2, 14)); // NOI18N
        jLabel3.setText("Kimberly Garcés");

        jLabel10.setFont(new java.awt.Font("Dustismo Roman", 2, 14)); // NOI18N
        jLabel10.setText("Laura de la Ossa");

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 331, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(52, 52, 52)))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(595, 595, 595)
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel10)
                                    .add(jLabel3)))
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .add(28, 28, 28)))
                        .add(18, 18, 18)
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(47, 47, 47))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(39, 39, 39)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 280, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(21, 21, 21)))
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel10)
                        .add(15, 15, 15))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(26, 26, 26))))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 990, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BiniciarActionPerformed
        // TODO add your handling code here:

        new Thread(new hilo()).start();


    }//GEN-LAST:event_BiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Simulacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulacion().setVisible(true);
            }

        });

    }

    public void Montar(int i) { 
        
        

        tllegada = (int) TEjecucion.getValueAt(i, 0);
        RafagaProceso = (int) TEjecucion.getValueAt(i, 1);
        QuantumProceso = (int) TEjecucion.getValueAt(i, 2);
        ResiduoRafagaProceso = (int) TEjecucion.getValueAt(i, 1);
        Prioridad=(int) TEjecucion.getValueAt(i, 5);
        NombreP=(String) TEjecucion.getValueAt(i, 6);
       

        if (tllegada > 0) {
            NumerosProcesos.setText(String.valueOf(tllegada));
        }
    }

    public void Barra(int rafaga, int residuo) { //Calcula porcentaje de la barra y su progreso
        int Rafaga = rafaga;
        int valor = 100 / rafaga;
        int porcentaje = 100 - (valor * residuo);
        ValorBarra = porcentaje;
        JLporcentajeProceso.setText(String.valueOf(ValorBarra + "%"));
    }

    public void PintarBarra() {
        BarraProgreso.setValue(ValorBarra);
        BarraProgreso.repaint();
    }

    public void EsperarProceso() {
        try {
            Thread.sleep(700); //Interrumpe sistema
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulacion1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Informe(int c) {

        modelo2 = (DefaultTableModel) TablaTerminados.getModel();
        
        if(Prioridad != 0){
       
        Object[] Tabla = new Object[7];
        Tabla[0] = c + 1;
        Tabla[1] = NombreP;
        Tabla[2] = tllegada;
        Tabla[3] = RafagaProceso;
        Tabla[4] = QuantumProceso;
        Tabla[5] = TiempoProceso + "Segundos";
        Tabla[6] = "Terminado";
        
        modelo2.addRow(Tabla);
        TablaTerminados.setModel(modelo2);

        CantidadProcesos++;
        NumerosProcesos.setText(String.valueOf(CantidadProcesos + " Terminados"));
        TiempoProcesos.setText(String.valueOf(TiempoProceso + " Segundos"));
        }
        JOptionPane.showMessageDialog(null, "Nombre proceso:" + TablaTerminados.getValueAt(c, 1));
    }

    
       public void InformeNoExclusivos(int c) {

        modelo3 = (DefaultTableModel) TablaNoExclusivos.getModel();

        if(Prioridad == 0){
        Object[] Tabla = new Object[7];
        Tabla[0] = c + 1;
        Tabla[1] = NombreP;
        Tabla[2] = tllegada;
        Tabla[3] = RafagaProceso;
        Tabla[4] = QuantumProceso;
        Tabla[5] = TiempoProceso + "Segundos";
        Tabla[6] = "Terminado";
        
        modelo3.addRow(Tabla);
        TablaNoExclusivos.setModel(modelo3);
       
     
        }
    }
    public void Borrar(int c) { //Elimina los registros de la tabla procesos
        TEjecucion.setValueAt(0, c, 0);
        TEjecucion.setValueAt("0", c, 1);
        TEjecucion.setValueAt("0", c, 2);
        TEjecucion.setValueAt("0", c, 3);
        TEjecucion.setValueAt("********", c, 4);

    }

    private class hilo implements Runnable {

        public void run() {

            int estado = 1;
            int i = 0;

            while (estado != 0) {
                while (i < Contador) { //Recorrer las filas
                    Montar(i);
                   
                    if (ResiduoRafagaProceso != 0 && ResiduoRafagaProceso > QuantumProceso) { //Ejecutando Procesos
                        for (int c = 1; c <= QuantumProceso; c++) {
                            TEjecucion.setValueAt("Procesando", i, 4);
                            ResiduoRafagaProceso--;
                            Barra(RafagaProceso, ResiduoRafagaProceso);
                            PintarBarra();
                            TEjecucion.setValueAt(String.valueOf(ResiduoRafagaProceso), i, 3);
                            TiempoProceso++;
                            EsperarProceso();
                        }
                        TEjecucion.setValueAt("Espera", i, 4);
                        if (ResiduoRafagaProceso == 0) {

                            TEjecucion.setValueAt("Terminado", i, 4);
                            PintarBarra();
                            Informe(i);
                            InformeNoExclusivos(i);
                            Borrar(i);
                            BarraProgreso.setValue(0);
                        }
                    } else {
                        if (ResiduoRafagaProceso > 0 && QuantumProceso != 0) {

                            while (ResiduoRafagaProceso > 0) {
                                TEjecucion.setValueAt("Procesando", i, 4);
                                ResiduoRafagaProceso--;
                                Barra(RafagaProceso, ResiduoRafagaProceso);
                                PintarBarra();
                                TEjecucion.setValueAt(String.valueOf(ResiduoRafagaProceso), i, 3);
                                TiempoProceso++;
                                EsperarProceso();
                            }
                            TEjecucion.setValueAt("Espera", i, 4);

                            if (ResiduoRafagaProceso == 0 && QuantumProceso != 0) {

                                TEjecucion.setValueAt("Terminado", i, 4);
                                PintarBarra();
                                Informe(i);
                                InformeNoExclusivos(i);
                                Borrar(i);
                                BarraProgreso.setValue(0);
                            }
                        } else {
                            if (ResiduoRafagaProceso == 0 && QuantumProceso != 0) {
                                TEjecucion.setValueAt("Terminado", i, 4);
                                PintarBarra();
                                Informe(i); 
                                InformeNoExclusivos(i);
                                Borrar(i);
                                BarraProgreso.setValue(0);
                            }
                        }
                    }
                    NumerosProcesos.setText(String.valueOf("")); //Borrar contenido
                    ProgresoProceso.setText(String.valueOf(""));
                    i++;
                }
                i = 0;
                NumerosProcesos.setText(String.valueOf("")); //Borrar contenido
                ProgresoProceso.setText(String.valueOf(""));
            }
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraProgreso;
    private javax.swing.JButton Biniciar;
    private javax.swing.JLabel JLporcentajeProceso;
    private javax.swing.JLabel NumerosProcesos;
    private javax.swing.JLabel ProgresoProceso;
    private javax.swing.JTable TEjecucion;
    private javax.swing.JTable TablaNoExclusivos;
    private javax.swing.JTable TablaTerminados;
    private javax.swing.JLabel TiempoProcesos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelE;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables

}
