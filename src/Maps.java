package the.box;

public class Maps {
    JPhysics ph = new JPhysics();

    public void generateMap() {
        int lev = 0;
        this.ph.setStringLevel("Easy?", lev);
        lev++;
        this.ph.setStringLevel("Don't touch the red BOX!", lev);
        this.ph.createInstance("obj_spike", 100, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("No really, don't.", lev);
        this.ph.createInstance("obj_level", 10, 180, 480, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 250, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Impossible?", lev);
        this.ph.createInstance("obj_level", 10, 180, 480, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 80, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Maybe", lev);
        this.ph.createInstance("obj_level", 10, 20, 50, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 70, 10, 10, 50, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("But improbable.", lev);
        this.ph.createInstance("obj_level", 10, 180, 480, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 300, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 70, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Dev...", lev);
        this.ph.createInstance("obj_spike", 10, 250, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 350, 10, 10, 50, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 350, 100, 140, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("ERROR!", lev);
        this.ph.createInstance("obj_level", 50, 60, 10, 200, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 50, 50, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 100, 10, 10, 60, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 70, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 100, 140, 10, 120, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 130, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 250, 10, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 250, 250, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 460, 40, 10, 220, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 460, 30, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("No way.", lev);
        this.ph.createInstance("obj_level", 10, 50, 100, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 50, 100, 100, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 140, 10, 10, 90, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 10, 180, 480, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 130, 50, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 10, 100, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 50, 110, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 150, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 460, 10, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("So you think you're good at this now...", lev);
        this.ph.createInstance("obj_level", 10, 50, 150, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 150, 60, 10, 200, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 200, 10, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 300, 10, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 200, 250, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 300, 250, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 250, 11, 10, 10, JPhysics.TYPE_RIGID, lev);
        lev++;
        this.ph.setStringLevel("STOP!!!", lev);
        this.ph.createInstance("obj_spike", 10, 250, 140, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 210, 250, 280, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 150, 120, 10, 140, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 150, 110, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 200, 80, 10, 180, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 200, 70, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Take a break", lev);
        this.ph.createInstance("obj_spike", 22, 10, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 33, 10, 300, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 200, 20, 10, 20, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 200, 40, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 200, 120, 10, 60, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 200, 110, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_level", 32, 180, 459, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 22, 180, 10, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 300, 170, 10, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Nobody's ever been scared of bouncy balls.", lev);
        for (int i = 0; i <= 10; i++)
            this.ph.createInstance("obj_spike", 150 + i * 10, 250, 3, 3, JPhysics.TYPE_RIGID, lev);
        lev++;
        this.ph.setStringLevel("Don't touch the floor!", lev);
        this.ph.createInstance("obj_spike", 10, 250, 480, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Spike, Spike, Spike, Spike, Spike.", lev);
        this.ph.createInstance("obj_spike", 100, 170, 20, 20, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 300, 170, 20, 20, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 300, 70, 20, 20, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 100, 70, 20, 20, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 10, 250, 480, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.setStringLevel("Simple", lev);
        this.ph.createInstance("obj_level", 10, 31, 480, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 460, 10, 10, 10, JPhysics.TYPE_GHOST, lev);
        lev++;
        this.ph.setStringLevel("What now?", lev);
        this.ph.createInstance("obj_level", 10, 31, 480, 10, JPhysics.TYPE_STATIC, lev);
        this.ph.createInstance("obj_spike", 460, 10, 10, 10, JPhysics.TYPE_GHOST, lev);
        this.ph.createInstance("obj_spike", 460, 20, 10, 10, JPhysics.TYPE_GHOST, lev);
        lev++;
        this.ph.setStringLevel("Never thought you'd make that.", lev);
        this.ph.createInstance("obj_level", 10, 31, 480, 10, JPhysics.TYPE_STATIC, lev);
        lev++;
        this.ph.createInstance("obj_level", 20, 10, 10, 10, JPhysics.TYPE_STATIC, lev);
    }
}
