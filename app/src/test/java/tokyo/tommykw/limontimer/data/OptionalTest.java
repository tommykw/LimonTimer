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
            Observable<String> observable = Optional.of("Timer");
            observable.map(value -> value.toUpperCase())
                    .subscribe(val -> assertThat(val, is("TIMER")));
        }

        {
            Observable<Integer> observable = Optional.of(1);
            observable.subscribe(value -> assertThat(1, is(1)));
        }
    }

    @Test
    public void ofNullableTest() throws Exception {
        {
            Observable<Integer> observable = Optional.ofNullable(null);
            observable.subscribe(value -> assertNotNull(value));
        }

        {
            Observable<Integer> observable = Optional.ofNullable(1);
            observable.subscribe(value -> assertThat(value, is(1)));
        }

        {
            Observable<String> observable = Optional.ofNullable("Timer");
            observable.subscribe(value -> assertThat(value, is("Timer")));
        }
    }

    @Test
    public void getTest() throws Exception {
        {
            Observable<String> observable = Optional.of("Timer");
            assertThat(Optional.get(observable), is("Timer"));
        }

        {
            Observable<Boolean> observable = Optional.of(Boolean.TRUE);
            assertTrue(Optional.get(observable));
        }
    }

    @Test
    public void orElseTest() throws Exception {
        {
            Observable<String> observable = Optional.ofNullable(null);
            assertThat(Optional.orElse(observable, "default"), is("default"));
        }

        {
            Observable<String> observable = Optional.of("Timer");
            assertThat(Optional.orElse(observable, "default"), is("Timer"));
        }
    }
}
