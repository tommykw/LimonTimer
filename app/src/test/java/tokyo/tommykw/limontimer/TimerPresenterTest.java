package tokyo.tommykw.limontimer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import tokyo.tommykw.limontimer.presenter.TimerPresenter;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class TimerPresenterTest {
    @Test
    public void timerStartTest() throws Exception {
        TimerPresenter p = TimerPresenter.newInstance(5000, 1000);
        p.startTimer(new TimerPresenter.TimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
            }
        });

        Thread.sleep(5000);
        assertEquals(p.getCurrentTime(), 0);
    }
}