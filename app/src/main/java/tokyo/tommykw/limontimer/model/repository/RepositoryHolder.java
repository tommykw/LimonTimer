package tokyo.tommykw.limontimer.model.repository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tommy on 15/11/24.
 */
//@Singleton
//@Component(modules = {
//        TimerRepository.class
//})
public interface RepositoryHolder {
    TimerRepository getTimerRepository();
}
