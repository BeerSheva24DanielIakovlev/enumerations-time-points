package telran.time;

public class FutureProximityAdjuster implements TimePointAdjuster {
    private TimePoint[] timePoints;
    public FutureProximityAdjuster(TimePoint[] timePoints) {
        //TODO
        //copy a given array
        //sort copy and assign to the field timePoints
        //using Java standart Arrays class
        //repeat time points are possible 
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
        //TODO 
        //returns a time point omly in future (greater than a given time point) from the field timePoints 
        //nearest to a given timePoint
        return null; 
    }
}
