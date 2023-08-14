package com.kireev.model;

public class YearlyReport {
    public int month;
    public double amount;
    public boolean isExpense;

    public YearlyReport(int month, double amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
