package rpg.renderengine;

public class Engine {

    World eWorld = new World();

    private int eXBorder = 0;
    private int eYBorder = 0;

    public void RenderNoBorders() {
        String renderBuffer = "";
        Character[][] cachedGeometry = eWorld.GetGeometry();

        for (int x = 0; x < eWorld.GetWidth(); x++) {
            for (int y = 0; y < eWorld.GetHeight(); y++) {
                renderBuffer += cachedGeometry[x][y];
            }
            System.out.println(renderBuffer);
            renderBuffer = "";
        }
    }

    public void RenderWithWindow() {
        String renderBuffer = "";
        Character[][] cachedGeometry = eWorld.GetGeometry();

        for (int x = eXBorder; x < eWorld.GetWidth(); x++) {
            for (int y = eYBorder; y < eWorld.GetHeight(); y++) {
                renderBuffer += cachedGeometry[x][y];
            }
            System.out.println(renderBuffer);
            renderBuffer = "";
        }
    }

    public void SetWindow(int xBorder, int yBorder) {
        eXBorder = xBorder;
        eYBorder = yBorder;
    }
}