package personne;

import personne.physique.Beneficiaire;
import personne.physique.Membre;
import personne.physique.President;
import personne.physique.Tresorier;

public abstract class Personne {

    private static int registre = 0;

    protected int id;

    protected String nom;

    protected String tel;

    protected String adresse;

    // contructeur
    public Personne(String nom, String adresse, String tel) {
        this.id = registre;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.registre++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean isPresident() {
        return (this instanceof President);
    }

    public boolean isTresorier() {
        return (this instanceof Tresorier);
    }

    public boolean isMembre() {
        return (this instanceof Membre);
    }

    public boolean isBeneficiaire() {
        return (this instanceof Beneficiaire);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", statut: personne"
                ;
    }

}
