import java.util.ArrayList;

public class ExampleMap implements Map {
    
    private ArrayList<Intersection> intersections = new ArrayList<Intersection>();
    private RoadMap roadMap = new RoadMap();
    private Intersection restaurant;

    public Intersection[] getIntersections() {
        Intersection[] result = (Intersection[]) intersections.toArray();
        return result;
    }

    public Intersection getRestaurant() {
        return restaurant;
    }

    public Road getRoad(Intersection start, Intersection end) {
        return roadMap.fetchRoad(start, end);
    }

    public ExampleMap(){
        Intersection intersectionR = new Intersection("R");
        Intersection intersectionA = new Intersection("A");
        Intersection intersectionB = new Intersection("B");
        Intersection intersectionC = new Intersection("C");
        Intersection intersectionD = new Intersection("D");
        Intersection intersectionE = new Intersection("E");
        Intersection intersectionF = new Intersection("F");
        Intersection intersectionG = new Intersection("G");
        House houseAB = new House("AB");
        House houseBC = new House("BC");
        House houseCD = new House("CD");
        House houseAE = new House("AE");
        House houseEG = new House("EG");
        House houseBG = new House("BG");

        // Intersection R 
        intersectionR.addIntersection(intersectionA, roadMap, "ra", 0, 5);
        intersectionR.addIntersection(intersectionB, roadMap, "rb", 0, 5);
        intersectionR.addIntersection(intersectionG, roadMap, "rg", 0, 5);

        // Intersection A

        intersectionA.addIntersection(houseAB, roadMap, "ab", 0, 5);
        houseAB.addIntersection(intersectionB, roadMap, "ab", 0, 5);
        intersectionA.addIntersection(intersectionC, roadMap, "ac", 0, 5);
        intersectionA.addIntersection(intersectionD, roadMap, "ad", 0, 5);
        intersectionA.addIntersection(houseAE, roadMap, "ae", 0, 5);
        houseAE.addIntersection(intersectionE, roadMap, "ae", 0, 5);

        // Intersection B

        intersectionB.addIntersection(houseBC, roadMap, "bc", 0, 5);
        houseBC.addIntersection(intersectionC, roadMap, "bc", 0, 5);
        intersectionB.addIntersection(houseBG, roadMap, "bg", 0, 5);
        houseBG.addIntersection(intersectionG, roadMap, "bg", 0, 5);

        // Intersection C

        intersectionC.addIntersection(houseCD, roadMap, "cd", 0, 5);
        houseCD.addIntersection(intersectionD, roadMap, "cd", 0, 5);

        // Intersection D

        // Intersection E

        intersectionE.addIntersection(intersectionF, roadMap, "ef", 0, 5);
        intersectionE.addIntersection(houseEG, roadMap, "eg", 0, 5);
        houseEG.addIntersection(intersectionG, roadMap, "eg", 0, 5);

        // Intersection F

        intersectionF.addIntersection(intersectionG, roadMap, "fg", 0, 5);

        // Intersection G

    }



}
