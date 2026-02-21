// https://leetcode.com/problems/meeting-rooms/description/ 
// Meeting Rooms
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        Collections.sort(intervals , (a,b)->
        a.start - b.start
    );

    Interval prev = intervals.get(0);
    for(int i =1;i<intervals.size();i++){
        Interval curr = intervals.get(i);
        if(curr.start < prev.end) return false;
        prev = curr;
    }
    return true;

    }
}
