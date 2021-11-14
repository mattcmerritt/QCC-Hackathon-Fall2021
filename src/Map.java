public interface Map {
    public Object[] getIntersections();
    public Intersection getRestaurant();
    public Road getRoad(Intersection start, Intersection end);
}
