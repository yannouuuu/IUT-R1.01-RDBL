class Croix extends Program {

    void algorithm() {
        print("Taille : ");
        int taille = readInt();
        print("Caractere : ");
        char caractere = readChar();

        for (int i = 0; i < taille; i++) {
            String line = "";
            for (int j = 0; j < taille; j++) {
                if (j == i || j == taille - 1 - i) {
                    line += caractere;
                } else {
                    line += ' ';
                }
            }
            println("");
        }
    }

}
