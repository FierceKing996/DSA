class Solution {
    public int alternateDigitSum(int n) {
        String str = Integer.toString(n);
        int sum = 0;
        for(int i =0;i<str.length();i++){
            if(i==0 || i%2==0){
                sum+= Integer.parseInt(String.valueOf(str.charAt(i)));
            }else{
                sum -= Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sum;
    }
}