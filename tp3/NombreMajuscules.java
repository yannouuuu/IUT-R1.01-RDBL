class NombreMajuscules extends Program {

    void algorithm() {
        print("Votre texte : ");
        String texte = readString();
        // à compléter /* TODO: Complete this */
        String resultat = "";

        for(int i = 0; i < length(texte); i++){
            char c = charAt(texte, i);
            if(c >= 65 && c <= 90){
                resultat = resultat + c;
            }
        }

        println("Il y a " + length(resultat) + " majuscule(s) dans votre texte."); 
    }
    
}
