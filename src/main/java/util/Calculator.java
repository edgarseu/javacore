package util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

/**
 * @author caozy
 * @create 2018/7/11
 */
public class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public static String cal01(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return String.valueOf(res);
    }

    public static Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }
}
