/*
1、读取连续整数
输入：包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
输出：a+b的结果。
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }
}

/*
2、读取有限整数
输入：第一行包括一个数据组数t(1 <= t <= 100)，接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
输出：a+b的结果
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        while(n-->0){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }
}

/*
3、每行读取空格隔开的整数
输入：输入数据有多组, 每行表示一组输入数据。每行不定有n个整数，空格隔开。(1 <= n <= 100)。
输出：每组数据输出求和的结果
 */
import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String[] temp=in.nextLine().split(" ");
            int sum=0;
            for(String s:temp)
                sum+=Integer.valueOf(s);
            System.out.println(sum);
        }
    }
}

/*
易错点
nextInt()或者next()读取完毕并回车之后其后紧跟nextLine()，就会导致nextLine()读取到空值，
因为nextLine()自动读取到'\n'，意味着遇到结束符；
有时候将字符串转为整数时，代码没问题却提示数组越界，往往是因为字符串代表的整数超过了int的最值，需要改用long。
 */