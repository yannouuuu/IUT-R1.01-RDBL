public class GestionParc extends Program{
    final int NB_MAX = 100;

    void algorithm(){
    
    }

    Parc newParc(){
        Parc p = new Parc();
        p.vehicules = new Vehicule[NB_MAX];
        p.nbVehicules = 0;
        return p;
    }

    void test_newParc(){
        Parc p = newParc();
        assertNotEquals(null, p.vehicules);
        assertEquals(NB_MAX, length(p.vehicules));
        assertEquals(0, p.nbVehicules);
    }

    boolean ajouter(Parc parking, Vehicule v){
        if(parking.nbVehicules >= NB_MAX){
            return false;
        }
        parking.vehicules[parking.nbVehicules] = v;
        parking.nbVehicules++;
        return true;
    }

    void test_ajouter(){
        Parc p = newParc();
        Vehicule v = newVehicule("123AB45", Gabarit.CITADINE);
        assertTrue(ajouter(p, v));
        assertEquals(1, p.nbVehicules);
        assertEquals(v, p.vehicules[0]);
    }

    String toString(Parc p){
        String result = "";
        for(int i = 0; i < p.nbVehicules; i++){
            result = result + toString(p.vehicules[i]) + "\n";
        }
        return result;
    }

    void testToStringParc(){
        Parc p = newParc();
        Vehicule v1 = newVehicule("309DF21", Gabarit.CITADINE);
        Vehicule v2 = newVehicule("204XZ99", Gabarit.SUV);
        ajouter(p, v1);
        ajouter(p, v2);
        assertEquals("CITADINE (309DF21)\nSUV (204XZ99)\n", toString(p));
    }

    int nbVoitures(Parc p, Gabarit g){
        int count = 0;
        for(int i = 0; i < p.nbVehicules; i++){
            if(p.vehicules[i].gabarit == g){
                count++;
            }
        }
        return count;
    }

    boolean fusionParcs(Parc p1, Parc p2){
        int placesDisponibles = NB_MAX - p1.nbVehicules;
        int nbATransferer;
        
        if(placesDisponibles < p2.nbVehicules){
            nbATransferer = placesDisponibles;
        } else {
            nbATransferer = p2.nbVehicules;
        }
        
        for(int i = 0; i < nbATransferer; i++){
            p1.vehicules[p1.nbVehicules] = p2.vehicules[i];
            p1.nbVehicules++;
        }
        
        for(int i = 0; i < p2.nbVehicules - nbATransferer; i++){
            p2.vehicules[i] = p2.vehicules[i + nbATransferer];
        }
        p2.nbVehicules = p2.nbVehicules + nbATransferer;
        
        return nbATransferer == p2.nbVehicules;
    }


    boolean enlever(Parc p, String immatriculation){
        int index = -1;
        for(int i = 0; i < p.nbVehicules; i++){
            if(equals(p.vehicules[i].immatriculation, immatriculation)){
                index = i;
            }
        }
        
        if(index == -1){
            return false;
        }

        for(int i = index; i < p.nbVehicules - 1; i++){
            p.vehicules[i] = p.vehicules[i + 1];
        }
        p.nbVehicules--;
        
        return true;
    }
}