package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FenetreParametrage extends JFrame implements ActionListener {
    private JTextField fieldDimensionX, fieldDimensionY, fieldAppareilX, fieldAppareilY, fieldAppareilOrientation;
    private JButton boutonConfirmer;
    private JLabel labelDimensionX;

    public FenetreParametrage()  {
        setTitle("Paramétrage");
        setBounds(700, 300, 300, 220);
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
        fieldAppareilOrientation = new JTextField(10);

        boutonConfirmer = new JButton("Confirmer");

        panel.add(labelDimensionX);
        panel.add(fieldDimensionX);
        panel.add(labelDimensionY);
        panel.add(fieldDimensionY);

        panel.add(labelAppareilX);
        panel.add(fieldAppareilX);
        panel.add(labelAppareilY);
        panel.add(fieldAppareilY);
        panel.add(labelOrientation);
        panel.add(fieldAppareilOrientation);

        panel.add(boutonConfirmer);
        contentPane.add(panel);

        setVisible(true);
    }

    private boolean checkField(JTextField field) {
        String fieldToCheck = field.getText();
        if (Objects.nonNull(fieldToCheck) && !fieldToCheck.isEmpty()) {
            try {
                Integer.parseInt(fieldToCheck);
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean checkAllFields() {
        return this.checkField(this.fieldDimensionX)
                && this.checkField(this.fieldDimensionY)
                && this.checkField(this.fieldAppareilX)
                && this.checkField(this.fieldAppareilY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonConfirmer) {
            if (this.checkAllFields()) {

            } else {
                new FenetreAction(
                        Integer.parseInt(this.fieldDimensionX.getText()),
                        Integer.parseInt(this.fieldDimensionY.getText()),
                        Integer.parseInt(this.fieldAppareilX.getText()),
                        Integer.parseInt(this.fieldDimensionY.getText())
                );
            }
        }
    }

    public static void main(String[] args) {
        new FenetreParametrage();
    }
}
