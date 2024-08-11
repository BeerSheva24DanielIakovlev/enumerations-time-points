package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TimePointUnitTest {

    @Test
    void betweenTest() {
        TimePoint p1 = new TimePoint(60, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(30,TimeUnit.SECOND);
        assertEquals(30, TimeUnit.SECOND.between(p2, p1));
    }

    @Test
    void compareToTest() {
        TimePoint p1 = new TimePoint(10, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(10, TimeUnit.SECOND);
        TimePoint p3 = new TimePoint(1, TimeUnit.MINUTE);
        TimePoint p4 = new TimePoint(1, TimeUnit.SECOND);
        assertEquals(0, p1.compareTo(p2));
        assertEquals(1, p1.compareTo(p3));
        assertEquals(-1, p1.compareTo(p4));

    }

    @Test
    void equalsTest() {
        TimePoint p1 = new TimePoint(60, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(60, TimeUnit.SECOND);
        TimePoint p3 = new TimePoint(2, TimeUnit.MINUTE);
        TimePoint p4 = new TimePoint(1, TimeUnit.MINUTE);
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertTrue(p1.equals(p4));
    }

    @Test
    void convertTest() {
        TimePoint p1 = new TimePoint(60, TimeUnit.SECOND);
        TimePoint conv1 = p1.convert(TimeUnit.SECOND);
        TimePoint conv2 = p1.convert(TimeUnit.MINUTE);
        assertEquals(p1, conv1);
        assertEquals(p1, conv2);
    }

    @Test
    public void futureProximityAdjusterTest() {
        TimePoint[] timePoints = {new TimePoint(20, TimeUnit.SECOND),new TimePoint(1, TimeUnit.HOUR),new TimePoint(10, TimeUnit.SECOND)};
        TimePoint p1 = new TimePoint(5, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(20, TimeUnit.MINUTE);
        TimePoint p3 = new TimePoint(2, TimeUnit.HOUR);
        FutureProximityAdjuster futureProximityAdjuster = new FutureProximityAdjuster(timePoints);
        TimePoint res1 = futureProximityAdjuster.adjust(p1);
        TimePoint res2 = futureProximityAdjuster.adjust(p2);
        TimePoint res3 = futureProximityAdjuster.adjust(p3);
    
        assertEquals(p1, res1);
        assertEquals(p2, res2);
        assertEquals(null, res3);
    }
}

    

    

    
