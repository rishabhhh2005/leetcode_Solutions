//                                             3110. Score of Strings
//                              https://leetcode.com/problems/score-of-strings/description/
class Solution {
    public int scoreOfString(String s) {
    
    int score =0;
    char[]str = s.toCharArray();

    int[]scores = new int[str.length];

    for(int i=0;i<scores.length;i++){
        int value = str[i];
        scores[i] = value;
    }
    int pt1=0;
    int pt2=1;
    while(pt2 < scores.length){
        int toadd = Math.abs(scores[pt1]-scores[pt2]);
        score+=toadd;

        pt1++;
        pt2++;

    }


    return score;

    }
}