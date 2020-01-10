package the.box;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPhysics extends JPanel {
    public static int TYPE_STATIC = 0;

    public static int TYPE_DYNAMIC = 1;

    public static int TYPE_RIGID = 2;

    public static int TYPE_GHOST = 3;

    public static int TYPE_FLUID = 4;

    public static double GRAVITY = 0.5D;

    public static double FRICTION = 0.01D;

    public static int MOUSEX = 0;

    public static int MOUSEY = 0;

    private static String[] NAME = new String[10000];

    private static int[] ArchNum = new int[10000];

    private static int[] X = new int[10000];

    private static int[] Y = new int[10000];

    private static int[] TYPE = new int[10000];

    private static int[] WIDTH = new int[10000];

    private static int[] HEIGHT = new int[10000];

    private static double[] VSPEED = new double[10000];

    private static double[] HSPEED = new double[10000];

    private static Color[] COLOR = new Color[10000];

    private static int[] DYNAMIC = new int[10000];

    private static int[] xPrevious = new int[10000];

    private static int[] yPrevious = new int[10000];

    private static boolean[] ACTIVE = new boolean[10000];

    private static boolean[][] COLLIDED = new boolean[10000][10000];

    private static int dynamics = 0;

    private static int instances = 0;

    private static String[] text = new String[500];

    private static Point textP = new Point();

    private static int textL = 0;

    public void setStringLevel(String string, int level) {
        text[level] = string;
    }

    public void setStringLocation(Point point) {
        textP = point;
    }

    public void setLevel(int level) {
        textL = level;
    }

    public int createInstance(String name, int x, int y, int width, int height, int type) {
        int id = ++instances;
        NAME[id] = name;
        ArchNum[id] = -1;
        X[id] = x;
        Y[id] = y;
        WIDTH[id] = width;
        HEIGHT[id] = height;
        TYPE[id] = type;
        VSPEED[id] = 0.0D;
        HSPEED[id] = 0.0D;
        ACTIVE[id] = true;
        COLOR[id] = Color.BLACK;
        if (type == TYPE_DYNAMIC || type == TYPE_RIGID || type == TYPE_FLUID) {
            dynamics++;
            DYNAMIC[dynamics] = id;
        }
        return id;
    }

    public int createInstance(String name, int x, int y, int width, int height, int type, int Arch) {
        int id = ++instances;
        NAME[id] = name;
        ArchNum[id] = Arch;
        X[id] = x;
        Y[id] = y;
        WIDTH[id] = width;
        HEIGHT[id] = height;
        TYPE[id] = type;
        VSPEED[id] = 0.0D;
        HSPEED[id] = 0.0D;
        ACTIVE[id] = true;
        COLOR[id] = Color.BLACK;
        if (type == TYPE_DYNAMIC || type == TYPE_RIGID || type == TYPE_FLUID) {
            dynamics++;
            DYNAMIC[dynamics] = id;
        }
        return id;
    }

    public String getName(int id) {
        return NAME[id];
    }

    public boolean getActive(int id) {
        return ACTIVE[id];
    }

    public int getX(int id) {
        return X[id];
    }

    public int getY(int id) {
        return Y[id];
    }

    public int getType(int id) {
        return TYPE[id];
    }

    public int getWidth(int id) {
        return WIDTH[id];
    }

    public int getHeight(int id) {
        return HEIGHT[id];
    }

    public int getArch(int id) {
        return ArchNum[id];
    }

    public void setName(String name, int id) {
        NAME[id] = name;
    }

    public void setArch(int Arch, int id) {
        ArchNum[id] = Arch;
    }

    public void setActivate(int id) {
        ACTIVE[id] = true;
    }

    public void setDeactivate(int id) {
        ACTIVE[id] = false;
    }

    public void setDeactivateAll() {
        for (int i = 1; i <= instances; i++)
            ACTIVE[i] = false;
    }

    public void setActivateAll() {
        for (int i = 1; i <= instances; i++)
            ACTIVE[i] = true;
    }

    public void setActiveAll(boolean active) {
        for (int i = 1; i <= instances; i++)
            ACTIVE[i] = active;
    }

    public void setActiveName(boolean active, String name) {
        for (int i = 1; i <= instances; i++) {
            if (NAME[i] == name)
                ACTIVE[i] = active;
        }
    }

    public void setActiveArch(boolean active, int Arch) {
        for (int i = 1; i <= instances; i++) {
            if (ArchNum[i] == Arch)
                ACTIVE[i] = active;
        }
    }

    public void setActivateName(String name) {
        for (int i = 1; i <= instances; i++) {
            if (NAME[i] == name)
                ACTIVE[i] = true;
        }
    }

    public Color getRGBColor(int red, int green, int blue) {
        float[] array = { 1.0F, 2.0F, 3.0F };
        int[] RGB = { red, green, blue };
        Color color = Color.getHSBColor(Color.RGBtoHSB(RGB[0], RGB[1], RGB[2], array)[0],
                Color.RGBtoHSB(RGB[0], RGB[1], RGB[2], array)[1], Color.RGBtoHSB(RGB[0], RGB[1], RGB[2], array)[2]);
        return color;
    }

    public int getRandom(int y) {
        Random rand = new Random();
        int num = rand.nextInt(y + 1);
        return num;
    }

    public int getRandom(int x, int y) {
        Random rand = new Random();
        int num = x + rand.nextInt(y + 1 - x);
        return num;
    }

    public void setDeactivateName(String name) {
        for (int i = 1; i <= instances; i++) {
            if (NAME[i] == name)
                ACTIVE[i] = false;
        }
    }

    public void setActive(boolean active, int id) {
        ACTIVE[id] = active;
    }

    public void setType(int type, int id) {
        TYPE[id] = type;
    }

    public void setX(int x, int id) {
        X[id] = x;
    }

    public void setY(int y, int id) {
        Y[id] = y;
    }

    public void setLocation(Point point, int id) {
        X[id] = point.x;
        Y[id] = point.y;
    }

    public void setLocation(int x, int y, int id) {
        X[id] = x;
        Y[id] = y;
    }

    public void moveInstance(int right, int down, int id) {
        X[id] = X[id] + right;
        Y[id] = Y[id] + down;
    }

    public void moveInstanceAll(int right, int down) {
        for (int i = 1; i <= instances; i++)
            moveInstance(right, down, i);
    }

    public void setHSpeed(int HSpeed, int id) {
        HSPEED[id] = HSpeed;
    }

    public void setVSpeed(int VSpeed, int id) {
        VSPEED[id] = VSpeed;
    }

    public Point getLocationMouse(Component comp) {
        Point point = new Point();
        (MouseInfo.getPointerInfo().getLocation()).x -= comp.getX();
        (MouseInfo.getPointerInfo().getLocation()).y -= comp.getY();
        return point;
    }

    public int getLocationMouseX(Component comp) {
        return (MouseInfo.getPointerInfo().getLocation()).x - comp.getX();
    }

    public void setLocationMouse(Component comp, int id) {
        int MOUSEX = (MouseInfo.getPointerInfo().getLocation()).x - comp.getX();
        int MOUSEY = (MouseInfo.getPointerInfo().getLocation()).y - comp.getY();
        X[id] = MOUSEX;
        Y[id] = MOUSEY;
    }

    public void setWidth(int width, int id) {
        WIDTH[id] = width;
    }

    public void setHeight(int height, int id) {
        HEIGHT[id] = height;
    }

    public void setPrevious() {
        for (int id = 1; id <= instances; id++) {
            xPrevious[id] = X[id];
            yPrevious[id] = Y[id];
        }
    }

    public void setColorID(Color c, int id) {
        COLOR[id] = c;
    }

    public void setColorName(Color c, String name) {
        for (int i = 1; i <= instances; i++) {
            if (NAME[i] == name)
                setColorID(c, i);
        }
    }

    public boolean checkCollided(int id1, int id2) {
        return COLLIDED[id1][id2];
    }

    public boolean checkCollided(int id, String name) {
        for (int i = 1; i <= instances; i++) {
            if (NAME[i] == name && (COLLIDED[id][i] || COLLIDED[i][id]))
                return true;
        }
        return false;
    }

    public void overrideCollided(int id1, int id2, boolean collided) {
        COLLIDED[id1][id2] = collided;
        COLLIDED[id2][id1] = collided;
    }

    public void overrideCollided(int id, String name, boolean collided) {
        for (int i = 1; i <= instances; i++) {
            if (NAME[i] == name) {
                COLLIDED[id][i] = collided;
                COLLIDED[i][id] = collided;
            }
        }
    }

    public boolean checkPointWithin(int X1, int Y1, int X2, int Y2, int X3, int Y3) {
        boolean within = false;
        if (X1 >= X2 && X1 <= X3 && Y1 >= Y2 && Y1 <= Y3)
            within = true;
        return within;
    }

    public boolean checkCollision(int id1, int id2) {
        boolean collision = false;
        int X1a = X[id1];
        int X2a = X[id1] + WIDTH[id1];
        int Y1a = Y[id1];
        int Y2a = Y[id1] + HEIGHT[id1];
        int X1b = X[id2];
        int X2b = X[id2] + WIDTH[id2];
        int Y1b = Y[id2];
        int Y2b = Y[id2] + HEIGHT[id2];
        if (checkPointWithin(X2a, Y2a, X1b, Y1b, X2b, Y2b))
            collision = true;
        if (checkPointWithin(X1a, Y2a, X1b, Y1b, X2b, Y2b))
            collision = true;
        if (checkPointWithin(X1a, Y1a, X1b, Y1b, X2b, Y2b))
            collision = true;
        if (checkPointWithin(X2a, Y1a, X1b, Y1b, X2b, Y2b))
            collision = true;
        X1a = X[id2];
        X2a = X[id2] + WIDTH[id2];
        Y1a = Y[id2];
        Y2a = Y[id2] + HEIGHT[id2];
        X1b = X[id1];
        X2b = X[id1] + WIDTH[id1];
        Y1b = Y[id1];
        Y2b = Y[id1] + HEIGHT[id1];
        if (checkPointWithin(X2a, Y2a, X1b, Y1b, X2b, Y2b))
            collision = true;
        if (checkPointWithin(X1a, Y2a, X1b, Y1b, X2b, Y2b))
            collision = true;
        if (checkPointWithin(X1a, Y1a, X1b, Y1b, X2b, Y2b))
            collision = true;
        if (checkPointWithin(X2a, Y1a, X1b, Y1b, X2b, Y2b))
            collision = true;
        return collision;
    }

    public void animateID(boolean SystemOut, int id) {
        if (ACTIVE[id]) {
            if (TYPE[id] == TYPE_FLUID && TYPE[id + 1] == TYPE_FLUID) {
                HSPEED[id] = HSPEED[id] - ((X[id + 1] - X[id]) / 10);
                VSPEED[id] = VSPEED[id] - ((Y[id + 1] - Y[id]) / 10);
            }
            if (TYPE[id] == TYPE_DYNAMIC || TYPE[id] == TYPE_RIGID || TYPE[id] == TYPE_FLUID) {
                X[id] = (int) (X[id] + HSPEED[id]);
                Y[id] = (int) (Y[id] + VSPEED[id]);
                VSPEED[id] = VSPEED[id] + GRAVITY;
            }
            for (int i = 1; i <= instances; i++) {
                if (TYPE[i] != TYPE_GHOST && i != id && ACTIVE[i])
                    if (checkCollision(id, i)) {
                        X[id] = xPrevious[id];
                        Y[id] = yPrevious[id];
                        COLLIDED[id][i] = true;
                        X[id] = (int) (X[id] + HSPEED[id]);
                        if (checkCollision(id, i)) {
                            X[id] = xPrevious[id];
                            if (TYPE[id] == TYPE_RIGID || TYPE[id] == TYPE_FLUID) {
                                HSPEED[id] = HSPEED[id] * -0.75D;
                            } else {
                                HSPEED[id] = 0.0D;
                            }
                        }
                        Y[id] = (int) (Y[id] + VSPEED[id]);
                        if (checkCollision(id, i)) {
                            Y[id] = yPrevious[id];
                            if (TYPE[id] == TYPE_RIGID || TYPE[id] == TYPE_FLUID) {
                                VSPEED[id] = VSPEED[id] * -0.75D;
                            } else {
                                VSPEED[id] = 0.0D;
                            }
                            VSPEED[id] = VSPEED[id] + GRAVITY;
                        }
                        for (int j = 1; checkCollision(id, i); j++) {
                            Y[id] = Y[id] - j;
                            VSPEED[id] = -j;
                            if (checkCollision(id, i)) {
                                Y[id] = Y[id] + j * 2;
                                VSPEED[id] = j;
                                if (checkCollision(id, i)) {
                                    Y[id] = Y[id] - j;
                                    VSPEED[id] = GRAVITY;
                                    X[id] = X[id] - j;
                                    HSPEED[id] = -j;
                                    if (checkCollision(id, i)) {
                                        X[id] = X[id] + j * 2;
                                        HSPEED[id] = j;
                                        if (checkCollision(id, i)) {
                                            X[id] = X[id] - j;
                                            HSPEED[id] = 0.0D;
                                        }
                                    }
                                }
                            }
                        }
                        if (TYPE[id] != TYPE_RIGID && TYPE[id] != TYPE_FLUID) {
                            int div = 5;
                            if (VSPEED[id] > 0.0D) {
                                VSPEED[id] = VSPEED[id] - FRICTION / div;
                                if (VSPEED[id] < 0.0D)
                                    VSPEED[id] = 0.0D;
                            } else if (VSPEED[id] < 0.0D) {
                                VSPEED[id] = VSPEED[id] + FRICTION / div;
                                if (VSPEED[id] > 0.0D)
                                    VSPEED[id] = 0.0D;
                            }
                            if (HSPEED[id] > 0.0D) {
                                HSPEED[id] = HSPEED[id] - FRICTION / div;
                                if (HSPEED[id] < 0.0D)
                                    HSPEED[id] = 0.0D;
                            } else if (HSPEED[id] < 0.0D) {
                                HSPEED[id] = HSPEED[id] + FRICTION / div;
                                if (HSPEED[id] > 0.0D)
                                    HSPEED[id] = 0.0D;
                            }
                        }
                        if (SystemOut) {
                            System.out.print(id);
                            System.out.print(" collided with ");
                            System.out.println(i);
                        }
                    } else {
                        COLLIDED[id][i] = false;
                    }
            }
        }
    }

    public void animateAll(boolean SystemOut) {
        for (int i = 1; i <= dynamics; i++) {
            int id = DYNAMIC[i];
            if (ACTIVE[id])
                animateID(SystemOut, id);
        }
    }

    public void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.create();
        JFrame f = new JFrame();
        g.setColor(Color.white);
        int i;
        for (i = 1; i <= instances; i++) {
            g.setColor(Color.BLACK);
            if (ACTIVE[i])
                g.fillRect(X[i] - 2, Y[i] - 2, WIDTH[i] + 5, HEIGHT[i] + 5);
        }
        for (i = 1; i <= instances; i++) {
            g.setColor(COLOR[i]);
            if (ACTIVE[i])
                g.drawRect(X[i], Y[i], WIDTH[i], HEIGHT[i]);
            if (ACTIVE[i])
                g.drawRect(X[i] + 1, Y[i] + 1, WIDTH[i] - 2, HEIGHT[i] - 2);
            if (ACTIVE[i])
                g.fillRect(X[i] + 3, Y[i] + 3, WIDTH[i] - 3 - 2, HEIGHT[i] - 3 - 2);
            if (TYPE[i] == TYPE_FLUID && TYPE[i + 1] == TYPE_FLUID && ACTIVE[i] && ACTIVE[i + 1])
                g.drawLine(X[i], Y[i], X[i + 1], Y[i + 1]);
        }
        g.setColor(Color.BLACK);
        if (text[textL] != null) {
            g.drawString(text[textL], textP.x, textP.y);
        } else {
            System.exit(0);
        }
        g.setColor(Color.WHITE);
        g.drawString("The BOX Beta by IRedStudio sector of DwarfPlanetGames", 1, 12);
        g.drawString("Liscenced under Creative Commons (CC). Distribute.", 1, 24);
    }
}
