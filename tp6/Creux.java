class Creux extends Program {

    void algorithm() {
        print("Taille : ");
        int taille = readInt();
        print("Caractere : ");
        char caractere = readChar();

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == taille - 1 || j == 0 || j == i) {
                    print(caractere);
                } else {
                    print(' ');
                }
            }
            println();
        }
    }

}
