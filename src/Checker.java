import java.util.ArrayList;
import java.util.HashMap;

public class Checker {
    public MonthlyReportManager reportManager;
    public YearlyReportManager yearlyReport;

    public Checker(MonthlyReportManager reportManager, YearlyReportManager yearlyReport) {
        this.reportManager = reportManager;
        this.yearlyReport = yearlyReport;
    }

    public void makeCheck() {
        HashMap<Integer, ArrayList<Expense>> monthlyReport = reportManager.monthlyReport;
        ArrayList<YearReport> yearReport = yearlyReport.yearReport;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (YearReport report : yearReport) {
            numbers.add(report.amount);
        }
        for (Integer month : monthlyReport.keySet()) {
            int totalExpenses = 0;
            int totalRevenue = 0;
            for (Expense product : monthlyReport.get(month)) {
                if (product.isExpense == true) {
                    totalExpenses += product.quantity * product.sumOfone;
                } else {
                    totalRevenue += product.quantity * product.sumOfone;
                }
            }
            if (!numbers.contains(totalExpenses) || !numbers.contains(totalRevenue)) {
                System.out.println("В месяце " + month + " обнаружено несоответствие");
            } else System.out.println("Месяц " + month + " - проверка завершена успешно");
        }
    }
}