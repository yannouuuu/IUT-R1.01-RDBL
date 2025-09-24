class CaractereSuivant extends Program {

    void algorithm(){
            print("Entrez un caractère : ");
            char c = readChar();

            char suivant = (char) (c + 1); // <-- À COMPLÉTER
            println("Le caractère après " + c + " est " + suivant );        
        }
  
}
