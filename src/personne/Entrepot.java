package personne;

public class Entrepot extends Morale {

    public Entrepot(String nom, String adresse, String tel) {
        super(nom, adresse, tel);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", statut: entrepôt"
                ;
    }
}
