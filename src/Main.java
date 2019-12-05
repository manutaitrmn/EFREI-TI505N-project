import personne.morale.Association;

public class Main {

    public static void main(String[] args) {

        Association association = new Association("Mobilier pour tous", "Paris", "0630698068");

        System.out.println(association.getAdresse());

    }


}
