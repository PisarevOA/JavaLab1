package mephi.sem2java1;

import java.util.ArrayList;

public class Human_Student_Factory extends Human_Factory{
    
    public Human_Student_Factory(ArrayList<String> maleName,
                                ArrayList<String> femaleName,
                                ArrayList<String> maleSurName,
                                ArrayList<String> femaleSurName,
                                ArrayList<String> maleLastName,
                                ArrayList<String> femaleLastName) {
        
    super(maleName, femaleName, maleSurName, femaleSurName, maleLastName,femaleLastName);
    }
    
    public Human createHuman() {
        Human_Student human = new Human_Student();
        if (initHuman(human))
            return human;
        return null;
    }
    
}
