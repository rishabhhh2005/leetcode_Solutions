class SegmentTree{
    int[] tree;
    
    SegmentTree(int[] arr , int n){
        this.tree = new int[4*n];
        buildTree(0,0,n-1,arr);
     
    }
    public void buildTree(int node , int left , int right , int[] arr){
        if(left ==  right){
            tree[node] = arr[left];
            return;
        }
        
        int mid = (left+right)/2;
        
        buildTree(2*node+1 ,left , mid,arr);
        buildTree(2*node+2 , mid+1 , right , arr);
        
        tree[node] = tree[2*node+1] +  tree[2*node+2];
        
    }
    public void update(int indextoUpdate , int updatedVal, int root, int left, int right ){
        if(left == right){
            tree[root] = updatedVal;
            return;
        }
        int mid = (left +  right)/2;
        if(indextoUpdate <= mid) update(indextoUpdate, updatedVal , 2*root+1 , left, mid);
        else update(indextoUpdate , updatedVal , 2*root+2, mid+1 , right);
        
        tree[root] = tree[2*root+1] + tree[2*root+2];
        
        
    }
    public int query(int root ,int segLeft , int segRight , int qLeft , int qRight){

        if(segRight < qLeft || segLeft > qRight) return 0; // case 1.. Non Overlapping Intervals

        if(qLeft <= segLeft && segRight <= qRight) return tree[root]; // case 2.. Complete Overlap
        //We check if the segment lies fully inside the query.

       int mid = (segLeft + segRight) / 2;

        int leftChild = query(2*root+1 ,segLeft  ,mid, qLeft, qRight);
        int rightChild = query(2*root+2 ,mid+1, segRight , qLeft , qRight);
        return leftChild + rightChild;
    }
}

class NumArray {
    int[] nums;
    SegmentTree tree;
    public NumArray(int[] nums) {
        this.nums =  nums;
        tree = new SegmentTree(nums , nums.length);
        
    }
    
    public void update(int index, int val) {
        tree.update(index,val,0,0,nums.length-1);
        
    }
    
    public int sumRange(int left, int right) {
        return tree.query(0,0,nums.length-1,left,right);
        
    }
}
