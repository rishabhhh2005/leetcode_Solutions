// https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/?envType=daily-question&envId=2026-05-08
// Minimum Jumps to Reach End via Prime Teleportation
class Solution {
    public int minJumps(int[] nums) {
        //This is a really good Question 
        // We have to create a Map and Find the Maximum element in array first
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max =nums[0];
        for(int i=0;i<n;i++){
            int curr = nums[i];
            int index =i;
            max = Math.max(max, curr);
            
            if(map.containsKey(curr)){
                map.get(curr).add(index);
            }
            else{
                map.put(curr , new ArrayList<>(Arrays.asList(index)));
            }
        }
        //Set To Avoid unecessary Recomputation of Prime values
        Set<Integer> usedPrime = new HashSet<>();

        // Now We have to do BFS along with a step count 
        // (Because  that will ensure that we get the minimum steps  at the end)
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] =true;
        int steps =0;
        while(!q.isEmpty()){  // BFS Start
            int size = q.size();
            for(int i=0;i<size;i++){
                int currIndex = q.poll();

                if(currIndex == n-1) return steps;  // return steps if we reach end

                // Now at every index we either move back || move front || check for prime
                if(currIndex-1 >=0 && !visited[currIndex-1]) {
                     visited[currIndex-1] = true;
                     q.offer(currIndex-1);
                }
                if(currIndex+1 < n && !visited[currIndex+1]) {
                     visited[currIndex+1] = true;
                     q.offer(currIndex+1);
                }
            // Prime Teleportation Logic
                if( isPrime(nums[currIndex]) && !usedPrime.contains(nums[currIndex])){
                    usedPrime.add(nums[currIndex]);
                    // if it is prime we need to check in map for every possible value we can go from here
                    // we will check multiple of curr number upto max and if they are present in array
                    // we might push them to the Queue
                    int currFactor = nums[currIndex];
                    int multiple =1; // starting from 1 , check all multiples
                    while(currFactor*multiple <= max){
                        int target = currFactor * multiple;
                        if(map.containsKey(target)){
                            for(int idxs : map.get(target)){
                                if(!visited[idxs]){
                                    visited[idxs] = true;
                                    q.offer(idxs);
                                }
                            }
                        }
                        multiple++;
                    }
                }
            }
            steps++;      
        }
        return -1; //return -1 if we never found end
        
        
    }
    // we will also need an isPrime Function to check for prime
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)  return false; // Found a divisor, so it's not prime
        }
        return true; 
    }   
}