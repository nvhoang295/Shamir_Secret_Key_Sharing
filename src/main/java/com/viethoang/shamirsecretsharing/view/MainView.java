/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.viethoang.shamirsecretsharing.view;

import com.viethoang.shamirsecretsharing.controller.MainController;
import com.viethoang.shamirsecretsharing.dto.Share;
import com.viethoang.shamirsecretsharing.service.MainService;
import com.viethoang.shamirsecretsharing.service.MainServiceImpl;
import com.viethoang.shamirsecretsharing.util.FormatUtil;
import com.viethoang.shamirsecretsharing.util.MathUtil;
import java.awt.Color;
import java.awt.Font;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class MainView extends javax.swing.JFrame {
    
    private final Font tableHeaderFont = new Font("Segoe UI", Font.BOLD, 14);
    
    private final Random random = new SecureRandom();
    private final MainService service = new MainServiceImpl(random);
    private final MainController controller = new MainController(service);
    
    private BigInteger prime;
    private int numShares;
    private int threshold;
    private List<Share> shares;

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBackground(Color.WHITE);
        messageDiaglog.setLocationRelativeTo(this);
        leftTable.getTableHeader().setFont(tableHeaderFont);
        rightTable.getTableHeader().setFont(tableHeaderFont);
    }
    
    private void showMessageDiaglog(String message) {
        messageDiaglog.setVisible(true);
        messageLabel.setText(message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageDiaglog = new javax.swing.JDialog();
        messageLabel = new javax.swing.JLabel();
        closeMessageDiaglogButton = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        secretLabel = new javax.swing.JLabel();
        numSharesLabel = new javax.swing.JLabel();
        thresholdLabel = new javax.swing.JLabel();
        primeLabel = new javax.swing.JLabel();
        secretTextField = new javax.swing.JTextField();
        numSharesTextField = new javax.swing.JTextField();
        thresholdTextField = new javax.swing.JTextField();
        primeTextField = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        shareKeyButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        leftTable = new javax.swing.JTable();
        rightPanel = new javax.swing.JPanel();
        restoreKeyButton = new javax.swing.JButton();
        reconstructedSecretLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rightTable = new javax.swing.JTable();
        reconstructedSecretTextField = new javax.swing.JTextField();

        messageDiaglog.setMinimumSize(new java.awt.Dimension(500, 300));

        messageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        messageLabel.setText("jLabel2");

        closeMessageDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        closeMessageDiaglogButton.setText("Đóng");
        closeMessageDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMessageDiaglogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout messageDiaglogLayout = new javax.swing.GroupLayout(messageDiaglog.getContentPane());
        messageDiaglog.getContentPane().setLayout(messageDiaglogLayout);
        messageDiaglogLayout.setHorizontalGroup(
            messageDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageDiaglogLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageDiaglogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeMessageDiaglogButton)
                .addGap(212, 212, 212))
        );
        messageDiaglogLayout.setVerticalGroup(
            messageDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageDiaglogLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(closeMessageDiaglogButton)
                .addGap(54, 54, 54))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        mainLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mainLabel.setText("Chương trình chia sẻ khoá bí mật dựa vào lược đồ ngưỡng Shamir");

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chia khoá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        secretLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        secretLabel.setText("Khoá cần chia sẻ");

        numSharesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numSharesLabel.setText("Số thành viên giữ khoá");

        thresholdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thresholdLabel.setText("Số thành viên tối thiểu để mở khoá");

        primeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        primeLabel.setText("Giá trị p");

        secretTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        secretTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                secretTextFieldKeyReleased(evt);
            }
        });

        numSharesTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        thresholdTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        primeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        resetButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        shareKeyButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shareKeyButton.setText("Chia sẻ khoá");
        shareKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareKeyButtonActionPerformed(evt);
            }
        });

        leftTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        leftTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(leftTable);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thresholdLabel)
                    .addComponent(numSharesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(primeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secretLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shareKeyButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetButton)
                    .addComponent(secretTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numSharesTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(thresholdTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(primeTextField))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secretLabel)
                    .addComponent(secretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numSharesLabel)
                    .addComponent(numSharesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thresholdLabel)
                    .addComponent(thresholdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primeLabel)
                    .addComponent(primeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(shareKeyButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
        );

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghép khoá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        restoreKeyButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        restoreKeyButton.setText("Khôi phục khoá");
        restoreKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreKeyButtonActionPerformed(evt);
            }
        });

        reconstructedSecretLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reconstructedSecretLabel.setText("Khoá ban đầu");

        rightTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(rightTable);

        reconstructedSecretTextField.setEditable(false);
        reconstructedSecretTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reconstructedSecretLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reconstructedSecretTextField)
                .addContainerGap())
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(restoreKeyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restoreKeyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reconstructedSecretLabel)
                    .addComponent(reconstructedSecretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(mainLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shareKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shareKeyButtonActionPerformed
        BigInteger secret = new BigInteger(secretTextField.getText());
        
        numShares = Integer.parseInt(numSharesTextField.getText());
        threshold = Integer.parseInt(thresholdTextField.getText());
        
        if (!(prime.compareTo(BigInteger.valueOf(numShares)) > 0)) {
            showMessageDiaglog("Số thành viên giữ khoá phải nhỏ hơn số nguyên tố p");
            return;
        }
        
        if (threshold > numShares) {
            showMessageDiaglog("Số thành viên tối thiểu để mở khoá vượt quá số thành viên giữ khoá");
            return;
        }
        
        
        
        shares = controller.splitSecret(secret, prime, numShares, threshold);
        
        loadDataToBothTable(shares);
    }//GEN-LAST:event_shareKeyButtonActionPerformed
    
    private void loadDataToBothTable(List<Share> items) {
        String[] tableHeader = {
            "xi",
            "Pi"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        items.forEach(share -> {
            tableModel.addRow(
                    new Object[] {
                        share.x(),
                        share.y()
                    }
            );
        });
        
        leftTable.setModel(tableModel);
        rightTable.setModel(tableModel);
    }
    
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        secretTextField.setText("");
        numSharesTextField.setText("");
        thresholdTextField.setText("");
        primeTextField.setText("");
        loadDataToBothTable(new ArrayList<>());
    }//GEN-LAST:event_resetButtonActionPerformed

    private void restoreKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreKeyButtonActionPerformed
        int[] selectedRows = rightTable.getSelectedRows();
        int selectedRowLen = selectedRows.length;
        if (selectedRows.length < threshold) {
            showMessageDiaglog(String.format("Cần ít nhất %d mảnh để khôi phục khoá.", threshold));
            return;
        }
        
        List<Share> selectedShares = new ArrayList<>();
        for (int i = 0; i < selectedRowLen; ++i) selectedShares.add(shares.get(i));
        
        BigInteger reconstructedSecret = controller.reconstructSecret(selectedShares, prime, threshold);
        reconstructedSecretTextField.setText(reconstructedSecret.toString());
    }//GEN-LAST:event_restoreKeyButtonActionPerformed

    private void secretTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_secretTextFieldKeyReleased
        String input = secretTextField.getText();
        
        if (!FormatUtil.isInteger(input)) return;
        
        
        prime = MathUtil.findNextPrime(new BigInteger(input));
        primeTextField.setText(prime.toString());
    }//GEN-LAST:event_secretTextFieldKeyReleased

    private void closeMessageDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMessageDiaglogButtonActionPerformed
        messageDiaglog.dispose();
    }//GEN-LAST:event_closeMessageDiaglogButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeMessageDiaglogButton;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTable leftTable;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JDialog messageDiaglog;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel numSharesLabel;
    private javax.swing.JTextField numSharesTextField;
    private javax.swing.JLabel primeLabel;
    private javax.swing.JTextField primeTextField;
    private javax.swing.JLabel reconstructedSecretLabel;
    private javax.swing.JTextField reconstructedSecretTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton restoreKeyButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTable rightTable;
    private javax.swing.JLabel secretLabel;
    private javax.swing.JTextField secretTextField;
    private javax.swing.JButton shareKeyButton;
    private javax.swing.JLabel thresholdLabel;
    private javax.swing.JTextField thresholdTextField;
    // End of variables declaration//GEN-END:variables
}
