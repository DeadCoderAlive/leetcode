import java.util.Stack;

/**
 * Created by srinivaz on 2/6/18.
 */
public class ValidParanthesisString {
    public static void main(String args[]){
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("())*"));
        System.out.println(checkValidString("(*()"));
    }

    public static  boolean checkValidString(String s) {
        return check(s,0,0);
    }

    public static boolean check(String s,int start,int count){
        for(int i=start;i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                if(count <= 0) return false;
                count--;
            }
            else {
                return check(s,i+1,count) || check(s,i+1,count-1) || check(s,i+1,count+1);
            }
        }
        return count == 0;
    }
}
