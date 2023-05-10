package mephi.sem2java1;

public abstract class Human {
    private String name;
    private String SurName;
    private String LastName;
    private boolean male;

public Human() {}

public void setName(String name) { 
    this.name = name; 
}
  
public void setSurName(String SurName) { 
    this.SurName = SurName; 
}

public void setLastName(String LastName) {
    this.LastName = LastName;
}

public void setMale(boolean male) { 
    this.male = male; 
}

public String name_check() {
    return name + " " + SurName + " " + LastName;
}
  
}