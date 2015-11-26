package tokyo.tommykw.limontimer.view.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by tommy on 15/11/25.
 */
public class LocalNotificationSender {
    private Context context;
    public LocalNotificationSender(Context context) {
        this.context = context;
    }

    public void sendNotification(long timestamp, int primaryKey, String ticker, String currentTitle, String currentText) {
        Context context = this.context.getApplicationContext();
        Intent intent = new Intent(context, LocalNotificationReceiver.class);
        intent.putExtra("PRIMARY_KEY", primaryKey);
        intent.putExtra("TICKER", ticker);
        intent.putExtra("CURRENT_TITLE", currentTitle);
        intent.putExtra("CURRENT_TEXT", currentText);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);

        PendingIntent sender = PendingIntent.getBroadcast(context, primaryKey, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    public void clearNotification(int primaryKey) {
        Context context = this.context.getApplicationContext();
        Intent intent = new Intent(context, LocalNotificationReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, primaryKey, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(sender);
        sender.cancel();
    }
}
