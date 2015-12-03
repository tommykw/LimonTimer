package tokyo.tommykw.limontimer.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.MenuItem;

import tokyo.tommykw.limontimer.R;
import tokyo.tommykw.limontimer.view.activity.SettingsActivity;

/**
 * Created by tommy on 15/11/29.
 */
public class NotificationPreferenceFragment extends PreferenceFragment {
    public static NotificationPreferenceFragment newInstance() {
        NotificationPreferenceFragment fragment = new NotificationPreferenceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_notification);
        setHasOptionsMenu(true);
        SettingsActivity.bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
