import java.util.*;
public class Main {

        public static void main(String[] args) {
            HashMap<String, ArrayList<String[]>> allMonths = new HashMap<>();
            MonthlyReportManager reportManager = new MonthlyReportManager();
            YearlyReportManager yearlyReportManager = new YearlyReportManager();
            Checker checker = new Checker(reportManager, yearlyReportManager);
            Scanner scanner = new Scanner(System.in);
            boolean madeAccountM = false;
            boolean madeAccountY = false;
            while(true){
                showMenu();
                String command = scanner.nextLine();
                if (command.equals("1")) {
                    madeAccountM = true;
                    reportManager.loadFile();
                    System.out.println("Месячные отсчёты считаны");
                }
                else if (command.equals("2")){
                    if (madeAccountM){
                        yearlyReportManager.loadFile();
                        madeAccountY = true;
                           System.out.println("Годовые отсчёты считаны");
                    }
                    else System.out.println("Требуется считать месячные отсчёты");
                }
                else if (command.equals("3")){
                    if (madeAccountM){
                        checker.makeCheck();
                    }
                    else System.out.println("Требуется считать месячные отсчёты");
                }
                else if (command.equals("4")){
                    if (madeAccountM){
                        reportManager.getInfo();
                    }
                    else System.out.println("Требуется считать месячные отсчёты");
                }
                else if (command.equals("5")){
                    if (madeAccountM && madeAccountY){
                        System.out.println("Год - 2021: ");
                        yearlyReportManager.countProfitPerMonth();
                        yearlyReportManager.countAverageExpensePerMonth();
                        yearlyReportManager.countAverageRevenuePerMonth();
                    }
                    else System.out.println("Требуется считать месячные и годовой отсчёты");
                }
                else if (command.equals("Exit")) {
                    break;
                }
                else System.out.println("Некорректный формат ввода. Введите число от 1 до 5");
            }
        }
        public static void showMenu() {
            System.out.println("Меню:");
            System.out.println("1. Считать все месячные отчёты");
            System.out.println("2. Считать годовой отчёт");
            System.out.println("3. Сверить отчёты");
            System.out.println("4. Вывести информацию о всех месячных отчётах");
            System.out.println("5. Вывести информацию о годовом отчёте");
        }
    }
