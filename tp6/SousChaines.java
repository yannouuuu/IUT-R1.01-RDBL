class SousChaines extends Program {

    void algorithm() {
        print("Mot : ");
        String mot = readString();
        
        for (int debut = 0; debut < length(mot); debut++) {
            for (int longueur = length(mot) - debut; longueur >= 1; longueur--) {
                String sousChaine = substring(mot, debut, debut + longueur);
                println(sousChaine);
            }
        }
    }
}
