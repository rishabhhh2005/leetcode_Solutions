// https://leetcode.com/problems/detect-squares/description/
// Detect Squares
// Approach:
// We store all added points and their frequency in a map.
// For a given query point, we try every existing point as a diagonal of a square
// and check if the other two required points exist using the frequency map.
class DetectSquares {
    Map<List<Integer>, Integer> pts_Freq;
    List<List<Integer>> pts;

    public DetectSquares() {
        pts_Freq = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        pts_Freq.put(p, pts_Freq.getOrDefault(p, 0) + 1);
        pts.add(p);
    }
        
    public int count(int[] point) {
        int res = 0;
        int px = point[0];   int py = point[1];

        for (List<Integer> pt : pts) {
            int x = pt.get(0);
            int y = pt.get(1);

            // Valid square condition:
            // 1. Side lengths equal (diagonal property)
            // 2. Not same x or same y (avoid line case)
            if (Math.abs(px - x) != Math.abs(py - y) || px == x || py == y)
                continue;

            // Multiply frequencies of the other two required corners
            res += pts_Freq.getOrDefault(Arrays.asList(x, py), 0) *
                   pts_Freq.getOrDefault(Arrays.asList(px, y), 0);
        }

        return res;
    }
}