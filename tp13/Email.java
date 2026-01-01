class Email extends Program {
    void algorithm(){

    }

    
    boolean estPeutEtreUnEmail(String email){
        // Cas d'arret
        if(length(email) == 0){
            return false;
        }
        
        if(charAt(email, 0) == '@'){
            return true;
        }
        return estPeutEtreUnEmail(substring(email, 1, length(email)));
    }

    void test_estPeutEtreUnEmail(){
        assertTrue(estPeutEtreUnEmail("test123@univlille.Fr"));
        assertTrue(estPeutEtreUnEmail("a@b"));
        assertFalse(estPeutEtreUnEmail("test123univlille.Fr"));
        assertFalse(estPeutEtreUnEmail(""));
    }
}
