public class Factorielle extends Program {

    void algorithm() {
     // TODO: implement the algorithm
        int cpt;
        int resultat = 1;

        print("Nombre pour le calcul de la factorielle : ");
        int n = readInt();

        for(int i = 0; i < n; i++){
            resultat = resultat * (i + 1);
        }
        println(n + "! = " + resultat);
    }
}