class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
    
    int i = 0, n = s.length();
    int sign = 1, result = 0;

    // 1. Skip leading whitespaces
    while (i < n && s.charAt(i) == ' ') {
        i++;
    }
    
    // 2. Check for sign
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = (s.charAt(i) == '-') ? -1 : 1;
        i++;
    }
    
    // 3. Process digits and check for overflow preemptively
    while (i < n && Character.isDigit(s.charAt(i))) {
        int digit = s.charAt(i) - '0';
        
        // Check if result will overflow on adding this digit
        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        result = result * 10 + digit;
        i++;
    }
    
    return result * sign;
    }
}