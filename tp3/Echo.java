class Echo extends Program {
    void algorithm() {
        // Saisir la chaine à répéter
        print("Chaîne à répéter : ");
        String phrase = readString();
        // Saisir le nombre de fois
        print("Nombre de fois : ");
        int nbFois = readInt();
        // Répéter et afficher
        for(int i = 0; i < nbFois ; i++){
            println(phrase);
        }
    }
}
