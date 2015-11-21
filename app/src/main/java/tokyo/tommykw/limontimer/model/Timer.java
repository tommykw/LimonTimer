package tokyo.tommykw.limontimer.model;

/**
 * Created by tommy on 15/11/21.
 */
public class Timer {
    public long currentTime;
    public String buttonText;
    public Timer(long currentTime, String buttonText) {
        this.currentTime = currentTime;
        this.buttonText = buttonText;
    }

    public int getPrettyTime() {
        return (int)(currentTime / 1000);
    }
}
