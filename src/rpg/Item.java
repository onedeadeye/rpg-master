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

    public String GetName() {
        return iName;
    }

    public int GetValue() {
        return iValue;
    }
}