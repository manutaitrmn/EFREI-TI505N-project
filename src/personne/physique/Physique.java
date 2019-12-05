package personne.physique;

import personne.Personne;

public abstract class Physique extends Personne {

    private String prenom;


    public Physique(String nom, String prenom, String adresse, String tel) {
        super(nom, adresse, tel);
        this.prenom = prenom;
    }
}
