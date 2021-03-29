package amazon;

import sun.misc.SoftCache;

import java.util.*;

class PairInt{
    int first, second;
    PairInt(){}
    PairInt(int first, int second){
        this.first=first;
        this.second=second;
    }
}
public class FetchItemsToDisplay {


    public static List<String> fetch(int numOfItems, Map<String ,PairInt> items, int sortParameter,
                                     int sortOrder, int itemsPerPage, int pageNumber){
        List<String> finalList = new LinkedList<>();

        List<Map.Entry<String ,PairInt>> listOfItems= new LinkedList<Map.Entry<String, PairInt>>(items.entrySet());
        //if sorted by name parameter
        if(sortParameter == 0){
            Collections.sort(listOfItems, (o1, o2) -> {
                //asc
                if(sortOrder == 0)
                    return o1.getKey().compareToIgnoreCase(o2.getKey());
                else
                    return o2.getKey().compareToIgnoreCase(o1.getKey());
            });
        }
        //if sorted by price parameter
        else if(sortParameter == 2){
            Collections.sort(listOfItems, (o1, o2) -> {
                //asc
                if(sortOrder == 0)
                    return o1.getValue().second-o2.getValue().second;
                else
                    return o2.getValue().second-o1.getValue().second;
            });

        }
        //if sorted by relevance parameter
        else if(sortParameter == 1){
            Collections.sort(listOfItems, (o1, o2) -> {
                //asc
                if(sortOrder == 0)
                    return o1.getValue().first-o2.getValue().first;
                else
                    return o2.getValue().first-o1.getValue().first;
            });
        }
        int currP =0;
        int currItemNum = 0;
        for(Map.Entry<String ,PairInt> entry : listOfItems){
            currItemNum++;
            if(currP == pageNumber){
                finalList.add(entry.getKey());
            }
            if(currItemNum == itemsPerPage){
                currItemNum=0;
                currP++;
            }
        }
        return  finalList;
    }

    public static void main(String[] args) {
       /* Map<String ,PairInt> items = new HashMap<>();
        items.put("owjevtkuyv", new PairInt(58584272, 62930912));
        items.put("rpaqgbjxik", new PairInt(9425650, 96088250));
        items.put("dfbkasyqcn", new PairInt(37469674, 46363902));
        items.put("vjrrisdfxe", new PairInt(18666489, 88046739));

        System.out.println("aaa"+fetch(4,items,2,1,2,0));*/


        Map<String ,PairInt> items = new HashMap<>();
        items.put("item1`", new PairInt(10, 15));
        items.put("items2", new PairInt(3, 4));
        items.put("items3", new PairInt(17, 8));

        System.out.println("aaa"+fetch(3,items,1,0,2,1));

            // create priority queue
            PriorityQueue< Integer > prq = new PriorityQueue <> (Collections.reverseOrder());

            // insert values in the queue
//        int[] boxes = {1,2,3};
//        int[] unitPerBox = {3,2,1};
//        for(int i=0;i<boxes.length;i++){
//            int num = boxes[i];
//            while(num>0){
//                prq.add(unitPerBox[i]);
//                num--;
//            }
//        }
//            //prq.add(6);
//            //prq.add(9);
//            //prq.add(5);
//            //prq.add(64);
//            //prq.add(6);
//
//            //print values
//        int truckSize = 3;
//            while (truckSize>0) {
//                System.out.print(prq.poll()+" ");
//                truckSize--;
//            }

        PriorityQueue<PairInt> pq = new PriorityQueue<>((a,b)-> a.first-b.first);

    }
}
