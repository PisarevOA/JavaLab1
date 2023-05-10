
package mephi.sem2java1;

public class TextBookEng implements Textbook{
    private final String name;
    private final String university;
    private final String author;
    private final String level;

    public TextBookEng(String name, String university, String author, String level) {
        this.name = name;
        this.university = university;
        this.author = author;
        this.level = level;
    }
    
    @Override
    public String getInfo() {
        return name + "; " + university + "; " + author + "; " + level;
    }
}
