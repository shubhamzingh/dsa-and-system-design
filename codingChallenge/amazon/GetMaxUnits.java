package amazon;

import java.util.*;

class Helper{
    int boxes;
    int units;
    Helper(){};
    Helper(int boxes, int units){
        this.boxes=boxes;
        this.units=units;
    }
}
public class GetMaxUnits {

    public static int getMaxUnitsInTruck(int[] boxes, int[] unitsPerBox, int truckSize){
        int res=0;
        List<Helper> infoList = new LinkedList<>();
        for(int i=0; i<boxes.length; i++){
            infoList.add(new Helper(boxes[i], unitsPerBox[i]));
        }
        Collections.sort(infoList,((o1, o2) -> o2.units-o1.units));

        for(Helper entry : infoList){
            if(truckSize<=0) break;
            else{
                int numOfBoxesToBePicked = Math.min(entry.boxes, truckSize);
                res+=numOfBoxesToBePicked* entry.units;
                truckSize-=numOfBoxesToBePicked;
            }
        }

        return res;
    }
    public static void main(String[] args) {
//        int[] boxes = {1,10000000,3};
//        int[] unitsPerBox = {3,100000,1};

        int[] boxes = {1,1};
        int[] unitsPerBox = {9,6};

        System.out.println(getMaxUnitsInTruck(boxes,unitsPerBox,1));
    }
}
