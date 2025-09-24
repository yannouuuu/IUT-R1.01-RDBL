class Suffixe extends Program {
    void algorithm() {
        print("Entrez une chaîne de caractères : ");
        String texte = readString();

        print("Nombre de lettres de fin souhaitées : ");
        int nbLettres = readInt();

        int taille = length(texte);
        if (nbLettres > 0 && nbLettres <= taille) {
            String suffixe = substring(texte, taille - nbLettres, taille);
            println("Résultat : " + suffixe);
        } else {
            println("Erreur, pas assez de caractères !");
        }
    }
}
