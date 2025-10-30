class MasqueChaine extends Program {

    void testMasque () {
            assertEquals("a...a...a....",    masque("au bal masqué",    'a'));
            assertEquals("................", masque("Tonari no Totoro", 'u'));
            assertEquals(".o......o..o.o.o", masque("Tonari no Totoro", 'o'));
            assertEquals("",                 masque("",                 'z'));
        }
        String masque(String phrase, char lettre){
            String str = "";

            for(int i = 0; i < length(phrase); i++){
                if(lettre ==  charAt(phrase, i)){
                    str = str + lettre;
                } else {
                    str = str + '.';
                }
            }
            return str;
        }
        
        void algorithm() {
        }

}
