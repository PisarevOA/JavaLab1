package mephi.sem2java1;

public class FictionEng implements Fiction{ 
    private String name;

    public FictionEng(String name) {
        this.name = name; 
    }

    @Override
    public String getInfo() {
     return name;
    }
}
