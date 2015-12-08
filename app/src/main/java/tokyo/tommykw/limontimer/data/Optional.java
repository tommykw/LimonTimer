package tokyo.tommykw.limontimer.data;

import rx.Observable;

/**
 * Created by tommy on 15/12/08.
 */
public class Optional {
    public static <T> Observable<T> of(T data) {
        if (data == null) {
            throw new NullPointerException();
        } else {
            return Observable.just(data);
        }
    }

    public static <T> Observable<T> ofNullable(T data) {
        if (data == null) {
            return Observable.empty();
        } else {
            return Observable.just(data);
        }
    }
}
