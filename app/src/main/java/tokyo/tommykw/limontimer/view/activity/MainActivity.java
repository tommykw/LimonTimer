package tokyo.tommykw.limontimer.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tokyo.tommykw.limontimer.R;
import tokyo.tommykw.limontimer.presenter.TimerPresenter;

public class MainActivity extends BaseActivity {
    @Bind(R.id.timer)
    TextView timer;

    @Bind(R.id.timer_button)
    Button timerButton;

    private static final int START_TIME = 10000;
    private static final int INTERVAL = 100;
    private TimerPresenter timerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer.setText(String.valueOf(START_TIME));
        timerPresenter = getTimerPresenter();
    }

    @OnClick(R.id.timer_button)
    public void onTimerButtonClick() {
        timerPresenter.startTimer(new TimerPresenter.TimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished));
            }
            @Override
            public void onFinish() {
                timer.setText("0");
            }
        });
    }

    private TimerPresenter getTimerPresenter() {
        TimerPresenter presenter = (TimerPresenter)getSupportFragmentManager().findFragmentByTag(TimerPresenter.TAG);
        if (presenter == null) {
            presenter = TimerPresenter.newInstance(START_TIME, INTERVAL);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(presenter, TimerPresenter.TAG).commit();
        }
        return presenter;
    }
}
