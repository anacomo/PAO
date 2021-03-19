package Fotbal;

import java.util.Scanner;

public class Meniu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de echipe: ");
        int k = scanner.nextInt(); // numarul de echipe participante
        System.out.println("Introduceti numarul de meciuri: ");
        int n = scanner.nextInt(); // numarul de meciuri
        Campionat campionat = new Campionat(k, n);


        for(int i = 0; i < campionat.getNrMeciuri(); i++)
        {
            System.out.println("Numele primei echipe: ");
            String primaEchipa = scanner.next();
            System.out.println("Scorul primei echipe: ");
            int scorPrimaEchipa = scanner.nextInt();

            Echipa e1 = new Echipa(primaEchipa);

            System.out.println("Numele celei de-a doua echipe: ");
            String aDouaEchipa = scanner.next();
            System.out.println("Scorul celei de-a doua echipe:");
            int scorADouaEchipa = scanner.nextInt();

            Echipa e2 = new Echipa(aDouaEchipa);

            campionat.calculeazaScor(e1, scorPrimaEchipa, e2, scorADouaEchipa);

        }

        if(!campionat.verif())
            System.out.println("Numarul de echipe introduse nu coincide cu cele introduse din meciuri");
        else {
            System.out.println("Punctajele tarilor inainte de sortare: ");
            campionat.afiseazaScoruri();
            System.out.println();
            System.out.println("Punctajele tarilor dupa sortare: ");
            campionat.sorteazaEchipe();
            campionat.afiseazaScoruri();
        }
    }
}
