import java.util.ArrayList;

public class PrintInfo {

    public void printMonthInfo(ArrayList<MonthlyReport> monthlyReports) {
        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport currentMonthlyReport = monthlyReports.get(i);
            if(currentMonthlyReport.month == 1) {
                System.out.println("Январь");
            }else if (currentMonthlyReport.month == 2) {
                System.out.println("Февраль");
            }else{
                System.out.println("Март");
            }
            currentMonthlyReport.findTheBestItem();
            currentMonthlyReport.findTheBiggestExpense();
        }
    }
    public void printYearInfo(YearlyReport yearlyReport) {
        System.out.println("2021 год : ");
        System.out.println("Прибыль за январь " + yearlyReport.getProfitOfMonthInYearReport(1) + " руб.");
        System.out.println("Прибыль за февраль " + yearlyReport.getProfitOfMonthInYearReport(2) + " руб.");
        System.out.println("Прибыль за март " + yearlyReport.getProfitOfMonthInYearReport(3) + " руб.");
        System.out.println("Средний расход за год " + yearlyReport.getAverageYearExpense() + " руб.");
        System.out.println("Средний доход за год " + yearlyReport.getAverageYearIncome() + " руб.");

    }
}
