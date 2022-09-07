import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] height = {1,1,-1,-2,-1,-4};
        Solution s = new Solution();
        List s1 = s.threeSum(height);
        for (int i = 0 ; i < s1.size(); i ++){
            int[] array = (int[])s1.get(i);
            for(int j = 0; j < array.length ; j++)
            {
                System.out.print(array[i] + " ");
            }
        }
    }
}
