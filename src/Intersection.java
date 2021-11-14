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
        this.name = name;
    }

    public void addIntersection(Intersection i, RoadMap roadMap, String roadName, double distance, double travelDistance)
    {
        connectedIntersections.add(i);
        Road newRoad = new Road(roadName, 0, travelDistance);
        i.connectBackwards(this);
        roadMap.addRoad(this, i, newRoad);
    }

    public Intersection[] getConnectedIntersections()
    {
        Object[] intersectionsObj = connectedIntersections.toArray();
        Intersection[] intersections = new Intersection[intersectionsObj.length];
        for (int i = 0; i < intersectionsObj.length; i++)
        {
            intersections[i] = (Intersection) intersectionsObj[i];
        }
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

    @Override
    public String toString()
    {
        return "Intersection: " + name;
    }

    public String getName()
    {
        return name;
    }
}
