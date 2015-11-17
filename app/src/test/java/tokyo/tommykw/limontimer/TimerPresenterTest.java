package tokyo.tommykw.limontimer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import tokyo.tommykw.limontimer.presenter.TimerPresenter;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class TimerPresenterTest {
    private TimerPresenter p;

    @Before
    public void setUp() {
        p = TimerPresenter.newInstance(5000, 1);
    }

    @Test
    public void timerStartTest() throws Exception {
        p.setTimerListener(new TimerPresenter.TimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                assertEquals(p.getCurrentTime(), 0);
            }
        });
        p.startTimer();
    }
}