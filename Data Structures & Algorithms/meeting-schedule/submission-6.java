class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.size(); i++) {

            // Current meeting starts before previous meeting ends
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }
}