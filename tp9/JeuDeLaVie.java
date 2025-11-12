class JeuDeLaVie extends Program {
    String afficher(boolean[][] monde){
        if (length(monde) == 0) 
            return "";

        String s = "";
        for (int i = 0; i < length(monde); i++) {
            for (int j = 0; j < length(monde[i]); j++) {
                if (monde[i][j]) {
                    s = s + "@";
                } else {
                    s = s + ".";
                }
            }
            s = s + "\n";
        }
        return s;
    }

    void initialiser(boolean[][] tab, double proba){
        for (int i = 1 ; i < length(tab) - 1; i++) {
            for (int j = 1; j < length(tab[i]) - 1 ; j++) {
                if (random() < proba) {
                    tab[i][j] = true;
                } else {
                    tab[i][j] = false;
                }
            }
        }
    }

    int nombreDeVoisins(boolean[][] monde, int lig, int col){
        int cpt = 0;
        int n = length(monde);
        int m = length(monde[0]);
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) {
                    continue;
                }
                int i = lig + di;
                int j = col + dj;
                if (i >= 0 && i < n && j >= 0 && j < m && monde[i][j]) {
                    cpt++;
                }
            }
        }
        return cpt;
    }

    boolean evolution(int nombreDeVoisins, boolean etatCellule){
        if (etatCellule) {
            return (nombreDeVoisins == 2 || nombreDeVoisins == 3);
        } else {
            return (nombreDeVoisins == 3);
        }
    }

    void ajouterCarre (boolean[][] monde, int lig, int col){
        int n = length(monde);
        int m = length(monde[0]);
        for (int i = lig; i <= lig + 1; i++){
            for (int j = col; j <= col + 1; j++){
                if (i >= 0 && i < n && j >= 0 && j < m) {
                    monde[i][j] = true;
                }
            }
        }
    }

    void ajouterGlisseur(boolean[][] monde, int lig, int col) {
        int n = length(monde);
        int m = length(monde[0]);
        int[][] coords = {{0,1},{1,2},{2,0},{2,1},{2,2}};
        for (int k = 0; k < length(coords); k++) {
            int[] c = coords[k];
            int i = lig + c[0], j = col + c[1];
            if (i >= 0 && i < n && j >= 0 && j < m) {
                monde[i][j] = true;
            }
        }
    }

    void ajouterBarre(boolean[][] monde, int lig, int col) {
        // barre horizontale de 3 cases
        int n = length(monde);
        int m = length(monde[0]);
        for (int j = col; j <= col + 2; j++) {
            if (lig >= 0 && lig < n && j >= 0 && j < m) {
                monde[lig][j] = true;
            }
        }
    }

    void algorithm() {
        boolean[][] monde = new boolean[20][20];
        int generation = 0;

        initialiser(monde, 0.1);
        // Ici, on pourra par la suite ajouter des motifs (carré, glisseur, barre, autres)
        ajouterCarre(monde, 2, 2);

        do {
            // afficher le monde
            println(afficher(monde));
            // calculer la génération suivante
            boolean[][] nouveauMonde = new boolean[20][20];
            for (int i = 0; i < length(monde); i++) {
                for (int j = 0; j < length(monde[i]); j++) {
                    int voisins = nombreDeVoisins(monde, i, j);
                    nouveauMonde[i][j] = evolution(voisins, monde[i][j]);
                }
            }
            monde = nouveauMonde;
            println("Génération " + generation);
            generation = generation + 1;
            println("Entrez \"stop\" pour arrêter, ou entrée pour continuer");
        } while (!equals("stop", readString()));
    }


    
    void test_evolution () {
        assertEquals(false, evolution(0, false));
        assertEquals(false, evolution(0,  true));
        assertEquals(false, evolution(1, false));
        assertEquals(false, evolution(1,  true));
        assertEquals(false, evolution(2, false));
        assertEquals( true, evolution(2,  true));
        assertEquals( true, evolution(3, false));
        assertEquals( true, evolution(3,  true));
        assertEquals(false, evolution(4, false));
        assertEquals(false, evolution(4,  true));
    }


    void test_nombreDeVoisins() {
        // Initialiser un monde exemple
        boolean[][] monde = new boolean[][]
            {{false, false, false, false, false},
            {false, false, false, false, false},
            {false,  true,  true,  true, false},
            {false, false, false, false, false},
            {false, false, false, false, false}};
        assertEquals(2, nombreDeVoisins(monde, 2, 2));
        assertEquals(2, nombreDeVoisins(monde, 1, 1));
        assertEquals(3, nombreDeVoisins(monde, 3, 2));
    }

    void test_afficher() {
        boolean[][] monde = {
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, false, true, false, false},
            {false, false, false, false, false}
        };
        String expected =
            ".....\n" +
            ".@@@.\n" +
            "..@..\n" +
            ".....\n";
        assertEquals(expected, afficher(monde));
    }

}
