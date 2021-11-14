public interface Map {
    public Intersection[] getIntersections();
    public Intersection getRestaurant();
    public Road getRoad(Intersection start, Intersection end);
}
