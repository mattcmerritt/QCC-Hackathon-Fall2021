import java.util.ArrayList;

public class Intersection {
    
    private ArrayList<Intersection> connectedIntersections;

    public Intersection()
    {
        connectedIntersections = new ArrayList<Intersection>();
    }

    public void addIntersection(Intersection i)
    {
        connectedIntersections.add(i);
    }

    public Intersection[] getConnectedIntersections()
    {
        Intersection[] intersections = (Intersection[]) connectedIntersections.toArray();
        return intersections;
    }
}
