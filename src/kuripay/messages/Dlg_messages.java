/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuripay.messages;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import kuripay.members.S1_members;
import kuripay.members.S1_members.to_members;
import kuripay.messages.S1_messages.to_messages;
import kuripay.util.PortConnection;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Guinness
 */
public class Dlg_messages extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_messages
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_messages(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_messages(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_messages() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_messages myRef;

    private void setThisRef(Dlg_messages myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_messages> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_messages create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_messages create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_messages dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_messages((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_messages dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_messages((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_messages dialog = Dlg_messages.create(new javax.swing.JFrame(), true);

        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_messages = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_members = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        tbl_messages.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_messages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_messagesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_messages);

        jButton2.setText("Get Messages");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reply");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dashboard", jPanel5);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_members.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_membersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_members);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Search:");

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel4.setText("Message:");

        jButton4.setText("Send");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("x");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Members", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Port:");

        jTextField1.setText("COM5");

        jLabel2.setText("Status:");

        jTextField2.setFocusable(false);

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        connect();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        get_messages();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        send_message();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_messagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_messagesMouseClicked
        delete_message();
    }//GEN-LAST:event_tbl_messagesMouseClicked

    private void tbl_membersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_membersMouseClicked
    }//GEN-LAST:event_tbl_membersMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        send_member_message();
    }//GEN-LAST:event_jButton4ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tbl_members;
    private javax.swing.JTable tbl_messages;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_messages();

        init_tbl_members();
        data_cols_members();
        tbl_members.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                select_member();
            }
        });
    }

    public void do_pass() {
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_ESCAPE, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_messages_ALM;
    private TblmessagesModel tbl_messages_M;

    private void init_tbl_messages() {
        tbl_messages_ALM = new ArrayListModel();
        tbl_messages_M = new TblmessagesModel(tbl_messages_ALM);
        tbl_messages.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_messages.setModel(tbl_messages_M);
        tbl_messages.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_messages.setRowHeight(25);
        int[] tbl_widths_messages = {90, 70, 100, 100, 60, 60};
        for (int i = 0, n = tbl_widths_messages.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_messages, i, tbl_widths_messages[i]);
        }
        Dimension d = tbl_messages.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_messages.getTableHeader().setPreferredSize(d);
        tbl_messages.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_messages.setRowHeight(25);
        tbl_messages.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_messages(List<to_messages> acc) {
        tbl_messages_ALM.clear();
        tbl_messages_ALM.addAll(acc);
    }

    public static class TblmessagesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Number", "Status", "Message", "Date/Time", "Reply", "Delete"
        };

        public TblmessagesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_messages tt = (to_messages) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.contact_no;
                case 1:
                    return " " + tt.status;
                case 2:
                    return " " + tt.message;
                case 3:
                    return " " + tt.date_sent;
                case 4:
                    return " Reply";
                case 5:
                    return " Delete";
                default:
                    return " Delete";
            }
        }
    }

    private void data_cols() {
        String where = "";
        loadData_messages(S1_messages.ret_data(where));
    }
    PortConnection serial_port = null;

    private void connect() {

        if (jButton1.getText().equals("Disconnect")) {
            serial_port.hangup();
            jButton1.setText("Connect");
        } else {
            final String port = jTextField1.getText();
            final PortConnection p = new PortConnection(port);

            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (serial_port != null) {
                        p.hangup();
                        serial_port.hangup();
                    }
                    if (p.init() == true) {
                        p.connect();
                        p.checkStatus();
                        serial_port = p;
                        jTextField2.setText("Connected");
                        jButton1.setText("Disconnect");
                    } else {
                        jTextField2.setText("Offline");
                    }
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();
        }

    }

    private void read() {
//        
    }

    private void get_messages() {
        PortConnection.list.clear();
        PortConnection.readMessage();
        try {
            Thread.sleep(3000);

            List<String> datas = PortConnection.list;
            System.out.println(datas.size() + " = size");
            String aw = "";
            for (String s : datas) {
                if (!s.isEmpty()) {
                    aw = aw + s;
                }
            }
//            System.out.println(aw);
            List<S1_messages.message_room> rows = new ArrayList();
            String[] lines = aw.split("\\n");
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].startsWith("+CMGL:")) {
//                    System.out.println(lines[i]); 

                    S1_messages.message_room a = new S1_messages.message_room("" + i, lines[i + 1]);
                    rows.add(a);
                }
            }

            String new_message = "";
            final List<to_messages> all_messages = new ArrayList();
            for (S1_messages.message_room message : rows) {
                String m = lines[Integer.parseInt(message.row)];
                new_message = new_message + m + "\n";

                String[] s2 = m.split(",");

                String index = s2[0].replace("+CMGL: ", "");
                String status = s2[1];
                String number = s2[2].replace("\"", "");
                String bytes = s2[3];
                String date = s2[4].replace("\"", "");
                String time = s2[5].replace("\"", "");
                if (time.length() > 7) {
                    time = time.substring(0, 7);
                }

                String mess = message.message;

                int id = -1;
                String contact_no = number;

                String date_sent = date + " " + time;
                String date_added = "";
                int index_no = FitIn.toInt(index);
                to_messages to = new to_messages(id, contact_no, status, mess, date_sent, date_added, index_no);
                all_messages.add(to);

            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    loadData_messages(all_messages);
                }
            });

        } catch (InterruptedException ex) {
            Logger.getLogger(Dlg_messages.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    private void disconnect() {
    }
    private void send_message() {
        final List<to_messages> messages = tbl_messages_ALM;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (final to_messages to : messages) {
                    try {
                        Thread.sleep(3000);
                        String phonenumber = to.contact_no;
                        String message = "Your current balance is 1000.00\n Powered by kurip@y!";
                        PortConnection.sendMessage(phonenumber, message);
                        System.out.println("Message send to " + phonenumber + " " + to.index_no);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dlg_messages.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        t.start();

    }

    private void delete_message() {

        int row = tbl_messages.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_messages.getSelectedColumn();
        if (col == 5) {
            to_messages to = (to_messages) tbl_messages_ALM.get(tbl_messages.convertRowIndexToModel(row));

            PortConnection.deleteMessage(to.index_no);
            try {
                Thread.sleep(1000);
                get_messages();
            } catch (InterruptedException ex) {
                Logger.getLogger(Dlg_messages.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (col == 4) {
            reply();
        }
    }
    public ArrayListModel tbl_members_ALM;
    public TblmembersModel tbl_members_M;

    private void init_tbl_members() {
        tbl_members_ALM = new ArrayListModel();
        tbl_members_M = new TblmembersModel(tbl_members_ALM);
        tbl_members.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_members.setModel(tbl_members_M);
        tbl_members.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_members.setRowHeight(25);
        int[] tbl_widths_members = {100, 100, 200, 30, 0, 0, 0};
        for (int i = 0, n = tbl_widths_members.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_members, i, tbl_widths_members[i]);
        }
        Dimension d = tbl_members.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_members.getTableHeader().setPreferredSize(d);
        tbl_members.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_members.setRowHeight(25);
        tbl_members.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_members(List<S1_members.to_members> acc) {
        tbl_members_ALM.clear();
        tbl_members_ALM.addAll(acc);
    }

    public static class TblmembersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Contact No", "Name", "Email Address", "", "department", "contact_no", "email_address"
        };

        public TblmembersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_members.to_members tt = (S1_members.to_members) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.contact_no;
                case 1:
                    return " " + tt.fname + " " + tt.mi + " " + tt.lname;
                case 2:
                    return " " + tt.email_address;
                case 3:
                    if (tt.selected == 1) {
                        return " [ - ]";
                    } else {
                        return " [ x ]";
                    }

                case 4:
                    return tt.department;
                case 5:
                    return tt.contact_no;
                default:
                    return tt.email_address;
            }
        }
    }

    private void data_cols_members() {
        String where = "";
        loadData_members(S1_members.ret_data(where));
    }

    private void send_member_message() {
        final int times = FitIn.toInt(jTextField4.getText());
        final List<S1_members.to_members> messages = tbl_members_ALM;
        System.out.println(messages.size());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (S1_members.to_members to : messages) {
                    try {
                        if (to.selected == 1) {
                            for (int i = 0; i < times; i++) {
                                Thread.sleep(3000);
                                String phonenumber = to.contact_no;
                                String message = jTextArea1.getText();
                                PortConnection.sendMessage(phonenumber, message);
                                System.out.println("Message send to " + phonenumber + " " + to.fname + " " + to.lname);
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dlg_messages.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t.start();
    }

    private void select_member() {
        int row = tbl_members.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_members to = (to_members) tbl_members_ALM.get(tbl_members.convertRowIndexToModel(row));
        int status = to.selected;
        if (status == 0) {
            to.setSelected(1);
        } else {
            to.setSelected(0);
        }
        tbl_members_M.fireTableDataChanged();
    }

    private void reply() {
        int row = tbl_messages.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_messages.getSelectedColumn();
        if (col == 4) {
            final to_messages to = (to_messages) tbl_messages_ALM.get(tbl_messages.convertRowIndexToModel(row));
            Window p = (Window) this;
            Dlg_reply nd = Dlg_reply.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_reply.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, final Dlg_reply.OutputData data) {
                    closeDialog.ok();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Dlg_messages.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String phonenumber = to.contact_no;
                            String message = data.message;
                            PortConnection.sendMessage(phonenumber, message);
                            System.out.println("Message send to " + phonenumber);
                        }
                    });
                    t.start();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }
}
