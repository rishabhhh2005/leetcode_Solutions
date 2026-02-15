// https://leetcode.com/problems/house-robber-iii/description/
// House Robber III
class Solution {

    public int rob(TreeNode root) {
        // Agar tree empty hai toh paisa 0
        if(root == null) return 0;

        // Har node se 2 cheeze milengi:
        // index 0 -> notRob (agar is node ko loot nahi kiya)
        // index 1 -> rob (agar is node ko loot kiya)
        int[] ans = houserobber(root);

        // Root pe final decision:
        // ya toh loot lo ya skip karo — jo max ho
        return Math.max(ans[0], ans[1]);
    }

    public int[] houserobber(TreeNode root){

        // Base case: null node -> {0,0}
        // na loot sakte, na paisa milega
        if(root == null) return new int[2];

        // Left subtree ka result
        int[] left = houserobber(root.left);

        // Right subtree ka result
        int[] right = houserobber(root.right);

        // Agar current node ko loot liya:
        // toh direct children ko nahi loot sakte
        // isliye unka notRob (index 0) add karenge
        int rob = root.val + left[0] + right[0];

        // Agar current node ko skip kiya:
        // toh children ko loot bhi sakte ya skip bhi
        // isliye unka max le lo
        int norob = Math.max(left[0], left[1]) 
                  + Math.max(right[0], right[1]);

        // Return pair:
        // index 0 -> notRob
        // index 1 -> rob
        return new int[]{norob, rob};
    }
}
