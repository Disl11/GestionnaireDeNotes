import java.util.ArrayList;

public class GestionEleve {

    private String nom;
    private String prenom;
    private int age;
    private ArrayList<Double> notes;

    public GestionEleve(String nom,String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.notes = new ArrayList<>();
    }


    public void ajouterNote(double note) {
        notes.add(note);
    }

    public double calculerMoyenne() {
        if (notes.isEmpty()) {
            return 0;
        }
        double somme = 0;
        for (double note : notes){
            somme += note;
        }
        return somme / notes.size();
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public int getAge(){
        return  age;
    }

   @Override
    public String toString(){
        return prenom + " " + nom + " " + age + " ans" + "(Moyenne : " + calculerMoyenne() + " )";
   }



}

