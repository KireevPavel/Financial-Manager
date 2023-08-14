package com.kireev.service;

public class ComparingReports {

    public boolean getCompareExpense(ManagerMonthlyReport managerMonthlyReport,
                                     ManagerYearlyReport managerYearlyReport, int month) {
        if (managerMonthlyReport.getAmountExpenseInMonth(month) != managerYearlyReport.getExpenseInMonth(month)) {
            return false;
        }
        return true;
    }

    public boolean getCompareIncome(ManagerMonthlyReport managerMonthlyReport,
                                    ManagerYearlyReport managerYearlyReport, int month) {
        if (managerMonthlyReport.getAmountIncomeInMonth(month) != managerYearlyReport.getIncomeInMonth(month)) {
            return false;
        }
        return true;
    }

}
