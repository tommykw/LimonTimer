package tokyo.tommykw.limontimer.presenter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by tommy on 15/11/15.
 */
public class TimerPresenter extends Presenter {
    public static final String TAG = TimerPresenter.class.getSimpleName();
    private CountDownTimer countDownTimer;
    private long startTime;
    private long interval;
    private long currentTime;
    private boolean isRunning = false;
    private boolean isFinished = false;
    private boolean isStopped = false;
    private static final String ARG_KEY_START_TIME = "start_time";
    private static final String ARG_KEY_INTERVAL = "interval";
    private TimerListener timerListener;

    public interface TimerListener {
        void onTick(long millisUntilFinished);
        void onFinish();
    }

    public static TimerPresenter newInstance(long startTime, long interval) {
        Bundle args = new Bundle();
        args.putLong(ARG_KEY_START_TIME, startTime);
        args.putLong(ARG_KEY_INTERVAL, interval);
        TimerPresenter fragment = new TimerPresenter();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            startTime = args.getLong(ARG_KEY_START_TIME);
            interval = args.getLong(ARG_KEY_INTERVAL);
            currentTime = startTime;
        }
    }

    @Override
    public void onDestroy() {
        countDownTimer = null;
        super.onDestroy();
    }

    public void setTimerListener(TimerListener listener) {
        timerListener = listener;
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(currentTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerListener.onTick(millisUntilFinished);
                currentTime = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                timerListener.onFinish();
                isFinished = true;
                isRunning = false;
                isStopped = true;
            }
        };
        countDownTimer.start();
        isRunning = true;
        isStopped = false;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        isRunning = false;
        isStopped = true;
    }

    public void resetTimer() {
        isRunning = false;
        isStopped = true;
        isFinished = false;
        currentTime = startTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public long getCurrentTime() {
        return currentTime;
    }
}
