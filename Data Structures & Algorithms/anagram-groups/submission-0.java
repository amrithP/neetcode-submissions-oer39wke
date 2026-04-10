class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs==null || strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
                 String freqString = getFreqString(str);

                 if(map.containsKey(freqString)){
                    map.get(freqString).add(str);
                 }
                 else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(str);//adding original values
                    map.put(freqString,list);
                 }
        }
             return new ArrayList<>(map.values());
    }
    public String getFreqString(String str){
        int[] freq = new int[26];

        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder builder = new StringBuilder(" ");
        char c='a';
        for(int i:freq){
            builder.append(c);
            builder.append(i);
            c++;
        }
        return builder.toString();
    }
}
