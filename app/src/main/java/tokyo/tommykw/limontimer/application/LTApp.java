package tokyo.tommykw.limontimer.application;

import android.app.Application;

import tokyo.tommykw.limontimer.model.repository.DaggerRepositoryHolder;
import tokyo.tommykw.limontimer.model.repository.RepositoryHolder;
import tokyo.tommykw.limontimer.model.repository.RepositoryModule;

/**
 * Created by tommy on 15/11/14.
 */
public class LTApp extends Application {
    private RepositoryHolder repositoryHolder;

    @Override
    public void onCreate() {
        super.onCreate();

        repositoryHolder = DaggerRepositoryHolder.builder()
                .repositoryModule(new RepositoryModule())
                .build();
    }
}
