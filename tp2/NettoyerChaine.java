class NettoyerChaine extends Program {

    void algorithm() {
        String chaine = readString();
        println("Avant nettoyage :");
        println(">"+chaine+"<");
        
        int debut = 0;
        int fin = length(chaine) - 1;

        // Supprimer les espaces au début
        while (debut <= fin && charAt(chaine, debut) == ' ') {
            debut = debut + 1;
        }

        // Supprimer les espaces à la fin
        while (fin >= debut && charAt(chaine, fin) == ' ') {
            fin = fin - 1;
        }

        if (debut <= fin) {
            chaine = substring(chaine, debut, fin + 1);
        } else {
            chaine = "";
        }

        println("Après nettoyage :");
        println(">"+chaine+"<");
    }
    
}
