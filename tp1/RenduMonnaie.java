/**
* Ce programme détermine le nombre minimal de coupures
* à restituer pour une somme donnée. Les coupures utilisables
* sont les billets de 20, 10, 5 et les pièces de 2 et 1 euros.
*
* @author yann.secq@univ-lille.fr
*/
class RenduMonnaie extends Program {

    void algorithm(){
            int somme, nb20, nb10, nb5, nb2, nb1, reste;
            print("Quelle est le montant que vous souhaitez rendre en monnaie ?");
            somme = readInt();

            // compléter le calcul SANS UTILISER le mot-clé if !
            nb20 = somme/20;
            somme = somme%20;
            nb10 = somme/10;
            somme = somme%10;
            nb5 = somme/5;
            somme = somme%5;
            nb2 = somme/2;
            somme = somme%2;
            nb1 = somme/1;
            somme = somme%1;
            
            println("Nombre de billets de 20 : " + nb20);
            println("Nombre de billets de 10 : " + nb10);
            println("Nombre de billets de  5 : " + nb5);
            println("Nombre de pièces  de  2 : " + nb2);
            println("Nombre de pièces  de  1 : " + nb1);
        }
}
