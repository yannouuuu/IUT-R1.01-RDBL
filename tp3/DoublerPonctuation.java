class DoublerPonctuation extends Program {
    void algorithm() {
     // TODO: implement the algorithm
        String str = readString();
        String result = "";
        for(int i = 0; i < length(str); i++){
            char c = charAt(str, i);
            if(c == '?' || c == '!'){
                char temp = c;
                result = result + c + temp; 
            } else {
                result = result + c;
            }
        }

        print(result);
    }
}
