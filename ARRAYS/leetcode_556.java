// https://leetcode.com/problems/next-greater-element-iii/
// Next Greater Element III
class Solution { // Same Approach hai Next Permutation KI
    boolean cantfind = false;
    public int nextGreaterElement(int n) {
        if(n>= Integer.MAX_VALUE) return -1;
        int c = 0;
        int temp =n;
        while(temp>0){
            temp= temp/10;
            c++;
        }
        int[] arr = NumbertoArray(n,c);
        nextPermutation(arr);
        if(cantfind) return -1;
        int x = ArrayToNumber(arr);
        return x;
        
        
    }
    public int ArrayToNumber (int[]arr){
        long sum =0;
        for(int x : arr) sum= sum*10+x;
        if(sum > Integer.MAX_VALUE) return -1;
        return (int)sum;
    }
    public int[] NumbertoArray(int x, int len){
        
        int[] res = new int[len];
        int index = res.length-1;
        while(x > 0){
            res[index -- ] = x%10;
            x=x/10;
        }
        return res;

    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot =-1;
        // we need to find the element drop  from LEFT  TO RIGHT

        for(int i= n-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                pivot = i-1;
                break;
            }
        }
        if(pivot < 0) {
            cantfind = true;
            return;
        }

        // now right se first elem > pivot is the elem to swap
        int j = n-1;
        while( j>=0 && nums[j] <= nums[pivot]) j--;
        // now swap
        int temp = nums[pivot];
        nums[pivot] = nums[j];
        nums[j] = temp;
        // not just reverse after pivot
        int left = pivot +1 ;  int right = n-1;
        while(left < right){
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;

            left++;
            right--;
        }

        return ;
        
    }
}