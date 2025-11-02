// https://leetcode.com/problems/next-greater-element-ii/description/
// Next Greater Element II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0) return new int[0];

        Stack<Integer> backupStack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--){
            backupStack.push(nums[i]);
        }
        
        Stack<Integer> saveGreater = new Stack<>();
        int[] res = new int[nums.length];
        int pointer = nums.length - 1;
        
        while(pointer >= 0){
            int curr = nums[pointer];
            
            if(saveGreater.isEmpty()){
                while(!backupStack.isEmpty() && !(backupStack.peek() > curr)){
                    backupStack.pop();
                }
                
                if(backupStack.isEmpty()){
                    // refill for circular nature
                    for(int i = nums.length - 1; i >= 0; i--){
                        backupStack.push(nums[i]);
                    }
                    
                    while(!backupStack.isEmpty() && !(backupStack.peek() > curr)){
                        backupStack.pop();
                    }
                }
                
                if(backupStack.isEmpty()){
                    res[pointer] = -1;
                } else {
                    res[pointer] = backupStack.peek();
                }
                
                saveGreater.push(curr);
                pointer--;
                continue;
            }
            else{
                while(!saveGreater.isEmpty() && !(saveGreater.peek() > curr)){
                    saveGreater.pop();
                }
                
                if(saveGreater.isEmpty()){
                    while(!backupStack.isEmpty() && !(backupStack.peek() > curr)){
                        backupStack.pop();
                    }
                    
                    if(backupStack.isEmpty()){
                        for(int i = nums.length - 1; i >= 0; i--){
                            backupStack.push(nums[i]);
                        }
                        
                        while(!backupStack.isEmpty() && !(backupStack.peek() > curr)){
                            backupStack.pop();
                        }
                    }
                    
                    if(backupStack.isEmpty()){
                        res[pointer] = -1;
                    } else {
                        res[pointer] = backupStack.peek();
                    }
                }
                else{
                    res[pointer] = saveGreater.peek();
                }
                
                saveGreater.push(curr);
                pointer--;
            }
        }
        
        return res;
    }
}
