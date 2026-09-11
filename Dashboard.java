//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame {
    private ExpenseManager manager = new ExpenseManager();
    private JComboBox<String> cmbCategory;
    private JTextField txtDescription;
    private JTextField txtAmount;
    private JTextField txtDate;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnDailySummary;
    private JButton btnStatistics;
    private JButton btnLogout;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblTotal;

    public Dashboard() {
        this.setTitle("Smart Expense Tracker");
        this.setSize(950, 650);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout((LayoutManager)null);
        this.getContentPane().setBackground(new Color(235, 245, 255));
        JLabel title = new JLabel("SMART EXPENSE TRACKER");
        title.setBounds(250, 20, 450, 40);
        title.setFont(new Font("Arial", 1, 28));
        title.setForeground(new Color(25, 60, 120));
        this.add(title);
        JLabel lblCategory = new JLabel("Category");
        lblCategory.setBounds(40, 90, 100, 25);
        this.add(lblCategory);
        String[] categories = new String[]{"Food", "Transport", "Shopping", "Bills", "Education", "Health", "Entertainment", "Others"};
        this.cmbCategory = new JComboBox(categories);
        this.cmbCategory.setBounds(150, 90, 180, 30);
        this.add(this.cmbCategory);
        JLabel lblDesc = new JLabel("Description");
        lblDesc.setBounds(40, 130, 100, 25);
        this.add(lblDesc);
        this.txtDescription = new JTextField();
        this.txtDescription.setBounds(150, 130, 250, 30);
        this.add(this.txtDescription);
        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(40, 170, 100, 25);
        this.add(lblAmount);
        this.txtAmount = new JTextField();
        this.txtAmount.setBounds(150, 170, 150, 30);
        this.add(this.txtAmount);
        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(40, 210, 100, 25);
        this.add(lblDate);
        this.txtDate = new JTextField();
        this.txtDate.setBounds(150, 210, 150, 30);
        this.txtDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        this.add(this.txtDate);
        this.btnAdd = new JButton("Add Expense");
        this.btnAdd.setBounds(150, 260, 170, 40);
        this.btnAdd.setBackground(new Color(52, 152, 219));
        this.btnAdd.setForeground(Color.WHITE);
        this.btnAdd.setFocusPainted(false);
        this.add(this.btnAdd);
        JLabel lblSearch = new JLabel("Search");
        lblSearch.setBounds(450, 90, 60, 25);
        this.add(lblSearch);
        this.txtSearch = new JTextField();
        this.txtSearch.setBounds(520, 90, 180, 30);
        this.add(this.txtSearch);
        this.btnSearch = new JButton("Search");
        this.btnSearch.setBounds(720, 90, 120, 30);
        this.add(this.btnSearch);
        this.model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.model.addColumn("Category");
        this.model.addColumn("Description");
        this.model.addColumn("Amount");
        this.model.addColumn("Date");
        this.table = new JTable(this.model);
        this.table.setRowHeight(28);
        this.table.setSelectionBackground(new Color(52, 152, 219));
        this.table.setSelectionForeground(Color.WHITE);
        this.table.getTableHeader().setFont(new Font("Arial", 1, 14));
        this.table.setFont(new Font("Arial", 0, 13));
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(0);

        for(int i = 0; i < this.table.getColumnCount(); ++i) {
            this.table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        JScrollPane pane = new JScrollPane(this.table);
        pane.setBounds(40, 320, 850, 220);
        this.add(pane);
        this.btnDelete = new JButton("Delete Selected");
        this.btnDelete.setBounds(40, 560, 170, 35);
        this.add(this.btnDelete);
        this.btnRefresh = new JButton("Refresh");
        this.btnRefresh.setBounds(230, 560, 130, 35);
        this.add(this.btnRefresh);
        this.btnDailySummary = new JButton("Daily Summary");
        this.btnDailySummary.setBounds(380, 560, 150, 35);
        this.btnDailySummary.setBackground(new Color(46, 204, 113));
        this.btnDailySummary.setForeground(Color.WHITE);
        this.add(this.btnDailySummary);
        this.btnStatistics = new JButton("Statistics");
        this.btnStatistics.setBounds(550, 560, 150, 35);
        this.btnStatistics.setBackground(new Color(52, 152, 219));
        this.btnStatistics.setForeground(Color.WHITE);
        this.add(this.btnStatistics);
        this.btnLogout = new JButton("Logout");
        this.btnLogout.setBounds(760, 560, 130, 35);
        this.btnLogout.setBackground(new Color(231, 76, 60));
        this.btnLogout.setForeground(Color.WHITE);
        this.add(this.btnLogout);
        this.lblTotal = new JLabel();
        this.lblTotal.setBounds(40, 605, 350, 25);
        this.lblTotal.setFont(new Font("Arial", 1, 20));
        this.lblTotal.setForeground(new Color(34, 139, 34));
        this.add(this.lblTotal);
        this.loadTable();
        this.btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String category = Dashboard.this.cmbCategory.getSelectedItem().toString();
                    String description = Dashboard.this.txtDescription.getText();
                    double amount = Double.parseDouble(Dashboard.this.txtAmount.getText());
                    String date = Dashboard.this.txtDate.getText();
                    if (description.isEmpty() || date.isEmpty()) {
                        JOptionPane.showMessageDialog((Component)null, "Please fill all fields.");
                        return;
                    }

                    Expense expense = new Expense(category, description, amount, date);
                    Dashboard.this.manager.addExpense(expense);
                    Dashboard.this.txtDescription.setText("");
                    Dashboard.this.txtAmount.setText("");
                    Dashboard.this.txtDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    Dashboard.this.loadTable();
                    JOptionPane.showMessageDialog((Component)null, "Expense Added Successfully!");
                } catch (NumberFormatException var8) {
                    JOptionPane.showMessageDialog((Component)null, "Please enter a valid amount.");
                }

            }
        });
        this.btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.model.setRowCount(0);

                for(Expense ex : Dashboard.this.manager.searchExpense(Dashboard.this.txtSearch.getText())) {
                    Dashboard.this.model.addRow(new Object[]{ex.getCategory(), ex.getDescription(), ex.getAmount(), ex.getDate()});
                }

            }
        });
        this.btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.txtSearch.setText("");
                Dashboard.this.loadTable();
            }
        });
        this.btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = Dashboard.this.table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog((Component)null, "Please select an expense.");
                } else {
                    Dashboard.this.manager.deleteExpense(row);
                    Dashboard.this.loadTable();
                }
            }
        });
        this.btnDailySummary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DailySummary();
            }
        });
        this.btnStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Statistics();
            }
        });
        this.btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard.this.dispose();
                new LoginPage();
            }
        });
        this.setVisible(true);
    }

    private void loadTable() {
        this.model.setRowCount(0);

        for(Expense ex : this.manager.getExpenses()) {
            this.model.addRow(new Object[]{ex.getCategory(), ex.getDescription(), ex.getAmount(), ex.getDate()});
        }

        this.updateTotal();
    }

    private void updateTotal() {
        this.lblTotal.setText("Total Expense : ₹ " + this.manager.getTotalExpense());
    }
}
