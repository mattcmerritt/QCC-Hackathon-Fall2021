public class RoadKey {
    private Intersection start, end;

    public RoadKey(Intersection start, Intersection end) {
        this.start = start;
        this.end = end;
    }

    // override equals to make road keys work from either side
    public boolean equals(RoadKey newRK) {
        return (start.equals(newRK.getStart()) && end.equals(newRK.getEnd())) ||
            (start.equals(newRK.getEnd()) && end.equals(newRK.getStart()));
    }

    public Intersection getStart() {
        return start;
    }

    public Intersection getEnd() {
        return end;
    }
}
