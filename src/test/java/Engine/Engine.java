package Engine;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Engine {

    public static String readFromExcel(String header) throws IOException {

        try {
            File file = new File("C:\\Users\\Kwanda Buso\\Documents\\NetBeansProjects\\mavenproject1\\test.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            Cell cell = null;
            var cellNumber =0;
            var rowNumber = 0;
            String myText="";
            String keyword="";
            Row row;
            boolean isfound = false;

            while (itr.hasNext() && !isfound) {
                row = itr.next();
                cellNumber =0;
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                try
                {
                    keyword = row.getCell(0).toString();
                }
                catch(Exception ex)
                {

                }

                if(keyword.startsWith("*")||keyword.equalsIgnoreCase("null"))
                {
                    rowNumber++;
                    row = itr.next();
//                    itr.next();
//                    itr.next();
                    continue;
                }


                while (cellIterator.hasNext()) {

                    cell = cellIterator.next();

                    //field that represents string cell type
                    String val = cell.getStringCellValue();

                    if(val.equalsIgnoreCase(header))
                    {
                        row = itr.next();
                        System.out.print(cell.getStringCellValue() + ":) :) :) :) ");
                        myText= row.getCell(cellNumber).toString();
                        isfound = true;
                        break;
                    }

                    cellNumber++;
                }

                if(itr.hasNext() && !isfound)
                {
                    row = itr.next();
                }

                System.out.println("");
            }
            System.out.println("");
            return myText;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
