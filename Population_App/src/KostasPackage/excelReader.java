package KostasPackage;

/**
 *
 * @author conspd
 */
import java.io.FileInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
    
    public static ObservableList<Country> Process() throws Exception {
        FileInputStream fis = new FileInputStream("/home/conspd/School/Java/day5/MAEProject/src/KostasPackage/TheFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        ObservableList<Country> statistics = FXCollections.observableArrayList();
        int rows = sheet.getLastRowNum();
        int year = 1950;
        int popul = 0;
        int i = 0;

        for (int r = 43; r < rows + 1; r++) {
            XSSFRow row = sheet.getRow(r);
            int cols = row.getLastCellNum();
            XSSFCell typeC = row.getCell(5);

            if (typeC.getStringCellValue().equals("Country/Area")) {
                /* Aρχικοποίηση του αντικειμένου Country */
                Country country = new Country();
                country.setIndex((int) row.getCell(0).getNumericCellValue());
                country.setVariant(row.getCell(1).getStringCellValue());
                country.setName(row.getCell(2).getStringCellValue());
                country.setNotes((int) row.getCell(3).getNumericCellValue());
                country.setCode((int) row.getCell(4).getNumericCellValue());
                country.setParentCode((int) row.getCell(6).getNumericCellValue());

                for (int c = 7; c < cols; c++) {
                    XSSFCell cell = row.getCell(c);
                    popul = ((int) cell.getNumericCellValue())*1000;
                    country.addToDatabase(year, popul);
                    year++;
                }
                country.setLastYear(year-1);
                country.setPopulation(popul);
                
                statistics.add(country);
                year = 1950;
                i++;
            }
        }
        return statistics;
    }
}
