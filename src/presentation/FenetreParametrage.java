package presentation;

import metier.Aspirateur;
import metier.Grille;
import utils.AdapterOrientation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FenetreParametrage extends JFrame implements ActionListener {

    private JTextField fieldDimensionX, fieldDimensionY, fieldAppareilX, fieldAppareilY;
    private JButton boutonConfirmer, boutonNord, boutonSud, boutonEst, boutonOuest;
    private JLabel labelErreur;
    private String orientationSelected;

    public FenetreParametrage()  {
        setTitle("Paramétrage");
        setBounds(750, 250, 375, 210);
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();
        
        JLabel labelDimensionX = new JLabel("Dimension X de la grille : ");
        fieldDimensionX = new JTextField(10);
        JLabel labelDimensionY = new JLabel("Dimension Y de la grille : ");
        fieldDimensionY = new JTextField(10);
        
        JLabel labelAppareilX = new JLabel("Position X de l'appareil : ");
        fieldAppareilX = new JTextField(10);
        JLabel labelAppareilY = new JLabel("Position Y de l'appareil : ");
        fieldAppareilY = new JTextField(10);

        JLabel labelOrientation = new JLabel("Orientation de l'appareil : ");
        boutonNord = new JButton("N");
        boutonSud = new JButton("S");
        boutonEst = new JButton("E");
        boutonOuest = new JButton("O");

        boutonConfirmer = new JButton("Confirmer");
        labelErreur = new JLabel("");
        labelErreur.setForeground(Color.RED);

        panel.add(labelDimensionX);
        panel.add(fieldDimensionX);
        panel.add(labelDimensionY);
        panel.add(fieldDimensionY);

        panel.add(labelAppareilX);
        panel.add(fieldAppareilX);
        panel.add(labelAppareilY);
        panel.add(fieldAppareilY);
        panel.add(labelOrientation);
        panel.add(boutonNord);
        panel.add(boutonSud);
        panel.add(boutonEst);
        panel.add(boutonOuest);

        panel.add(boutonConfirmer);
        panel.add(labelErreur);
        contentPane.add(panel);

        boutonConfirmer.addActionListener(this);
        boutonNord.addActionListener(this);
        boutonSud.addActionListener(this);
        boutonEst.addActionListener(this);
        boutonOuest.addActionListener(this);
        orientationSelected = "";
        setVisible(true);
    }

    private boolean checkField(JTextField field) {
        String fieldToCheck = field.getText();
        if (Objects.nonNull(fieldToCheck) && !fieldToCheck.isEmpty()) {
            try {
                if (Integer.parseInt(fieldToCheck) < 0) { return false; }
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean checkAppareilPosition() {
        return Integer.parseInt(this.fieldAppareilX.getText()) <= Integer.parseInt(this.fieldDimensionX.getText())
                && Integer.parseInt(this.fieldAppareilY.getText()) <= Integer.parseInt(this.fieldDimensionY.getText());
    }

    private boolean checkAllFields() {
        return this.checkField(this.fieldDimensionX)
                && this.checkField(this.fieldDimensionY)
                && this.checkField(this.fieldAppareilX)
                && this.checkField(this.fieldAppareilY)
                && checkAppareilPosition()
                && !this.orientationSelected.isEmpty();
    }

    private void enableAllButton() {
        boutonNord.setEnabled(true);
        boutonSud.setEnabled(true);
        boutonEst.setEnabled(true);
        boutonOuest.setEnabled(true);
    }

    private void setOrientationSelected(String orientation) {
        orientationSelected = orientation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonNord) {
            enableAllButton();
            boutonNord.setEnabled(false);
            setOrientationSelected("N");
        }
        if (e.getSource() == boutonSud) {
            enableAllButton();
            boutonSud.setEnabled(false);
            setOrientationSelected("S");
        }
        if (e.getSource() == boutonEst) {
            enableAllButton();
            boutonEst.setEnabled(false);
            setOrientationSelected("E");
        }
        if (e.getSource() == boutonOuest) {
            enableAllButton();
            boutonOuest.setEnabled(false);
            setOrientationSelected("O");
        }
        if (e.getSource() == boutonConfirmer) {
            if (!this.checkAllFields()) {
                labelErreur.setText("Vérifiez les champs.");
            } else {
                new FenetreAction(
                        new Aspirateur(Integer.parseInt(this.fieldAppareilX.getText()),
                                Integer.parseInt(this.fieldAppareilY.getText()),
                                AdapterOrientation.stringToIntOrientation(orientationSelected),
                                Grille.getInstance(Integer.parseInt(this.fieldDimensionX.getText()), Integer.parseInt(this.fieldDimensionY.getText()))
                        )
                );
                this.dispose();
            }
        }
    }
}
