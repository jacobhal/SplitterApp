/*
package jhallman.split.di

import dagger.Component
import jhallman.split.view.ui.MainActivity
import javax.inject.Singleton

/**
 * Created by Jacob on 2018-02-16.
 * This interface is used by Dagger 2 to generate code which uses the modules to fulfill the requested dependencies.
 * The component is used to connect objects to their dependencies,
 * typically by use of overridden inject() methods.
 * A component serves as a bridge between the modules and the injections.
 * In order to use the component, it must be accessible from the parts of the app that need injection.
 * Typically, that will happen from the app Application subclass.
 */


@Singleton
@Component(modules = [AppModule::class]) // GoogleAPIModule::class
interface GoogleAPIComponent {
    fun inject(activity: MainActivity)
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
        */