public class RoadKey {
    private final Intersection start, end;

    public RoadKey(Intersection start, Intersection end) {
        this.start = start;
        this.end = end;
    }

    // override equals to make road keys work from either side
    @Override
    public boolean equals(Object obj) {
        RoadKey newRK = (RoadKey) obj;
        return (start.equals(newRK.getStart()) && end.equals(newRK.getEnd())) ||
            (start.equals(newRK.getEnd()) && end.equals(newRK.getStart()));
    }

    public Intersection getStart() {
        return start;
    }

    public Intersection getEnd() {
        return end;
    }

    // override hashing function
    @Override
    public int hashCode() {
        return start.hashCode() * end.hashCode();
    }
}
