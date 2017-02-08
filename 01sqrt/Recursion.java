public class Recursion{ 
    public static String name(){
	return "Kalmakova,Bermet";
    }
    public static double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}
	return helper(n, 1);
    }
    public static double helper(double n, double guess){
	if (closeEnough(n,guess*guess)){
	    return guess;
	}
	double better = ((n/guess) + guess)/2;
	return helper(n,better);
    }
    public static boolean closeEnough(double a, double b){
	return (a-b)/a < 0.000000000001 && (a-b)/a > -0.000000000001;
    }
    public static void main(String[] args){
	System.out.println(sqrt(900));
    }
}
