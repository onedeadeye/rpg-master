package rpg.renderengine;
import java.util.*;

public class World {

    private int wXWidth = 256;
    private int wYHeight = 256;
    public Character[][] wGeometry = new Character[wXWidth][wYHeight];

    public World() {
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

    public int GetWidth() {
        return wXWidth;
    }

    public int GetHeight() {
        return wYHeight;
    }

}