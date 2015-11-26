package tokyo.tommykw.limontimer.view.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import tokyo.tommykw.limontimer.R;
import tokyo.tommykw.limontimer.databinding.ActivityMainBinding;
import tokyo.tommykw.limontimer.model.entity.TimerEntity;
import tokyo.tommykw.limontimer.presenter.TimerPresenter;
import tokyo.tommykw.limontimer.view.notification.LocalNotificationSender;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityBinding;
    private static final int START_TIME = 50000;
    private static final int INTERVAL = 1;
    private TimerPresenter timerPresenter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        TimerEntity timer = new TimerEntity(START_TIME / 1000, getString(R.string.timer_text_start));
        activityBinding.setTimer(timer);
        activityBinding.timerButton.setOnClickListener(onClickTimerListener);
        timerPresenter = getTimerPresenter();
        snackbar = Snackbar.make(activityBinding.coordinatorLayout, null, Snackbar.LENGTH_LONG);

        MaterialRippleLayout.on(activityBinding.rippleTimerButtonLayout)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.5f)
                .rippleHover(true)
                .create();
    }

    private View.OnClickListener onClickTimerListener = (View v) -> {
        if (timerPresenter.isRunning()) {
            timerPresenter.stopTimer();
            activityBinding.timerButton.setText(getString(R.string.timer_text_start));
            snackbar.setText(getString(R.string.timer_text_stop)).show();
        } else if (timerPresenter.isFinished()) {
            timerPresenter.resetTimer();
            activityBinding.timer.setText(String.valueOf(START_TIME / 1000));
            activityBinding.timerButton.setText(getString(R.string.timer_text_start));
            snackbar.setText(getString(R.string.timer_text_reset)).show();
        } else {
            timerPresenter.startTimer();
            activityBinding.timerButton.setText(getString(R.string.timer_text_stop));
            snackbar.setText(getString(R.string.timer_text_start)).show();
        }
    };

    private TimerPresenter getTimerPresenter() {
        TimerPresenter presenter = (TimerPresenter)getSupportFragmentManager().findFragmentByTag(TimerPresenter.TAG);
        if (presenter == null) {
            presenter = TimerPresenter.newInstance(START_TIME, INTERVAL);
            getSupportFragmentManager().beginTransaction().add(presenter, TimerPresenter.TAG).commit();
            presenter.setTimerListener(new TimerPresenter.TimerListener() {
                @Override
                public void onTick(long millisUntilFinished) {
                    activityBinding.timer.setText(String.valueOf(millisUntilFinished / 1000));
                }
                @Override
                public void onFinish() {
                    activityBinding.timer.setText("0");
                    activityBinding.timerButton.setText(getString(R.string.timer_text_reset));
                    snackbar.setText(getString(R.string.timer_text_finish)).show();
                    LocalNotificationSender lnSender = new LocalNotificationSender(MainActivity.this);
                    lnSender.sendNotification(0, 0, "timer", "Finish", "Finish");
                }
            });
        }
        return presenter;
    }
}
