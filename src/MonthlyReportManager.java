import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportManager {
    public HashMap<Integer, ArrayList<Expense>> monthlyReport = new HashMap<>();

    public void loadFile() {
        for (int i = 1; i < 4; i++) {
            ArrayList<Expense> monthInfo = new ArrayList<>();
            String content = readFileContents("resources/m.20210" + i + ".csv");
            String[] lines = content.split("\r?\n");
            for (int j = 1; j < lines.length; j++) {
                String line = lines[j];
                String[] parts = line.split(",");
                String name = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfone = Integer.parseInt(parts[3]);

                Expense expense = new Expense(name, isExpense, quantity, sumOfone);
                monthInfo.add(expense);
            }
            monthlyReport.put(i, monthInfo);
        }
    }

    public void getInfo() {
        for (Integer key : monthlyReport.keySet()) {
            int maxSum = 0;
            int expense;
            int curExpense;
            int maxExpense = 0;
            int revenue;
            int currentSum;
            String maxSumItemName = "";
            String maxExpenseItemName = "";
            for (Expense product : monthlyReport.get(key)) {
                if (product.isExpense) {
                    expense = product.quantity * product.sumOfone;
                    curExpense = expense;
                    if (curExpense >= maxExpense) {
                        maxExpense = curExpense;
                        maxExpenseItemName = product.name;
                    }
                } else {
                    revenue = product.quantity * product.sumOfone;
                    currentSum = revenue;
                    if (currentSum >= maxSum) {
                        maxSum = currentSum;
                        maxSumItemName = product.name;
                    }
                }
            }
            System.out.println(key + " месяц");
            System.out.println("Самый прибыльный товар: " + maxSumItemName + ": " + maxSum);
            System.out.println("Самая большая трата: " + maxExpenseItemName + ": " + maxExpense);
        }
    }

    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }
}