package mephi.sem2java1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWork {
    private Workbook wb;
    private FileInputStream fis;

    public ExcelWork(String filename) {
        
        Init(filename);
        
        try {
            fis.close();
        } catch (IOException e) {
            System.out.print("IOException");
        }
    }

    private void Init(String filename) {
        try {
            fis = new FileInputStream(filename);
            this.wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException"); //Добавить в GUI
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
    
    private ArrayList<String> readSheet(int sheetNum, boolean male) {
        Sheet sheet = wb.getSheetAt(sheetNum);
        ArrayList<String> list = new ArrayList<>();
        for (Row row : sheet) {
            //System.out.println(row.getCell(1).getCellType());
            if (male ? row.getCell(1).getBooleanCellValue()
                : !row.getCell(1).getBooleanCellValue())
                list.add(row.getCell(0).getStringCellValue());
            }
        return list;
    }
    
    public ArrayList<String> getMaleNameList() { 
        return readSheet(0, true); 
    }

    public ArrayList<String> getFemaleNameList() {
        return readSheet(0, false); 
    }

    public ArrayList<String> getMaleStudentSurNameList() {
        return readSheet(1, true);
    }

    public ArrayList<String> getFemaleStudentSurNameList() {
        return readSheet(1, false);
    }

     public ArrayList<String> getMaleTeacherSurNameList() {
        return readSheet(2, true);
    }

    public ArrayList<String> getFemaleTeacherSurNameList() {
        return readSheet(2, false);
    }

    public ArrayList<String> getMaleLastName() {
        return readSheet(3, true); 
    }

    public ArrayList<String> getFemaleLastName() {
        return readSheet(3, false);
    }

}
