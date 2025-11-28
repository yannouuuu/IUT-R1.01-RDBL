import extensions.File;

class Fichiers extends Program {

    void algorithm() {
        String repertoire = "categories";
        String nomFichier = choixFichier(repertoire);
        println("Vous avez choisi le fichier : " + nomFichier);
        println("Ce fichier contient "+nbLignes(repertoire+"/"+nomFichier)+" lignes.");
        dump(repertoire + "/" + nomFichier);
    }

    String choixFichier(String repertoire) {
        String[] files = getAllFilesFromDirectory(repertoire);
        for (int i = 0; i < length(files); i++) {
            println(i + " : " + files[i]);
        }
        println("Choisir un fichier en indiquant son numéro : ");
        int choix = readInt();
        return files[choix];
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

    void test_nbLignes_animaux_txt() {
        assertEquals(13, nbLignes("categories/animaux.txt"));
    }

    void dump(String file) {
        File f = newFile(file);
        while (ready(f)) {
            println(readLine(f));
        }
    }
}