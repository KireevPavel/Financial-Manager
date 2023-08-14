package com.kireev.service;

import com.kireev.model.MonthlyReport;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerMonthlyReport {
    FileReader fileReader = new FileReader();
    public ArrayList<MonthlyReport> report = new ArrayList<>();

    public void readAllMonthlyReports() {
        for (int i = 1; i <= 3; i++) {
            String path = "./resources/" + "m.20210" + i + ".csv";
            ReadMonthlyReports(i, path);
        }
    }

    void ReadMonthlyReports(int month, String path) {
        String content = fileReader.readFileContents(path);
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] element = line.split(",");
            String name = element[0];
            boolean isExpense = Boolean.parseBoolean(element[1]);
            int quantity = Integer.parseInt(element[2]);
            double sumOfOne = Double.parseDouble(element[3]);
            MonthlyReport monthlyReport = new MonthlyReport(name, isExpense, quantity, sumOfOne, month);
            report.add(monthlyReport);
        }
    }

    public String getTopProductIncomeInMonth(int month) {
        HashMap<String, Double> topProduct = new HashMap<>();
        for (MonthlyReport monthlyReport : report) {
            if (monthlyReport.isExpense == false && monthlyReport.month == month) {
                topProduct.put(monthlyReport.name, monthlyReport.sumOfOne * monthlyReport.quantity);
            }
        }
        String maxName = null;
        for (String name : topProduct.keySet()) {
            if (maxName == null) {
                maxName = name;
                continue;
            }
            if (topProduct.get(maxName) < topProduct.get(name)) {
                maxName = name;
            }
        }
        return " Самый прибыльный товар - " + maxName + ",\n его сумма составляет - " + topProduct.get(maxName) + " рублей";
    }

    public String getTopProductExpenseInMonth(int month) {
        HashMap<String, Double> topProduct = new HashMap<>();
        for (MonthlyReport monthlyReport : report) {
            if (monthlyReport.isExpense == true && monthlyReport.month == month) {
                topProduct.put(monthlyReport.name, monthlyReport.sumOfOne * monthlyReport.quantity);
            }
        }
        String maxName = null;
        for (String name : topProduct.keySet()) {
            if (maxName == null) {
                maxName = name;
            }
            if (topProduct.get(maxName) < topProduct.get(name)) {
                maxName = name;
            }
        }
        return " Самая большая трата - " + maxName + ",\n ее сумма составляет - " + topProduct.get(maxName) + " рублей";
    }

    double getAmountExpenseInMonth(int month) {
        double sumExpense = 0;
        double expense;
        for (MonthlyReport monthlyReport : report) {
            if (monthlyReport.isExpense == true && monthlyReport.month == month) {
                expense = monthlyReport.quantity * monthlyReport.sumOfOne;
                sumExpense += expense;
            }
        }
        return sumExpense;
    }

    public double getAmountIncomeInMonth(int month) {
        double sumIncome = 0;
        double income;
        for (MonthlyReport monthlyReport : report) {
            if (monthlyReport.isExpense == false && monthlyReport.month == month) {
                income = monthlyReport.quantity * monthlyReport.sumOfOne;
                sumIncome += income;
            }
        }
        return sumIncome;
    }
}




