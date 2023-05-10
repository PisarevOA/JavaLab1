package mephi.sem2java1;

import java.util.ArrayList;

public class Sem2Java1 {

    public static void main(String[] args) {
        ExcelWork test = new ExcelWork("Data.xlsx");
        
        //генерация людей
        HumanGen gen = new HumanGen(test);
        ArrayList<Human> list = gen.GenHumanList();
        
        //генерация литературы
        BookGen genBook = new BookGen();
        ArrayList<Bookable> Booklist = genBook.GenBookList();
        
        GUI gui = new GUI("Библиотечная система", list, Booklist);
        gui.setVisible(true);
    }
}
