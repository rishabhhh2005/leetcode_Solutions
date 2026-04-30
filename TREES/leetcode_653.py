# https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
# Two Sum IV - Input is a BST
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        myset = set()
        return self.helper(root, k,myset)
        
    
    def helper(self , root , k, myset):
        if root is None: return False
        if(k - root.val) in myset : return True
        myset.add(root.val)
        bool1 =self.helper(root.left, k, myset)
        bool2 =self.helper(root.right, k, myset)
        
        return bool1 or bool2 or False

        