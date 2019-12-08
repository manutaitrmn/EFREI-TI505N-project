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

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: " + nom +
                ", tel: " + tel +
                ", adresse: " + adresse +
                ", statut: association"
                ;
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
        LinkedList<Adherent> allStaff = new LinkedList<Adherent>();
        for (Adherent a : recupTousLesAdherents()) {
            if (!(a instanceof Membre)) {
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

    public LinkedList<Morale> recupToutesLesDestinations() {
        LinkedList<Morale> destinations = new LinkedList<Morale>();
        destinations.add(this);
        for (DepotVente d : recupTousLesDepotVentes()) {
            destinations.add(d);
        }
        for (Entrepot e : recupTousLesEntrepots()) {
            destinations.add(e);
        }
        return destinations;
    }

    public Morale recupUneDestinationParId(int id) {
        Morale destination = null;
        for (Morale m : recupToutesLesDestinations()) {
            if (m.getId() == id) {
                destination = m;
            }
        }
        return destination;
    }

    public void afficherToutesLesDestinations() {
        for (Morale m : recupToutesLesDestinations()) {
            if (m instanceof Association) {
                System.out.println((Association)m);
            }
            if (m instanceof DepotVente) {
                System.out.println((DepotVente)m);
            }
            if (m instanceof Entrepot) {
                System.out.println((Entrepot)m);
            }
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

    public void afficherTousLesDonsAjoutes() {
        LinkedList<Don> donsAjoutes = recupTousLesDonsAjoutes();
        for (Don don : donsAjoutes) {
            System.out.println(don);
        }
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

    public DonAccepte recupUnDonAccepteParId(int id) {
        DonAccepte donAccepte = null;
        for (DonAccepte d : recupTousLesDonsAcceptes()) {
            if (d.getId() == id) {
                donAccepte = d;
            }
        }
        return donAccepte;
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
            System.out.println(donStocke);
        }
    }

    public DonStocke recupUnDonStockeParId(int id) {
        DonStocke donStocke = null;
        for (DonStocke d : recupTousLesDonsStockes()) {
            if (d.getId() == id) {
                donStocke = d;
            }
        }
        return donStocke;
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

