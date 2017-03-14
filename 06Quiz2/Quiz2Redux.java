import java.util.ArrayList;
public class Quiz2Redux{
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	combinationH(s,words,0,"");
	return words;
    }
    public static void combinationH(String s, ArrayList<String> words,int index, String temp ){
	if (index == s.length()){
	    words.add(temp);
	    return;
	}
	combinationH(s,words,index+1,temp);
	combinationH(s,words,index+1,temp + s.charAt(index));

    }
}
