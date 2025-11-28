import extensions.CSVFile;

public class DumpCSV extends Program {
    void algorithm() {
        dump("USPresident.csv");
    }

    void dump(String nomFichier) {
        CSVFile file = loadCSV(nomFichier);
        for (int i = 0; i < rowCount(file); i++) {
            for (int j = 0; j < columnCount(file); j++) {
                print(getCell(file, i, j) + "\t");
            }
            println();
        }
    }
}