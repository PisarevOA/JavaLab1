package mephi.sem2java1;

import java.util.ArrayList;

public class HumanGen {
    Human_Teacher_Factory TeacherFactory;
    Human_Student_Factory studentFactory;

    public HumanGen(ExcelWork excel) {
        
        this.TeacherFactory = new Human_Teacher_Factory(
        excel.getMaleNameList(), excel.getFemaleNameList(),
        excel.getMaleTeacherSurNameList(), excel.getFemaleTeacherSurNameList(),
        excel.getMaleLastName(), excel.getFemaleLastName());
        this.studentFactory = new Human_Student_Factory(
        excel.getMaleNameList(), excel.getFemaleNameList(),
        excel.getMaleStudentSurNameList(),
        excel.getFemaleStudentSurNameList(), excel.getMaleLastName(),
        excel.getFemaleLastName());
    }

    public ArrayList<Human> GenHumanList() {
        ArrayList<Human> list = new ArrayList<>();
        Human human;

        human = this.TeacherFactory.createHuman();
        while (human != null) {
            list.add(human);
            human = this.TeacherFactory.createHuman();
        }
        human = this.studentFactory.createHuman();
        while (human != null) {
            list.add(human);
            human = this.studentFactory.createHuman();
        }
        return list;
    }
           
}
