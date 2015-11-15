package tokyo.tommykw.limontimer.presenter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;

/**
 * Created by tommy on 15/11/15.
 */
public class TimerPresenter extends Presenter {
    private CountDownTimer countDownTimer;
    private long startTime;
    private long interval;
    private boolean isRunning = false;
    private static final String ARG_KEY_START_TIME = "start_time";
    private static final String ARG_KEY_INTERVAL = "interval";

    public interface TimerListener {
        void onFinish();
        void onTick(long millisUntilFinished);
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
        if (savedInstanceState != null) {
            startTime = savedInstanceState.getLong(ARG_KEY_START_TIME);
            interval = savedInstanceState.getLong(ARG_KEY_INTERVAL);
        }
    }

    @Override
    public void onDestroy() {
        countDownTimer = null;
        super.onDestroy();
    }

    public void startTimer(@NonNull TimerListener listener) {
        if (countDownTimer == null) {
            countDownTimer = new CountDownTimer(startTime, interval) {
                @Override
                public void onTick(long millisUntilFinished) {
                    //listener.onTick(millisUntilFinished);
                }

                @Override
                public void onFinish() {
                    //listener.onFinish();
                }
            };
        }
        countDownTimer.start();
        isRunning = true;
    }

    public void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.onFinish();
        }
        isRunning = false;
    }

    public void cancelTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
