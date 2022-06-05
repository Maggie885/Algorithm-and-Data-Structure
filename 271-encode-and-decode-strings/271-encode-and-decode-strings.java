class Codec{
    public String encode(List<String> strs){
        StringBuilder encodedString = new StringBuilder();
        
        for(String str:strs){
            int length = str.length();
            encodedString.append(length + "#");
            encodedString.append(str);
        }
        return encodedString.toString();
    }
    
     public List<String> decode(String str){
         List<String> decodedStrings = new ArrayList<>();
         
         for(int i=0; i<str.length(); i++){
             String length = "";     
             while(str.charAt(i)!='#'){
                 length += str.charAt(i);
                 i++;
             }
             int wordlength = Integer.parseInt(length);
             i++;
             
             String word = "";
             for(int j=i; j<wordlength+i; j++){
                 word += str.charAt(j);
             }
             decodedStrings.add(word);
             i = i + wordlength -1;
         }

         return decodedStrings;
     }
}