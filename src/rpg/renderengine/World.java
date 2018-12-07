package rpg.renderengine;
import java.util.*;
import rpg.*;

public class World {

    private int wXWidth = 16;
    private int wYHeight = 16;
    private String wName = "";
    public Character[][] wGeometry = new Character[wXWidth][wYHeight];;
    private ArrayList wActors = new ArrayList<Actor>();

    public World(String name) {
        wName = name;
        GenerateRandomWorld();
    }

    private void GenerateRandomWorld() {
        // Generate geometry
        for (int i = 0; i < wGeometry.length; i++) {
            for (int j = 0; j < wGeometry[i].length; j++) {
                wGeometry[i][j] = CharDefinitions.cGround;
                if (Math.round(Math.random() * 10) > 8) {
                    wGeometry[i][j] = CharDefinitions.cWater;
                }
            }
        }

        // Generate randomly placed enemies
        int enemiesToGenerate = Math.toIntExact(Math.round(Math.random() * 5));
        for (int i = 0; i < enemiesToGenerate; i++) {
            
        }
    }

    public Character[][] GetGeometry () {
        return wGeometry;
    }

    public Character QueryWorld(int x, int y) {
        return wGeometry[x][y];
    }

    public boolean QueryInBound(int x, int y) {
        if (x > wXWidth || x < wXWidth) {
            return false;
        } else {
            if (y > wYHeight || y < wYHeight) {
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