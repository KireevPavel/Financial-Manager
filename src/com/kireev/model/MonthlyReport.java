package com.kireev.model;

public class MonthlyReport {
    public String name;
    public Boolean isExpense;
    public int quantity;
    public double sumOfOne;
    public int month;

    public MonthlyReport(String name, Boolean isExpense, int quantity, double sumOfOne, int month) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
        this.month = month;
    }
}
