import java.util.ArrayList;

public class ReconciliationOfReports {

    public void compareMonthlyAndYearReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        checkIncome(yearlyReport, monthlyReports);
        checkExpenses(yearlyReport, monthlyReports);
    }


   private void checkIncome(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
       for (int i = 0; i < monthlyReports.size(); i++) {
           MonthlyReport itemMonthReport = monthlyReports.get(i);
            int monthIncome = itemMonthReport.getIncomeOfMonth();
            int yearIncome = yearlyReport.getIncomeOfMonthInYearReport(itemMonthReport.month);
            if(monthIncome != yearIncome) {
                System.out.println("Обнаружена ошибка при сверке доходов в месяце " + itemMonthReport.month);
            }
        }
    }

    private void checkExpenses(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport itemMonthReport = monthlyReports.get(i);
            int monthExpense = itemMonthReport.getExpensesOfMonth();
            int yearExpense = yearlyReport.getExpensesOfMonthInYearReport(itemMonthReport.month);
            if(monthExpense != yearExpense) {
                System.out.println("Обнаружена ошибка при сверке расходов в месяце " + itemMonthReport.month);
            }
        }
    }

}






