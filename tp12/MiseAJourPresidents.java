import extensions.CSVFile;

class MiseAJourPresidents extends Program {

    // Constructeur pour President
    President newPresident(String nom, String parti, Date debut, Date fin) {
        President p = new President();
        p.nom = nom;
        p.parti = parti;
        p.debut = debut;
        p.fin = fin;
        return p;
    }

        // Fonction toString pour President
    String toString(President president) {
            return "Nom: " + president.nom + ", Parti: " + president.parti + ", Début: " + toString(president.debut) + ", Fin: " + toString(president.fin);
    }
        // Constructeur pour Date
    Date newDate(int jour, int mois, int annee) {
        Date d = new Date();
        d.day = jour;
        d.month = mois;
        d.year = annee;
        return d;
    }

        // Fonction toString pour Date
    String toString(Date d){
        return d.day + "/" + d.month + "/" + d.year;
    }

    President[] load(String nomFichier, int presidentEnPlus) {
        President[] presidents = new President[presidentEnPlus];
        CSVFile file = loadCSV(nomFichier);
        int rows = rowCount(file);

        for (int i = 1; i < rows; i++) {
            String nom = getCell(file, i, 1);
            String parti = getCell(file, i, 5);

            String debutString = getCell(file, i, 3);
            Date debut = newDate(
                    charAt(debutString, 0) - '0' + (charAt(debutString, 1) - '0') * 10,
                    charAt(debutString, 3) - '0' + (charAt(debutString, 4) - '0') * 10,
                    charAt(debutString, 6) - '0' + (charAt(debutString, 7) - '0') * 10 + (charAt(debutString, 8) - '0') * 100 + (charAt(debutString, 9) - '0') * 1000);

            String finString = getCell(file, i, 4);
            Date fin = newDate(
                    charAt(finString, 0) - '0' + (charAt(finString, 1) - '0') * 10,
                    charAt(finString, 3) - '0' + (charAt(finString, 4) - '0') * 10,
                    charAt(finString, 6) - '0' + (charAt(finString, 7) - '0') * 10 + (charAt(finString, 8) - '0') * 100 + (charAt(finString, 9) - '0') * 1000);

            presidents[i - 1] = newPresident(nom, parti, debut, fin);
        }

        return presidents;
    }
        // Fonction nombreDe pour compter le nombre de présidents d'un parti donné

        // Fonction regneMaximal pour calculer la durée maximale au pouvoir

        void algorithm() {
            President[] presidents = load("USPresidents.csv", 10);
            println(toString(presidents[0]));
        }

}
