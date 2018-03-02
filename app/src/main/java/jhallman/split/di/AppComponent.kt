package jhallman.split.di

import dagger.Component
import jhallman.split.application.SplitterApplication
import jhallman.split.view.ui.MainActivity
import jhallman.split.view.ui.fragment.*
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
@Component(modules = [
    AppModule::class,
    ViewModelModule::class]) // GoogleAPIModule::class
interface AppComponent {
    fun inject(application: SplitterApplication)

    fun inject(target: MainActivity)
    fun inject(target: AddPersonFragment)
    fun inject(target: AddReceiptFragment)
    fun inject(target: AwaitingPaymentTabsFragment)
    fun inject(target: CreatedTabFragment)
    fun inject(target: EditReceiptFragment)
    fun inject(target: EditTabContactsFragment)
    fun inject(target: EditTabFragment)
    fun inject(target: FinishTabFragment)
    fun inject(target: HomeFragment)
    fun inject(target: RunningTabsFragment)
    fun inject(target: SettingsFragment)
}