package don;

import personne.physique.adherent.Membre;

import java.util.Date;

public class Don extends Objet {

    private Date date;

    public Don(Membre donateur, int type, String description) {
        super(donateur, type, description);
        this.date = new Date();
    }

}
