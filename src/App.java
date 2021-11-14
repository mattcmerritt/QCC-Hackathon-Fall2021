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
        Intersection target = (Intersection) map.getIntersections()[(int) (Math.random() * map.getIntersections().length)];
        System.out.println(target);

        LinkedList<Intersection> validPaths = new LinkedList<Intersection>();

        findShortestPath(paths, target, validPaths);

        System.out.println(validPaths);
    }

    public static void findShortestPath(Stack<LinkedList<Intersection>> paths, Intersection target, LinkedList<Intersection> validPaths) {
        LinkedList<Intersection> currentPath = paths.pop();
        Intersection current = currentPath.peekLast();
        if (current != null)
        {
            if (current == target)
            {
                // add to list of valid paths
            }
            else
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
        }
        else 
        {
            System.out.println("NO PATHS FOUND");
        }
    }
}
