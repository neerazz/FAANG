import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Created on:  Nov 12, 2020
 * Questions: https://leetcode.com/discuss/interview-question/566978/Micorsoft-onsite.
 */

public class StopWatchImplementation {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        System.out.println(LocalDateTime.now() + "\tStart");
        stopWatch.start();
        Thread.sleep(200);
        System.out.println("stopWatch.getTime() = " + stopWatch.getTime());
        System.out.println(LocalDateTime.now() + "\tEnd");
        System.out.println("stopWatch.stop() = " + stopWatch.stop());
    }

    static class StopWatch {
        Long start, end;

        public void start() {
            start = System.currentTimeMillis();
        }

        public long stop() {
            end = System.currentTimeMillis();
            return getTime();
        }

        private long getTime() {
            return end == null ? System.currentTimeMillis() - start : end - start;
        }
    }
}
