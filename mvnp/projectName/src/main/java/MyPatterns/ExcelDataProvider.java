package MyPatterns;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public  class ExcelDataProvider {
    public static void main(String[] args) throws IOException {


    }
    public static ArrayList<String> getExceldata(String sheetName, String rowName) throws IOException {
        FileInputStream fis = new FileInputStream("PathTo Excel file");
        XSSFWorkbook data_excel = new XSSFWorkbook(fis);
        ArrayList<String> data_list = new ArrayList<>();
        for (int i = 0; i < data_excel.getNumberOfSheets(); i++) {


            if (data_excel.getSheetName(i).equals(sheetName)) {
                XSSFSheet sheet = data_excel.getSheetAt(i);
                //System.out.println(data_excel.getSheetName(i));

                Iterator<Row> rowIterator = sheet.rowIterator();
                Row row1;

                while (rowIterator.hasNext()) {

                    row1 = rowIterator.next();

                    Iterator<Cell> cell_iterator = row1.cellIterator();

                    if (cell_iterator.next().getStringCellValue().equals(rowName)) {
                        while (cell_iterator.hasNext()) {
                            data_list.add(cell_iterator.next().getStringCellValue());



                        }
                    } else {
                    }




                }


            } else{}
        }




        return data_list;

    }
}








