import java.util.ArrayList;
import java.util.Hashtable;

public class Intersection {
    
    private ArrayList<Intersection> connectedIntersections;
    private String name;
    private Hashtable<Integer, Boolean> paths;

    public Intersection(String name)
    {
        connectedIntersections = new ArrayList<Intersection>();
        paths = new Hashtable<Integer, Boolean>();
    }

    public void addIntersection(Intersection i, RoadMap roadMap, String roadName, double distance, double travelDistance)
    {
        connectedIntersections.add(i);
        Road newRoad = new Road(roadName, 0, 5);
        i.connectBackwards(this);
        roadMap.addRoad(this, i, newRoad);
    }

    public Intersection[] getConnectedIntersections()
    {
        Intersection[] intersections = (Intersection[]) connectedIntersections.toArray();
        return intersections;
    }

    public void connectBackwards(Intersection i)
    {
        connectedIntersections.add(i);
    }
    
    public void visit(int path)
    {
        paths.put(path, true);
    }

    public boolean checkVisited(int path)
    {
        return paths.get(path) != null && !paths.get(path);
    }
}
