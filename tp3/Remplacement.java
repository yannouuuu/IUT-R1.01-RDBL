class Remplacement extends Program {
    
    void algorithm(){
     // TODO: implement the algorithm
        String txt;
        String resultat = "";
        char ancien, nouveau;
        print("Veuillez saisir votre texte : ");
        txt = readString(); // oooTITREooo
        print("Caractère à remplacer : ");
        ancien = readChar(); // o
        print("Caractère de remplacement : ");
        nouveau = readChar(); // x  donc xxxTITRExxx

       for(int i = 0; i < length(txt); i++){
            char c = charAt(txt, i);
            if(ancien == c){
                resultat = resultat + nouveau;
            } else {
                resultat = resultat + c;
            }
        }

        print(resultat);
    }
}
