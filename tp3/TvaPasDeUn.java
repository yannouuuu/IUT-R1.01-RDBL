class TvaPasDeUn extends Program {

    void algorithm() {
        final double TVA = 0.196;
        print("Combien de lignes ? ");
        int lignes = readInt();

        for (int euros = 1; euros <= lignes; euros++) {
            double ttc = euros * (1 + TVA);
            println(euros + " euros HT = " + ttc + " euros TTC.");
        }
    }

}
