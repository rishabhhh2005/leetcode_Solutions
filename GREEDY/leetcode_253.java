// https://leetcode.com/problems/meeting-rooms-ii/
// Meeting Rooms II
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return  0;
        // Line Sweep Trick
        List<int[]> events  = new ArrayList<>();

        for(Interval i : intervals){
            int a = i.start;
            events.add( new int[]{a,1});
            int b = i.end;
            events.add( new int[]{b,-1});
        }
        Collections.sort(events, (a,b)-> {
            if(a[0] == b[0]) return a[1] -b[1];
            return a[0] -b[0];
        });

        int overlaps=0;
        int maxoverlaps = overlaps;

        for(int[] e : events){
            maxoverlaps = Math.max(maxoverlaps , overlaps);
            if(e[1] == 1) overlaps++;
            else overlaps--;
        }
        return maxoverlaps;

    }
}
