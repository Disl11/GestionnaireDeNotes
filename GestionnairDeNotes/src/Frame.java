import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Frame extends JFrame implements ActionListener {

    private HashMap<String, ArrayList<GestionEleve>> classesMap;
    private DefaultTableModel tableModel;
    private JTable table;

    JTextField prenomField = new JTextField(20);
    JTextField nomField = new JTextField(20);
    JTextField ageField = new JTextField(20);
    JTextField classeField = new JTextField(20);

    JLabel prenomLabel = new JLabel("Prénom :");
    JLabel nomLabel = new JLabel("Nom :");
    JLabel ageLabel = new JLabel("Age :");
    JLabel classeLabel = new JLabel("Classe : ");

    JButton summitBouton = new JButton("Ajouter");
    JButton calculerMoyenneBouton = new JButton("Calculer Moyenne");

    public Frame() {
        classesMap = new HashMap<>();
        tableModel = new DefaultTableModel();

        setTitle("Gestionnaire d'éleves");
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        prenomField.setBounds(200, 100, 200, 30);
        nomField.setBounds(200, 50, 200, 30);
        ageField.setBounds(200, 150, 200, 30);
        classeField.setBounds(200, 200, 200, 30);

        prenomLabel.setBounds(140, 50, 100, 30);
        nomLabel.setBounds(160, 100, 100, 30);
        ageLabel.setBounds(160, 150, 100, 30);
        classeLabel.setBounds(140, 200, 100, 30);

        summitBouton.setBounds(450, 90, 100, 50);
        summitBouton.addActionListener(this);

        tableModel.setColumnIdentifiers(new Object[]{"Prénom", "Nom", "Age", "Classe", "Moyenne"});
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(65, 275, 500, 300);

        calculerMoyenneBouton.setBounds(450, 150, 150, 50);
        calculerMoyenneBouton.addActionListener(this);

        add(prenomLabel);
        add(prenomField);
        add(nomLabel);
        add(nomField);
        add(summitBouton);
        add(prenomField);
        add(nomField);
        add(ageField);
        add(ageLabel);
        add(classeLabel);
        add(classeField);
        add(js);
        add(calculerMoyenneBouton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String prenom = prenomField.getText();
        String nom = nomField.getText();
        String classe = classeField.getText();
        String ageText = ageField.getText();

        if (e.getSource() == summitBouton) {
            if (prenom.isEmpty() || nom.isEmpty() || classe.isEmpty() || ageText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int age = Integer.parseInt(ageText);

                GestionEleve eleve = new GestionEleve(prenom, nom, age);

                if (!classesMap.containsKey(classe)) {
                    classesMap.put(classe, new ArrayList<>());
                }

                classesMap.get(classe).add(eleve);

                tableModel.addRow(new Object[]{eleve.getPrenom(), eleve.getNom(), eleve.getAge(), classe, eleve.calculerMoyenne()});

                prenomField.setText("");
                nomField.setText("");
                ageField.setText("");
                classeField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "L'âge doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String prenomSelected = (String) table.getValueAt(selectedRow, 0);
            String nomSelected = (String) table.getValueAt(selectedRow, 1);


            GestionEleve selectedEleve = null;


            for (String key : classesMap.keySet()) {
                for (GestionEleve eleve : classesMap.get(key)) {
                    if (eleve.getPrenom().equals(prenomSelected) && eleve.getNom().equals(nomSelected)) {
                        selectedEleve = eleve;
                        break;
                    }
                }
                if (selectedEleve != null) {
                    break;
                }
            }

            if (selectedEleve != null) {
                new FenetreNote(selectedEleve);
            } else {
                JOptionPane.showMessageDialog(this, "Aucun élève trouvé.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}