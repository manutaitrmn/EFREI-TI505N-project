package personne;

import personne.Personne;

public abstract class Adherent extends Personne {

    protected String prenom;

    public Adherent(String nom, String prenom, String adresse, String tel) {
        super(nom, adresse, tel);
        this.prenom = prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", prenom: " + prenom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", statut: adhérent"
                ;
    }
}
