package personne.morale;

import personne.Personne;

public class DepotVente extends Morale {

    protected double solde;

    public DepotVente(String nom, String adresse, String tel) {
        super(nom, adresse, tel);
        this.solde = 1000;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", solde: " + solde + "€" +
                ", statut: dépôt-vente"
                ;
    }

    public void ajouterAuSolde(double a) {
        solde += a;
    }
}
