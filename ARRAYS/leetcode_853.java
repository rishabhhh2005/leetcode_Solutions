// https://leetcode.com/problems/car-fleet/description/
// Car Fleet
class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        if(pos.length <=1 ) return pos.length;
        // time at which car will reach = (target - pos)/speed
        //We will store the car pos and the time it will reach in TreeMap to get them in desc order
        Map<Integer,Double> map = new TreeMap<>(Collections.reverseOrder());  
        for(int i =0 ;i <pos.length;i++)      map.put(pos[i] , (double)(target-pos[i]) / speed[i] );
        int carfleets =0;  double curr =0;
        for(double time : map.values()){
            if(time > curr){ // if any car requires more time than the prev one that means it will
                curr = time; // slow down and cause car fleet
                carfleets++;
            }
        }
        return carfleets;
    }
}