class Demineur extends Program {
    String afficher(boolean[][] champs, boolean[][] carte) {
        String res = "  ";
        int n = length(champs);
        int m = length(champs[0]);
        for (int j = 0; j < m; j++) {
            res = res + (char) ('A' + j);
        }
        res = res + "\n";
        for (int i = 0; i < n; i++) {
            res = res + (i + 1) + " ";
            for (int j = 0; j < m; j++) {
                if (!carte[i][j]) {
                    res = res + "?";
                } else if (champs[i][j]) {
                    res = res + "@";
                } else {
                    res = res + ".";
                }
            }
            res = res + "\n";
        }
        return res;
    }

    void initialiserChamps(boolean[][] champ, double proba){
        for (int i = 0 ; i < length(champ); i++) {
            for (int j = 0; j < length(champ[i]) ; j++) {
                if (random() < proba) {
                    champ[i][j] = true;
                } else {
                    champ[i][j] = false;
                }
            }
        }
    }
    
    int saisirLigne(int nombreLignes) {
        int ligne;
        do {
            print("Ligne (1-" + nombreLignes + ") : ");
            ligne = readInt();
        } while (ligne < 1 || ligne > nombreLignes);
        return ligne - 1;
    }

    int saisirColonne(int nombreColonnes) {
        int colonne;
        do {
            print("Colonne (A-" + (char) ('A' + nombreColonnes - 1) + ") : ");
            char saisie = readChar();
            colonne = saisie - 'A';
        } while (colonne < 0 || colonne >= nombreColonnes);
        return colonne;
    }

    void algorithm() {
        boolean[][] champs = new boolean[5][7];
        boolean[][] carte = new boolean[5][7];
        boolean perdu = false;
        int score = 0;

        initialiserChamps(champs, 0.1);

        while (!perdu) {
            println("Score: " + score);
            // Afficher le plateau
            println(afficher(champs, carte));
            println("Où veux-tu tenter ta chance ?");

            // Saisir les coordonnées et découvrir la case correspondante
            // sur la carte
            int ligne = saisirLigne(5);
            int colonne = saisirColonne(7);

            carte[ligne][colonne] = true;

            if (champs[ligne][colonne]) {
                perdu = true;
            } else {
                score++;
            }
        }

        // Afficher le plateau
        println(afficher(champs, carte));
        println("BOUM !"); // Dans ce jeu on perd toujours ...
        println("Ton score final est " + score);
    }



    void test_initialiserChamps() {
        boolean[][] champs = new boolean[1][4]; 
        initialiserChamps(champs, 0.0);
        assertArrayEquals(new boolean[][]{{false, false, false, false}}, champs);
        initialiserChamps(champs, 1.0);
        assertArrayEquals(new boolean[][]{{true, true, true, true}}, champs);
    }

    void test_afficher() {
        boolean[][] champs = {
            {true, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, true, false}
        };

        boolean[][] carte = {
            {true, false, true, false, true},
            {true, false, true, true, false},
            {false, true, true, true, false}
        };

        String attendu =
            "  ABCDE\n" +
            "1 @?.?.\n" +
            "2 .?..?\n" +
            "3 ?..@?\n";

        String resultat = afficher(champs, carte);
        assertEquals(attendu, resultat);
    }
}