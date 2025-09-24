class TvaPasDemi extends Program {

    void algorithm() {
        final double TVA = 0.196;
        print("Combien de lignes ? ");
        int lignes = readInt();
        print("A partir de ? ");
        double commencement = readDouble();

        for (int i = 0; i < lignes; i++) {
            double euros = commencement + i * 0.5;
            double ttc = euros * (1 + TVA);
            println(euros + " euros HT = " + ttc + " euros TTC.");
        }
    }

}
