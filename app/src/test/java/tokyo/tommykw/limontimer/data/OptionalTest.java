package tokyo.tommykw.limontimer.data;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import rx.Observable;

/**
 * Created by tommy on 15/12/08.
 */
public class OptionalTest {
    @Test
    public void ofTest() throws Exception {
        {
            Observable<String> observable = Optional.of("hoge");
            observable.map(value -> value.toUpperCase())
                    .subscribe(val -> assertThat(val, is("HOGE")));
        }

        {
            Observable<Integer> observable = Optional.of(1);
            observable.subscribe(value -> assertThat(1, is(1)));
        }
    }

    @Test
    public void ofNullableTest() throws Exception {
        Observable<Integer> observable = Optional.ofNullable(null);
        observable.subscribe(value -> assertNull(value));
    }
}
