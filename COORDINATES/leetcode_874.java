// https://leetcode.com/problems/walking-robot-simulation/description/
// Walking Robot Simulation
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // firstly Store obstacles in a set for fast retrieval
        // We are storing String set instead of int because of reference equality check by Set
        Set<String> set  = new HashSet<>();
        for(int[] ob : obstacles){
            set.add(ob[0] + "," + ob[1]);
        }
        int max =0;
        //initial start
        int x =0;  int y=0;

        //directions
        int dir =0;  // 0->N , 1->E , 2->S, 3->W
        int[][] dirs = { {0,1}, {1,0}, {0,-1} , {-1,0}};

        for(int c : commands){
            // move direction to forward by 1
            if( c == -1) dir = (dir+1)%4;  
            
             // move direction to backward by 1 is equivalent to moving forward by 3
            else if( c == -2) dir =(dir+3)%4; 
           
            else{  //move robot

                for(int i=0;i<c;i++){ // try moving by 1 unit per step to check for obstacle
                    int nx = x + dirs[dir][0];
                    int ny =  y + dirs[dir][1];

                    // We cannot move further if the next is obstacle, so break
                    if(set.contains(nx + "," +  ny)) break; 
                    x = nx;
                    y= ny;
                     max = Math.max(max, (x*x)+(y*y));
                }
            }
        }        
        return max;
    }
}