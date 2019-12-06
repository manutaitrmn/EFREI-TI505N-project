package don;

import personne.physique.adherent.Membre;

public abstract class Objet {

    private static int registre = 0;

    private int id;

    private Membre donateur;

    private int type;

    private String description;

    public Objet(Membre donateur ,int type, String description) {
        this.id = registre;
        this.donateur = donateur;
        this.type = type;
        this.description = description;
        this.registre++;
    }

}
