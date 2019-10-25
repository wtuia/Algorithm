package lint_code.insert_interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Interval interval1 = new Interval(2, 3);
        Interval interval2 = new Interval(5, 9);
        Interval newInterval = new Interval(1, 1);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        List<Interval> newIntervals = new Solution().insert(intervals, newInterval);
        System.out.println(newIntervals);

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int newStart = newInterval.start, newEnd = newInterval.end, start, end;
        List<Interval> newIntervals = new ArrayList<>();
        Interval interval;
        for (int i = 0, len = intervals.size() ; i < len; i++) {
            interval = intervals.get(i);
            start = interval.start;
            end = interval.end;
            if (newStart > end) {
                newIntervals.add(interval);
                continue;
            }
            if (newStart <= start) {
                if (newEnd < start) { // 如果在該區間之前
                    Interval insetInterval = new Interval(newStart, newEnd);
                    newIntervals.add(insetInterval);
                    setOther(intervals, newIntervals, i);
                    return newIntervals;
                }
                if (newEnd == start || newEnd <= end) { // 為該區間的子區間，或左重合
                    Interval insetInterval = new Interval(newStart, end);
                    newIntervals.add(insetInterval);
                    setOther(intervals, newIntervals, i + 1);
                    return newIntervals;
                }
                 // 該區間為子區間
                checkEndAndSet(intervals, newIntervals, i + 1, newStart ,newEnd);
                return newIntervals;
            }
            if (newEnd > end) { // 與該區間右重合
                checkEndAndSet(intervals, newIntervals, i + 1, start, newEnd);
                return newIntervals;
            }
            // 為該區間子區間
            setOther(intervals, newIntervals, i);
            return newIntervals;
        }
        // 在所有區間之後
        Interval insetInterval = new Interval(newStart, newEnd);
        newIntervals.add(insetInterval);
        return newIntervals;
    }

    private void checkEndAndSet(List<Interval> intervals, List<Interval> newIntervals,
                                int index, int start, int newEnd) {
        Interval interval;
        int end;
        for (int i = index, len = intervals.size() ; i < len; i++) {
            interval = intervals.get(i);
            if (interval.start > newEnd) { // 在該區間之前
                Interval newInterval = new Interval(start, newEnd);
                newIntervals.add(newInterval);
                setOther(intervals, newIntervals, i);
                return;
            }
            end = interval.end;
            if (newEnd <= end) { // 與該區間左重合
                Interval newInterval = new Interval(start, end);
                newIntervals.add(newInterval);
                setOther(intervals, newIntervals, i + 1);
                return;
            }
            // 該區間為子區間,繼續往後查找
        }
        // 所有區間都是子區間
        Interval newInterval = new Interval(start, newEnd);
        newIntervals.add(newInterval);
    }


    private void setOther(List<Interval> intervals, List<Interval> newIntervals, int index) {
        for (int i = index, len = intervals.size(); i < len; i++) {
            newIntervals.add(intervals.get(i));
        }
    }
}
