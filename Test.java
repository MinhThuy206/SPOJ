import java.util.Stack;

public class Test{
    public static void main(String[] args) {
        String str = "(())";
        System.out.println(isValidExpr(str));
    }
    public static boolean isValidExpr(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c =='('){
                stack.push(c);
            }else if(c ==')'){
                if(!stack.isEmpty())
                    stack.pop();
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
