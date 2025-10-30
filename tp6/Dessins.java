class Dessins extends Program {

    void algorithm() {
        print("Taille : ");
        int taille = readInt();
        print("Caractere : ");
        char caractere = readChar();

        trianglePlein(taille, caractere);
        println();
        triangleCreux(taille, caractere);
        println();
        croix(taille, caractere);
        println();
    }

    void triangleCreux(int taille, char c){
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == taille - 1 || j == 0 || j == i) {
                    print(c);
                } else {
                    print(' ');
                }
            }
            println();
        }
    }
    
    void trianglePlein(int taille, char c){
        for (int i = 1; i <= taille; i++) {
            for (int j = 1; j <= i; j++) {
                print(c);
            }
            println();
        }
    }

    void croix(int taille, char c){
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (j == i || j == taille - 1 - i) {
                    print(c);
                } else {
                    print(' ');
                }
            }
            println();
        }
    }
}
