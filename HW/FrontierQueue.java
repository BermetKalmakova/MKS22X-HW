public class FrontierQueue implements Frontier{
    private Queue<Location> locations;
    public void add(Location l){
	locations.add(l);
    }
    public Location next(){
	return locations.remove();
    }
}
