import extensions.File;

class JeuDeMots extends Program {

    final String NOM_REPERTOIRE = "categories";

    String choixFichier(String repertoire) {
        String[] files = getAllFilesFromDirectory(repertoire);
        for (int i = 0; i < length(files); i++) {
            println(i + " : " + files[i]);
        }
        println("Choisir un fichier en indiquant son numéro : ");
        int choix = readInt();
        return files[choix];
    }


    Categorie newCategorie(Theme theme, String sujet, char[] mots){
        Categorie c = new Categorie();
        c.theme = theme;
        c.sujet = sujet;
        c.mots = new char[length(mots)];
        return c;
    }

    int nbLignes(String nomFichier) {
        File file = newFile(nomFichier);
        int count = 0;
        while (ready(file)) {
            readLine(file);
            count++;
        }
        return count;
    }


    // Categorie chargerCategorie(String cheminFichier)
    Categorie chargerCategorie(String cheminFichier) {
        File file = newFile(cheminFichier);
        String sujet = readLine(file);
        Theme theme;
        if (equals(substring(sujet, 0, 7), "animaux")) {
            theme = Theme.BIOLOGIE;
        } else {
            theme = Theme.GEOGRAPHIE;
        }
        char[] mots = new char[nbLignes(cheminFichier) - 1];
        int i = 0;
        while (ready(file)) {
            String line = readLine(file);
            mots[i] = charAt(line, 0);
            i++;
        }
        return newCategorie(theme, sujet, mots);
    }

    // void affichageCategorie(Categorie categorie)
    void affichageCategorie(Categorie categorie) {
        println("[" + categorie.theme + "] " + categorie.sujet + " : ");
        for (int i = 0; i < length(categorie.mots); i++) {
            println(categorie.mots[i]);
        }
    }
    void algorithm(){
            String nomFichier   = choixFichier(NOM_REPERTOIRE);
            Categorie categorie = chargerCategorie(NOM_REPERTOIRE+"/"+nomFichier);
            affichageCategorie(categorie);
    }

}
