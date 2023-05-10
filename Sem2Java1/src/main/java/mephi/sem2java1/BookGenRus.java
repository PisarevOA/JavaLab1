package mephi.sem2java1;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Locale;

public class BookGenRus implements BookFactory{
    private int textIter;
    private final ArrayList<String> prevNames;
    private final ArrayList<String> lastNames;
    private final ArrayList<String> names;

    public BookGenRus() {
        this.faker = new Faker(new Locale("ru"));
        this.textIter = 0;
        this.names = new ArrayList<>(
            Arrays.asList("Английский язык", "Немецкий язык", "Французский язык", "Испанский язык",
                      "Международные отношения", "Политика", "Западная культура", "Восточная культура"));
        this.prevNames = new ArrayList<>(Arrays.asList("Учебник", "Методические указания","Рабочая тетрадь"));
        this.lastNames = new ArrayList<>(Arrays.asList(
            "для начинащих", "средний уровень", "продвинутый уровень"));
      
    }

    @Override
    public Textbook createTextbook() {
        if (textIter / (lastNames.size() * prevNames.size()) == names.size())
            return null;
        String name = new String();
        name = name.concat(prevNames.get(textIter % 2)).concat(" \"");
        name = name.concat(names.get((textIter / 3) % names.size())).concat(" ");
        name = name.concat(lastNames.get(textIter % 3)).concat("\"");
        textIter++;
        return new TextBookRus(name);
    }
    Faker faker;
    @Override
    public Fiction createFiction() {
        return new FictionRus(faker.address().firstName() + " и " + faker.aviation().aircraft());  
    }
}
