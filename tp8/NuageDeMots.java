class NuageDeMots extends Program {

        void algorithm() {
            String texte = "Keep it simple, stupid !" +
                        "Keep it stupid simple !" +
                        "Keep it simple and stupid !" +
                        "Keep it small and simple !";

            // complétez le programme pour afficher les mots et leur fréquence
            String[] mots = extraireMots(texte);
            String[] motsDiff = motsDifferents(mots);
            int[] freq = frequences(motsDiff, mots);

            for (int i = 0; i < length(motsDiff); i++) {
                println(motsDiff[i] + ": " + freq[i]);
            }
        }
        boolean estLettre(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }

        String[] extraireMots(String texte){
            if (texte == null){
                return new String[0];
            }
            texte = texte + " ";
            int n = texte.length();
            boolean inWord = false;
            int count = 0;

            for (int i = 0; i < n; i++) {
                char c = texte.charAt(i);
                if (estLettre(c)) {
                    if (!inWord) inWord = true;
                } else {
                    if (inWord) {
                        count++;
                        inWord = false;
                    }
                }
            }

            String[] tab = new String[count];
            int idx = 0;
            inWord = false;
            int start = 0;
            for (int i = 0; i < n; i++) {
                char c = charAt(texte, i);
                if (estLettre(c)) {
                    if (!inWord) { 
                        inWord = true; 
                        start = i; 
                    }
                } else {
                    if (inWord) {
                        tab[idx++] = substring(texte, start, i);
                        inWord = false;
                    }
                }
            }

            return tab;
        }
        
        boolean estPresent(String[] tab, String mot){
            for(int i = 0; i < length(tab); i++){
                if(tab[i].equals(mot)){
                    return true;
                }
            }
            return false;
        }

        String[] motsDifferents(String[] mots){
            String[] motsDiff = new String[mots.length];
            for(int i = 0; i< motsDiff.length; i++){
                motsDiff[i] = "";
            }
            int pos = 0;
            for(int i = 0; i < length(mots); i++){
                if(!estPresent(motsDiff, mots[i])){
                    motsDiff[pos] = mots[i];
                    pos = pos + 1;
                }
            }
            return motsDiff;
        }
        
        String[] sousTableau(String[] tab, int idxD, int idxF){
            String[] result;
            int start;
            if (idxD < 0 || idxF > tab.length || idxD > idxF) {
                result = new String[tab.length];
                start = 0;
            } else {
                result = new String[idxF - idxD];
                start = idxD;
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = tab[start + i];
            }
            return result;
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

