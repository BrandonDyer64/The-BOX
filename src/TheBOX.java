package the.box;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class TheBOX {
    public static String title = "The BOX";

    public static String release = "beta";

    public static int[] version = new int[] { 0, 3, 2 };

    public static int startingLevel = 0;

    public static void main(String[] args) {
        JFrame f = new JFrame(title + " " + release + " v" + version[0] + '.' + version[1] + '.' + version[2]);
        f.setDefaultCloseOperation(3);
        JPhysics ph = new JPhysics();
        int[] cloudid = { ph.createInstance("obj_cloud", 0, 0, 30, 30, JPhysics.TYPE_GHOST),
                ph.createInstance("obj_cloud", 0, 0, 30, 30, JPhysics.TYPE_GHOST),
                ph.createInstance("obj_cloud", 0, 0, 30, 30, JPhysics.TYPE_GHOST),
                ph.createInstance("obj_cloud", 0, 0, 30, 30, JPhysics.TYPE_GHOST),
                ph.createInstance("obj_cloud", 0, 0, 30, 30, JPhysics.TYPE_GHOST) };
        for (int i = 0; i < cloudid.length; i++) {
            ph.setColorID(Color.WHITE, cloudid[i]);
            ph.setY(ph.getRandom(150), cloudid[i]);
            ph.setX(ph.getRandom(500), cloudid[i]);
            ph.setWidth(ph.getRandom(20, 30), cloudid[i]);
            ph.setHeight(ph.getRandom(10, 20), cloudid[i]);
        }
        Point textP = new Point();
        textP.x = 214;
        textP.y = 384;
        ph.setStringLocation(textP);
        ph.setStringLevel("Easy?", 0);
        ph.setLevel(startingLevel);
        int Level = startingLevel;
        int mouseid = ph.createInstance("obj_mouse", 0, 0, 30, 30, JPhysics.TYPE_STATIC);
        ph.setColorID(Color.BLUE, mouseid);
        ph.createInstance("obj_wall", 0, 0, 500, 10, JPhysics.TYPE_STATIC);
        ph.createInstance("obj_wall", 0, 260, 500, 10, JPhysics.TYPE_STATIC);
        ph.createInstance("obj_wall", 0, 10, 10, 250, JPhysics.TYPE_STATIC);
        ph.createInstance("obj_wall", 490, 10, 10, 250, JPhysics.TYPE_STATIC);
        ph.createInstance("obj_wall", 110, 270, 390, 20, JPhysics.TYPE_STATIC);
        Maps map = new Maps();
        map.generateMap();
        int j;
        for (j = 0; j <= 6; j++) {
            for (int k = 0; k <= 9; k++)
                ph.createInstance("obj_wall", k * 11, 271 + j * 11, 10, 10, JPhysics.TYPE_GHOST, j * 10 + k);
        }
        for (j = 0; j <= 6; j++) {
            for (int k = 0; k <= 9; k++)
                ph.createInstance("obj_spike", k * 11 + 1, 271 + j * 11 + 1, 8, 8, JPhysics.TYPE_GHOST, j * 10 + k);
        }
        BufferedImage cursorImg = new BufferedImage(16, 16, 2);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        f.getContentPane().setCursor(blankCursor);
        ph.setColorName(Color.red, "obj_spike");
        int goal = ph.createInstance("obj_goal", 470, 10, 20, 20, JPhysics.TYPE_STATIC);
        ph.setColorID(Color.MAGENTA, goal);
        int Player = ph.createInstance("obj_player", 11, 11, 8, 8, JPhysics.TYPE_DYNAMIC);
        ph.setColorID(Color.GREEN, Player);
        ph.setDeactivateAll();
        ph.setActivateName("obj_wall");
        ph.setActivateName("obj_cloud");
        ph.setActivateName("obj_player");
        ph.setLocation(11, 11, Player);
        ph.setActivateName("obj_mouse");
        ph.setActivateName("obj_goal");
        ph.setActiveArch(true, Level);
        int lives = 3;
        ph.moveInstanceAll(100, 100);
        Color wall_color = ph.getRGBColor(83, 43, 0);
        Color player_color = ph.getRGBColor(50, 200, 0);
        ph.setColorName(wall_color, "obj_wall");
        ph.setColorName(wall_color, "obj_level");
        ph.setColorName(player_color, "obj_player");
        while (true) {
            JPhysics phd = new JPhysics();
            f.setDefaultCloseOperation(3);
            phd.setBackground(Color.CYAN);
            f.setSize(700, 520);
            for (int k = 0; k < cloudid.length; k++) {
                phd.setColorID(Color.WHITE, cloudid[k]);
                phd.setLocation(phd.getX(cloudid[k]) - 1, phd.getY(cloudid[k]), cloudid[k]);
                if (phd.getX(cloudid[k]) <= -100) {
                    phd.setY(phd.getRandom(250), cloudid[k]);
                    phd.setX(700 + phd.getRandom(200), cloudid[k]);
                    phd.setWidth(phd.getRandom(20, 50), cloudid[k]);
                    phd.setHeight(phd.getRandom(10, 20), cloudid[k]);
                }
            }
            phd.setPrevious();
            Point Mouse = new Point();
            phd.getLocationMouse(f).x -= phd.getWidth(mouseid) / 2;
            phd.getLocationMouse(f).y -= phd.getHeight(mouseid) / 2;
            phd.setLocation(Mouse, mouseid);
            phd.animateAll(false);
            if (phd.checkCollided(Player, goal)) {
                Level++;
                phd.setDeactivateAll();
                phd.setActivateName("obj_wall");
                ph.setActivateName("obj_cloud");
                phd.setActivateName("obj_player");
                phd.setLocation(11, 11, Player);
                phd.moveInstance(100, 100, Player);
                phd.setActivateName("obj_mouse");
                phd.setActivateName("obj_goal");
                phd.setActiveArch(true, Level);
                ph.setLevel(Level);
                lives = 3;
            }
            if (phd.checkCollided(Player, "obj_spike")) {
                phd.setLocation(11, 11, Player);
                phd.moveInstance(100, 100, Player);
                phd.overrideCollided(Player, "obj_spike", false);
            }
            if (lives <= 0) {
                Level--;
                phd.setDeactivateAll();
                phd.setActivateName("obj_wall");
                ph.setActivateName("obj_cloud");
                phd.setActivateName("obj_player");
                phd.setLocation(11, 11, Player);
                phd.setActivateName("obj_mouse");
                phd.setActivateName("obj_goal");
                phd.setActiveArch(true, Level);
                lives = 3;
            }
            f.add(phd);
            f.setVisible(true);
            phd.delay(15);
        }
    }
}
