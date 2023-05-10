
package mephi.sem2java1;

public class FictionRus implements Fiction{
    private String name;

    public FictionRus(String name) {
        this.name = name; 
    }

    @Override
    public String getInfo() {
        return name;
    }
}
