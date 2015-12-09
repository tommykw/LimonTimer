package tokyo.tommykw.limontimer.data;

import rx.Observable;
import rx.functions.Func0;

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
            return Optional.empty();
        } else {
            return Observable.just(data);
        }
    }

    public static <T> Observable<T> empty() {
        return Observable.empty();
    }

    public static <T> boolean isPresent(Observable<T> observable) {
        return observable.isEmpty().toBlocking().single();
    }

    public static <T> T get(Observable<T> observable) {
        return observable.toBlocking().single();
    }

    public static <T> T orElse(Observable<T> observable, T defaultValue) {
        return observable.defaultIfEmpty(defaultValue).toBlocking().single();
    }

    public static <T> T orElseGet(Observable<T> observable, Func0<T> other) {
        return isPresent(observable) ? get(observable) : other.call();
    }

    public static <T, X extends Throwable> T orElseThrow(Observable<T> observable, Func0<? extends X> other) throws X {
        if (isPresent(observable)) {
            return get(observable);
        } else {
            throw other.call();
        }
    }
}


