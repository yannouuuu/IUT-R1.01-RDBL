public class Intervalle extends Program {
    void algorithm(){
        int borneInf, borneSup;

        print("Entrez la borne inférieure : ");
        borneInf = readInt();
        println();

        print("Entrez la borne supérieure : ");
        borneSup = readInt();
        println();

        if (borneInf > borneSup) {
            println("cet intervalle est vide.");
        } else {
            println("cet intervalle n'est pas vide.");
        }
    }
}
