package mephi.sem2java1;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;

public class BookGenEng implements BookFactory{
    private int textIter;
    private final ArrayList<String> names;
    private final ArrayList<String> surNames;
    private final ArrayList<String> authors;
    private final ArrayList<String> university;
    private final ArrayList<String> levels;

    public BookGenEng() {
        this.textIter = 0;
        this.names = new ArrayList<>(Arrays.asList(
            "Becoming a Diplomat", "Foreign languages for an engineer",
            "Foundations of Politics","Communication models", 
            "International relationships: basics"));
        this.university = new ArrayList<>(
            Arrays.asList("Southwestern University", "Moscow State University",
                      "University of London", "Northwestern University",
                      "University of Doha"));
        this.authors = new ArrayList<>(
            Arrays.asList("Janet Reeves", "Thomas Moore", "Hector Perry",
                       "Eva Mathis", "Tim Davis"));
        this.surNames = new ArrayList<>(
             Arrays.asList("(beginner)", "(intermediate)", "(advanced)"));
        this.levels =
            new ArrayList<>(Arrays.asList("bachelor", "master", "doctor"));
    }
    Faker faker = new Faker();
    @Override
    public Textbook createTextbook() {
    if (textIter / 3 == names.size())
        return null;
        
    String name = "\"";
    name = name.concat(names.get(textIter / 3)).concat(" ");
    name = name.concat(surNames.get(textIter % 3)).concat("\"");
    String level = textIter % 3 == 2 ? levels.get(1) : levels.get(0);
    textIter++;
    return new TextBookEng(name, university.get((textIter - 1) / 3),
                          authors.get((textIter - 1) / 3), level);
    }

    @Override
    public Fiction createFiction() {
        return new FictionEng(faker.book().title());
    }
    
}