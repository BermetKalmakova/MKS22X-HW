import java.util.*;
public class eval{
    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack values = new Stack();
	for(String token:tokens){
	    if(isOp(token)){
		values.push(apply(token,Double.parseDouble(values.pop()),Double.parseDouble(values.pop())));
	    }
	    else{
		values.push(token);
	    }
	}
	return Double.parseDouble(values.pop());
    }
    public static boolean isOp(String x){
	return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("%");
    }
    public static double apply(String op, double b, double a){
	if(op.equals("+")){
	    return a + b;
	}
	if(op.equals("-")){
	    return a - b;
	}
	if(op.equals("*")){
	    return a * b;
	}
	if(op.equals("/")){
	    return a / b;
	}
	if(op.equals("%")){
	    return a % b;
	}
    }
    public static void main(String[] args){
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
