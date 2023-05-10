package mephi.sem2java1;

public class TextBookRus implements Textbook{
    private String name;

    public TextBookRus(String name) {
        this.name = name; 
    }

    @Override
    public String getInfo() {
        return name;
    }
}
