import java.util.ArrayList;


public class Classe {

    private String nomClasse;
    private ArrayList<Classe> eleves;

    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
        this.eleves = new ArrayList<>();
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public ArrayList<Classe> getEleves() {
        return eleves;
    }

    public void afficherEleves() {
        System.out.println("Liste des élèves dans la classe " + nomClasse + ":");
        for (Classe eleve : eleves) {
            System.out.println(eleve);
        }
    }
}