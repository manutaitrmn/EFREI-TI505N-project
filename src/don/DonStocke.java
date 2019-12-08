package don;

import personne.morale.Morale;
import personne.physique.Adherent;

import java.time.LocalDate;

public class DonStocke extends DonAccepte {

    protected LocalDate dateDeDepot;

    protected Morale destination;

    protected double montant;


    public DonStocke(DonAccepte donAccepte, Morale destination, double montant) {
        super(donAccepte, donAccepte.staff);
        this.destination = destination;
        this.montant = montant;
        dateDeDepot = LocalDate.now();
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
                ", statut: stocké";
    }
}
