package tokyo.tommykw.limontimer.view.activity;

import android.os.Bundle;

import icepick.Icepick;

/**
 * Created by tommy on 15/12/09.
 */
public class BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }
}
