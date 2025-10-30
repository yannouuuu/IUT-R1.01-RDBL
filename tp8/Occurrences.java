class Occurrences extends Program {

    void test_nbFois () {
            String[] tab = new String[]{"je", "tu", "tu", "elle" , "je" , "je"};
            // "je" apparait 3 fois dans tab
            assertEquals(3, nbFois(tab, "je"));
            assertEquals(2, nbFois(tab, "tu"));
            assertEquals(0, nbFois(tab, "il"));
    }

    int nbFois(String[] tab, String mot){
        int cpt = 0;
        for(int i = 0; i < length(tab); i++){
            if(tab[i].equals(mot)){
                cpt++;
            }
        }
        return cpt;
    }

    void algorithm() {
            // ne rien écrire ici !
    }

}
