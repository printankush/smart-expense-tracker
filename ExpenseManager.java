import java.util.ArrayList;
import java.io.*;

public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private final String FILE_NAME = "expenses.txt";

    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public void deleteExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            saveExpenses();
        }
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public ArrayList<Expense> searchExpense(String keyword) {

        ArrayList<Expense> result = new ArrayList<>();

        keyword = keyword.toLowerCase();

        for (Expense e : expenses) {
            if (e.getCategory().toLowerCase().contains(keyword)
                    || e.getDescription().toLowerCase().contains(keyword)
                    || e.getDate().toLowerCase().contains(keyword)) {

                result.add(e);
            }
        }

        return result;
    }

    public double getTotalExpense() {

        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        return total;
    }

    private void saveExpenses() {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(FILE_NAME));

            for (Expense e : expenses) {
                bw.write(e.toString());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadExpenses() {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    Expense expense = new Expense(
                            data[0],
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]
                    );

                    expenses.add(expense);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}