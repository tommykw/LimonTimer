package tokyo.tommykw.limontimer.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tokyo.tommykw.limontimer.R;
import tokyo.tommykw.limontimer.presenter.TimerPresenter;

public class MainActivity extends BaseActivity {
    @Bind(R.id.timer)
    TextView timer;

    private static final int START_TIME = 10000;
    private static final int INTERVAL = 100;
    private TimerPresenter timerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer.setText(String.valueOf(START_TIME));
        timerPresenter = TimerPresenter.newInstance(START_TIME, INTERVAL);
    }

    @OnClick(R.id.timer_button)
    public void onTimerButtonClick(View v) {
        timerPresenter.startTimer(null);
    }
}
