package tokyo.tommykw.limontimer.model.repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tommy on 15/12/06.
 */
@Module
public class RepositoryModule {
    @Provides
    public TimerRepository provideTimerRepository() {
        return new TimerRepository();
    }
}
