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

    public void renderNoBorders() {
        String renderBuffer = "";
        Character[][] cachedGeometry = eWorld.getGeometry();
        Actor[][] cachedActors = eWorld.getActors();

        for (int x = 0; x < eWorld.getWidth(); x++) {
            for (int y = 0; y < eWorld.getHeight(); y++) {
                if (x == ePlayer.getXPos() && y == ePlayer.getYPos()) {
                    renderBuffer += CharDefinitions.cPCharacterChar;
                    renderBuffer += CharDefinitions.cSpaceChar;
                } else {
                    if (cachedActors[x][y] != null) {
                        renderBuffer += CharDefinitions.cEnemyChar;
                        renderBuffer += CharDefinitions.cSpaceChar;
                    } else {
                        renderBuffer += cachedGeometry[x][y];
                        renderBuffer += CharDefinitions.cSpaceChar;
                    }
                }
            }
            System.out.println(renderBuffer);
            renderBuffer = "";
        }
        renderStatusBar();
    }

    //TODO: RenderWithWindow is currently not being worked on. FInish RenderNoBorders first.
    public void renderWithWindow(int xPos, int yPos) {
        String renderBuffer = "";
        Character[][] cachedGeometry = eWorld.getGeometry();

        for (int x = eXBorder + xPos; x < eWorld.getWidth(); x++) {
            for (int y = eYBorder + yPos; y < eWorld.getHeight(); y++) {
                renderBuffer += cachedGeometry[x][y];
                renderBuffer += CharDefinitions.cSpaceChar;
            }
            System.out.println(renderBuffer);
            renderBuffer = "";
        }
    }

    public void setWindow(int xBorder, int yBorder) {
        eXBorder = xBorder;
        eYBorder = yBorder;
    }

    public void renderStatusBar() {
        String bar = "";

        for (int x = 0; x < eWorld.getWidth(); x++) {
            bar += "--";
        }

        bar = bar.substring(0, bar.length() - 1);
        Game.say(bar);
        Game.say("you are in " + eWorld.getName());
        Game.say(bar);
    }
}