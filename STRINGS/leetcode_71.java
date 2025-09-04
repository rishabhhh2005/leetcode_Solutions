//                                                                71. Simplify Path
//                                              https://leetcode.com/problems/simplify-path/description/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[]directories = path.split("/");

        for(String dir : directories){

            if(dir.isEmpty() || dir.equals(".")) continue;

            else if( dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }

            }
            else{
                stack.push(dir);
            }

        }
        String arr[] = new String[stack.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i] = stack.pop();
        }
        StringBuilder result = new StringBuilder("/");
       
        for(int i =0;i<arr.length;i++){
             result.append(arr[i]);
             if(i!=arr.length-1) result.append('/');
        }
        return result.toString();

        

        
        
    }
}