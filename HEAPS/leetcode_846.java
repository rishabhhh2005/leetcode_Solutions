// https://leetcode.com/problems/hand-of-straights/description/
// Hand of Straights

class Solution {
    public boolean isNStraightHand(int[] hand, int gpsize) {

        int l = hand.length;
        // Agar total cards group size se divisible nahi hain → impossible
        if (l % gpsize != 0) return false;

        // Frequency map banaya
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // Min-heap jo smallest card pehle de
        PriorityQueue<int[]> minheap =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Heap me {card, frequency} daala
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minheap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // Jab tak heap empty nahi hoti, groups banate raho
        while (!minheap.isEmpty()) {

            // Temporary list jisme leftover cards store honge
            List<int[]> temp = new ArrayList<>();

            // Sabse chhota card group ka start hoga
            int[] first = minheap.poll();
            int start = first[0];

            // gpsize length ka consecutive group banana hai
            for (int i = 0; i < gpsize; i++) {

                // Agar mid-group me heap khali ho gayi → invalid
                if (minheap.isEmpty() && i > 0) return false;

                // Pehla element already nikala hua hai
                int[] curr = (i == 0) ? first : minheap.poll();

                // Consecutive check: start, start+1, start+2 ...
                if (curr[0] != start + i) return false;

                // Card use ho gaya → frequency kam
                curr[1]--;

                // Agar abhi bhi bacha hai to baad me wapas heap me daalenge
                if (curr[1] > 0) temp.add(curr);
            }

            // Jo cards bache unko heap me wapas daalo
            for (int[] arr : temp) {
                minheap.offer(arr);
            }
        }

        // Agar sab groups ban gaye → true
        return true;
    }
}
