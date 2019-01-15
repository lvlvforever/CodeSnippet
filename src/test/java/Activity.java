import java.util.Comparator;

/**
 * Description:
 * User: daipeng
 * Date: 2018-12-18 14:26
 * Project:CodeSnippet
 */

public class Activity implements Comparable<Activity>{
    public String startTime;

    @Override
    public int compareTo(Activity o) {
        return this.startTime.compareTo(o.startTime);
    }
    public static class SortByStartTime implements Comparator<Activity> {
        private int order;

        public SortByStartTime(int order) {
            this.order = order;
        }
        @Override
        public int compare(Activity o1, Activity o2) {
            if (order > 0) {
                return o1.startTime.compareTo(o2.startTime);
            }else {
                return o2.startTime.compareTo(o1.startTime);
            }
        }
    }

}
