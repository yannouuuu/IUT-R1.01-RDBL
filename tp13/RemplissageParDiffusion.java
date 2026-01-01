class RemplissageParDiffusion extends Program {

    void algorithm() {	
        char[][] image = new char [][]{{'X', 'X', 'O', 'X', 'X'},
                                        {'X', 'O', 'O', 'X', 'O'},
                                        {'O', 'O', 'X', 'O', 'X'},
                                        {'X', 'O', 'X', 'X', 'X'},
                                        {'X', 'O', 'O', 'X', 'X'}};
        
        println("Image initiale");
        println(toString(image));
        println("Saisir les indices du point de départ, ainsi que la nouvelle couleur");
        print("Indice ligne : ");
        int ligne = readInt();
        print("Indice colonne : ");
        int colonne = readInt();
        print("Nouvelle couleur : ");
        char couleur = readChar();
        
        diffuser(image, ligne, colonne, image[ligne][colonne], couleur);
        println(toString(image));
    }

    String toString(char[][] image) {
        String resultat = "";
        for (int i = 0; i < length(image); i++) {
            for (int j = 0; j < length(image[i]); j++) {
                resultat = resultat + image[i][j];
            }
            resultat = resultat + "\n";
        }
        return resultat;
    }

    void diffuser(char[][] image, int indiceLigne, int indiceColonne, char ancienneCouleur, char nouvelleCouleur){
        // Conditions d'arrêt
        if (indiceLigne < 0 || indiceLigne >= length(image)) return;
        if (indiceColonne < 0 || indiceColonne >= length(image[0])) return;
        if (image[indiceLigne][indiceColonne] != ancienneCouleur) return;
        
        // Colorier le pixel actuel
        image[indiceLigne][indiceColonne] = nouvelleCouleur;
        
        // Diffuser récursivement aux 4 voisins
        diffuser(image, indiceLigne - 1, indiceColonne, ancienneCouleur, nouvelleCouleur); // haut
        diffuser(image, indiceLigne + 1, indiceColonne, ancienneCouleur, nouvelleCouleur); // bas
        diffuser(image, indiceLigne, indiceColonne - 1, ancienneCouleur, nouvelleCouleur); // gauche
        diffuser(image, indiceLigne, indiceColonne + 1, ancienneCouleur, nouvelleCouleur); // droite
    }
}
