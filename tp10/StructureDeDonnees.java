class StructureDeDonnees extends Program {

    // définition des constantes pour les moutons et l'espace
        final char GAUCHE = '<';
        final char DROITE = '>';
        final char ESPACE = '_';
        
        


        // initialisation d'une prairie en situation initiale
        // à compléter ...

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

        // test d'initialisation d'une prairie en situation initiale
        void test_initialiser_7() {
            assertArrayEquals(
                new char[]{DROITE, DROITE, DROITE, ESPACE, GAUCHE, GAUCHE, GAUCHE},
                initialiser(7));
        }
        void test_initialiser_3() {
            assertArrayEquals(
                new char[]{DROITE, ESPACE, GAUCHE},
                initialiser(3));
        }
        void test_initialiser_2() {
            assertArrayEquals(
                new char[]{DROITE, ESPACE, GAUCHE},
                initialiser(2));
        }

        // visualisation d'une prairie
        // à compléter ...
        String toString(char[] prairie){
            String resultat = "";
            for (int i = 0; i < length(prairie); i++) {
                resultat += prairie[i];
            }
            return resultat;
        }

        // test de la visualisation d'une prairie
        void test_toString_vide() {
            char[] prairie_vide = new char[]{ESPACE, ESPACE, ESPACE, ESPACE, ESPACE};
            assertEquals("_____", toString(prairie_vide));
        }
        void test_toString_prairie_initiale() {
            char[] prairie_initiale = new char[]{
                DROITE, DROITE, DROITE, ESPACE, GAUCHE, GAUCHE, GAUCHE};
            assertEquals(">>>_<<<", toString(prairie_initiale));
        }
        void test_toString_prairie_inexistante() {
            char[] test_toString_prairie_inexistante = new char[]{};
            assertEquals("", toString(test_toString_prairie_inexistante));
        }

        void algorithm () {
            // A décommenter une fois les tests au vert !
            char[] prairie = initialiser(7);
            println(toString(prairie));
        }

}
