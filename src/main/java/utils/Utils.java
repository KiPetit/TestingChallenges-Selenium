package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;
import static utils.DriverManager.driver;

public class Utils {
    @DataProvider
    public static Object[][] getData(){
        return new Object[][]{{" ", "Space"},
                {"t", "Minimum value"},
                {"Tim", "Average value"},
                {"tttttttttttttttttttttttttttttt", "Maximum values"},
                {"ttttttttttttttttttttttttttttttttt", "More than maximum values"},
                {" test", "Space values at the beginning"},
                {"test test", "Space in the middle"},
                {"test ","Space values at the end"}};
    }
    public static String generateCNP(){
        String cnp;
        Random rnd = new Random();
        int[] multiplier=new int[] {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int[] idNumber=new int[6];
        int bornCentury=rnd.nextInt((9-1)+1)+1;
        int bornYear=rnd.nextInt((15-11)+1)+11;
        int bornMonth=rnd.nextInt((12-10)+1)+10;
        int bornDay=rnd.nextInt((30-10)+1)+10;
        int areaCode=rnd.nextInt((50-12)+1)+12;
        int orderNumber=rnd.nextInt((500-111)+1)+111;

        idNumber[0]=bornCentury;
        idNumber[1]=bornYear;
        idNumber[2]=bornMonth;
        idNumber[3]=bornDay;
        idNumber[4]=areaCode;
        idNumber[5]=orderNumber;

        String resultArray= Arrays.toString(idNumber);
        String resultString=resultArray
                .replace(",","")
                .replace("[","")
                .replace("]","")
                .replace(" ","")
                .trim();
        int[] resultDigits= Stream.of(resultString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int first = resultDigits[0] * multiplier[0];
        int second = resultDigits[1] * multiplier[1];
        int third = resultDigits[2] * multiplier[2];
        int fourth = resultDigits[3] * multiplier[3];
        int fifth = resultDigits[4] * multiplier[4];
        int sixth = resultDigits[5] * multiplier[5];
        int seventh = resultDigits[6] * multiplier[6];
        int eight = resultDigits[7] * multiplier[7];
        int ninth = resultDigits[8] * multiplier[8];
        int tenth = resultDigits[9] * multiplier[9];
        int eleventh = resultDigits[10] * multiplier[10];
        int twelfth = resultDigits[11] * multiplier[11];

        int multipliedResult = first + second + third + fourth + fifth +
                sixth + seventh + eight + ninth + tenth + eleventh + twelfth;
        int quotient = multipliedResult / 11;
        if(quotient==10){
            cnp=resultString+"1";
        }
        else{
            int resultRest=multipliedResult%11;
            cnp=resultString+resultRest;
            if(cnp.length()==14){
              cnp=cnp.substring(0,cnp.length()-1);
            }
        }
        return cnp;
    }
    public ArrayList<String> getData(String Sheet, String UserName) throws IOException {
        ArrayList<String> a = new ArrayList<>();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/DDT.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(Sheet)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Username")) {
                        column = k;
                    }
                    k++;
                }
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(UserName)) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
    public static void waitForElementToBeVisible(WebElement element, String text){
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    public static String randomUsernameGenerator(){
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
