public class FrontierStack implements Frontier{
    private Stack<Location> locations;
    public void add(Location l){
	locations.push(l);
    }
    public Location next(){
	return locations.pop();
    }
}
