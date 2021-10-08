import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2 {

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        if(x == null || x.size() <= 0)  return 0;
        if(x.size() == 1) return 1;

        Collections.sort(x);

        int cur = k, req = 0, left = -1;
        for (int i = 0; i < x.size() - 1; i++) {
            int diff = x.get(i + 1) - x.get(i);
            if(left < 0) {
                if (diff > cur) {
                    ++req;
                    cur = k;
                    left = k - diff;
                }else cur -= diff;
            }else left -= diff;
        }

        if(left < 0)   ++req;

        return req;
    }

    public static void main(String[] args) {
        System.out.println(hackerlandRadioTransmitters(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 1)); // 2
        System.out.println(hackerlandRadioTransmitters(new ArrayList<>(Arrays.asList(7, 2, 4, 6, 5, 9, 12, 11)), 2)); // 3
        System.out.println(hackerlandRadioTransmitters(new ArrayList<>(Arrays.asList(9, 5, 4, 2, 6, 15, 12)), 2)); // 4
    }

}
