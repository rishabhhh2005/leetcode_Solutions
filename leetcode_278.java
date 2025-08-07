//                                                        LeetCode 278 - First Bad Version
//                                                      https://leetcode.com/problems/first-bad-version/


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

  class Solution  {
    public int firstBadVersion(int n) {
        int low =1;
        int high =n;

        while(low<=high){
            int mid = low + (high -low)/2;

            if(isBadVersion(mid) ==true ){
                //go back
                high=mid-1;
            }
            else if(!isBadVersion(mid)){
                //bad version not found yet
                low=mid+1;
            }

        }

        //low is the bad version
        return low;
        
    }
}
//here do not directly copy paste it 
//in the place of class Solution you have to write public class Solution extends VersionControl because it is mentioned there in leetcode