import java.util.ArrayList;


public class Classe {

    private String nomClasse;
    private ArrayList<GestionEleve> eleves;

    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
        this.eleves = new ArrayList<>();
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public ArrayList<GestionEleve> getEleves() {
        return eleves;
    }

  public void ajouterEleve(GestionEleve eleve){
        eleves.add(eleve);
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Classe: " + nomClasse + "\n");
        for (GestionEleve e : eleves) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }
}