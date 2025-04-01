import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {

    private ArrayList<Classe> classes;
    private DefaultListModel<String> listModel;
    private JList<String> listElves;

    public Frame() {

        classes = new ArrayList<>();
        listModel = new DefaultListModel<>();

        Classe classe1A = new Classe("1ere A");
        classes.add(classe1A);

        setTitle("Gestionnaire d'éleves ");
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JTextField prenomField = new JTextField(20);
        JTextField nomField = new JTextField(20);
        JTextField ageFiled = new JTextField(20);
        JTextField classeField = new JTextField(20);

        prenomField.setBounds(200, 50, 200, 30);
        nomField.setBounds(200, 100, 200, 30);
        ageFiled.setBounds(200, 150, 200, 30);
        classeField.setBounds(200, 200, 200, 30);


        JLabel prenomLabel = new JLabel("Prénom :");
        JLabel nomLabel = new JLabel("Nom :");
        JLabel ageLabel = new JLabel("Age :");
        JLabel classeLabel = new JLabel("Classe : ");

        prenomLabel.setBounds(140, 50, 100, 30);
        nomLabel.setBounds(160, 100, 100, 30);
        ageLabel.setBounds(160, 150, 100, 30);
        classeLabel.setBounds(140, 200, 100, 30);


        JButton summitBouton = new JButton("Ajouter");
        summitBouton.setBounds(450, 90, 100, 50);
        summitBouton.addActionListener(this);


        add(prenomLabel);
        add(prenomField);
        add(nomLabel);
        add(nomField);
        add(summitBouton);
        add(prenomField);
        add(nomField);
        add(ageFiled);
        add(ageLabel);
        add(classeLabel);
        add(classeField);

        listElves = new JList<>(listModel);
        listElves.setBounds(65, 275, 500, 300);
        add(listElves);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        }
    }


