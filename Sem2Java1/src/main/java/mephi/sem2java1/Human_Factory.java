package mephi.sem2java1;

import java.util.ArrayList;
import java.util.Random;

public abstract class Human_Factory {
    ArrayList<String> maleName;
    ArrayList<String> femaleName;
    ArrayList<String> maleSurName;
    ArrayList<String> femaleSurName;
    ArrayList<String> maleLastName;
    ArrayList<String> femaleLastName;
    Random rand;

    public Human_Factory(ArrayList<String> maleName, 
                         ArrayList<String> femaleName,
                         ArrayList<String> maleSurName,
                         ArrayList<String> femaleSurName,
                         ArrayList<String> maleLastName,
                         ArrayList<String> femaleLastName) {
        
    this.maleName = maleName;
    this.femaleName = femaleName;
    this.maleSurName = new ArrayList<>(maleSurName);
    this.femaleSurName = new ArrayList<>(femaleSurName);
    this.maleLastName = maleLastName;
    this.femaleLastName = femaleLastName;
    this.rand = new Random();
    }

    private boolean femaleInit(Human human) {
        if (femaleSurName.isEmpty())
            return false;
        
        human.setMale(false);
        human.setName(femaleName.get(rand.nextInt(femaleName.size())));
        human.setSurName(femaleSurName.get(0));
        femaleSurName.remove(0);
        human.setLastName(femaleLastName.get(rand.nextInt(femaleLastName.size())));
        return true;
    }

    protected boolean initHuman(Human human) {
        if (maleSurName.isEmpty()) {
            return femaleInit(human);
        }
        
        human.setMale(true);
        human.setName(maleName.get(rand.nextInt(maleName.size())));
        human.setSurName(maleSurName.get(0));
        maleSurName.remove(0);
        human.setLastName(maleLastName.get(rand.nextInt(maleLastName.size())));
        return true;
    }


}
