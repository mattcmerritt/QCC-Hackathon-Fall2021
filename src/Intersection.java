import java.util.ArrayList;
import java.util.Hashtable;

public class Intersection {
    
    private ArrayList<Intersection> connectedIntersections;
    private Hashtable<Integer, Boolean> paths;

    public Intersection()
    {
        connectedIntersections = new ArrayList<Intersection>();
        paths = new Hashtable<Integer, Boolean>();
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

    public void visit(int path)
    {
        paths.put(path, true);
    }

    public boolean checkVisited(int path)
    {
        return paths.get(path) != null && !paths.get(path);
    }
}
