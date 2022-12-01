import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        while(true){
            showMenu();
            String command = scanner.nextLine();
            if (command.equals("1"))
            {
                System.out.println("lol1");
                for (int i = 1; i < 4; i++){
                  readFileContents("m.20210" + i + ".csv");
                }
            }
            else if (command.equals("2")){
                System.out.println("lol2");

            }
            else if (command.equals("3")){
                System.out.println("lol3");

            }
            else if (command.equals("4")){
                System.out.println("lol4");

            }
            else if (command.equals("5")){
                System.out.println("lol5");

            }
            else if (command.equals("Еxit")) {
                break;
            }
            else System.out.println("Некорректный формат ввода. Введите число от 1 до 5");
        }
    }
    public static void showMenu(){
        System.out.println("Меню:");
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
    }
        public static String readFileContents(String path) {
            try {
                return Files.readAllLines(Path.of(path));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
                return Collections.emptyList();
            }
        }
}

