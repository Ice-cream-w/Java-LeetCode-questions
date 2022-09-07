import java.util.Stack;

/*
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
 */
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        //初始断点0
        stack.push(-1);

        for(int i = 0; i < s.length() ; i++){
            //左括号入栈
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            //右括号出栈
            else{
                stack.pop();
                //出栈后，若栈为空，则把i值放进去，记为新断点；
                //若不为空，将i值与栈顶值（旧断点）相减得到此段有效括号长度
                //每次()后，如果下一个是），则返回此段有效括号长度
                //如果下一个是（，则放入，不会影响返回的值，完美解决()(()的问题
                //()(()，虽然第四个（入栈时，栈非空，但是要重新计数因为断开了
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i- stack.peek());
                }
            }
        }

        return max;
    }
}