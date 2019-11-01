package ch.noseryoung;

import java.time.Duration;
import java.time.Instant;

/**
 * The Stopwatch class is basically just to stop the time to know how long it took the user to solve the exercises.
 * I copied this class from the internet and deleted the parts i didn't need that's why i linked the site as an author
 *
 * @author https://stackoverflow.com/questions/8255738/is-there-a-stopwatch-in-java/8255766#8255766
 */
public class StopWatch {
    private Instant startTime;
    private Duration duration;
    private boolean isRunning = false;

    public void start() {
        if (isRunning) {
            throw new RuntimeException("Stopwatch is already running.");
        }
        this.isRunning = true;
        startTime = Instant.now();
    }

    public Duration stop() {
        Instant endTime = Instant.now();
        if (!isRunning) {
            throw new RuntimeException("Stopwatch has not been started yet");
        }
        isRunning = false;
        Duration result = Duration.between(startTime, endTime);
        if (this.duration == null) {
            this.duration = result;
        } else {
            this.duration = duration.plus(result);
        }
        return this.getElapsedTime();
    }

    public Duration getElapsedTime() {
        return this.duration;
    }
}
