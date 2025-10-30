class AffichageTableau extends Program {

    
    void test_toString_tab_int () {
        assertEquals("1 2 3 ", toString(new int[]{1,2,3}));
        assertEquals("", toString(new int[0]));
    }


    
    void test_toString_tab_string () {
        assertEquals("un deux trois ", toString(new String[]{"un", "deux", "trois"}));
        assertEquals("", toString(new String[0]));
    }
    

    void algorithm() {
        int[] tabInt = new int[]{1,2,3};
        String[] tabString = new String[]{"un", "deux", "trois"};
        println(toString(tabInt));  
        println(toString(tabString)); // <- appel d'une foncion qu'il faudra écrire
    }


    public String toString(int[] tab){
        String result = "";
        for(int i = 0; i < length(tab); i++){
            result = result + tab[i] + " ";        
        }
        return result;
    }

    public String toString(String[] tab){
        String result = "";
        for(int i = 0; i < length(tab); i++){
            result = result + tab[i] + " ";        
        }
        return result;
    }

}
