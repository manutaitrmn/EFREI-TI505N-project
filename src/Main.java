import don.Don;
import don.DonAccepte;
import personne.Personne;
import personne.morale.Association;
import personne.morale.DepotVente;
import personne.morale.Entrepot;
import personne.physique.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    // MAIN

    public static void main(String[] args) {

        // On instancie l'association;
        Association association = new Association("Mobilier pour tous", "Paris", "0630698068");

        //Recupere les fichiers
        String fichierAdherents = new File("").getAbsolutePath() + "/src/fichier/Adherents.txt";
        String fichierBeneficiaires = new File("").getAbsolutePath() + "/src/fichier/Beneficiaires.txt";

        association.importerTousLesAdherents(fichierAdherents);
        association.importerTousLesBeneficiaires(fichierBeneficiaires);

        System.out.println("\n*** Bienvenue sur l'application de gestion de " + association.getNom() + " ***");

        accueil(association);

    }

    // MENU ACCUEIL

    private static void accueil(Association association) {
        System.out.println("\nAccueil");
        System.out.println("1 : Personne \n2 : Don \n3 : Recherche \n4 : Statistiques \n5 : Autre \n0 : Quitter");
        System.out.print("\ninput: ");
        Scanner action = (new Scanner(System.in));
        int nb = action.nextInt();
        while (nb >= 1) {

            // Module Personne
            if (nb == 1) {personne(association);}

            // Module Don
            if (nb == 2) {don(association);}

            // Module Recherche
            if (nb == 3) {}

            // Module Statistiques
            if (nb == 4) {}

            // Module Autre
            if (nb == 5) {}

            System.out.println("\nAccueil");
            System.out.println("1 : Personne \n2 : Don \n3 : Recherche \n4 : Statistiques \n5 : Autre \n0 : Quitter");
            System.out.print("\ninput: ");
            action = (new Scanner(System.in));
            nb = action.nextInt();
        }
    }

    // MODULE PERSONNE

    private static void personne(Association association) {
        System.out.println("\nAccueil > Personne");
        System.out.println("1 : Rechercher \n2 : Afficher \n3 : Ajouter \n4 : Modifier \n5 : Supprimer \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        while (nb >= 1) {

            // Rechercher
            if (nb == 1) {rechercherPersonne(association);}

            // Afficher
            if (nb == 2) {afficherPersonnes(association);}

            // Ajouter
            if (nb == 3) {ajouterPersonne(association);}

            // Modifier
            if (nb == 4) {modifierPersonne(association);}

            //
            if (nb == 5) {supprimerPersonne(association);}


            System.out.println("\nAccueil > Personne");
            System.out.println("1 : Rechercher \n2 : Afficher \n3 : Ajouter \n4 : Modifier \n5 : Supprimer \n0 : Retour");
            System.out.print("\ninput: ");
            action = new Scanner(System.in);
            nb = action.nextInt();
        }
    }

    private static void rechercherPersonne(Association association) {
        System.out.println("\nAccueil > Personne > Rechercher");
        System.out.println("* Permet de rechercher n'importe quelle personne dans l'assoc");
        System.out.print("\nId ou nom ou numéro de téléphone: ");
        Scanner action = new Scanner(System.in);
        String s = action.nextLine();

        System.out.println("\nRésultats: ");

        LinkedList<Personne> result = new LinkedList<Personne>();

        for (Adherent a : association.recupTousLesAdherents()) {
            if (a.getNom().contains(s) || a.getTel().contains(s)) {
                result.add(a);
            }
        }

        for (Beneficiaire b : association.recupTousLesBeneficiaires()) {
            if (b.getNom().contains(s) || b.getTel().contains(s)) {
                result.add(b);
            }
        }

        if (result.size() != 0) {
            for (Personne p : result) {
                if (p.isPresident()) {
                    System.out.println((President) p);
                }
                if (p.isTresorier()) {
                    System.out.println((Tresorier) p);
                }
                if (p.isMembre()) {
                    System.out.println((Membre) p);
                }
                if (p.isBeneficiaire()) {
                    System.out.println((Beneficiaire) p);
                }
            }
        } else {
            System.out.println("Nous n'avons trouvé aucune personne.");
        }
        promptEnterKey();
    }

    private static void afficherPersonnes(Association association) {
        System.out.println("\nAccueil > Personne > Afficher");
        System.out.println("1 : Tout \n2 : Adhérent \n3 : Bénéficiaires \n4 : Dépôt-ventes \n5 : Entrepôts \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        if (nb >= 0 && nb <= 5) {

            if (nb != 0) {
                switch (nb) {
                    case 1:
                        System.out.println("Toutes les personnes: ");
                        association.afficherToutesLesPersonnes();
                        break;
                    case 2:
                        System.out.println("Tous les adhérents (président, trésorier, membre): ");
                        association.afficherTousLesAdherents();
                        break;
                    case 3:
                        System.out.println("Tous les bénéficiaires: ");
                        association.afficherTousLesBeneficiaires();
                        break;
                    case 4:
                        System.out.println("Tous les dépôts-ventes: ");
                        association.afficherTousLesDepotVentes();
                        break;
                    case 5:
                        System.out.println("Tous les entrepôts: ");
                        association.afficherTousLesEntrepots();
                        break;
                }
                promptEnterKey();
                afficherPersonnes(association);
            }

        } else {
            System.out.println("Veuillez resaisir correctement.");
            afficherPersonnes(association);
        }
    }

    private static void ajouterPersonne(Association association) {
        System.out.println("\nAccueil > Personne > Ajouter");
        System.out.println("1 : Président \n2 : Tresorier \n3 : Membre \n4 : Bénéficiaire \n5 : Dépôt-vente \n6 : Entrepôt \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        if (nb >= 0 && nb <= 6) {

            if (nb != 0) {
                String nom = "";
                String prenom = "";
                String adresse = "";
                String tel = "";
                String dateNaissance = "";
                int go = 0;

                if (nb <= 4) {
                    if (nb == 1) {
                        System.out.println("\nFormulaire d'ajout d'un président: ");
                    } else if (nb == 2) {
                        System.out.println("\nFormulaire d'ajout d'un trésorier: ");
                    } else if (nb == 3){
                        System.out.println("\nFormulaire d'ajout d'un membre: ");
                    } else {
                        System.out.println("\nFormulaire d'ajout d'un bénéficiare: ");
                    }

                    System.out.print("Nom: ");
                    action = new Scanner(System.in);
                    nom = action.nextLine();
                    while (nom.isEmpty()) {
                        System.out.println("Veuillez rentrer un nom!");
                        System.out.print("Nom: ");
                        action = new Scanner(System.in);
                        nom = action.nextLine();
                    }

                    System.out.print("Prénom: ");
                    action = new Scanner(System.in);
                    prenom = action.nextLine();
                    while (prenom.isEmpty()) {
                        System.out.println("Veuillez rentrer un prénom!");
                        System.out.print("Prénom: ");
                        action = new Scanner(System.in);
                        prenom = action.nextLine();
                    }

                    System.out.print("Adresse: ");
                    action = new Scanner(System.in);
                    adresse = action.nextLine();
                    while (adresse.isEmpty()) {
                        System.out.println("Veuillez rentrer une adresse!");
                        System.out.print("Adresse: ");
                        action = new Scanner(System.in);
                        adresse = action.nextLine();
                    }

                    System.out.print("Téléphone: ");
                    action = new Scanner(System.in);
                    tel = action.nextLine();
                    while (tel.isEmpty()) {
                        System.out.println("Veuillez rentrer un téléphone!");
                        System.out.print("Téléphone: ");
                        action = new Scanner(System.in);
                        tel = action.nextLine();
                    }

                    if (nb == 4) {
                        boolean dcorrecte = false;
                        System.out.print("Date de naisssance (ex: 21/03/1994): ");
                        action = new Scanner(System.in);
                        dateNaissance = action.nextLine();
                        String[] dsplit = dateNaissance.split("/");
                        if (dsplit.length == 3) {
                            try {
                                LocalDate.parse(dsplit[2]+"-"+dsplit[1]+"-"+dsplit[0]);
                                dcorrecte = true;
                            } catch (DateTimeParseException e) {
                                dcorrecte = false;
                            }
                        }
                        while (!dcorrecte) {
                            System.out.println("Veuillez rentrer une date de naissance valide!");
                            System.out.print("Date de naisssance (ex: 21/03/1994): ");
                            action = new Scanner(System.in);
                            dateNaissance = action.nextLine();
                            dsplit = dateNaissance.split("/");
                            if (dsplit.length == 3) {
                                try {
                                    LocalDate.parse(dsplit[2]+"-"+dsplit[1]+"-"+dsplit[0]);
                                    dcorrecte = true;
                                } catch (DateTimeParseException e) {
                                    dcorrecte = false;
                                }
                            }
                        }
                        go = 2;
                    } else {
                        go = 1;
                    }

                } else {
                    if (nb == 5) {
                        System.out.println("\nFormulaire d'ajout d'un dépôt-vente: ");
                        go = 3;
                    } else {
                        System.out.println("\nFormulaire d'ajout d'un entrepôt: ");
                        go = 4;
                    }

                    System.out.print("Nom: ");
                    action = new Scanner(System.in);
                    nom = action.nextLine();
                    while (nom.isEmpty()) {
                        System.out.println("Veuillez rentrer un nom!");
                        System.out.print("Nom: ");
                        action = new Scanner(System.in);
                        nom = action.nextLine();
                    }

                    System.out.print("Adresse: ");
                    action = new Scanner(System.in);
                    adresse = action.nextLine();
                    while (adresse.isEmpty()) {
                        System.out.println("Veuillez rentrer une adresse!");
                        System.out.print("Adresse: ");
                        action = new Scanner(System.in);
                        adresse = action.nextLine();
                    }

                    System.out.print("Téléphone: ");
                    action = new Scanner(System.in);
                    tel = action.nextLine();
                    while (tel.isEmpty()) {
                        System.out.println("Veuillez rentrer un téléphone!");
                        System.out.print("Téléphone: ");
                        action = new Scanner(System.in);
                        tel = action.nextLine();
                    }
                }
                switch (go) {
                    case 1:
                        association.ajouterUnAdherent(new President(nom,prenom,adresse,tel));
                        break;
                    case 2:
                        association.ajouterUnBeneficiaire(new Beneficiaire(nom,prenom,adresse,tel,dateNaissance));
                        break;
                    case 3:
                        association.ajouterUnDepotVente(new DepotVente(nom,adresse,tel));
                        break;
                    case 4:
                        association.ajouterUnEntrepot(new Entrepot(nom,adresse,tel));
                        break;
                }
                System.out.println("\nAjouté!");
                ajouterPersonne(association);
            }
        } else {
            System.out.println("Veuillez ressaisir correctement.");
            ajouterPersonne(association);
        }
    }

    private static void modifierPersonne(Association association) {
        System.out.println("\nAccueil > Personne > Modifier");
        System.out.println("1 : Adhérent \n2 : Bénéficiaire \n3 : Dépôt-vente \n4 : Entrepôt \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        if (nb >= 0 && nb <= 4) {

            if (nb != 0) {
                int id;
                String l;
                switch (nb) {
                    case 1:
                        association.afficherTousLesAdherents();
                        System.out.print("\nId (-1 pour quitter): ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        Adherent adherent = association.recupUnAdherentParId(id);
                        while (adherent == null && id > -1) {
                            System.out.println("Id incorrect!");
                            association.afficherTousLesAdherents();
                            System.out.print("\nId (-1 pour quitter): ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            adherent = association.recupUnAdherentParId(id);
                        }
                        if (adherent != null) {
                            System.out.print("\nNom ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                adherent.setNom(l);
                            }
                            System.out.print("\nPrénom ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                adherent.setPrenom(l);
                            }
                            System.out.print("\nAdresse ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                adherent.setAdresse(l);
                            }
                            System.out.print("\nTéléphone ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                adherent.setTel(l);
                            }
                            System.out.println("Adhérent (président, trésorier, membre) modifié!");
                        }
                        break;
                    case 2:
                        association.afficherTousLesBeneficiaires();
                        System.out.print("\nId (-1 pour quitter): ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        Beneficiaire beneficiaire = association.recupUnBeneficiaireParId(id);
                        while (beneficiaire == null && id > -1) {
                            System.out.println("Id incorrect!");
                            association.afficherTousLesBeneficiaires();
                            System.out.print("\nId (-1 pour quitter): ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            beneficiaire = association.recupUnBeneficiaireParId(id);
                        }
                        if (beneficiaire != null) {
                            System.out.print("\nNom ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                beneficiaire.setNom(l);
                            }
                            System.out.print("\nPrénom ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                beneficiaire.setPrenom(l);
                            }
                            System.out.print("\nAdresse ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                beneficiaire.setAdresse(l);
                            }
                            System.out.print("\nTéléphone ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                beneficiaire.setTel(l);
                            }

                            boolean dcorrect = false;
                            System.out.print("\nDate de naissance ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            String[] dsplit = l.split("/");
                            if (l.isEmpty()) {
                                dcorrect = true;
                            } else {
                                if (dsplit.length == 3) {
                                    try {
                                        LocalDate.parse(dsplit[2]+"-"+dsplit[1]+"-"+dsplit[0]);
                                        dcorrect = true;
                                    } catch (DateTimeParseException e) {
                                        dcorrect = false;
                                    }
                                }
                            }
                            while (!dcorrect) {
                                System.out.println("Veuillez rentrer une date de naissance correcte!");
                                System.out.print("\nDate de naissance ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                                action = new Scanner(System.in);
                                l = action.nextLine();
                                dsplit = l.split("/");
                                if (l.isEmpty()) {
                                    dcorrect = true;
                                } else {
                                    if (dsplit.length == 3) {
                                        try {
                                            LocalDate.parse(dsplit[2]+"-"+dsplit[1]+"-"+dsplit[0]);
                                            dcorrect = true;
                                        } catch (DateTimeParseException e) {
                                            dcorrect = false;
                                        }
                                    }
                                }
                            }
                            if (dcorrect) {
                                beneficiaire.setDateNaissance(LocalDate.parse(dsplit[2]+"-"+dsplit[1]+"-"+dsplit[0]));
                            }
                            System.out.println("Bénéficiaire modifié!");
                        }
                        break;
                    case 3:
                        association.afficherTousLesDepotVentes();
                        System.out.print("\nRentrez l'id: ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        DepotVente depotVente = association.recupUnDepotVenteParId(id);

                        while (depotVente == null && id > -1) {
                            System.out.println("Id incorrect!");
                            association.afficherTousLesDepotVentes();
                            System.out.print("\nRentrez l'id: ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            depotVente = association.recupUnDepotVenteParId(id);
                        }
                        if (depotVente != null) {
                            System.out.print("\nNom ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                depotVente.setNom(l);
                            }
                            System.out.print("\nAdresse ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                depotVente.setAdresse(l);
                            }
                            System.out.print("\nTéléphone ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                depotVente.setTel(l);
                            }
                            System.out.println("Dépôt-vente modifié!");
                        }
                        break;
                    case 4:
                        association.afficherTousLesEntrepots();
                        System.out.print("\nRentrez l'id: ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        Entrepot entrepot = association.recupUnEntrepotParId(id);
                        while (entrepot == null && id > -1) {
                            System.out.println("Id incorrect!");
                            association.afficherTousLesEntrepots();
                            System.out.print("\nRentrez l'id: ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            entrepot = association.recupUnEntrepotParId(id);
                        }

                        if (entrepot != null) {
                            System.out.print("\nNom ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                entrepot.setNom(l);
                            }
                            System.out.print("\nAdresse ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                entrepot.setAdresse(l);
                            }
                            System.out.print("\nTéléphone ('entrée' si vous ne souhaitez pas modifier ce champ): ");
                            action = new Scanner(System.in);
                            l = action.nextLine();
                            if (!l.isEmpty()) {
                                entrepot.setTel(l);
                            }
                            System.out.println("Entrepôt modifié!");
                        }
                        break;
                }

                modifierPersonne(association);
            }
        } else {
            System.out.println("Veuillez resaisir correctement.");
            modifierPersonne(association);
        }
    }

    private static void supprimerPersonne(Association association) {
        System.out.println("\nAccueil > Personne > Supprimer");
        System.out.println("1 : Adhérent \n2 : Bénéficiaire \n3 : Dépôt-vente \n4 : Entrepôt \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        if (nb >= 0 && nb <= 4) {

            if (nb != 0) {
                int id;
                switch (nb) {
                    case 1:
                        System.out.println("Choisir un adhérent à supprimer: ");
                        association.afficherTousLesAdherents();
                        System.out.print("\nid (-1 pour quitter): ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        Adherent adherent = association.recupUnAdherentParId(id);
                        while (adherent == null && id > -1) {
                            System.out.println("\nId incorrecte!");
                            System.out.println("Choisir un adhérent à supprimer: ");
                            association.afficherTousLesAdherents();
                            System.out.print("\nid (-1 pour quitter): ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            adherent = association.recupUnAdherentParId(id);
                        }
                        if (adherent != null) {
                            association.supprimerUnAdherent(adherent);
                            System.out.println("Adhérent supprimé!");
                        }
                        break;
                    case 2:
                        System.out.println("Choisir un bénéficiaire à supprimer: ");
                        association.afficherTousLesBeneficiaires();
                        System.out.print("\nid (-1 pour quitter): ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        Beneficiaire beneficiaire = association.recupUnBeneficiaireParId(id);
                        while (beneficiaire == null && id > -1) {
                            System.out.println("\nId incorrecte!");
                            System.out.println("Choisir un bénéficiaire à supprimer: ");
                            association.afficherTousLesBeneficiaires();
                            System.out.print("\nid (-1 pour quitter): ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            beneficiaire = association.recupUnBeneficiaireParId(id);
                        }
                        if (beneficiaire != null) {
                            association.supprimerUnBeneficiaire(beneficiaire);
                            System.out.println("Bénéficiaire supprimé!");
                        }
                        break;
                    case 3:
                        System.out.println("Choisir un dépôt-vente à supprimer: ");
                        association.afficherTousLesDepotVentes();
                        System.out.print("\nid (-1 pour quitter): ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        DepotVente depotVente = association.recupUnDepotVenteParId(id);
                        while (depotVente == null && id > -1) {
                            System.out.println("\nId incorrecte!");
                            System.out.println("Choisir un dépôt-vente à supprimer: ");
                            association.afficherTousLesDepotVentes();
                            System.out.print("\nid (-1 pour quitter): ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            depotVente = association.recupUnDepotVenteParId(id);
                        }
                        if (depotVente != null) {
                            association.supprimerUnDepotVente(depotVente);
                            System.out.println("Dépôt-vente supprimé!");
                        }

                        break;
                    case 4:
                        System.out.println("Choisir un entrepôt à supprimer: ");
                        association.afficherTousLesEntrepots();
                        System.out.print("\nid (-1 pour quitter): ");
                        action = new Scanner(System.in);
                        id = action.nextInt();
                        Entrepot entrepot = association.recupUnEntrepotParId(id);
                        while (entrepot == null && id > -1) {
                            System.out.println("\nId incorrecte!");
                            System.out.println("Choisir un entrepôt à supprimer: ");
                            association.afficherTousLesEntrepots();
                            System.out.print("\nid (-1 pour quitter): ");
                            action = new Scanner(System.in);
                            id = action.nextInt();
                            entrepot = association.recupUnEntrepotParId(id);
                        }
                        if (entrepot != null) {
                            association.supprimerUnEntrepot(entrepot);
                            System.out.println("Entrepôt supprimé!");
                        }
                        break;
                }
                supprimerPersonne(association);
            }
        } else {
            System.out.println("Veuillez ressaisir correctement.");
            supprimerPersonne(association);
        }
    }

    // MODULE DON

    private static void don(Association association) {
        System.out.println("\nAccueil > Don");
        System.out.println("1 : Nouveau don \n2 : Accepter un don \n3 : Stocker un don \n4 : Don vendu/donnée \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        association.afficherTousLesDons();

        while (nb >= 1) {

            // Nouveau don
            if (nb == 1) {ajouterDon(association);}

            // Afficher
            if (nb == 2) {accepterDon(association);}

            // Ajouter
            if (nb == 3) {}

            // Modifier
            if (nb == 4) {}

            System.out.println("\nAccueil > Don");
            System.out.println("1 : Nouveau don \n2 : Accepter un don \n3 : Stocker un don \n4 : Don vendu/donnée \n0 : Retour");
            System.out.print("\ninput: ");
            action = new Scanner(System.in);
            nb = action.nextInt();
        }
    }

    public static void ajouterDon(Association association) {
        System.out.println("\nAccueil > Don > Ajouter");
        System.out.println("1 : Commencer \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        if (nb >= 0 && nb <= 1) {
            if (nb == 1) {
                int type;
                String desc;
                int id;
                System.out.print("Type de don (entier, voir annexe): ");
                action = new Scanner(System.in);
                type = action.nextInt();
                System.out.print("Description: ");
                action = new Scanner(System.in);
                desc = action.nextLine();
                Membre membre = null;
                System.out.println("\nChoisir un donateur: ");
                association.afficherTousLesMembres();
                System.out.print("Id du donateur: ");
                action = new Scanner(System.in);
                id = action.nextInt();
                membre = association.recupUnMembreParId(id);
                while (membre == null) {
                    System.out.println("\nChoisir un donateur: ");
                    association.afficherTousLesMembres();
                    System.out.println("** Veuillez rentrer un id correct! **");
                    System.out.print("Id du donateur: ");
                    action = new Scanner(System.in);
                    id = action.nextInt();
                    membre = association.recupUnMembreParId(id);
                }
                Don don = new Don(type, desc, membre);
                association.ajouterUnDon(don);
                System.out.println(don);
            }
        } else {
            System.out.println("Veuillez resaisir correctement.");
            ajouterDon(association);
        }
    }

    public static void accepterDon(Association association) {
        System.out.println("\nAccueil > Don > Accepter");
        System.out.println("1 : Commencer \n0 : Retour");
        System.out.print("\ninput: ");
        Scanner action = new Scanner(System.in);
        int nb = action.nextInt();

        if (nb >= 0 && nb <= 1) {
            if (nb == 1) {
                System.out.println("Choisir un don à accepter parmis ces dons:");
                association.afficherTousLesDonsAjoutes();
                System.out.print("Id du don: ");
                action = new Scanner(System.in);
                int id = action.nextInt();
                Don don = association.recupUnDonAjouteParId(id);
                while (don == null) {
                    System.out.println("\nId du don incorrect! ");
                    System.out.println("Choisir un don à accepter parmis ces dons:");
                    association.afficherTousLesDonsAjoutes();
                    System.out.println("Rentrez un id correct!");
                    System.out.print("Id du don: ");
                    action = new Scanner(System.in);
                    id = action.nextInt();
                    don = association.recupUnDonAjouteParId(id);
                }
                System.out.println("\nChoisir le staff qui traite la demande:");
                association.afficherTousLesStaffs();
                System.out.print("Id du staff: ");
                action = new Scanner(System.in);
                id = action.nextInt();
                Adherent staff = association.recupUnStaffParId(id);
                while (staff == null) {
                    System.out.println("\nId du staff incorrect! ");
                    System.out.println("Choisir le staff qui traite la demande:");
                    association.afficherTousLesStaffs();
                    System.out.println("Rentrez un id correct!");
                    System.out.print("Id du staff: ");
                    action = new Scanner(System.in);
                    id = action.nextInt();
                    staff = association.recupUnStaffParId(id);
                }
                association.supprimerUnDon(don);
                association.ajouterUnDon(new DonAccepte(don, staff));
                System.out.println("Don accepté.");
                accepterDon(association);
            }
        } else {
            System.out.println("Veuillez resaisir correctement.");
            accepterDon(association);
        }
    }
    // FONCTIONS UTILES

    private static void promptEnterKey(){
        System.out.println("Appuyez sur 'ENTRÉE' pour continuer");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
