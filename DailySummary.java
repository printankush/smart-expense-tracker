//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DailySummary extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public DailySummary() {
        this.setTitle("Daily Expense Summary");
        this.setSize(500, 400);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.setLayout(new BorderLayout());
        this.model = new DefaultTableModel();
        this.model.addColumn("Date");
        this.model.addColumn("Total Expense");
        this.table = new JTable(this.model);
        this.add(new JScrollPane(this.table), "Center");
        this.loadSummary();
        this.setVisible(true);
    }

    private void loadSummary() {
        Map<String, Double> summary = new LinkedHashMap();
        File file = new File("expenses.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "No Expense Data Found");
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        String date = data[3];
                        double amount = Double.parseDouble(data[2]);
                        summary.put(date, (Double)summary.getOrDefault(date, (double)0.0F) + amount);
                    }
                }

                for(Map.Entry<String, Double> entry : summary.entrySet()) {
                    this.model.addRow(new Object[]{entry.getKey(), "₹ " + String.valueOf(entry.getValue())});
                }
            } catch (Exception var11) {
                JOptionPane.showMessageDialog(this, "Error reading expenses file.");
            }

        }
    }
}
