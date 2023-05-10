package mephi.sem2java1;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI extends JFrame{
    private final JTree tree;
    private final DefaultMutableTreeNode rootTree;
    private final DefaultMutableTreeNode students;
    private final DefaultMutableTreeNode teachers;
    private final JScrollPane scroll;
    private final Random rand;

    public GUI(String name, ArrayList<Human> people, ArrayList<Bookable> books) {
        super(name);
        rand = new Random();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBounds(200,200,800,400);
        
        this.rootTree = new DefaultMutableTreeNode("Пользователи");
        this.tree = new JTree(rootTree);
        this.students = new DefaultMutableTreeNode("Студенты");
        this.teachers = new DefaultMutableTreeNode("Преподаватели");
        this.scroll = new JScrollPane(tree);
        
        rootTree.add(teachers);
        rootTree.add(students);
        initHumanNodes(people, books);
        this.add(scroll);
    }

    private void initHumanNodes(ArrayList<Human> people, ArrayList<Bookable> books) {
        DefaultMutableTreeNode varNode;

        for (Human p : people) {
            varNode = new DefaultMutableTreeNode(p.name_check());
            if (p instanceof Human_Teacher) {
                teachers.add(varNode);
            } else {
                students.add(varNode);
            }
            initBookNodes(varNode, books);
        }
    }

    private void initBookNodes(DefaultMutableTreeNode parent, ArrayList<Bookable> books) {
        ArrayList<Bookable> copy = new ArrayList<>(books);
        
        Collections.shuffle(copy);
        DefaultMutableTreeNode varNode;

        for (Bookable b : copy.subList(0, rand.nextInt(3, 10))) {
            varNode = new DefaultMutableTreeNode(b.getInfo());
            parent.add(varNode);
        }
    }
}
