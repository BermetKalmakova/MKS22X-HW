import java.util.Random;
public class HW{
    public static int part(int[] data, int start, int end){
	int[] temp = new int[data.length];
	for (int i = 0; i < data.length; i++){
	    if(i < start || i > end){
		temp[i] = data[i];
	    }
	}
	Random rand = new Random();
	int x = rand.nextInt(end-start+1) + start;
	int temps = start;
	int tempe = end;
	for (int i = start;i < end + 1; i++){
	    if(i != x){
		if(data[i] < data[x]){
		    temp[temps] = data[i];
		    temps++;
		}
		else{
		    temp[tempe] = data[i];
		    tempe--;
		}
	    }
	}
	temp[temps] = data[x];
	for(int i = 0; i < temp.length; i++){
	    data[i] = temp[i];
	}
	return temps;
    }
    // public static void main(String[]args){
    // 	int[] ex = {0, 7, 6, 9, 2, 1, 5};
    // 	System.out.println(part(ex,0,3));
    // 	for(int i = 0; i < ex.length; i++){
    // 	    System.out.println(ex[i]);
    // 	}
    // }
}
