package controller;

import metier.Appareil;

public class ControllerAspirateur {

    private Appareil aspirateur;

    public ControllerAspirateur(Appareil aspirateur) {
        this.aspirateur = aspirateur;
    }

    public void setOrientationAspirateur(String orientation) {
        this.aspirateur.setOrientation(orientation);
    }

    public void avancerAspirateur() {
        this.aspirateur.avancer();
    }
}
