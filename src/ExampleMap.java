import java.util.ArrayList;

public class ExampleMap {
    
    private ArrayList<Intersection> intersections = new ArrayList<Intersection>();
    private RoadMap roadMap = new RoadMap();

    public ExampleMap(){
        Intersection intersectionR = new Intersection();
        Intersection intersectionA = new Intersection();
        Intersection intersectionB = new Intersection();
        Intersection intersectionC = new Intersection();
        Intersection intersectionD = new Intersection();
        Intersection intersectionE = new Intersection();
        Intersection intersectionF = new Intersection();
        Intersection intersectionG = new Intersection();

        // Intersection R Connected
        intersectionR.addIntersection(intersectionA);
        intersectionR.addIntersection(intersectionB);
        intersectionR.addIntersection(intersectionG);

        // Intersection A
        intersectionA.addIntersection(intersectionR);
        intersectionA.addIntersection(intersectionB);
        intersectionA.addIntersection(intersectionC);
        intersectionA.addIntersection(intersectionD);
        intersectionA.addIntersection(intersectionE);

        // Intersection B
        intersectionB.addIntersection(intersectionA);
        intersectionB.addIntersection(intersectionC);
        intersectionB.addIntersection(intersectionR);
        intersectionB.addIntersection(intersectionG);

        // Intersection C
        intersectionC.addIntersection(intersectionA);
        intersectionC.addIntersection(intersectionB);
        intersectionC.addIntersection(intersectionD);

        // Intersection D
        intersectionC.addIntersection(intersectionA);
        intersectionC.addIntersection(intersectionC);

        // Intersection E
        intersectionE.addIntersection(intersectionA);
        intersectionE.addIntersection(intersectionF);
        intersectionE.addIntersection(intersectionG);

        // Intersection F
        intersectionF.addIntersection(intersectionE);
        intersectionF.addIntersection(intersectionG);

        // Intersection G
        intersectionG.addIntersection(intersectionF);
        intersectionG.addIntersection(intersectionE);
        intersectionG.addIntersection(intersectionR);
        intersectionG.addIntersection(intersectionB);

        Road ra = new Road("ra", 0, 5);
        Road rb = new Road("rb", 0, 5);
        Road rg = new Road("rg", 0, 5);
        Road ab = new Road("ab", 0, 5);
        Road ac = new Road("ac", 0, 5);
        Road bg = new Road("bg", 0, 5);
        Road cb = new Road("cb", 0, 5);
        Road dc = new Road("dc", 0, 5);
        Road da = new Road("da", 0, 5);
        Road ae = new Road("ae", 0, 5);
        Road ef = new Road("ef", 0, 5);
        Road eg = new Road("eg", 0, 5);
        Road fg = new Road("fg", 0, 5);

        roadMap.addRoad(intersectionR, intersectionA, ra);
        roadMap.addRoad(intersectionR, intersectionB, rb);
        roadMap.addRoad(intersectionR, intersectionG, rg);
        roadMap.addRoad(intersectionA, intersectionB, ab);
        roadMap.addRoad(intersectionA, intersectionC, ac);
        roadMap.addRoad(intersectionB, intersectionG, bg);
        roadMap.addRoad(intersectionC, intersectionB, cb);
        roadMap.addRoad(intersectionD, intersectionC, dc);
        roadMap.addRoad(intersectionD, intersectionA, da);
        roadMap.addRoad(intersectionA, intersectionE, ae);
        roadMap.addRoad(intersectionE, intersectionF, ef);
        roadMap.addRoad(intersectionE, intersectionG, eg);
        roadMap.addRoad(intersectionF, intersectionG, fg);
    }



}
