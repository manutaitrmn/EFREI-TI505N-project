package don;

import personne.Adherent;

import java.time.LocalDate;

public class DonAccepte extends Don {

    protected LocalDate dateTraitement;

    protected Adherent staff;

    public DonAccepte(Don don, Adherent staff, LocalDate dateTraitement) {
        super(don.type, don.description, don.donateur, don.dateDon);
        this.dateTraitement = dateTraitement;
        this.staff = staff;
    }

    public LocalDate getDateTraitement() {
        return dateTraitement;
    }

    public Adherent getStaff() {
        return staff;
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
                ", statut: accepté";
    }
}
