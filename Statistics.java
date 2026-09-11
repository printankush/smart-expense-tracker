//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Statistics extends JFrame {
    private JButton btnChart;

    public Statistics() {
        this.setTitle("Expense Statistics");
        this.setSize(600, 500);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.setLayout((LayoutManager)null);
        JLabel title = new JLabel("EXPENSE STATISTICS");
        title.setBounds(150, 20, 300, 35);
        title.setFont(new Font("Arial", 1, 24));
        this.add(title);
        double totalExpense = (double)0.0F;
        String highestCategory = "";
        String highestDay = "";
        Map<String, Double> categoryMap = new HashMap();
        Map<String, Double> dayMap = new HashMap();

        try {
            BufferedReader br = new BufferedReader(new FileReader("expenses.txt"));

            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String category = data[0];
                    double amount = Double.parseDouble(data[2]);
                    String date = data[3];
                    totalExpense += amount;
                    categoryMap.put(category, (Double)categoryMap.getOrDefault(category, (double)0.0F) + amount);
                    dayMap.put(date, (Double)dayMap.getOrDefault(date, (double)0.0F) + amount);
                }
            }

            br.close();
        } catch (Exception var18) {
            JOptionPane.showMessageDialog(this, "No Expense Data Found.");
        }

        double maxCategoryExpense = (double)0.0F;

        for(String key : categoryMap.keySet()) {
            if ((Double)categoryMap.get(key) > maxCategoryExpense) {
                maxCategoryExpense = (Double)categoryMap.get(key);
                highestCategory = key;
            }
        }

        double maxDayExpense = (double)0.0F;

        for(String key : dayMap.keySet()) {
            if ((Double)dayMap.get(key) > maxDayExpense) {
                maxDayExpense = (Double)dayMap.get(key);
                highestDay = key;
            }
        }

        JLabel total = new JLabel("Total Expense : ₹ " + totalExpense);
        total.setBounds(60, 80, 400, 30);
        total.setFont(new Font("Arial", 1, 18));
        this.add(total);
        JLabel cat = new JLabel("Highest Category : " + highestCategory);
        cat.setBounds(60, 120, 400, 30);
        cat.setFont(new Font("Arial", 0, 18));
        this.add(cat);
        JLabel day = new JLabel("Highest Spending Day : " + highestDay);
        day.setBounds(60, 160, 450, 30);
        day.setFont(new Font("Arial", 0, 18));
        this.add(day);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", 0, 16));
        area.append("Category-wise Expense\n\n");

        for(String key : categoryMap.keySet()) {
            area.append(key + " : ₹ " + String.valueOf(categoryMap.get(key)) + "\n");
        }

        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(60, 220, 460, 180);
        this.add(pane);
        this.btnChart = new JButton("View Bar Chart");
        this.btnChart.setBounds(180, 420, 220, 35);
        this.btnChart.setBackground(new Color(52, 152, 219));
        this.btnChart.setForeground(Color.WHITE);
        this.add(this.btnChart);
        this.btnChart.addActionListener((ex) -> new BarChart());
        this.setVisible(true);
    }
}
