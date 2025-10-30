class Frequences extends Program {

    void test_frequences_je_tu_elle() {
        String[] motsCles = new String[]{"je", "tu", "elle"};
        int[] freq = new int[]{3, 2, 1};
        String[] mots = new String[]{"je", "tu", "tu", "elle", "je", "je"};
        assertArrayEquals(freq, frequences(motsCles, mots));
    }

    void algorithm() {
    }

    int nbFois(String[] tab, String mot){
        int cpt = 0;
        for(int i = 0; i < tab.length; i++){
            if(tab[i].equals(mot)){
                cpt++;
            }
        }
        return cpt;
    }

    int[] frequences(String[] motsCles, String[] mots){
        int[] freq = new int[motsCles.length];
        for(int i = 0; i < motsCles.length; i++){
            freq[i] = nbFois(mots, motsCles[i]);
        }
        return freq;
    }
}
