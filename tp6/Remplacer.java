class Remplacer extends Program {

    void algorithm() {
        print("Phrase : ");
        String texte = readString();
        print("Avant : ");
        String avant = readString();
        print("Après : ");
        String apres = readString();
        println(copieEnRemplacant(texte, avant, apres));
    }

    String copieEnRemplacant(String texte, String avant, String apres) {
        String resultat = "";
        int i = 0;
        
        while (i < length(texte)) {
            if (i <= length(texte) - length(avant) 
                    && substring(texte, i, i + length(avant)).equals(avant)) {
                resultat = resultat + apres;
                i = i + length(avant);
            } else {
                resultat = resultat + charAt(texte, i);
                i = i + 1;
            }
        }
        
        return resultat;
    }
}
