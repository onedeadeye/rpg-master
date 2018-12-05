package rpg.renderengine;
import rpg.*;

public class Engine {

    private World eWorld;

    private int eXBorder = 0;
    private int eYBorder = 0;
    private Player ePlayer;

    public Engine(Player player, World world) {
        ePlayer = player;
        eWorld = world;
    }

    public void RenderNoBorders() {
        String renderBuffer = "";
        Character[][] cachedGeometry = eWorld.GetGeometry();

        for (int x = 0; x < eWorld.GetWidth(); x++) {
            for (int y = 0; y < eWorld.GetHeight(); y++) {
                if (x == ePlayer.GetXPos() && y == ePlayer.GetYPos()) {
                    renderBuffer += CharDefinitions.cPCharacterChar;
                    renderBuffer += CharDefinitions.cSpaceChar;
                } else {
                    renderBuffer += cachedGeometry[x][y];
                    renderBuffer += CharDefinitions.cSpaceChar;
                }
            }
            System.out.println(renderBuffer);
            renderBuffer = "";
        }
        RenderStatusBar();
    }

    //TODO: RenderWithWindow is currently not being worked on. FInish RenderNoBorders first.
    public void RenderWithWindow(int xPos, int yPos) {
        String renderBuffer = "";
        Character[][] cachedGeometry = eWorld.GetGeometry();

        for (int x = eXBorder + xPos; x < eWorld.GetWidth(); x++) {
            for (int y = eYBorder + yPos; y < eWorld.GetHeight(); y++) {
                renderBuffer += cachedGeometry[x][y];
                renderBuffer += CharDefinitions.cSpaceChar;
            }
            System.out.println(renderBuffer);
            renderBuffer = "";
        }
    }

    public void SetWindow(int xBorder, int yBorder) {
        eXBorder = xBorder;
        eYBorder = yBorder;
    }

    public void RenderStatusBar() {
        String bar = "";

        for (int x = 0; x < eWorld.GetWidth(); x++) {
            bar += "--";
        }
        System.out.println(bar);
        System.out.println("you are in " + eWorld.GetName());
        System.out.println(bar);
    }
}