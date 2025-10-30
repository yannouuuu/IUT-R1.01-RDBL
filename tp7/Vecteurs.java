class Vecteurs extends Program {

    /** La fonction readVector doit saisir les trois éléments du vecteur auprès de l'utilisateur. */

    
    int[] readVector(){
        int[] tab = new int[3];
        for(int i = 0; i < length(tab); i++){
            tab[i] = readInt();
        }
        return tab;
    }

    /** La fonction equals retourne vrai si les deux vecteurs donnés en paramètre contiennent les mêmes valeurs, et retourne faux sinon. */
    
    void test_equals() {
        assertTrue(equals(new int[]{1,1,1}, new int[]{1,1,1}));
        assertFalse(equals(new int[]{1,1,2}, new int[]{1,1,1}));
    }
    

    boolean equals(int[] firstTab, int[] secondTab){
        if (length(firstTab) != length(secondTab)) {
            return false;
        }
        for (int i = 0; i < length(firstTab); i++) {
            if (firstTab[i] != secondTab[i]) {
                return false;
            }
        }
        return true;
    }


    /** La fonction toString retourne la représentation d'un vecteur sous forme de chaine de caractères. */
    
    void test_toString() {
        int[] v = new int[]{1,2,3};
        assertEquals("[1, 2, 3]", toString(v));
    }
    

    String toString(int[] tab){
        String result = "[";

        for(int i = 0; i < length(tab); i++){
            result = result + tab[i];

            if(i < length(tab) - 1){
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }

    /** La fonction add calcule la somme de deux vecteurs.
     *  Rappelons que si v1=[x,y,z] et v2=[a,b,c], alors la somme de v1 et v2 est le vecteur
     *  [x+a, y+b, z+c] */
    
    void test_add() {
        int[] v1 = new int[]{1,2,3};
        int[] v2 = new int[]{-1,-2,-3};
        assertArrayEquals(new int[]{0,0,0}, add(v1,v2));
    }
    

    int[] add(int[] first, int[] second){
        int[] result = new int[length(first)];
        for(int i = 0; i < length(first); i++){
            result[i] = first[i] + second[i];
        }
        return result;
    }

    /** La fanction scalarProduct calcule le produit scalaire de deux vecteurs.
     *  Rappelons que si v1=[x,y,z] et v2=[a,b,c], alors la somme de v1 et v2 est le nombre
     *  x*a + y*b + z*c */
    
    void test_scalarProduct() {
        assertEquals(6, scalarProduct(new int[]{1,1,1},
                new int[]{1,2,3}));
        assertEquals(-14, scalarProduct(new int[]{1,2,3},
                new int[]{-1,-2,-3}));
    }

    int scalarProduct(int[] first, int[] second){
        int result = 0;
        for(int i = 0; i < length(first); i++){
            result += first[i] * second[i];
        }
        return result;
    }

    void algorithm() {
    }

}
