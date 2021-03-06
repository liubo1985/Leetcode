package CC150.PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 4/13/16.
 * 数学规律。
 其实学过数学，知道排列组合，无重复数据的话，n个数，从1到n就有n!种组合。
 那么如果我们知道第一位数字是多少，就能算出后面的(n-1)位数的组合，也就是(n-1)!种组合。
 这个分析很明显了，n可以分成n组，每组有(n-1)!个数，
 比如n = 6，那么以1,2,3,4,5,6开头的组合必然是各有(n-1)! = 5! = 120中组合。
 我们认为组数应该从0开始，那么k要-1;
 注意此时K = 299，那么我们先要求解这个k在第几组，k/(n-1)! = 299/120 = 2,也就是说k应该在第
 3组(注意组号从0开始)，第三组的首个数字应该是3。这样第一个数字就确定了。
 确定第2个数字的时候，注意这个时候，k应该等于k % 120 = 59,为什么要这么算呢，因为每个组有120个数字，
 而且k在第三组，那么前两组加起来是240，k在第二次循环的时候，应该是从(5-1)!中确定是属于哪个组，其实
 就是确定k在第三组中是属于哪个位置。这个时候59/24 = 2,确定应该是属于第三组，
 因为在上一步中，3已经用过了，所以这个时候的5个数字是1,2,4,5,6，
 所以第三组的首个数字是4，依次类推，一直到n个数字全部算完为止。
 答案就出来了。
 */

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> array = new ArrayList<Integer>();
        int sum = 1;
        for(int i = 1; i <= n; i++){
            array.add(i);
            sum *= i;
        }
        //对于第一位（最高位）， 共有（n-1）(n-2)(n-3)(n-4)...1个组合，sum需要除以n
        sum = sum/n;
        //k--是因为array从0开始，查找第i位的数字实际上是i - 1
        k--;
        StringBuilder sb = new StringBuilder();
        int size = array.size();
        for(int i = 0; i < size - 1; i++){
            //
            int group = k/sum;
            sb.append(array.get(group));
            //找到第i位后，要把他从list里去掉，因为每个数字只能用一次
            array.remove(group);
            //更新k和sum
            k %= sum;
            sum /= (n - i - 1);
        }
        //最后一位不用算，因为只有一种选择，直接加到sb里
        sb.append(array.get(0));
        return sb.toString();
    }
}




