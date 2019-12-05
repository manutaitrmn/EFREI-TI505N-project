package personne.physique.beneficiaire;

import personne.physique.Physique;

import java.util.Date;

public class Beneficiaire extends Physique {

    private Date dateNaissance;

    public Beneficiaire(String nom, String prenom, String adresse, String tel, Date dateNaissance) {
        super(nom, prenom, adresse, tel);
        this.dateNaissance = dateNaissance;
    }
}
