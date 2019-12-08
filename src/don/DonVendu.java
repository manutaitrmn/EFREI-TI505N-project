package don;

import personne.morale.Morale;
import personne.physique.Adherent;
import personne.physique.Beneficiaire;
import personne.physique.Membre;

import java.time.LocalDate;

public class DonVendu extends DonStocke {

    protected LocalDate dateVente;

    protected Beneficiaire beneficiaire;

    public DonVendu(DonStocke donStocke, Beneficiaire beneficiaire, LocalDate dateVente) {
        super(donStocke, donStocke.destination, donStocke.montant, donStocke.dateDeDepot);
        this.beneficiaire = beneficiaire;
        this.dateVente = dateVente;
    }

    public LocalDate getDateVente() {
        return dateVente;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", type: " + type +
                ", description: " + description +
                ", date du don: " + String.format("%02d", dateDon.getDayOfMonth()) + "/" + String.format("%02d", dateDon.getMonthValue()) + "/" + dateDon.getYear() +
                ", donateur: " + donateur.getId() +
                ", date de traitement: " + String.format("%02d", dateTraitement.getDayOfMonth()) + "/" + String.format("%02d", dateTraitement.getMonthValue()) + "/" + dateTraitement.getYear() +
                ", staff: " + staff.getId() +
                ", date de depot: " + String.format("%02d", dateDeDepot.getDayOfMonth()) + "/" + String.format("%02d", dateDeDepot.getMonthValue()) + "/" + dateDeDepot.getYear() +
                ", destination: " + destination.getId() +
                ", montant: " + montant + "€" +
                ", date de vente: " + String.format("%02d", dateVente.getDayOfMonth()) + "/" + String.format("%02d", dateVente.getMonthValue()) + "/" + dateVente.getYear() +
                ", beneficiaire: " + beneficiaire.getId() +
                ", statut: vendu/donné";
    }
}
