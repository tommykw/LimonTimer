package tokyo.tommykw.limontimer.model.storage;

import java.util.Map;

import rx.Observable;

/**
 * Created by tommy on 15/11/24.
 */
public interface Storager {
    Observable<Void> saveTimer(Map<String, String> query);
    Observable<TimerStorage> getTimer();
}
