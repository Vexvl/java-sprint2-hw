import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReportManager {
    public ArrayList<YearReport> yearReport = new ArrayList<>();

    void loadFile() {
        String content = readFileContents("resources/y.2021.csv");
        String[] lines = content.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            String nameNum = parts[0];
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            YearReport yReport = new YearReport(nameNum, amount, isExpense);
            yearReport.add(yReport);
        }
    }

    public void countProfitPerMonth() {
        for (YearReport report : yearReport) {
            int revenue = 0;
            int expense = 0;
            if (report.isExpense == true) {
                revenue += report.amount;
            } else expense += report.amount;
            System.out.println("Месяц " + report.nameNum + ". Прибыль: " + (revenue - expense));
        }
    }

    public void countAverageExpensePerMonth() {
        int expense = 0;
        for (YearReport report : yearReport) {
            if (report.isExpense == true) {
                expense += report.amount;
            }
        }
        System.out.println("Средний расход за все месяцы в году: " + (expense / 3));
    }

    public void countAverageRevenuePerMonth() {
        int revenue = 0;
        for (YearReport report : yearReport) {
            if (!report.isExpense == true) {
                revenue += report.amount;
            }
        }
        System.out.println("Средний доход за все месяцы в году: " + (revenue / 3));
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