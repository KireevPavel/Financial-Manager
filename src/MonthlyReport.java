import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<ItemMonthlyReport> itemMonthlyReports;
    int month;
    public int getIncomeOfMonth() {

        int income = 0;
        for (int i = 0; i < itemMonthlyReports.size(); i++) {
            ItemMonthlyReport item = itemMonthlyReports.get(i);
            if (!item.isExpense) {
                income += item.quantity * item.sumOfOne;
            }
        }
        return income;
    }
    public int getExpensesOfMonth() {
        int expense = 0;
        for (int i = 0; i < itemMonthlyReports.size(); i++) {
            ItemMonthlyReport item = itemMonthlyReports.get(i);
            if (item.isExpense) {
                expense += item.quantity * item.sumOfOne;
            }
        }
        return expense;
    }

    public void findTheBestItem() {
        int sum = 0;
        String name = "";
        for (int i = 0; i < itemMonthlyReports.size(); i++) {
            ItemMonthlyReport item = itemMonthlyReports.get(i);
            String currentName = item.itemName;
            int incomeOfItem = item.quantity * item.sumOfOne;
            if(!item.isExpense && incomeOfItem > sum) {
                sum = incomeOfItem;
                name = currentName;
            }
        }
        System.out.println("Самый прибыльный товар - " + name + ". Сумма " + sum + " руб.");
    }
    public void findTheBiggestExpense () {
        int expense = 0;
        String name = "";
        for (int i = 0; i < itemMonthlyReports.size(); i++) {
            ItemMonthlyReport item = itemMonthlyReports.get(i);
            String currentName = item.itemName;
            int expenseOfItem = item.quantity * item.sumOfOne;
            if(item.isExpense && expenseOfItem > expense) {
                expense = expenseOfItem;
                name = currentName;
            }
        }
        System.out.println("Самая большая трата - " + name + ". Сумма " + expense + " руб.");
    }
}




