package rpg.renderengine;
import java.util.*;

public class World {

    private int wXWidth = 16;
    private int wYHeight = 16;
    private String wName = "";
    public Character[][] wGeometry = new Character[wXWidth][wYHeight];

    public World(String name) {
        wName = name;
        GenerateWorld();
    }

    private void GenerateWorld() {
        for (int i = 0; i < wGeometry.length; i++) {
            for (int j = 0; j < wGeometry[i].length; j++) {
                wGeometry[i][j] = CharDefinitions.cGround;
                if (Math.round(Math.random() * 10) > 8) {
                    wGeometry[i][j] = CharDefinitions.cWater;
                }
            }
        }
    }

    public Character[][] GetGeometry () {
        return wGeometry;
    }

    public Character QueryWorld(int x, int y) {
        return wGeometry[x][y];
    }

    public boolean QueryInBound(int x, int y) {
        if (x - 1 > wXWidth) {
            return false;
        } else {
            if (y - 1 > wYHeight) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int GetWidth() {
        return wXWidth;
    }

    public int GetHeight() {
        return wYHeight;
    }

    public String GetName() {
        return wName;
    }

}