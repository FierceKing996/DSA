class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int ans[] =new int[nums2.length];
        int[] result = new int[nums1.length];
        for(int i = nums2.length-1;i>=0;i--){
            while(!st.empty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.empty()){
                ans[i]=-1;
            }else{
                ans[i] = st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i = 0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++ ){
                if(nums1[i]==nums2[j]){
                    result[i]=ans[j];
                }
            }
        }
        return result;
    }
}