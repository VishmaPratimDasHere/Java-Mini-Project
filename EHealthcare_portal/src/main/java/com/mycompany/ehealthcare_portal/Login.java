/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ehealthcare_portal;
import java.sql.*;

/**
 *
 * @author Vishma
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Login extends javax.swing.JFrame {
    String uname;
    String patientname;
    long phone;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        errorBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 170, 30));

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 610, 70));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 70));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usernameLabel.setText("Username");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 100, 20));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 100, 20));

        errorBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        errorBox.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(errorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 610, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdata?useSSL=false","root","root");
            String usrname=username.getText();
            String pass=password.getText();
            Statement stm=con.createStatement();
            String sql="Select * from patientdata where username='"+usrname+"' and passwords='"+pass+"'";
            ResultSet rs=stm.executeQuery(sql);
            
            if (rs.next()) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdata?useSSL=false","root","root");
                
                sql="Select username, patientname, phone from patientdata where username='"+usrname+"'";
                stm=con1.createStatement();
                rs=stm.executeQuery(sql);
                if(rs.next()) {
                    uname=rs.getString("username");
                    patientname=rs.getString("patientname");
                    phone=rs.getLong("phone");
                }
                
                dispose();
                HomeWindow home=new HomeWindow();
                home.setVisible(true);
                
                // UPDATE TEXT
                home.updateText(this.uname,this.patientname,this.phone);
            }
            else {
                errorBox.setText("username or/and password is/are wrong");
                username.setText("");
                password.setText("");
            }
            
        } catch (Exception e) {
            errorBox.setText(e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
