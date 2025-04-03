class Solution {
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Extract the palindrome found
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }

            // Even-length palindrome
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }
}