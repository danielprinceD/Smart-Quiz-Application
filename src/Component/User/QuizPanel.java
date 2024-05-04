/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Component.User;

import Component.Admin.ManageBatch;
import Home.Home;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class QuizPanel extends javax.swing.JPanel {
    
    
    final private String username = "root";
    final private String password = "";
    final private String database_name = "quiz";
    final private String table_name = "assignquiz";
    
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    ResultSetMetaData metaData;
    ResultSetMetaData metaData2;
    ResultSetMetaData metaData3;
DefaultTableModel dtm;

    /**
     * Creates new form QuizPanel
     */
    public QuizPanel() {
        
        initComponents();
        tableRecords();
    }
    
    
    private void tableRecords(){
        int count;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name, username,password);
            pst = conn.prepareStatement("select * from "+table_name+ " where assignedto = ?");
            pst.setString(1,Home.BATCH);
            rs = pst.executeQuery();
            metaData = rs.getMetaData();
            
            count = metaData.getColumnCount();
            
            dtm = (DefaultTableModel) quiztable.getModel();
            dtm.setRowCount(0);
            
            while(rs.next()){
                
                pst = conn.prepareStatement("select duration from "+"managequiz"+ " where name = ?");
                pst.setString(1, rs.getString("quizname"));
                rs2 = pst.executeQuery();
                int duration = 0;
                
                while(rs2.next()){
                    duration = rs2.getInt("duration");
                }
                
                
                pst = conn.prepareStatement("select * from "+table_name+ " where quizname = ?");
                pst.setString(1,rs.getString("quizname"));
                rs3 = pst.executeQuery();
                metaData3 = rs3.getMetaData();
                
                int c = 0;
                
                while(rs3.next()){
                    ++c;
                }
                
                
                Vector v = new Vector();
                for(int i = 0; i <= count; i++){
                    v.add(rs.getString("quizname"));
                    v.add(c);
                    v.add(duration);
                }
                dtm.addRow(v);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageBatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        quiztable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        quiztable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quiz", "No of Quest", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        quiztable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quiztableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(quiztable);

        jButton1.setBackground(new java.awt.Color(51, 255, 0));
        jButton1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Attend");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            
        if(QuizConsole.ID != 0)
        {
            QuizConsole qp = new QuizConsole();
            UserHome uh = new UserHome();
            qp.setVisible(true);
            uh.dispose();
        }
        else 
        {
            JOptionPane.showMessageDialog(this , "Select Any Quiz " , "Exception" , 2 );
        }
            
    }//GEN-LAST:event_jButton1MouseClicked

    private void quiztableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quiztableMouseClicked
       
        try { QuizConsole.ID =(int) dtm.getValueAt(quiztable.getSelectedRow(), 1); }
       catch(Exception e) {JOptionPane.showMessageDialog(this , e.getMessage() , "Exception" , 2 );}
    }//GEN-LAST:event_quiztableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable quiztable;
    // End of variables declaration//GEN-END:variables
}
