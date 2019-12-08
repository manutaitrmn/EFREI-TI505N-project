package don;

import personne.Membre;
import java.time.LocalDate;

public class Don {

    private static int registre = 0;

    protected int id;

    protected int type;

    protected String description;

    protected LocalDate dateDon;

    protected Membre donateur;

    public Don(int type, String description, Membre donateur, LocalDate dateDon) {
        id = registre;
        this.type = type;
        this.description = description;
        registre++;
        this.dateDon = dateDon;
        this.donateur = donateur;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateDon() {
        return dateDon;
    }

    public Membre getDonateur() {
        return donateur;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", type: " + type +
                ", description: " + description +
                ", date du don: " + String.format("%02d", dateDon.getDayOfMonth()) + "/" + String.format("%02d", dateDon.getMonthValue()) + "/" + dateDon.getYear() +
                ", donateur: " + donateur.getId() +
                ", statut: nouveau";
    }
}

