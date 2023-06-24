package controller;

import metier.Appareil;

public class ControllerAspirateur {

    public ControllerAspirateur() {
    }

    public void setOrientationAspirateur(Appareil aspirateur, String orientation) {
        aspirateur.setOrientation(orientation);
    }

    public void avancerAspirateur(Appareil aspirateur) {
        aspirateur.avancer();
    }
}
