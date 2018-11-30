package rpg;

public class Item {
    protected String iName;
    protected int iValue;
    protected float iWeight;

    public Item(String name, int value, float weight) {
        iName = name;
        iValue = value;
        iWeight = weight;
    }

    public Item() {
        super();
    }

    public void Use() {

    }

    public String GetName() {
        return iName;
    }

    public int GetValue() {
        return iValue;
    }

    public float GetWeight() {
        return iWeight;
    }
}