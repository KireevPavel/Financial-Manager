import java.util.ArrayList;

public class ReportBase {

     ArrayList<MonthlyReport> reports = new ArrayList<>();

    public ArrayList<MonthlyReport> getReportsForAllMonths() {
        int monthNumber = 1;
        ArrayList<MonthlyReport> reports = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReport.itemMonthlyReports = getMonthlyReport("resources/m.20210" + i + ".csv");
            monthlyReport.month = monthNumber++;
            reports.add(monthlyReport);
        }
        return reports;
    }
    public ArrayList<ItemMonthlyReport> getMonthlyReport(String path) {

        String fileContents = ReadingFiles.readFileContentsOrNull(path);

        String[] lines = fileContents.split("\\n"); //
        ArrayList<ItemMonthlyReport> dataArray = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {

            String[] lineContents = lines[i].split(","); //

            String itemName = lineContents[0];
            int quantity = Integer.parseInt(lineContents[2]);
            int sumOfOne = Integer.parseInt(lineContents[3]);
            boolean isExpense = Boolean.parseBoolean(lineContents[1]);

            ItemMonthlyReport item = new ItemMonthlyReport();
            item.itemName = itemName;
            item.isExpense = isExpense;
            item.quantity = quantity;
            item.sumOfOne = sumOfOne;

            dataArray.add(item);
        }
        return dataArray;
    }
    public ArrayList<ItemYearlyReport> readYearlyReport(String path) {

        String fileContents = ReadingFiles.readFileContentsOrNull(path);
        String[] lines = fileContents.split("\\n");
        ArrayList<ItemYearlyReport> yearDataArray = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {

            String[] lineContents = lines[i].split(",");
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);

            ItemYearlyReport item = new ItemYearlyReport();
            item.month = month;
            item.amount = amount;
            item.isExpense = isExpense;

            yearDataArray.add(item);

        }
        return yearDataArray;
    }
    public YearlyReport getYearlyReport() {

        YearlyReport yearlyReport = new YearlyReport();
        yearlyReport.itemYearlyReports = readYearlyReport("resources/y.2021.csv");

        return yearlyReport;
    }
}








