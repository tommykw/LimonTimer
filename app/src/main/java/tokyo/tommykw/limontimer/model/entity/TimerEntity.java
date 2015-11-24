package tokyo.tommykw.limontimer.model.entity;

/**
 * Created by tommy on 15/11/21.
 */
public class TimerEntity {
    public long currentTime;
    public String buttonText;
    public TimerEntity(long currentTime, String buttonText) {
        this.currentTime = currentTime;
        this.buttonText = buttonText;
    }

    public int getPrettyTime() {
        return (int)(currentTime / 1000);
    }
}
