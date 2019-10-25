package lint_code.insert_interval;

public class Interval {
    public int start, end;

    public Interval(int start, int end) {
       this.start = start;
       this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
