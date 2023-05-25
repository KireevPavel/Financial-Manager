import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        YearlyReport yearlyReport = null;
        ArrayList<MonthlyReport> monthlyReports = null;

        ReportBase actionsWithReports = new ReportBase();
        ReconciliationOfReports reconciliationOfReports = new ReconciliationOfReports();
        PrintInfo printInfo = new PrintInfo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                monthlyReports = actionsWithReports.getReportsForAllMonths();
                System.out.println("Считывание месяных отчетов выполнено.");
            } else if (userInput == 2) {
                yearlyReport = actionsWithReports.getYearlyReport();
                System.out.println("Считыание годового отчета выполнено.");
            } else if (userInput == 3) {
                if (monthlyReports == null || yearlyReport == null) {
                    System.out.println("Перед сверкой отчета сначала нужно их считать!");
                } else {
                    reconciliationOfReports.compareMonthlyAndYearReports(yearlyReport, monthlyReports);
                    System.out.println("Сверка отчетов проведена успешно!");
                }
            } else if (userInput == 4) {
                if(monthlyReports == null) {
                    System.out.println("Перед выводом информации нужно произвести считвание отчета.");
                } else {
                    printInfo.printMonthInfo(monthlyReports);
                }
            } else if (userInput == 5) {
                if(yearlyReport == null) {
                    System.out.println("Перед выводом информации нужно произвести считвание отчета.");
                } else {
                    printInfo.printYearInfo(yearlyReport);
                }
            } else if (userInput == 0) {
                System.out.println("Программа завершена.");
                break;
            } else {
                System.out.println("Извините, такой команды нет!");
            }
        }
    }
        public static void printMenu() {
            System.out.println("Что Вы хотите сделать?");
            System.out.println("1 - Считать все месячные отчеты");
            System.out.println("2 - Считать годовой отчет");
            System.out.println("3 - Сверить отчеты");
            System.out.println("4 - Вывести информацию о всех месячных отчетах");
            System.out.println("5 - Вывести информацию о годовом отчете");
            System.out.println("0 - Выход");
        }
    }









