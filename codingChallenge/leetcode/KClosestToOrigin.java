package leetcode;
import java.util.*;

class Node{
    int[] pair;
    double distance;

    Node(){}

    Node(int[] pair, double distance){
        this.pair= pair;
        this.distance = distance;
    }
}
public class KClosestToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Node> pq = new LinkedList<>();

        for(int i=0;i< points.length;i++){
            pushPoints(points[i], pq);
        }

        int[][] res = new int[k][2];
        int i=0;

        Collections.sort(pq, ((o1,o2)-> (int) (o2.distance - o1.distance)));

        for(Node temp : pq){
            if(k>0){
                res[i]=temp.pair;
                i++;
                k--;
            }
            else break;

        }

        return res;

    }

    public void pushPoints(int[] point, List<Node> pq){

        double distance = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
        Node pointInfo = new Node(point, distance);
        pq.add(pointInfo);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{-2,2}};
        KClosestToOrigin k = new KClosestToOrigin();
        k.kClosest(arr,1);
    }
}
