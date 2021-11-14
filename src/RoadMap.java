import java.util.Hashtable;

public class RoadMap {
    private Hashtable<RoadKey, Road> RoadDictionary = new Hashtable<RoadKey, Road>();
    
    public Road fetchRoad(Intersection start, Intersection end) {
        return RoadDictionary.get(new RoadKey(start, end));
    }

    public void addRoad(Intersection start, Intersection end, Road road) {
        RoadDictionary.put(new RoadKey(start, end), road);
    }
}
