public class Menu extends Program {
    void algorithm() {
        println(
            "Bienvenue dans le SuperLogicielDeLanTroisMille\n\n" +
            "1. Ouvrir un document existant.\n" +
            "2. Créer un nouveau document.\n" +
            "3. Enregistrer le document courant.\n" +
            "4. Quitter ce magnifique logiciel.\n"
        );

        print("Veuillez entrer votre choix:");
        int choix = readInt();

        String message;
        if (choix == 1) {
            message = "Ouvrir un document existant.";
        } else if (choix == 2) {
            message = "Créer un nouveau document.";
        } else if (choix == 3) {
            message = "Enregistrer le document courant.";
        } else if (choix == 4) {
            message = "Quitter ce magnifique logiciel.";
        } else {
            message = "Choix invalide.";
        }

        println("Vous avez choisi: \"" + message + "\"");
    }
}
