package personne.morale;

import don.Don;
import don.DonAccepte;
import don.DonStocke;
import don.DonVendu;
import personne.physique.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class Association extends Morale {

    Collection<Don> dons = new LinkedList<Don>();

    Collection<Adherent> adherents = new LinkedList<Adherent>();

    Collection<Beneficiaire> beneficiaires = new LinkedList<Beneficiaire>();

    Collection<DepotVente> depotVentes = new LinkedList<DepotVente>();

    Collection<Entrepot> entrepots = new LinkedList<Entrepot>();

    public Association(String nom, String adresse, String tel) {
        super(nom, adresse, tel);
    }

    // GLOBAL

    public void afficherToutesLesPersonnes() {
        afficherTousLesAdherents();
        afficherTousLesBeneficiaires();
        afficherTousLesDepotVentes();
        afficherTousLesEntrepots();
    }

    // ADHERENTS

    public void ajouterUnAdherent(Adherent adherent) {
        adherents.add(adherent);
    }

    public void supprimerUnAdherent(Adherent adherent) {
        adherents.remove(adherent);
    }

    public Adherent recupUnAdherentParId(int id) {
        Adherent adherent = null;
        for (Adherent a : adherents) {
            if (a.getId() == id) {
                adherent = a;
            }
        }
        return adherent;
    }

    public Membre recupUnMembreParId(int id) {
        Membre membre = null;
        for (Adherent a : adherents) {
            if (a instanceof Membre && a.getId() == id) {
                membre = (Membre) a;
            }
        }
        return membre;
    }

    public LinkedList<Adherent> recupTousLesAdherents() {
        return (LinkedList<Adherent>) adherents;
    }

    public LinkedList<Adherent> recupTousLesStaffs() {
        LinkedList<Adherent> allStaff = recupTousLesAdherents();
        for (Adherent a : allStaff) {
            if ((a instanceof Tresorier) && (a instanceof President)) {
                allStaff.add(a);
            }
        }
        return allStaff;
    }

    public void afficherTousLesStaffs() {
        LinkedList<Adherent> allStaff = recupTousLesStaffs();
        for (Adherent a : allStaff) {
            if (a instanceof President) {
                System.out.println((President) a);
            } else if (a instanceof Tresorier) {
                System.out.println((Tresorier) a);
            }
        }
    }

    public Adherent recupUnStaffParId(int id) {
        Adherent staff = null;
        for (Adherent a : recupTousLesStaffs()) {
            if (a.getId() == id) {
                staff = a;
            }
        }
        return staff;
    }

    public void afficherTousLesAdherents() {
        for (Adherent a : adherents) {
            if (a.isMembre()) {
                System.out.println((Membre)a);
            }
            if (a.isPresident()) {
                System.out.println((President)a);
            }
            if (a.isTresorier()) {
                System.out.println((Tresorier)a);
            }
        }
    }

    public void afficherTousLesMembres() {
        for (Adherent a : adherents) {
            if (a instanceof Membre) {
                System.out.println(a);
            }
        }
    }

    // BENEFICIAIRES

    public void ajouterUnBeneficiaire(Beneficiaire beneficiaire) {
        beneficiaires.add(beneficiaire);
    }

    public void supprimerUnBeneficiaire(Beneficiaire beneficiaire) {
        beneficiaires.remove(beneficiaire);
    }

    public LinkedList<Beneficiaire> recupTousLesBeneficiaires() {
        return (LinkedList<Beneficiaire>) beneficiaires;
    }

    public Beneficiaire recupUnBeneficiaireParId(int id) {
        Beneficiaire beneficiaire = null;
        for (Beneficiaire b : beneficiaires) {
            if (b.getId() == id) {
                beneficiaire = b;
            }
        }
        return beneficiaire;
    }

    public void afficherTousLesBeneficiaires() {
        for (Beneficiaire b : beneficiaires) {
            System.out.println(b);
        }
    }

    // DEPOT-VENTE

    public void ajouterUnDepotVente(DepotVente depotVente) {
        depotVentes.add(depotVente);
    }

    public void supprimerUnDepotVente(DepotVente depotVente) {
        depotVentes.remove(depotVente);
    }

    public DepotVente recupUnDepotVenteParId(int id) {
        DepotVente depotVente = null;
        for (DepotVente d : depotVentes) {
            if (d.getId() == id) {
                depotVente = d;
            }
        }
        return depotVente;
    }

    public LinkedList<DepotVente> recupTousLesDepotVentes() {
        return (LinkedList<DepotVente>) depotVentes;
    }

    public void afficherTousLesDepotVentes() {
        for (DepotVente d : depotVentes) {
            System.out.println(d);
        }
    }

    // ENTREPOT

    public void ajouterUnEntrepot(Entrepot entrepot) {
        entrepots.add(entrepot);
    }

    public void supprimerUnEntrepot(Entrepot entrepot) {
        entrepots.remove(entrepot);
    }

    public Entrepot recupUnEntrepotParId(int id) {
        Entrepot entrepot = null;
        for (Entrepot e : entrepots) {
            if (e.getId() == id) {
                entrepot = e;
            }
        }
        return entrepot;
    }

    public LinkedList<Entrepot> recupTousLesEntrepots() {
        return (LinkedList<Entrepot>) entrepots;
    }

    public void afficherTousLesEntrepots() {
        for (Entrepot e : entrepots) {
            System.out.println(e);
        }
    }

    // DON

    public void ajouterUnDon(Don don) {
        dons.add(don);
    }

    public void supprimerUnDon(Don don) {
        dons.remove(don);
    }

    public LinkedList<Don> recupTousLesDonsAjoutes() {
        LinkedList<Don> donsAjoutes = new LinkedList<Don>();
        for (Don don : dons) {
            if (!(don instanceof DonAccepte)) {
                donsAjoutes.add(don);
            }
        }
        return donsAjoutes;
    }

    public Don recupUnDonAjouteParId(int id) {
        Don don = null;
        for (Don d : recupTousLesDonsAjoutes()) {
            if (d.getId() == id) {
                don = d;
            }
        }
        return don;
    }

    public void afficherTousLesDonsAjoutes() {
        LinkedList<Don> donsAjoutes = recupTousLesDonsAjoutes();
        for (Don don : donsAjoutes) {
            System.out.println(don);
        }
    }

    public LinkedList<DonAccepte> recupTousLesDonsAcceptes() {
        LinkedList<DonAccepte> donsAcceptes = new LinkedList<DonAccepte>();
        for (Don don : dons) {
            if ((don instanceof DonAccepte) && !(don instanceof DonStocke)) {
                donsAcceptes.add((DonAccepte)don);
            }
        }
        return donsAcceptes;
    }

    public void afficherTousLesDonsAcceptes() {
        LinkedList<DonAccepte> donsAcceptes = recupTousLesDonsAcceptes();
        for (DonAccepte donAccepte : donsAcceptes) {
            System.out.println(donAccepte);
        }
    }

    public LinkedList<DonStocke> recupTousLesDonsStockes() {
        LinkedList<DonStocke> donsStockes = new LinkedList<DonStocke>();
        for (Don don : dons) {
            if ((don instanceof DonStocke) && !(don instanceof DonVendu)) {
                donsStockes.add((DonStocke) don);
            }
        }
        return donsStockes;
    }

    public void afficherTousLesDonsStockes() {
        LinkedList<DonStocke> donsStockes = recupTousLesDonsStockes();
        for (DonStocke donStocke : donsStockes) {
            System.out.println(donsStockes);
        }
    }

    public LinkedList<DonVendu> recupTousLesDonsVendus() {
        LinkedList<DonVendu> donsVendus = new LinkedList<DonVendu>();
        for (Don don : dons) {
            if ((don instanceof DonVendu)) {
                donsVendus.add((DonVendu) don);
            }
        }
        return donsVendus;
    }

    public void afficherTousLesDons() {
        for (Don don : dons) {
            if (don instanceof DonVendu) {
                System.out.println((DonVendu) don);
            } else if (don instanceof DonStocke) {
                System.out.println((DonStocke) don);
            } else if (don instanceof DonAccepte) {
                System.out.println((DonAccepte) don);
            } else {
                System.out.println(don);
            }
        }
    }

    public void afficherTousLesDonsVendus() {
        LinkedList<DonVendu> donsVendus = recupTousLesDonsVendus();
        for (DonVendu donVendu : donsVendus) {
            System.out.println(donVendu);
        }
    }

    // IMPORT DES FICHIERS

    public void importerTousLesAdherents(String file) {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] l = line.split(";");
                switch (l[5]) {
                    case "president":
                        President president = new President(l[1],l[4],l[2],l[3]);
                        adherents.add(president);
                        break;
                    case  "tresorier":
                        Tresorier tresorier = new Tresorier(l[1],l[4],l[2],l[3]);
                        adherents.add(tresorier);
                        break;
                    case "membre":
                        Membre membre = new Membre(l[1],l[4],l[2],l[3]);
                        adherents.add(membre);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void importerTousLesBeneficiaires(String file) {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] l = line.split(";");
                Beneficiaire beneficiaire = new Beneficiaire(l[1],l[4],l[2],l[3],l[5]);
                beneficiaires.add(beneficiaire);

            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}

