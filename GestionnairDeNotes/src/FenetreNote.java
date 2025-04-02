import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreNote extends JFrame implements ActionListener {


        private GestionEleve eleve;
        private JTextField noteField;
        private JButton ajouterButton;
        private JButton validerButton;
        private JLabel moyenneLabel;

        public FenetreNote(GestionEleve eleve) {
            this.eleve = eleve;
            setTitle("Ajouter les notes de " + eleve.getPrenom() + " " + eleve.getNom());
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(null);

            noteField = new JTextField(20);
            noteField.setBounds(50, 50, 100, 30);

            ajouterButton = new JButton("Ajouter Note");
            ajouterButton.setBounds(50, 100, 150, 30);
            ajouterButton.addActionListener(this);

            validerButton = new JButton("Valider");
            validerButton.setBounds(50, 150, 100, 30);
            validerButton.addActionListener(this);

            moyenneLabel = new JLabel("Moyenne : " + eleve.calculerMoyenne());
            moyenneLabel.setBounds(50, 200, 200, 30);

            add(noteField);
            add(ajouterButton);
            add(validerButton);
            add(moyenneLabel);

            setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajouterButton) {
            try {
                double note = Double.parseDouble(noteField.getText());
                if (note < 0 || note > 20) {
                    JOptionPane.showMessageDialog(this, "La note doit être entre 0 et 20.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    eleve.ajouterNote(note);
                    moyenneLabel.setText("Moyenne : " + eleve.calculerMoyenne());
                    noteField.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer une note valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == validerButton){

            }
        }
    }


