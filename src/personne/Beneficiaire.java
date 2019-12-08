package personne;

import personne.Personne;

import java.time.LocalDate;

public class Beneficiaire extends Personne {

    private String prenom;

    private LocalDate dateNaissance;

    public Beneficiaire(String nom, String prenom, String adresse, String tel, String dateNaissance) {
        super(nom, adresse, tel);
        this.prenom = prenom;
        String[] d = dateNaissance.split("/");
        this.dateNaissance = LocalDate.parse(d[2]+"-"+d[1]+"-"+d[0]);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", prenom: " + prenom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", date de naissance: " + String.format("%02d", dateNaissance.getDayOfMonth()) + "/" + String.format("%02d", dateNaissance.getMonthValue()) + "/" + dateNaissance.getYear() +
                ", statut: bénéficiaire"
                ;
    }
}
