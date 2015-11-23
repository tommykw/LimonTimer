package tokyo.tommykw.limontimer.model.storage;

import io.realm.RealmObject;

/**
 * Created by tommy on 15/11/23.
 */
public class TimerStorage extends RealmObject {
    private long currentTime;
    private long startTime;
    private boolean useNotification;

    public long getCurrentTime() {
        return currentTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public boolean isUseNotification() {
        return useNotification;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setUseNotification(boolean useNotification) {
        this.useNotification = useNotification;
    }
}
