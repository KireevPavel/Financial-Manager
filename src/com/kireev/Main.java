package com.kireev;

import com.kireev.service.ComparingReports;
import com.kireev.service.ManagerMonthlyReport;
import com.kireev.service.ManagerYearlyReport;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManagerMonthlyReport managerMonthlyReport = new ManagerMonthlyReport();
        ManagerYearlyReport managerYearlyReport = new ManagerYearlyReport();
        ComparingReports comparingReports = new ComparingReports();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {

                case 1:
                    if (!managerMonthlyReport.report.isEmpty()) {
                        System.out.println("Месячные отчеты уже считаны");
                    } else {
                        managerMonthlyReport.readAllMonthlyReports();
                        System.out.println("Операция завершена");
                    }
                    break;
                case 2:
                    if (!managerYearlyReport.report.isEmpty()) {
                        System.out.println("Годовой отчет уже считан");
                    } else {
                        managerYearlyReport.readYearlyReport();
                        System.out.println("Операция завершена");
                    }
                    break;
                case 3:
                    if (managerMonthlyReport.report.isEmpty()) {
                        System.out.println("Перед выполнением операции пожалуйста считайте месячные отчеты");
                    } else if (managerYearlyReport.report.isEmpty()) {
                        System.out.println("Перед выполнением операции пожалуйста считайте годовой отчет");
                    } else {
                        for (int i = 1; i <= 3; i++) {
                            if (!comparingReports.getCompareIncome(managerMonthlyReport, managerYearlyReport, i)) {
                                System.out.println("Сумма доходов за год не сходится в месяце - " + i);
                            } else if (!comparingReports.getCompareExpense(managerMonthlyReport,
                                    managerYearlyReport, i)) {
                                System.out.println("Сумма расходов за год не сходится в месяце - " + i);
                            } else {
                                System.out.println("Сверка отчетов прошла успешно");
                            }
                        }
                    }
                    break;
                case 4:
                    if (managerMonthlyReport.report.isEmpty()) {
                        System.out.println("Перед выполнением операции пожалуйста считайте месячные отчеты");
                    } else {
                        for (int i = 1; i <= 3; i++) {
                            System.out.println("Месяц - " + i);
                            System.out.println(managerMonthlyReport.getTopProductIncomeInMonth(i));
                            System.out.println(managerMonthlyReport.getTopProductExpenseInMonth(i));
                        }
                    }
                    break;
                case 5:
                    if (managerYearlyReport.report.isEmpty()) {
                        System.out.println("Перед выполнением операции пожалуйста считайте годовой отчет");
                    } else {
                        System.out.println("2021 год ");
                        System.out.println(managerYearlyReport.getAverageExpense());
                        System.out.println(managerYearlyReport.getAverageIncome());
                        for (int i = 1; i <= 3; i++) {
                            managerYearlyReport.getProfitByMonth(i);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    scanner.close();
                    return;
                default:
                    System.out.println("Введено некорректное значение ");
                    printMenu();
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
