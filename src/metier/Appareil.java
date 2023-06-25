package metier;

public interface Appareil {

    public int getX();
    public int getY();
    public int getOrientation();
    public Grille getGrille();
    public void setOrientation(String orientation);
    public void avancer();
}
