package rpg;

public class Class {

    private String cName;
    private float cLevelSpeed;

    public Class(String name, float levelSpeed) {
        cName = name;
        cLevelSpeed = levelSpeed;
    }

    public String GetName() {
        return cName;
    }

    public float GetLevelSpeed() {
        return cLevelSpeed;
    }
}