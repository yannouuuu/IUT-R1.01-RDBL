public class Conversion extends Program {

    void algorithm() {
        // À compléter
        final double TAUX = 135.90;
        int euros = 0;
        print("Combien de lignes souhaitez-vous ? ");
        int lignes = readInt();
        double yens;

        // euros++ puis application du taux
        for(int i = 0; i < lignes ; i++){
            euros++;
            yens = TAUX*euros;
            println(euros + " euros " + " = " + yens + " yens.");
        }


    }
}
