package mephi.sem2java1;

import java.util.ArrayList;

public class BookGen {
    private static final int num = 50;
    private final BookGenEng en;
    private final BookGenRus ru;

    public BookGen() {
        this.en = new BookGenEng();
        this.ru = new BookGenRus();
    }
    
    public ArrayList<Bookable> GenBookList() {
        ArrayList<Bookable> list = new ArrayList<>();
        Bookable book;

        book = en.createTextbook();
        while (book != null) {
            list.add(book);
            book = en.createTextbook();
        }
        
        book = ru.createTextbook();
        while (book != null) {
            list.add(book);
            book = ru.createTextbook();
        }
        
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                list.add(en.createFiction());
            } else {
                list.add(ru.createFiction());
            }
        }
        return list;
    }
}
