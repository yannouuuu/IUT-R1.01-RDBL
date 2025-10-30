class Plein extends Program {

    void algorithm() {
        print("Taille : ");
        int taille = readInt();
        print("Caractere : ");
        char caractere = readChar();

        for (int i = 1; i <= taille; i++) {
            for (int j = 1; j <= i; j++) {
                print(caractere);
            }
            println();
        }
    }

}
