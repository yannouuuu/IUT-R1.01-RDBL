class SauteMouton extends Program {

    // définition de la fonction appliquer
        // définition des constantes pour les moutons et l'espace
        final char GAUCHE = '<';
        final char DROITE = '>';
        final char ESPACE = '_';
        
        char[] initialiser(int taille) {
            // si taille paire, passer à l'impair suivant
            if (taille % 2 == 0) {
                taille++;
            }
            if (taille < 3) {
                taille = 3;
            }

            char[] prairie = new char[taille];
            int milieu = taille / 2;
            for (int i = 0; i < taille; i++) {
                if (i < milieu) {
                    prairie[i] = DROITE;
                } else if (i == milieu) {
                    prairie[i] = ESPACE;
                } else {
                    prairie[i] = GAUCHE;
                }
            }
            return prairie;
        }

        String toString(char[] prairie){
            String resultat = "";
            for (int i = 0; i < length(prairie); i++) {
                resultat += prairie[i];
            }
            return resultat;
        }

        void appliquer(char[] prairie, int[] coup){
            int from = coup[0];
            int to = coup[1];
            char piece = prairie[from];
            prairie[from] = ESPACE;
            prairie[to] = piece;
        }

        // test de l'application d'un coup
        void test_appliquer_avancer_droite() {
            char[] prairie = new char[]{DROITE, ESPACE, GAUCHE};
            appliquer(prairie, new int[]{0, 1});
            assertArrayEquals(new char[]{ESPACE, DROITE, GAUCHE}, prairie);
        }
        void test_appliquer_avancer_gauche() {
            char[] prairie = new char[]{DROITE, ESPACE, GAUCHE};
            appliquer(prairie, new int[]{2, 1});
            assertArrayEquals(new char[]{DROITE, GAUCHE, ESPACE}, prairie);
        }
        void test_appliquer_sauter_droite() {
            char[] prairie = new char[]{DROITE, GAUCHE, ESPACE, GAUCHE};
            appliquer(prairie, new int[]{0, 2});
            assertArrayEquals(new char[]{ESPACE, GAUCHE, DROITE, GAUCHE}, prairie);
        }
        void test_appliquer_sauter_gauche() {
            char[] prairie = new char[]{DROITE, ESPACE, GAUCHE, GAUCHE};
            appliquer(prairie, new int[]{3, 1});
            assertArrayEquals(new char[]{DROITE, GAUCHE, GAUCHE, ESPACE}, prairie);
        }

        int[] saisir(char[] prairie) {
            println(toString(prairie)); 
            int taille = length(prairie);
            while (true) {
                println("Position du mouton");
                int from = readInt();

                if (from >= 0 && from < taille) {
                    char piece = prairie[from];
                    if (piece == DROITE || piece == GAUCHE) {
                        println("Indice d'arrivée ?");
                        int to = corriger(readInt(), taille);

                        boolean valide = false;
                        if (piece == DROITE) {
                            if (from + 1 < taille && to == from + 1 && prairie[to] == ESPACE) {
                                valide = true;
                            } else if (from + 2 < taille && to == from + 2 && prairie[from + 1] != ESPACE && prairie[to] == ESPACE) {
                                valide = true;
                            }
                        } else {
                            if (from - 1 >= 0 && to == from - 1 && prairie[to] == ESPACE) {
                                valide = true;
                            } else if (from - 2 >= 0 && to == from - 2 && prairie[from - 1] != ESPACE && prairie[to] == ESPACE) {
                                valide = true;
                            }
                        }

                        if (valide) {
                            return new int[]{from, to};
                        } else {
                            println("Coup invalide. Réessayez.");
                        }
                    } else {
                        println("Ce n'est pas un mouton. Réessayez.");
                    }
                } else {
                    println("Indice hors du tableau. Réessayez.");
                }
                println(toString(prairie));
            }
        }



        // corriger: retourne un indice valide
        int corriger(int indice, int taille) {
            if (indice < 0) {
                return 0;
            }
            if (indice >= taille) {
                return taille - 1;
            }
            return indice;
        }

        boolean bloque(char[] prairie){
            int n = length(prairie);
            for (int i = 0; i < n; i++) {
                char c = prairie[i];
                if (c == DROITE) {
                    // avancer d'une case
                    if (i + 1 < n && prairie[i + 1] == ESPACE) 
                        return false;
                    // sauter par-dessus
                    if (i + 2 < n && prairie[i + 1] != ESPACE && prairie[i + 2] == ESPACE) return false;
                } else if (c == GAUCHE) {
                    if (i - 1 >= 0 && prairie[i - 1] == ESPACE) 
                        return false;
                    if (i - 2 >= 0 && prairie[i - 1] != ESPACE && prairie[i - 2] == ESPACE) 
                        return false;
                }
            }
            return true;
        }


        // définition de la fonction gagne
        boolean gagne(char[] prairie) {
            int n = length(prairie);
            int mid = n / 2;
            if (prairie[mid] != ESPACE) 
                return false;
            for (int i = 0; i < mid; i++) {
                if (prairie[i] != GAUCHE) 
                    return false;
            }
            for (int i = mid + 1; i < n; i++) {
                if (prairie[i] != DROITE) 
                    return false;
            }
            return true;
        }

        void algorithm() {
            char[] prairie = initialiser(7);
            println(toString(prairie));
            int[] coup = saisir(prairie);
            appliquer(prairie, coup);
            println(toString(prairie));
        }   

        void test_bloque() {
            assertFalse(bloque(new char[]{ESPACE, GAUCHE, DROITE, GAUCHE, DROITE}));
            assertFalse(bloque(new char[]{DROITE, GAUCHE, DROITE, GAUCHE, ESPACE}));
            assertTrue (bloque(new char[]{DROITE, DROITE, GAUCHE, GAUCHE, ESPACE}));
            assertTrue (bloque(new char[]{ESPACE, DROITE, DROITE, GAUCHE, GAUCHE}));
            assertTrue (bloque(new char[]{GAUCHE, GAUCHE, ESPACE, DROITE, DROITE}));
        }

            void test_corriger_negatif() {
                assertEquals(0, corriger(-3, 5));
            }
            void test_corriger_trop_grand() {
                assertEquals(4, corriger(10, 5));
            }
            void test_corriger_valide() {
                assertEquals(2, corriger(2, 5));
            }

        void test_gagne() {
            assertTrue(
                gagne(new char[]{GAUCHE, GAUCHE, GAUCHE, ESPACE, DROITE, DROITE, DROITE}));
            assertFalse(
                gagne(new char[]{GAUCHE, GAUCHE, GAUCHE, DROITE, ESPACE, DROITE, DROITE}));
        }


}
