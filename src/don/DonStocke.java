package don;

import personne.Morale;

import java.time.LocalDate;

public class DonStocke extends DonAccepte {

    protected LocalDate dateDeDepot;

    protected Morale destination;

    protected double montant;


    public DonStocke(DonAccepte donAccepte, Morale destination, double montant, LocalDate dateDeDepot) {
        super(donAccepte, donAccepte.staff, donAccepte.dateTraitement);
        this.destination = destination;
        this.montant = montant;
        this.dateDeDepot = dateDeDepot;
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

    public Morale getDestination() {
        return destination;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDate getDateDeDepot() {
        return dateDeDepot;
    }
}
