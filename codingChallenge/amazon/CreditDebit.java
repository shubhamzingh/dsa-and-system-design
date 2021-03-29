package amazon;

import java.util.*;

class debtRecord{
    String borrower;
    String lender;
    int amount =0;
    debtRecord(){};
    debtRecord(String borrower, String lender, int amount){
        this.borrower=borrower;
        this.lender=lender;
        this.amount=amount;
    }
}

public class CreditDebit {

    public static List<String> getMostNegative(List<debtRecord> records){
        Map<String, Integer> map = new HashMap<>();
        for(debtRecord d : records){
            int borrowerAmount = -(d.amount);
            int lenderAmount = d.amount;
            //put borrower
            int borrowNet = map.getOrDefault(d.borrower, 0);
            borrowNet=borrowNet+borrowerAmount;
            map.put(d.borrower, borrowNet);

            //put lender
            int lenderNet = map.getOrDefault(d.lender, 0);
            lenderNet=lenderNet+lenderAmount;
            map.put(d.lender, lenderNet);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq1 = new PriorityQueue<Map.Entry<String, Integer>>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq1.add(entry);
        }

        List<String> res = new LinkedList<>();

        Map.Entry<String, Integer> first = pq1.poll();
        if(first.getValue() >=0){
            res.add("Nobody has a negative balance");
            return res;
        }
        else{
            res.add(first.getKey());
            while(first.getValue() == pq1.peek().getValue()){
                Map.Entry<String, Integer> t = pq1.poll();
                res.add(t.getKey());
            }
        }

        Collections.sort(res);
        return res;




    }
    public static void main(String[] args) {
        List<debtRecord> input  = new LinkedList<>();
        input.add(new debtRecord("Alex", "Blake", 2));
        input.add(new debtRecord("Blake", "Alex", 2));
        input.add(new debtRecord("Casey", "Alex", 5));
        input.add(new debtRecord("Blake", "Casey", 7));
        input.add(new debtRecord("Alex", "Blake", 4));
        input.add(new debtRecord("Alex", "Casey", 4));

        System.out.println(getMostNegative(input));
    }
}
