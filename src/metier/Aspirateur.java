package metier;

public class Aspirateur implements Appareil {

    private int x;
    private int y;
    private int orientation;
    private Grille grille;

    public Aspirateur(int x, int y, int orientation, Grille grille) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.grille = grille;
    }

    private boolean peutAvancerEnX() {
        return this.x >= 0 && this.x < this.grille.getMaxX();
    }

    private boolean peutReculerEnX() { return this.x <= this.grille.getMaxX() && this.x > 0;  }

    private boolean peutAvancerEnY() {
        return this.y >= 0 && this.y < this.grille.getMaxY();
    }

    private boolean peutReculerEnY() { return this.y <= this.grille.getMaxY() && this.y > 0;  }

    private boolean isNord() {
        return this.orientation == 0;
    }

    private boolean isSud() {
        return this.orientation == 180;
    }

    private boolean isEst() {
        return this.orientation == 90;
    }

    private boolean isOuest() {
        return this.orientation == 270;
    }

    private void avanceEnX() {
        if (this.peutAvancerEnX()) { this.x++; }
    }

    private void reculeEnX() {
        if (this.peutReculerEnX()) { this.x--; }
    }

    private void avanceEnY() {
        if (this.peutAvancerEnY()) { this.y++; }
    }

    private void reculeEnY() {
        if (this.peutReculerEnY()) { this.y--; }
    }

    private void tourneOrientationDroite() {
        if (this.isOuest()) { this.orientation = 0; }
        else { this.orientation += 90; }
    }

    private void tourneOrientationGauche() {
        if (this.isNord()) { this.orientation = 270; }
        else { this.orientation -= 90; }
    }

    @Override
    public int getX() { return x; }

    @Override
    public int getY() { return y; }

    @Override
    public int getOrientation() { return orientation; }

    @Override
    public Grille getGrille() { return grille; }

    @Override
    public void setOrientation(String direction) {
        if (direction.equals("D")) { this.tourneOrientationDroite(); }
        if (direction.equals("G")) { this.tourneOrientationGauche(); }
    }

    @Override
    public void avancer() {
        if (this.isNord()) { this.avanceEnY(); }
        if (this.isSud()) { this.reculeEnY(); }
        if (this.isEst()) { this.avanceEnX(); }
        if (this.isOuest()) { this.reculeEnX(); }
    }

}
