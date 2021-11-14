public class Road {
    private String name;
    private double distance, travelDuration;

    public Road(String name, double distance, double travelDuration) {
        this.name = name;
        this.distance = distance;
        this.travelDuration = travelDuration;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getTravelDuration() {
        return travelDuration;
    }
}
