package telran.time;

public class TimePoint implements Comparable<TimePoint> {
    private float amount;
    private TimeUnit timeUnit;

    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }

    @Override
    public int compareTo(TimePoint o) {
        float currentValue = this.amount * this.timeUnit.getValueOfSeconds();
        float otherValue = o.amount * o.timeUnit.getValueOfSeconds();

        return Float.compare(currentValue, otherValue);
    }

    public float getAmount() {
        return amount;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TimePoint anotherTimePoint = (TimePoint) obj;
        float currentValue = this.amount * this.timeUnit.getValueOfSeconds();
        float anotherValue = anotherTimePoint.amount * anotherTimePoint.timeUnit.getValueOfSeconds();

        return Float.compare(currentValue, anotherValue) == 0;
    }

    public TimePoint convert(TimeUnit timeUnit) {
        //TODO
        //returns new TimePoint object to use "this" object but with a given timeUnit
        float currentAmountToSecond = amount * this.timeUnit.getValueOfSeconds();
        float newAmount = currentAmountToSecond / timeUnit.getValueOfSeconds();

        return new TimePoint(newAmount, timeUnit);
    }

    public TimePoint with(TimePointAdjuster adjuster) {

        return adjuster.adjust(this);
    }

}
