package generic;

public class Cube extends SolidMaterial {
    private int level;

    public Cube(int level) {
        super(10,10);
        this.level = level;
    }

    public Cube(int size, int weight, int level) {
        super(size, weight);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "cube{" +
                "level=" + level +
                '}';
    }
}
