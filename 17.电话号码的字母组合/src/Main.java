import java.util.List;

public class Main {
    public static void main(String[] args) {
        String digits = "7";
        Soul s = new Soul();
        List s1 = s.letterCombinations(digits);
        for (int i = 0 ; i < s1.size(); i ++){
            System.out.print(s1.get(i) + " ");

        }
    }
}
