import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        ExampleMap map = new ExampleMap();
        Stack<LinkedList<Intersection>> paths = new Stack<LinkedList<Intersection>>();
        LinkedList<Intersection> start = new LinkedList<Intersection>();
        start.add(map.getRestaurant());
        paths.push(start);

        Scanner scan = new Scanner(System.in);
        Object[] allHouses = map.getHouses();
        Intersection target = null; // destination

        // keep going until a valid house is input
        while(target == null) {
            System.out.println("Which house would you like to deliver to?");
            String houseID = scan.nextLine();
            
            for(Object house : allHouses) {
                // find house in list of all houses
                if(((House) house).toString().contains(houseID.trim().toUpperCase())) {
                    target = (Intersection) house;
                }
            }
            if(target == null) {
                System.out.println("That house could not be found. Please try again.");
            }
        }

        LinkedList<LinkedList<Intersection>> validPaths = new LinkedList<LinkedList<Intersection>>();

        while (!paths.empty())
        {
            findAllPaths(paths, target, validPaths);
        }

        System.out.println(validPaths.size() + " paths found.");

        ListAndTime shortestPath = findShortestPath(validPaths, map);

        printList(shortestPath.list);
        System.out.println("Duration of Trip: " + shortestPath.time + " minutes.");

        // TODO: ask if they want to repeat, and then recurse main after closing scanner
        scan.close();
    }

    public static void findAllPaths(Stack<LinkedList<Intersection>> paths, Intersection target, LinkedList<LinkedList<Intersection>> validPaths) {
        if (!paths.empty()) 
        {
        LinkedList<Intersection> currentPath = paths.pop();
        Intersection current = currentPath.peekLast();
            if (current == target)
            {
                // add to list of valid paths
                LinkedList<Intersection> copy = new LinkedList<Intersection>();
                for (Intersection i : currentPath)
                {
                    copy.add(i);
                }
                validPaths.add(copy);
            }
            else
            {
                for (Intersection connected : current.getConnectedIntersections())
                {
                    LinkedList<Intersection> copy = new LinkedList<Intersection>();
                    boolean repeating = false;
                    for (Intersection i : currentPath)
                    {
                        if (!repeating)
                        {
                            if (i == connected)
                            {
                                repeating = true;
                            }
                            else
                            {
                                copy.add(i);
                            }
                        }
                    }
                    if (!repeating)
                    {
                        copy.add(connected);
                        paths.push(copy);
                    } 
                }
            }
        }
        else 
        {
            System.out.println("NO PATHS FOUND AT ALL");
        }
    }

    public static ListAndTime findShortestPath(LinkedList<LinkedList<Intersection>> validPaths, Map map)
    {
        double minTime = Double.MAX_VALUE;
        LinkedList<Intersection> shortest = null;
        for (LinkedList<Intersection> path : validPaths)
        {
            double currentTime = 0;
            for (int i = 0; i < path.size() - 1; i++)
            {
                currentTime += map.getRoad(path.get(i), path.get(i+1)).getTravelDuration();
            }

            if (currentTime < minTime)
            {
                minTime = currentTime;
                shortest = path;
            }
        }
        return new ListAndTime(shortest, minTime);
    }

    public static void printList(LinkedList<Intersection> path)
    {
        for (Intersection i : path)
        {
            System.out.println(i);
        }
    }
}
