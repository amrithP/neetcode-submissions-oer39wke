class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1C = new int[26];
        int[] window = new int[26];

        // first window
        for (int i = 0; i < s1.length(); i++) {
            s1C[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        // check first window
        if (Arrays.equals(s1C, window)) {
            return true;
        }

        // slide window
        for (int i = s1.length(); i < s2.length(); i++) {
            
            // add new character
            window[s2.charAt(i) - 'a']++;

            // remove old character
            window[s2.charAt(i - s1.length()) - 'a']--;

            // check EVERY window
            if (Arrays.equals(s1C, window)) {
                return true;
            }
        }

        return false;
    }
}