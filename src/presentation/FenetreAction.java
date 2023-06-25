package presentation;

import controller.ControllerAspirateur;
import metier.Appareil;
import utils.AdapterOrientation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FenetreAction extends JFrame implements ActionListener {

    private Appareil aspirateur;
    private TextArea areaInformations;
    private JButton directionButtonDroite;
    private JButton directionButtonGauche;
    private JButton buttonAvancer;
    private JLabel labelAspirateur;
    private ControllerAspirateur controllerAspirateur;

    public FenetreAction(Appareil aspirateur) {

        setTitle("Démo aspirateur");
        setBounds(750, 250, 500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();

        JLabel labelInformations = new JLabel("Informations de la démo : ");
        areaInformations = new TextArea();
        areaInformations.setEditable(false);
        new JScrollPane(areaInformations);
        areaInformations.append("Dimension de la grille : x=" + aspirateur.getGrille().getMaxX() + " y=" + aspirateur.getGrille().getMaxY() + "\n");
        areaInformations.append("Position initiale de l'aspirateur : x=" +
                aspirateur.getX() + " y=" + aspirateur.getY() + " orientation=" +
                AdapterOrientation.intToStringOrientation(aspirateur.getOrientation()) + "\n"
        );
        areaInformations.append("Instructions : ");

        this.aspirateur = aspirateur;
        this.controllerAspirateur = new ControllerAspirateur(this.aspirateur);

        labelAspirateur = new JLabel("Position finale de l'aspirateur : x= " + this.aspirateur.getX() +
                " y= " + this.aspirateur.getY()+ " orientation: "
                + AdapterOrientation.intToStringOrientation(this.aspirateur.getOrientation()));
        directionButtonDroite = new JButton("D");
        directionButtonGauche = new JButton("G");
        buttonAvancer = new JButton("A");

        panel.add(labelInformations);
        panel.add(areaInformations);
        panel.add(labelAspirateur);
        panel.add(directionButtonDroite);
        panel.add(directionButtonGauche);
        panel.add(buttonAvancer);
        contentPane.add(panel);

        directionButtonDroite.addActionListener(this);
        directionButtonGauche.addActionListener(this);
        buttonAvancer.addActionListener(this);

        setVisible(true);

    }

    private void majInstructions(String instruction) {
        String sauvegarde = this.areaInformations.getText();
        this.areaInformations.setText("");
        this.areaInformations.append(sauvegarde + instruction);
    }

    private void majPositionAspirateur() {
        this.labelAspirateur.setText("Position finale de l'aspirateur : x= " + this.aspirateur.getX() +
                " y= " + this.aspirateur.getY()+ " orientation: "
                + AdapterOrientation.intToStringOrientation(this.aspirateur.getOrientation()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.directionButtonDroite) {
            this.majInstructions("D");
            this.controllerAspirateur.setOrientationAspirateur("D");
            this.majPositionAspirateur();
        }
        if (e.getSource() == this.directionButtonGauche) {
            this.majInstructions("G");
            this.controllerAspirateur.setOrientationAspirateur("G");
            this.majPositionAspirateur();
        }
        if (e.getSource() == this.buttonAvancer) {
            this.majInstructions("A");
            this.controllerAspirateur.avancerAspirateur();
            this.majPositionAspirateur();
        }
    }
}
