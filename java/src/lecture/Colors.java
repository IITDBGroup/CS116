package lecture;

public class Colors {
    
    public static final Colors red = new Colors("red");
    public static final Colors green = new Colors("green");
    public static final Colors blue = new Colors("blue");
    private static final Colors[] values = { red, green, blue };
    
    private String name;
    
    private Colors(String name) {
        this.name = name;
    }
    
    public static Colors getColor(String name) {
        for(int i = 0; i < values.length; i++)
            if (values[i].name.equals(name))
                return values[i];
        return null;
    }
}