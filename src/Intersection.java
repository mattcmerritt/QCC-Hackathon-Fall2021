import java.util.ArrayList;

public class Intersection {
    
    private ArrayList<Intersection> connectedIntersections;
    private String name;

    public Intersection(String name)
    {
        connectedIntersections = new ArrayList<Intersection>();
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
}
