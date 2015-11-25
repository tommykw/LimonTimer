package tokyo.tommykw.limontimer.presenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by tommy on 15/11/25.
 */
public class LocalNotificationPresenter extends Presenter {
    public void sendNotification(long timestamp, int primaryKey, String ticker, String title, String text) {
        Context context = getContext().getApplicationContext();
        Intent intent = new Intent(context, null); // TODO receiver
        intent.putExtra("PRIMARY_KEY", primaryKey);
        intent.putExtra("TICKER", ticker);
        intent.putExtra("CONTENT_TITLE", title);
        intent.putExtra("CONTENT_TEXT", text);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        PendingIntent sender = PendingIntent.getBroadcast(context, primaryKey, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    public void clearNotification(int primaryKey) {
        Context context = getContext().getApplicationContext();
        Intent intent = new Intent(context, null); // NotificationReceiver
        PendingIntent sender = PendingIntent.getBroadcast(context, primaryKey, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(sender);
        sender.cancel();
    }
}
