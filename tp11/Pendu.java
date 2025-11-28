public class Pendu extends Program{
    
    void test_newLettre(){
        Lettre l1 = newLettre('a');
        assertNotEquals(null, l1);
        assertEquals('a', l1.caractere);
        assertEquals(false, l1.decouverte);
        Lettre l2 = newLettre('z');
        assertNotEquals(null, l2);
        assertEquals('z', l2.caractere);
        assertEquals(false, l2.decouverte);
    }
    
    public Lettre newLettre(char car){
        Lettre l = new Lettre();
        l.caractere = car;
        l.decouverte = false;
        return l;
    }

    public Lettre newLettre(char car, boolean decouverte){
        Lettre l = new Lettre();
        l.caractere = car;
        l.decouverte = decouverte;
        return l;
    }

    void test_creerMot(){
    Lettre[] mot1 = creerMot("bonjour");
    assertNotEquals(null, mot1);
    assertEquals(7, length(mot1));
    assertEquals('b', mot1[0].caractere);
    assertEquals(false, mot1[0].decouverte);
    assertEquals('r', mot1[6].caractere);
    
    Lettre[] mot2 = creerMot("test");
    assertNotEquals(null, mot2);
    assertEquals(4, length(mot2));
    assertEquals('t', mot2[0].caractere);
    assertEquals('t', mot2[3].caractere);
}

    public Lettre[] creerMot(String mot){
        Lettre[] resultat = new Lettre[length(mot)];
        for(int i = 0; i < length(mot); i++){
            resultat[i] = newLettre(charAt(mot, i));
        }
        return resultat;
    }

    void algorithm(){

    }
}