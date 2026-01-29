// https://leetcode.com/problems/kth-largest-element-in-an-array/
// Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // approach using Heap  -> Make it max heap + then while(k-- >0) extract the first elem ie max

        //convert to maxheap
        //heapify from n/2
        int n = nums.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(nums, i,n);
        }        
        //converted to max heap succesfully
        int heapSize =n;
        while(k -- >1){
            extract(nums , heapSize);
            heapSize--;
          
        }
        return extract(nums, heapSize);
    }
    public void heapify(int[] nums , int node, int n){
        int largest = node;
        int left = 2*node+1;
        int right = 2*node+2;

        if(left < n && nums[left] > nums[largest]) largest = left;
        if(right <n && nums[right] > nums[largest]) largest = right;


        if(largest != node){
            int temp = nums[node];
            nums[node] = nums[largest];
            nums[largest] = temp;

            heapify(nums,largest , n);
        }

    }
    public int extract(int[] heap , int size){
        if(size <= 0) return-1;
        int max = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(heap,0, size);
        return max;
    
    }
}