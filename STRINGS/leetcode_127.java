// https://leetcode.com/problems/word-ladder/
// Word Ladder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Approach: BFS use karte hain kyunki har word ek node hai, ek character change = ek edge,
// aur shortest transformation (minimum steps) BFS se level-by-level milta hai


        Set<String> set = new HashSet(wordList); // fast lookup + visited tracking
        if(!set.contains(endWord)) return 0;     // endWord hi nahi hai → answer 0

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);                      // BFS start

        int level = 1;                           // current transformation length

        while(!q.isEmpty()){
            int size = q.size();                 // ek BFS level me jitne words

            for(int x = 0; x < size; x++){
                String curr = q.poll();

                if(curr.equals(endWord))         // pehli baar mila = shortest path
                    return level;

                // har position par ek-ek character change kar rahe
                for(int i = 0; i < curr.length(); i++){
                    for(int j = 0; j < 26; j++){
                        // sirf i-th index ka character change
                        String newWord =
                            curr.substring(0, i) +
                            (char)('a' + j) +
                            curr.substring(i + 1);

                        // agar valid word hai aur pehle use nahi kiya
                        if(set.contains(newWord)){
                            q.offer(newWord);    // next BFS level ke liye
                            set.remove(newWord); // visited mark
                        }
                    }
                }
            }
            level++; // ek full level complete → step +1
        }
        return 0; // transformation possible nahi
    }
}
