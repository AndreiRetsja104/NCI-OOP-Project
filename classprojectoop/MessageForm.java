/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package classprojectoop;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arets
 */
public class MessageForm extends javax.swing.JFrame {
    //  Connection to DataBase Creater 
    DatabaseTableCreater dbc = new DatabaseTableCreater (); 
    private String senderUserName;
    private String recipientUserName;
   
    
  
      /**
     * Creates new form messageForm
     */
    public MessageForm() {   
        initComponents();
        setLocationRelativeTo(null);
        displayNewsFeeds();
   
    // Populate the ComboBox with the list of users
        populateUserComboBox();
   
}
    
    
    // Populate the ComboBox with users during initialization or an appropriate event
     
     private void populateUserComboBox() {
     comboBoxUser.removeAllItems(); // Clear existing items

    // Retrieve all users from the database
    List<String> allUsers = dbc.getAllUsers();

    // Populate the ComboBox with the retrieved users
     for (String user : allUsers) {
      System.out.println("Adding user to combo box: " + user);
     comboBoxUser.addItem(user);
     }
}
     
       // Display news feeds in a TextArea = newsFeedTA
     
    private void displayNewsFeeds() {
    try {
        // Clear existing content
        newsFeedTA.setText("");

        // Get the news feed and username from the database
        List<NewsFeedEntry> newsFeedEntries = dbc.getNewsFeedEntries();

        // Append news feeds to the TextArea
        for (NewsFeedEntry entry : newsFeedEntries) {
            String newsFeedText = entry.getUsername() + ": " + entry.getNewsFeed();
            newsFeedTA.append(newsFeedText + "\n");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  
    // Display messages in a message2TA
  
    private void displayMessages(List<String> messages) {
    StringBuilder messageBuilder = new StringBuilder();

    // Append messages to the StringBuilder
    for (String message : messages) {
        // Append the retrieved message with timestamp and user to the TextArea
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss" ));
        String fullMessage = "" + formattedTimestamp + ": " + message;
        message2TA.append(fullMessage + "\n");

        // Append the message with timestamp to the StringBuilder
        messageBuilder.append(fullMessage).append("\n");
    }

    // Show a pop-up message with user name and messages
    String selectedUser = (String) comboBoxUser.getSelectedItem();
    if (selectedUser != null) {
        String popupMessage = "Messages for user " + selectedUser + ":\n\n" + messageBuilder.toString();
        JOptionPane.showMessageDialog(null, popupMessage);
    } else {
        JOptionPane.showMessageDialog(null, "No user selected");
    }
}
    // Refresh the interface
    private void refreshUI() {
     
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        topTextLbl = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        mainPageBtn = new javax.swing.JButton();
        nextPageBtn = new javax.swing.JButton();
        sendMessageBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        scrollPanelUser1 = new javax.swing.JScrollPane();
        message1TA = new javax.swing.JTextArea();
        sendMessageArea = new javax.swing.JTextField();
        backgroundMessage1Lbl = new javax.swing.JLabel();
        userlbl2 = new javax.swing.JLabel();
        userImage2Lbl = new javax.swing.JLabel();
        scrollPanelUser2 = new javax.swing.JScrollPane();
        message2TA = new javax.swing.JTextArea();
        backgroundMessage2Lbl = new javax.swing.JLabel();
        comboBoxUser = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        newsFeedTA = new javax.swing.JTextArea();
        returnBtn = new javax.swing.JButton();
        userImage1Lbl = new javax.swing.JLabel();
        subMainPageImageLbl = new javax.swing.JLabel();
        searchBarTF = new javax.swing.JTextField();
        mainPageImageLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topTextLbl.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        topTextLbl.setForeground(new java.awt.Color(255, 153, 0));
        topTextLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topTextLbl.setText("Chat Console ");
        topTextLbl.setToolTipText("");
        jPanel1.add(topTextLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 40));

        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 130, 40));

        mainPageBtn.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        mainPageBtn.setText("Main Page");
        mainPageBtn.setActionCommand("Back");
        mainPageBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));
        mainPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPageBtnActionPerformed(evt);
            }
        });
        jPanel1.add(mainPageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 120, 40));

        nextPageBtn.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        nextPageBtn.setText("Next page");
        nextPageBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));
        jPanel1.add(nextPageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 120, 40));

        sendMessageBtn.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        sendMessageBtn.setText("Send");
        sendMessageBtn.setToolTipText("");
        sendMessageBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));
        sendMessageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageBtnActionPerformed(evt);
            }
        });
        jPanel1.add(sendMessageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 100, 40));

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/Search_Image.png"))); // NOI18N
        searchBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 2, true));
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 50, 30));

        message1TA.setBackground(new java.awt.Color(51, 255, 0));
        message1TA.setColumns(20);
        message1TA.setRows(5);
        scrollPanelUser1.setViewportView(message1TA);

        jPanel1.add(scrollPanelUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 290, 140));

        sendMessageArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageAreaActionPerformed(evt);
            }
        });
        jPanel1.add(sendMessageArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 290, 30));

        backgroundMessage1Lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundMessage1Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/chat bacground .png12323.png"))); // NOI18N
        backgroundMessage1Lbl.setToolTipText("");
        backgroundMessage1Lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jPanel1.add(backgroundMessage1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 310, 210));

        userlbl2.setForeground(new java.awt.Color(255, 255, 255));
        userlbl2.setLabelFor(userlbl2);
        jPanel1.add(userlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 120, 30));

        userImage2Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/user_Image_1.png"))); // NOI18N
        userImage2Lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jPanel1.add(userImage2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 50, 60));

        message2TA.setBackground(new java.awt.Color(0, 153, 204));
        message2TA.setColumns(20);
        message2TA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        message2TA.setRows(5);
        scrollPanelUser2.setViewportView(message2TA);

        jPanel1.add(scrollPanelUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 250, 150));

        backgroundMessage2Lbl.setForeground(new java.awt.Color(255, 255, 255));
        backgroundMessage2Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/new 123.png"))); // NOI18N
        backgroundMessage2Lbl.setToolTipText("");
        backgroundMessage2Lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jPanel1.add(backgroundMessage2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 310, 170));

        comboBoxUser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboBoxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Users" }));
        comboBoxUser.setSelectedIndex(-1);
        comboBoxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUserActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 120, -1));

        newsFeedTA.setColumns(20);
        newsFeedTA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        newsFeedTA.setRows(5);
        jScrollPane1.setViewportView(newsFeedTA);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 240, 370));

        returnBtn.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        returnBtn.setText("Return ");
        returnBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 2, true));
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        jPanel1.add(returnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 100, 40));

        userImage1Lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/user_Image_2.png"))); // NOI18N
        userImage1Lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jPanel1.add(userImage1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 60, 60));

        subMainPageImageLbl.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        subMainPageImageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/Chat_Cansole_p1.gif"))); // NOI18N
        subMainPageImageLbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(subMainPageImageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 730, 410));

        searchBarTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBarTF.setText("  Search ");
        searchBarTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 3, true));
        searchBarTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarTFActionPerformed(evt);
            }
        });
        jPanel1.add(searchBarTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 210, 30));

        mainPageImageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_chat/BackGroungImage2Main.jpg"))); // NOI18N
        jPanel1.add(mainPageImageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Action performed when the Main Page button is clicked
    private void mainPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPageBtnActionPerformed
    GrupPageForm fp = new GrupPageForm();
        fp.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_mainPageBtnActionPerformed
 
    
     // Action performed when the Send Message button is clicked
    private void sendMessageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageBtnActionPerformed
                                        
    // Get the selected user from the comboBox
    String selectedUser = (String) comboBoxUser.getSelectedItem();
    System.out.println("Selected User: " + selectedUser);
    String message = sendMessageArea.getText();

    if (!message.isEmpty() && selectedUser != null) {
        try {
            // Get user ID based on user name
            int senderId = dbc.getUserIdByUsername(selectedUser);
            System.out.println("Sender ID: " + senderId);

            // Check if the sender user was found
            if (senderId == -1) {
                System.out.println("Sender with username " + selectedUser + " not found.");
                // Handle this case, display an error message or log it
                return;
            }

            // Assuming you have a method like getRecipientIdByUsername in your DatabaseTableCreater class
            int recipientId = dbc.getRecipientIdByUsername(selectedUser);
            System.out.println("Recipient ID: " + recipientId);

            // Check if the recipient user was found 
            if (recipientId == -1) {
                System.out.println("Recipient with username " + selectedUser + " not found.");
                // Handle this case, display an error message or log it
                return;
            }

            // Send the message
            dbc.sendMessage(message, senderId, recipientId);
            System.out.println("Message Sent");

            // Retrieve messages for the user 
            List<String> userMessages = dbc.getMessagesForUser(selectedUser);

            // Display them in a UI component
            displayMessages(userMessages);

            // Refresh the UI or perform other actions after sending a message
            refreshUI();

            // Clear the content of the sendMessageArea text field
           sendMessageArea.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("No user selected or empty message");
        JOptionPane.showMessageDialog(null, "No user selected or empty message");
    }

 
    
    }//GEN-LAST:event_sendMessageBtnActionPerformed
    
    // Action performed when the Exit button is clicked
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
     System.exit(WIDTH);
        // TODO add your handling code here:
    }//GEN-LAST:event_exitBtnActionPerformed
    
    // Action performed when the Search bar is used
    private void searchBarTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarTFActionPerformed

    
    
    private void comboBoxUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUsersActionPerformed
        // TODO add your handling 
     
    }//GEN-LAST:event_comboBoxUsersActionPerformed
    // Action performed when a user is selected from the comboBoxUser
    private void comboBoxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUserActionPerformed
        // TODO add your handling code here
      // Get the selected user from the comboBoxUser
        String selectedUser = (String) comboBoxUser.getSelectedItem();

        if (selectedUser != null) {
        try {
        // Retrieve messages for the user 
        List<String> userMessages = dbc.getMessagesForUser(selectedUser);
        
            // Refresh the UI or perform other actions after selecting a user
            refreshUI();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        } else {
        System.out.println("No user selected");
        }
    }//GEN-LAST:event_comboBoxUserActionPerformed

    private void sendMessageAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageAreaActionPerformed
        // TODO add your handling code here:
        // sendMessageArea1 is a TextField
      sendMessageArea = new javax.swing.JTextField();
      sendMessageArea.setToolTipText("Enter your message here");
    }//GEN-LAST:event_sendMessageAreaActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        FrameForPanelsOpen ffpo = null;
        ffpo = new FrameForPanelsOpen();
        ffpo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MessageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundMessage1Lbl;
    private javax.swing.JLabel backgroundMessage2Lbl;
    private javax.swing.JComboBox<String> comboBoxUser;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainPageBtn;
    private javax.swing.JLabel mainPageImageLbl;
    private javax.swing.JTextArea message1TA;
    private javax.swing.JTextArea message2TA;
    private javax.swing.JTextArea newsFeedTA;
    private javax.swing.JButton nextPageBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JScrollPane scrollPanelUser1;
    private javax.swing.JScrollPane scrollPanelUser2;
    private javax.swing.JTextField searchBarTF;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField sendMessageArea;
    private javax.swing.JButton sendMessageBtn;
    private javax.swing.JLabel subMainPageImageLbl;
    private javax.swing.JLabel topTextLbl;
    private javax.swing.JLabel userImage1Lbl;
    private javax.swing.JLabel userImage2Lbl;
    private javax.swing.JLabel userlbl2;
    // End of variables declaration//GEN-END:variables

    private static class SQLException {

        public SQLException() {
        }
    }

   
}

