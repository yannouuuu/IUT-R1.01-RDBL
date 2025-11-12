class TicTacToe extends Program {
    char[][] grille;

    String afficher(char[][] grille) {
        String res = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i][j] == '\0') {
                    res = res + ".";
                } else {
                    res = res + grille[i][j];
                }
                if (j < 2) {
                    res = res + " ";
                }
            }
            res = res + "\n";
        }
        return res;
    }

    void test_afficher() {
        grille = new char[3][3];
        grille[1][1] = 'X';
        grille[0][0] = 'O';
        println(afficher(grille));
    }

    int saisir(char[][] grille) {
        int choix;
        do {
            print("Entrez un nombre entre 1 et 9 : ");
            choix = readInt();
            int ligne = (choix - 1) / 3;
            int colonne = (choix - 1) % 3;
            if (choix < 1 || choix > 9 || grille[ligne][colonne] != '\0') {
                println("Saisie invalide. Réessayez.");
                choix = -1;
            }
        } while (choix == -1);
        return choix;
    }

    void jouer(char[][] grille, int choix, char symbole) {
        int ligne = (choix - 1) / 3;
        int colonne = (choix - 1) % 3;
        grille[ligne][colonne] = symbole;
    }

    void test_jouer() {
        grille = new char[3][3];
        jouer(grille, 5, 'X');
        jouer(grille, 1, 'O');
        println(afficher(grille));
    }

    boolean alignement(char[][] grille, char symbole) {
        for (int i = 0; i < 3; i++) {
            if (grille[i][0] == symbole && grille[i][1] == symbole && grille[i][2] == symbole) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (grille[0][j] == symbole && grille[1][j] == symbole && grille[2][j] == symbole) {
                return true;
            }
        }
        if (grille[0][0] == symbole && grille[1][1] == symbole && grille[2][2] == symbole) {
            return true;
        }
        if (grille[0][2] == symbole && grille[1][1] == symbole && grille[2][0] == symbole) {
            return true;
        }
        return false;
    }

    void test_alignement() {
        grille = new char[3][3];
        grille[0][0] = 'X';
        grille[0][1] = 'X';
        grille[0][2] = 'X';
        println(alignement(grille, 'X')); // true
        grille[0][2] = '\0';
        grille[1][1] = 'X';
        grille[2][2] = 'X';
        println(alignement(grille, 'X')); // true
        grille[1][1] = '\0';
        println(alignement(grille, 'X')); // false
    }

    void algorithm() {
        grille = new char[3][3];
        char joueurActuel = 'X';
        boolean victoire = false;
        int tours = 0;

        while (!victoire && tours < 9) {
            println(afficher(grille));
            println("Joueur " + joueurActuel + " :");
            int choix = saisir(grille);
            jouer(grille, choix, joueurActuel);
            victoire = alignement(grille, joueurActuel);
            tours++;
            if (!victoire && tours < 9) {
                if (joueurActuel == 'X') {
                    joueurActuel = 'O';
                } else {
                    joueurActuel = 'X';
                }
            }
        }
        

        println(afficher(grille));
        if (victoire) {
            println("Bravo " + joueurActuel + " a gagné !");
        } else {
            println("Match nul !");
        }
    }
}