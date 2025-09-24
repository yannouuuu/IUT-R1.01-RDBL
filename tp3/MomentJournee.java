public class MomentJournee extends Program {

    void algorithm() {
        print("Saisir une heure: ");
        // à compléter /* TODO: Complete this */
        int h = readInt();
        String err = "erreur";
        String morning = "matinée";
        String jsplus = "après-midi";
        String midnight = "soirée";
        String night = "nuit";

        if(h >= 0 && h <= 23){
            if(h >= 0 && h < 6 || h == 23){ // night
                println(night);
            } else if(h >= 6 && h < 12){ // morning
                println(morning);
            } else if(h >= 12 && h < 18){ // après-midi
                println(jsplus);
            } else { // soirée
                println(midnight);
            }
        } else {
            println(err);
        }
    
    }
}
