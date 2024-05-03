/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Component.Admin;

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
public class AssignQuiz extends javax.swing.JPanel {
    
    final private String username = "root";
    final private String password = "";
    final private String database_name = "quiz";
    final private String table_name1 = "managequiz";
    final private String table_name2 = "question";
    final private String table_name3 = "assignquiz";
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    ResultSetMetaData metaData;

    /**
     * Creates new form AssignQuiz
     */
    public AssignQuiz() {
        initComponents();
        tableRecords1();
        tableRecords2();
        tableRecords3();
    }  
    
    private void tableRecords1(){
        int count;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name, username,password);
            pst = conn.prepareStatement("select * from "+table_name1);
            
            rs = pst.executeQuery();
            metaData = rs.getMetaData();
            
            count = metaData.getColumnCount();
            
            DefaultTableModel dtm = (DefaultTableModel) tableQuiz.getModel();
            dtm.setRowCount(0);
            
            while(rs.next()){
                Vector v = new Vector();
                for(int i = 0; i <= count; i++){
                    v.add(rs.getString("id"));
                    v.add(rs.getString("name"));
                    
                }
                dtm.addRow(v);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssignQuiz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AssignQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tableRecords2()
    {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/quiz" , "root" , "");
            pst = conn.prepareStatement("select * from question");
            ResultSet resultset = pst.executeQuery();
            ResultSetMetaData metadata = resultset.getMetaData();
            int count = metadata.getColumnCount();
            
            DefaultTableModel dtm = (DefaultTableModel)tableQuestion.getModel();
            dtm.setRowCount(0);
            
            while(resultset.next())
            {
                Vector v = new Vector();
                for(int i=1;i<=count;i++)
                {
                    v.add(resultset.getInt("id"));
                    v.add(resultset.getString("question"));
                }
                dtm.addRow(v);
            }
        }
        catch(Exception ex){    System.out.print(ex);}
    }
    
    private void tableRecords3(){
        int count;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name, username,password);
            pst = conn.prepareStatement("select * from "+table_name3);
            
            rs = pst.executeQuery();
            metaData = rs.getMetaData();
            
            count = metaData.getColumnCount();
            
            DefaultTableModel dtm = (DefaultTableModel) tableAssignedQuiz.getModel();
            dtm.setRowCount(0);
            
            while(rs.next()){
                Vector v = new Vector();
                for(int i = 0; i <= count; i++){
                    v.add(rs.getString("quizid"));
                    v.add(rs.getString("quizname"));
                    v.add(rs.getString("assignedto"));
                    v.add(rs.getString("question"));
                }
                dtm.addRow(v);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssignQuiz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AssignQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuiz = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableQuestion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAssignedQuiz = new javax.swing.JTable();
        textQid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textQzid = new javax.swing.JTextField();
        btnAssign = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        textBatch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        tableQuiz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Quiz ID", "Quiz Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQuizMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableQuiz);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 508;
        gridBagConstraints.ipady = 237;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(31, 37, 0, 0);
        add(jScrollPane1, gridBagConstraints);

        tableQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Question Id", "Question"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableQuestion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 508;
        gridBagConstraints.ipady = 237;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(31, 45, 0, 6);
        add(jScrollPane2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Question ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 56, 0, 0);
        add(jLabel1, gridBagConstraints);

        tableAssignedQuiz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Quiz ID", "Quiz Name", "Assigned to", "Question"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableAssignedQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAssignedQuizMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableAssignedQuiz);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 516;
        gridBagConstraints.ipady = 262;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(45, 29, 34, 0);
        add(jScrollPane3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 33, 0, 0);
        add(textQid, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quiz ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 56, 0, 0);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 33, 0, 0);
        add(textQzid, gridBagConstraints);

        btnAssign.setBackground(new java.awt.Color(51, 255, 0));
        btnAssign.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        btnAssign.setForeground(new java.awt.Color(255, 255, 255));
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 111, 0, 0);
        add(btnAssign, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 60, 0, 0);
        add(btnDelete, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 33, 0, 0);
        add(textBatch, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Batch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 115;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 59, 0, 0);
        add(jLabel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tableQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuizMouseClicked
        
    }//GEN-LAST:event_tableQuizMouseClicked

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        int qid = Integer.parseInt(textQid.getText());
        String batch = textBatch.getText();
        int qzid = Integer.parseInt(textQzid.getText());
        String quizname = "",qname ="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database_name, username,password);
            
            pst = conn.prepareStatement("select name from "+ table_name1 +" where id =?");
            pst.setInt(1, qzid);
            rs = pst.executeQuery();
            
            
            while(rs.next()){
                quizname = rs.getString("name");
            }
            
            pst = conn.prepareStatement("select question from "+ table_name2 +" where id =?");
            pst.setInt(1, qid);
            rs = pst.executeQuery();
            
            while(rs.next()){
                qname = rs.getString("question");
            }
            
            pst = conn.prepareStatement("update "+ table_name2 +" set quizid = "+qzid+" where id =?");
            pst.setInt(1, qid);
            pst.executeUpdate();
            
            pst = conn.prepareStatement("insert into "+ table_name3 +"(quizid,quizname,assignedto,question) values(?,?,?,?)");
            pst.setInt(1, qzid);
            pst.setString(2, quizname);
            pst.setString(3, batch);
            pst.setString(4, qname);
            
            pst.executeUpdate();
            
            textQid.setText("");
            textBatch.setText("");
            textQzid.setText("");
            textQid.requestFocus();
            tableRecords3();
            JOptionPane.showMessageDialog(this, "Quiz Assigned Added Successfully...." );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void tableAssignedQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAssignedQuizMouseClicked
        
    }//GEN-LAST:event_tableAssignedQuizMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableAssignedQuiz;
    private javax.swing.JTable tableQuestion;
    private javax.swing.JTable tableQuiz;
    private javax.swing.JTextField textBatch;
    private javax.swing.JTextField textQid;
    private javax.swing.JTextField textQzid;
    // End of variables declaration//GEN-END:variables
}
