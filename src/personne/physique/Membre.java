package personne.physique;

public class Membre extends Adherent {

    public Membre(String nom, String prenom, String adresse, String tel) {
        super(nom, prenom, adresse, tel);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", prenom: " + prenom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", statut: membre"
                ;
    }
}
