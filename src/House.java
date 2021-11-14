public class House extends Intersection{
    
    public House(String name)
    {
        super(name);
    }

    @Override
    public String toString()
    {
        return "House: " + getName();
    }
}
