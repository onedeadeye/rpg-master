package rpg;

public class Item {
    protected String iName;
    protected int iValue;

    public Item(String name, int value) {
        iName = name;
        iValue = value;
    }

    public Item() {
        super();
    }

    public String getName() {
        return iName;
    }

    public int getValue() {
        return iValue;
    }
}