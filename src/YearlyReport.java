import java.util.ArrayList;

public class YearlyReport {
    ArrayList<ItemYearlyReport> itemYearlyReports;
    public int getIncomeOfMonthInYearReport(int monthNumber) {

        int income = 0;
        for (int i = 0; i < itemYearlyReports.size(); i++) {
            ItemYearlyReport currentData = itemYearlyReports.get(i);
            if (currentData.month == monthNumber && !currentData.isExpense) {
                income += currentData.amount;
            }
        }
        return income;
    }
    public int getExpensesOfMonthInYearReport(int monthNumber) {

        int expense = 0;
        for (int i = 0; i < itemYearlyReports.size(); i++) {
            ItemYearlyReport currentData = itemYearlyReports.get(i);
            if (currentData.month == monthNumber && currentData.isExpense) {
                expense += currentData.amount;
            }
        }
        return expense;
    }

    public int getProfitOfMonthInYearReport(int monthNumber) {
        return getIncomeOfMonthInYearReport(monthNumber) - getExpensesOfMonthInYearReport(monthNumber);
    }
   public int getAverageYearExpense() {
        int sumOfExpenses = 0;
        int quantityOfExpenses = 0;
        for (int i = 0; i < itemYearlyReports.size(); i++) {
            ItemYearlyReport currentData = itemYearlyReports.get(i);
            if (currentData.isExpense) {
                quantityOfExpenses++;
                sumOfExpenses += currentData.amount;
            }
        }
        return sumOfExpenses / quantityOfExpenses;
    }
    public int getAverageYearIncome() {
        int sumOfIncome = 0;
        int quantityOfIncome = 0;
        for (int i = 0; i < itemYearlyReports.size(); i++) {
            ItemYearlyReport currentData = itemYearlyReports.get(i);
            if (!currentData.isExpense) {
                quantityOfIncome++;
                sumOfIncome += currentData.amount;
            }
        }
        return sumOfIncome / quantityOfIncome;
    }

}


