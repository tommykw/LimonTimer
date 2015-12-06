package tokyo.tommykw.limontimer.model.repository;

import javax.inject.Inject;

import rx.Observable;
import tokyo.tommykw.limontimer.model.entity.TimerEntity;
import tokyo.tommykw.limontimer.model.storage.TimerStorage;

/**
 * Created by tommy on 15/11/24.
 */
public class TimerRepository {
    @Inject
    public TimerStorage timerStorage;

    public TimerStorage getTimerStorage() {
        return this.timerStorage;
    }

    public void setTimerStorage(long startTime) {
        timerStorage.setStartTime(startTime);
    }
}
