import java.util.LinkedList;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        
        ExampleMap map = new ExampleMap();
        Stack<LinkedList<Intersection>> paths = new Stack<LinkedList<Intersection>>();
        LinkedList<Intersection> start = new LinkedList<Intersection>();
        start.add(map.getRestaurant());

        // set a random target
        // TODO: make a house
        Intersection target = map.getIntersections()[(int) (Math.random() * map.getIntersections().length)];

        findShortestPath(paths, target);
    }

    public static void findShortestPath(Stack<LinkedList<Intersection>> paths, Intersection target) {
        LinkedList<Intersection> currentPath = paths.pop();
        Intersection current = currentPath.peekLast();
        if (current != null)
        {
            for (Intersection connected : current.getConnectedIntersections())
            {
                LinkedList<Intersection> copy = new LinkedList<Intersection>();
                for (Intersection i : currentPath)
                {
                    if (i == connected)
                    {
                        // repeating path terminated
                        break;
                    }
                    else
                    {
                        copy.add(i);
                    }
                }
                paths.push(copy);
            }
        }
        else 
        {
            System.out.println("NO PATHS FOUND");
        }
    }
}
