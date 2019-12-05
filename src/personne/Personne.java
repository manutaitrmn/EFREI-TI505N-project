package personne;

public abstract class Personne {

    public static int registre = 0;

    private int id;

    private String nom;

    private String tel;

    private String adresse;

    // contructeur
    public Personne(String nom, String adresse, String tel) {
        this.id = registre;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.registre++;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }
}
