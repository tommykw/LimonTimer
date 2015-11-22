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
    private static final int START_TIME = 5000;
    private static final int INTERVAL = 3000;

    @Before
    public void setUp() {
        p = TimerPresenter.newInstance(START_TIME, 1);
    }

    @Test
    public void timerStartTest() throws Exception {
        p.setTimerListener(new TimerPresenter.TimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                assertEquals(0, p.getCurrentTime());
            }
        });
        p.startTimer();
    }

    @Test
    public void timerStopTest() throws Exception {
        p.setTimerListener(new TimerPresenter.TimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
            }
        });

        p.startTimer();
        p.stopTimer();
        long currentTime = p.getCurrentTime();
        Thread.sleep(INTERVAL);

        assertEquals(currentTime, p.getCurrentTime());
    }

    @Test
    public void timerResetTest() throws Exception {
        p.setTimerListener(new TimerPresenter.TimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
            }
        });

        long defaultTime = p.getCurrentTime();
        p.startTimer();
        Thread.sleep(INTERVAL);
        p.resetTimer();

        assertEquals(defaultTime, p.getCurrentTime());
    }
}