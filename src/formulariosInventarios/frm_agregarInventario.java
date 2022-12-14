/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formulariosInventarios;
import baseDatos.baseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.MutableComboBoxModel;
import model.instrumentos;
/**
 *
 * @author Keng
 */
public class frm_agregarInventario extends javax.swing.JFrame {

    private baseDatos bd;
    private Connection conn = null;
    private ArrayList<instrumentos> listaInstrumentos;
    /**
     * Creates new form frm_agregarInventario
     */
    public frm_agregarInventario() {
        initComponents();
        listaInstrumentos = new ArrayList<>();
        
        //desactivar los inputs
        txt_valor.setEditable(false);
        txt_tipo.setEditable(false);
        
        
        
         //obtener datos desde la bd, de la tabla instrumentos
        try {
            conn = bd.abrirBD();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM instrumentos WHERE disponible = '0'";
            ResultSet rs = stmt.executeQuery(query);
          
           cb_instrumentos.addItem("Seleccionar");
            while(rs.next()){
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String valor = rs.getString("valor");
                String disponible = rs.getString("disponible");
                String fechaCreacion = rs.getString("fecha_de_creacion");
                instrumentos ins = new instrumentos(id, nombre, tipo, valor, disponible, fechaCreacion);
                listaInstrumentos.add(ins);
                cb_instrumentos.addItem(nombre);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        //evento al tocar el item del combo box
        cb_instrumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instrumento = cb_instrumentos.getSelectedItem().toString();
        
                if(instrumento.equals("Seleccionar")){
                    txt_valor.setText("");
                    txt_tipo.setText("");
                    txt_cantidad.setText("");
                }else{
                    for (int i = 0; i < listaInstrumentos.size(); i++) {
                        if(listaInstrumentos.get(i).getNombre().toLowerCase().equals(instrumento.toLowerCase())){
                            txt_valor.setText(listaInstrumentos.get(i).getValor());
                            txt_tipo.setText(listaInstrumentos.get(i).getTipo());
                            break;
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txt_cantidad1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cb_instrumentos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad");

        txt_cantidad1.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Nuevo Inventario");

        cb_instrumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_instrumentosMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Seleccionar Instrumento");

        txt_cantidad.setToolTipText("");
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Valor por cada Instrumento");

        txt_valor.setEditable(false);
        txt_valor.setToolTipText("");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_atras.setText("Atras");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Tipo de Instrumento");

        txt_tipo.setEditable(false);
        txt_tipo.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(cb_instrumentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txt_cantidad)
                            .addComponent(txt_valor)
                            .addComponent(txt_tipo))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_instrumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String instrumento = cb_instrumentos.getSelectedItem().toString();
        
        if(instrumento.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione un instrumento");
        }else{
            if(Pattern.matches("^[0-9]*$", txt_cantidad.getText())){
                for (int i = 0; i < listaInstrumentos.size(); i++) {
                    if(listaInstrumentos.get(i).getNombre().toLowerCase().equals(instrumento.toLowerCase())){
                        int id = Integer.parseInt(listaInstrumentos.get(i).getId());
                        int cantidad = Integer.parseInt(txt_cantidad.getText());
                        try{
                            Statement stmt = conn.createStatement();
                            String query = "insert into inventarios(id_instrumento, cantidad_disponible) values("+ id +", " + cantidad +")";

                            if(stmt.executeUpdate(query) == 1){
                                JOptionPane.showMessageDialog(null, "Se ha creado un nuevo inventario");
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo crear el inventario");
                            }
                        }
                        catch (SQLException e){
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "La cantidad debe ser numerico");
                txt_cantidad.setText("");
            }
        }     
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void cb_instrumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_instrumentosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cb_instrumentosMouseClicked

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

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
            java.util.logging.Logger.getLogger(frm_agregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_agregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_agregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_agregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_agregarInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_instrumentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cantidad1;
    private javax.swing.JTextField txt_tipo;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
