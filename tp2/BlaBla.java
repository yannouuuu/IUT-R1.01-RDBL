public class BlaBla extends Program{
    void algorithm(){
        String mot = readString();
        int idxMid = length(mot) / 2;
        String firstPart = substring(mot, 0, idxMid);
        String secondPart = substring(mot, idxMid, length(mot));

        boolean concordance = equals(firstPart, secondPart);

        println(mot + " = " + concordance);
    }
}
