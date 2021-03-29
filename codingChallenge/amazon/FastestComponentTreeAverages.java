package amazon;

import java.util.ArrayList;
//
//class Info{
//    Integer max;
//    Integer totalLinesPerSubComponent;
//    Integer totalChildrenPerSubComponent;
//    Info(){
//        max=0;
//        totalChildrenPerSubComponent=0;
//        totalLinesPerSubComponent=0;
//    }
//    Info(Integer max,Integer totalLinesPerSubComponent,Integer totalChildrenPerSubComponent){
//        this.max=max;
//        this.totalLinesPerSubComponent=totalLinesPerSubComponent;
//        this.totalChildrenPerSubComponent=totalChildrenPerSubComponent;
//    }
//}


class ComponentNode{

    int value;
    ArrayList<ComponentNode> components;
    public ComponentNode(){components=new ArrayList<>();}

    ComponentNode(int numberOfLinesChanged){
        this.value=numberOfLinesChanged;
        components=new ArrayList<>();
    }
}

public class FastestComponentTreeAverages {
    public static int totalChildrenPerSubComponent=0;
    public static int totalLinesPerSubComponent=0;
    public static int max=0;

    public static ComponentNode getFastestComponent(ComponentNode rootComponent){
        ComponentNode res = new ComponentNode();
        helper(rootComponent, res);
        return  res;
    }

    static void helper(ComponentNode root, ComponentNode nodeWithMaxAverage){
        if(root.components.size() == 0){
            totalChildrenPerSubComponent=1;
            totalLinesPerSubComponent= root.value;
            return;
        }
        int totalForNode = root.value;
        int totalChildren = 1;
        for(ComponentNode child : root.components){
            totalLinesPerSubComponent=0;totalChildrenPerSubComponent=0;
            helper(child, nodeWithMaxAverage);
            totalForNode+=totalLinesPerSubComponent;
            totalChildren+=totalChildrenPerSubComponent;
        }

        int averageForNode = totalForNode/totalChildren;
        if(averageForNode>max){
            max=averageForNode;
            nodeWithMaxAverage.value=root.value;
            nodeWithMaxAverage.components= root.components;
        }
        totalLinesPerSubComponent=totalForNode;
        totalChildrenPerSubComponent=totalChildren;
    }

    public static void main(String[] args) {

        ComponentNode b = new ComponentNode(120);
        ComponentNode c = new ComponentNode(180);

        ComponentNode root =new ComponentNode(200);
        root.components= new ArrayList<>();
        root.components.add(b);
        root.components.add(c);

        b.components=new ArrayList<>();
        b.components.add(new ComponentNode(110));
        b.components.add(new ComponentNode(20));
        b.components.add(new ComponentNode(30));

        c.components=new ArrayList<>();
        c.components.add(new ComponentNode(150));
        c.components.add(new ComponentNode(80));

        System.out.println(getFastestComponent(root).value);
    }
}
