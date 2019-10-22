import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RejectedCreditCard {
    class Tender {
        int id;
        int mount;
        Tender(int id, int mount){
            this.id = id;
            this.mount = mount;
        }
    }

    public List<List<Integer>> findRejectCreditCard (int[] creditcards, int numberOfRejectedCard, int mountOfRejected) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (numberOfRejectedCard == 0 || mountOfRejected == 0){
            return res;
        }
        Tender[] tenders = new Tender[creditcards.length];
        for (int i = 0; i < creditcards.length; i++){
            tenders[i] = new Tender(i, creditcards[i]);
        }
        Arrays.sort(tenders, new Comparator<Tender>(){
            public int compare(Tender a, Tender b){
                return a.mount - b.mount;
            }
        });

        helper(tenders, numberOfRejectedCard, mountOfRejected, list, res, 0);
        return res;
    }

    public void helper (Tender[] creditcards, int numOfRejectedCard, int mountOfRejected, List<Integer> list, List<List<Integer>> res, int pos){
        if (numOfRejectedCard == 0 && mountOfRejected == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i < creditcards.length; i++) {
            if (creditcards[i].mount > mountOfRejected){
                continue;
            }
            list.add(creditcards[i].mount);
            helper(creditcards, numOfRejectedCard - 1, mountOfRejected - creditcards[i].mount, list, res, i + 1);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        RejectedCreditCard sol = new RejectedCreditCard();
        // {1, $18}, {2, $14}, {3, $21}, {4, $10}, {5, $32}
        int[] creditcards = new int[]{17, 14, 4, 21, 10, 32, 18, 32};
        List<List<Integer>> res = sol.findRejectCreditCard(creditcards, 3, 50);
        for (List<Integer> list : res){
            for (Integer ele : list){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
