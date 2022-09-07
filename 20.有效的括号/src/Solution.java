/*
给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

输入：s = "()[]{}"
输出：true

输入：s = "([)]"
输出：false
 */
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //创建栈，存储括号
        Stack<Character> stack = new Stack<>();

        for (Character c:s.toCharArray()){
            //空栈直接放入该元素，因为不能判断
            if (stack.isEmpty())
                stack.push(c);
            //不是空栈，代表里面有元素，判断栈顶是否与i元素相对
            else switch (c){
                case '}': {
                    if ('{' == stack.peek()){
                        stack.pop();
                        continue;
                    }
                    else return false;
                }
                case ']': {
                    if ('[' == stack.peek()){
                        stack.pop();
                        continue;
                    }
                    else return false;
                }
                case ')': {
                    if ('(' == stack.peek()){
                        stack.pop();
                        continue;
                    }
                    else return false;
                }
                default:stack.push(c);
            }
        }

        //判断是否为空栈，如果是对的，则进去的左括号，判断时都会出去
        return stack.isEmpty();
    }
}