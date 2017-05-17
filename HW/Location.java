public class Location implements Comparable<Location>{
    private int row,col,distToGoal,distToStart;
    private Location previous;
    private boolean aStar;
    
    public Location(int r,int c,Location previous,int distToStart,int distToGoal,boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	aStar = aStar;
    }
    public int getdts(){
	return distToStart;
    }
    public int getdtg(){
	return distToGoal;
    }
    public int CompareTo(Location other){
	if(aStar){
	    return (distToStart + distToGoal) - (other.getdts + other.getdtg);
	}
        return distToGoal - other.dtg;
    }
}
