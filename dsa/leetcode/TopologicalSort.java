package leetcode;
import java.util.*;


public class TopologicalSort {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        //make adjacency list
        for(int i=0; i<prerequisites.length; i++){
            int sub = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if(!adjList.containsKey(pre)){
                // adjList.add(pre);
                adjList.put(pre, new ArrayList<Integer>());
            }
            if(adjList.containsKey(sub)){
                List<Integer> preList = adjList.get(sub);
                preList.add(pre);
                adjList.put(sub,preList);
            }
            else{
                List<Integer> preList = new LinkedList<>();
                preList.add(pre);
                adjList.put(sub,preList);
            }

        }
        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()){
            System.out.println("key ..."+ entry.getKey() + "... adj list ..."+ entry.getValue());
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        for(Integer key : adjList.keySet()){
            visited.put(key, false);
        }


        Stack<Integer> stack = new Stack<>();
        for(Integer node : adjList.keySet()){
            if(visited.get(node) == false) topoSort(node,adjList,visited, stack);
        }

        System.out.println(stack);

        return stack.size()==0;

    }

    public static void topoSort(int node, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visited, Stack<Integer> stack){

        if(visited.get(node) == true) return ;

        for(Integer pre : adjList.get(node)){
            if(visited.get(pre) == false) topoSort(pre,adjList,visited, stack);
        }

        visited.put(node, true);

        System.out.println("adding node in stack "+node);

        stack.push(node);
    }

    public static void main(String[] args) {
        int [][] arr = {{1,0},{1,2},{2,0}};
        //TopologicalSort.canFinish(3, arr);
        HashSet<Character> hs = new HashSet<>();
        //hs.add("".charAt(0));
        hs.add(" ".charAt(0));
        //System.out.println(hs);

        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(1,2);hm.put(2,3);hm.put(3,4);hm.put(4,5);

        for(Integer value : hm.values()){
            System.out.println(value);
        }


    }
}
