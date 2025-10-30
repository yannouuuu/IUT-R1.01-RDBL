class VoteMajoritaire extends Program {

    void test_estAdopte(){
        assertFalse(estAdopte(new boolean[]{true,false}));
        assertTrue(estAdopte(new boolean[]{true,true,false}));
    }

    void algorithm() {
    }


    boolean estAdopte(boolean[] votes){
        int cptPour = 0;
        int cptContre = 0;
        
        for(int i = 0; i < length(votes); i++){
            if(votes[i] == true){
                cptPour++;
            } else {
                cptContre++;
            }
        }


        if(cptPour > cptContre){
            return true;
        } else {
            return false;
        }
    }

}
