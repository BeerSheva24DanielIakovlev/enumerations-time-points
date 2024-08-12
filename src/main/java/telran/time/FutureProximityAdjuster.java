package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster {
    TimePoint[] timePoints;


    public FutureProximityAdjuster(TimePoint[] timePoints) {
            this.timePoints = Arrays.copyOf(timePoints, timePoints.length);
            Arrays.sort(this.timePoints);
        //copy a given array
        //sort copy and assign to the field timePoints
        //using Java standart Arrays class
        //repeat time points are possible 
    }

    public TimePoint[] getSortedTimePoints() {
        return timePoints;
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
        //returns a time point omly in future (greater than a given time point) from the field timePoints 
        //nearest to a given timePoint
        int start = 0;
        int finish = timePoints.length - 1;
        int res = -1;

        while (start <= finish) {
            int middle = start + (finish - start) / 2;
            if (timePoints[middle].compareTo(timePoint) > 0) {
                res = middle;
                finish = middle -1;
            } 
            else {
                start = middle +1;
            }
        }

        return res != -1 ? timePoints[res] : null;
    }
}
