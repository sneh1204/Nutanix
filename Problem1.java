import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        if(arr == null) return null;

        ArrayList<Integer> out = new ArrayList<>();

        int curSum = arr.get(0);
        int maxSum = curSum;
        for (int i = 1; i < arr.size(); ++i) {
            int num = arr.get(i);
            curSum = Math.max(num, curSum + num);
            maxSum = Math.max(curSum, maxSum);
        }
        out.add(maxSum);

        maxSum = 0;
        int maxNeg = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num <= 0){
                maxNeg = Math.max(maxNeg, num);
                continue;
            }
            maxSum += num;
        }

        maxSum = (maxSum <= 0) ? maxNeg : maxSum;

        out.add(maxSum);

        return out;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarray(new ArrayList<>(Arrays.asList(2, -1, 2, 3, 4, -5))));
    }

}
