class InitTableau extends Program {

    void test_creerTableau_taille_fixe_10() {
        assertArrayEquals(new int[]{1,1,1,1,1,2,2,2,2,2}, creerTableau());
    }

    
    void test_creerTableau_taille_en_parametre () {
        assertArrayEquals(new int[]{1,1,1,1,1,2,2,2,2,2}, creerTableau(10));
        assertArrayEquals(new int[]{1,1,2,2,2}, creerTableau(5));
        assertArrayEquals(new int[]{}, creerTableau(0));
    }

    void test_creerTableauAleatoire() {
        boolean[] valeursVues = new boolean[21];
        int[] t = creerTableauAleatoire(600);
        for (int i=0; i<length(t); i++) {
            assertTrue( t[i] >=0 && t[i] <=20 );
            valeursVues[t[i]] = true;
        }
        for (int i = 0; i < length(valeursVues); i++) {
            assertTrue(valeursVues[i]);
        }
    }
    

    void algorithm() {
    }

    int[] creerTableau(){
        int[] tableau = new int[10];
        for(int i = 0; i < 5; i++){
            tableau[i] = 1;
        }
        for(int i = 5; i < 10; i++){
            tableau[i] = 2;
        }
        return tableau;
    }

    int[] creerTableau(int taille){
        int[] tableau = new int[taille];
        int moitie = taille / 2;
        for(int i = 0; i < moitie; i++){
            tableau[i] = 1;
        }
        for(int i = moitie; i < taille; i++){
            tableau[i] = 2;
        }
        return tableau;
    }

    int[] creerTableauAleatoire(int taille){
        int[] tableau = new int[taille];
        for(int i = 0; i < taille; i++){
            tableau[i] = (int)(random() * 21);
        }
        return tableau;
    }
}
