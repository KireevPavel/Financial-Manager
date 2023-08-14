package com.kireev.service;

import com.kireev.model.YearlyReport;

import java.util.ArrayList;

public class ManagerYearlyReport {
    FileReader fileReader = new FileReader();
    public ArrayList<YearlyReport> report = new ArrayList<>();
    String path = "./resources/y.2021.csv";

    public void readYearlyReport() {
        String content = fileReader.readFileContents(path);
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] element = line.split(",");
            int month = Integer.parseInt(element[0]);
            double amount = Double.parseDouble(element[1]);
            boolean isExpense = Boolean.parseBoolean(element[2]);
            YearlyReport yearlyReport = new YearlyReport(month, amount, isExpense);
            report.add(yearlyReport);
        }
    }

    public String getProfitByMonth(int month) {
        double income = 0;
        double expense = 0;
        double profit = 0;
        for (YearlyReport yearlyReport : report) {
            if (yearlyReport.isExpense == false && yearlyReport.month == month) {
                income = yearlyReport.amount;
            }
            if (yearlyReport.isExpense == true && yearlyReport.month == month) {
                expense = yearlyReport.amount;
            }
            profit = income - expense;
        }
        return "Прибыль за " + month + "-й месяц, составляет: " + profit + ".руб";
    }

    public String getAverageExpense() {
        double sumExpense = 0;
        double countExpense = 0;

        for (YearlyReport yearlyReport : report) {
            if (yearlyReport.isExpense == true) {
                double income = yearlyReport.amount;
                sumExpense += income;
                countExpense++;
            }
        }
        double averageIncome = sumExpense / countExpense;
        return "Средний расход за все имеющиеся операции в году: " + averageIncome + ".руб";
    }

    public String getAverageIncome() {
        double sumIncome = 0;
        double countIncome = 0;

        for (YearlyReport yearlyReport : report) {
            if (yearlyReport.isExpense == false) {
                double income = yearlyReport.amount;
                sumIncome += income;
                countIncome++;
            }
        }
        double averageIncome = sumIncome / countIncome;
        return "Средний доход за все имеющиеся операции в году: " + averageIncome + ".руб";
    }

    public double getIncomeInMonth(int month) {
        double sumIncome = 0;
        double income;
        for (YearlyReport yearlyReport : report) {
            if (yearlyReport.isExpense == false && yearlyReport.month == month) {
                income = yearlyReport.amount;
                sumIncome += income;
            }
        }
        return sumIncome;
    }

    double getExpenseInMonth(int month) {
        double sumExpense = 0;
        double expense;
        for (YearlyReport yearlyReport : report) {
            if (yearlyReport.isExpense == true && yearlyReport.month == month) {
                expense = yearlyReport.amount;
                sumExpense += expense;
            }
        }
        return sumExpense;
    }
}
