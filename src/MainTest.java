import exception.*;
import maquette.*;
import singleton.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class MainTest {

    public static void main(String[] args) throws AlimentNonTrouveException, DonneeIncoherenteException {
        ArrayList<Aliment> alimentsAAjouter = new ArrayList<>();

        alimentsAAjouter.add(new AlimentLiquide("Jus d'orange", 46, 11, 1, 0));
        alimentsAAjouter.add(new AlimentLiquide("Lait de vache", 62, 5, 3, 3));
        alimentsAAjouter.add(new AlimentLiquide("Coca-Cola", 43, 11, 0, 0));
        alimentsAAjouter.add(new AlimentLiquide("Vin rouge", 83, 3, 0, 0));
        alimentsAAjouter.add(new AlimentSolide("Poulet", 215, 0, 19, 15));
        alimentsAAjouter.add(new AlimentSolide("Steak hache", 201, 0, 20, 13));
        alimentsAAjouter.add(new AlimentSolide("Saumon", 127, 0, 21, 4));
        alimentsAAjouter.add(new AlimentSolide("Pomme", 52, 14, 0, 0));
        alimentsAAjouter.add(new AlimentSolide("Orange", 47, 12, 1, 0));
        alimentsAAjouter.add(new AlimentSolide("Riz", 130, 29, 2, 0));
        alimentsAAjouter.add(new AlimentSolide("Pates", 371, 75, 13, 2));
        alimentsAAjouter.add(new AlimentSolide("Frites", 289, 37, 3, 14));
        alimentsAAjouter.add(new AlimentSolide("Pizza", 282, 32, 12, 12));
        BaseDeDonneeAliment.getInstance(alimentsAAjouter);
        System.out.println("Aliments présent dans la base de données\n");
        System.out.println(BaseDeDonneeAliment.getInstance(alimentsAAjouter).toString());

        boolean ajouter = false;
        String ajouterString = "";
        System.out.println("Voulez-vous rajouter un aliment ? O/N");
        Scanner ajouterS = new Scanner(System.in);
        try {
            ajouterString = ajouterS.next();

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        if (ajouterString.equals("O")) {
            ajouter = true;
        }
        if ((!(ajouterString.equals("O")) && (!(ajouterString.equals("N"))))) {
            throw new DonneeIncoherenteException("La reponse ne peut etre que O ou N");
        }

        if (ajouter) {
            String nomAliment = "";
            Scanner nomAlimentS = new Scanner(System.in);
            System.out.println("Entrer un nom d'aliment : ");
            try {
                nomAliment = nomAlimentS.next();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            boolean liquide = false;
            String liquideString = "";
            Scanner liquideSolideS = new Scanner(System.in);
            System.out.println("Votre aliment est-il liquide ? O/N");
            try {
                liquideString = liquideSolideS.next();

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            if (liquideString.equals("O")) {
                liquide = true;
            }
            if ((!(liquideString.equals("O")) && (!(liquideString.equals("N"))))) {
                throw new DonneeIncoherenteException("La reponse ne peut etre que O ou N");
            }

            int kcal = 0;
            Scanner kiloCalS = new Scanner(System.in);
            System.out.println("Kilo Calorie ?");
            try {
                kcal = kiloCalS.nextInt();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if(kcal<0){
                throw new DonneeIncoherenteException("nombre négatif");
            }

            int glucide = 0;
            Scanner glucideS = new Scanner(System.in);
            System.out.println("Glucides ?");
            try {
                glucide = glucideS.nextInt();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if(glucide<0){
                throw new DonneeIncoherenteException("nombre négatif");
            }

            int proteines = 0;
            Scanner proteineS = new Scanner(System.in);
            System.out.println("Proteines ?");
            try {
                proteines = proteineS.nextInt();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if(proteines<0){
                throw new DonneeIncoherenteException("nombre négatif");
            }

            int lipides = 0;
            Scanner lipideS = new Scanner(System.in);
            System.out.println("Lipides ?");
            try {
                lipides = lipideS.nextInt();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if(lipides<0){
                throw new DonneeIncoherenteException("nombre négatif");
            }

            if (liquide) {
                alimentsAAjouter.add(new AlimentLiquide(nomAliment, kcal, glucide, proteines, lipides));
            } else {
                alimentsAAjouter.add(new AlimentSolide(nomAliment, kcal, glucide, proteines, lipides));
            }
            BaseDeDonneeAliment.getInstance(alimentsAAjouter);
            System.out.println("Aliments présent dans la base de données\n");
            System.out.println(BaseDeDonneeAliment.getInstance(alimentsAAjouter).toString());

        }
        // Création d'un plat
        BaseDeDonneeAliment.getInstance(alimentsAAjouter);

        Portion p1 = new Portion(0, 200, "Jus d'orange");
        Portion p2 = new Portion(550, 0, "Poulet");
        Portion p3 = new Portion(300, 0, "Riz");
        Portion p4 = new Portion(200, 0, "Orange");

        ArrayList<Portion> portions = new ArrayList<>();
        portions.add(p1);
        portions.add(p2);
        portions.add(p3);
        portions.add(p4);

        // aliment non présent dans la base
        // Portion p5 = new Portion(200, 0, "machin");

        // aliment incoherent (grammes et millilitres)
        // Portion p6 = new Portion(200, 42, "machin");

        // nombre négatif
        // Portion p7 = new Portion(-4, 0, "machin");

        Repas repas = new Repas("Dejeuner", portions);

        System.out.println(repas.toString());

    }

}