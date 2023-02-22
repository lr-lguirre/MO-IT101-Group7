package Motorphg7;

import static com.kingaspx.util.UtilOutput.messageBox;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        label_user = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        label_pass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(100, 163, 135));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 100, -1));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(154, 154, 193));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(175, 239, 233));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_user.setForeground(new java.awt.Color(57, 57, 57));
        label_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        label_user.setBorder(null);
        label_user.setOpaque(false);
        kGradientPanel1.add(label_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 20));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 390, 20));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(154, 154, 193));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(175, 239, 233));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_pass.setForeground(new java.awt.Color(57, 57, 57));
        label_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        label_pass.setBorder(null);
        label_pass.setOpaque(false);
        label_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                label_passKeyReleased(evt);
            }
        });
        kGradientPanel2.add(label_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 20));

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, 20));

        jLabel1.setForeground(new java.awt.Color(109, 109, 109));
        jLabel1.setText("Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel2.setForeground(new java.awt.Color(109, 109, 109));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 230));

        setSize(new java.awt.Dimension(465, 246));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login(label_user.getText(), label_pass.getText(), "C:\\Imperium\\credentials.csv");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void label_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_passKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login(label_user.getText(), label_pass.getText(), "C:\\Imperium\\credentials.csv");
        }
    }//GEN-LAST:event_label_passKeyReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField label_pass;
    private javax.swing.JTextField label_user;
    // End of variables declaration//GEN-END:variables

    public void login(String username, String pass, String file) {
        if (validaLogin(username, pass, file)) {
            messageBox("Login successfully");
        } else {
            messageBox("Invalid Credentials");
        }

    }

    public boolean validaLogin(String user, String pass, String file) {
        boolean sucess = false;
        Map<String, String> mapUser = new HashMap();
        getLines(file).forEach(l -> {
            String[] strs = l.split(";");
            mapUser.put(strs[0], strs[1]);
        });
        if (mapUser.containsKey(user)) {
            return mapUser.get(user).equals(pass);
        }
        return sucess;
    }

    public List<String> getLines(String path) {
        List<String> lines = new ArrayList();
        try {
            lines = Files.readAllLines(new File(path).toPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lines;
    }

}