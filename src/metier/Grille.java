package metier;


public class Grille {
    private int maxX;
    private int maxY;
    private static Grille instance;

    public Grille(int x, int y) {
        this.maxX = x;
        this.maxY = y;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public static Grille getInstance(int x, int y) {
        if (instance == null) {
            instance = new Grille(x, y);
        }
        return instance;
    }
}
