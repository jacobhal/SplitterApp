package jhallman.split.di

import dagger.Component
import jhallman.split.application.SplitterApplication
import jhallman.split.view.ui.MainActivity
import jhallman.split.view.ui.contacts.AddContactFragment
import jhallman.split.view.ui.contacts.EditTabContactsFragment
import jhallman.split.view.ui.home.HomeFragment
import jhallman.split.view.ui.receipts.AddReceiptFragment
import jhallman.split.view.ui.receipts.EditReceiptFragment
import jhallman.split.view.ui.settings.SettingsFragment
import jhallman.split.view.ui.tabs.*
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
    fun inject(target: AddContactFragment)
    fun inject(target: AddReceiptFragment)
    fun inject(target: TabFragment)
    fun inject(target: EditReceiptFragment)
    fun inject(target: EditTabContactsFragment)
    fun inject(target: EditTabFragment)
    fun inject(target: FinishTabFragment)
    fun inject(target: HomeFragment)
    fun inject(target: AllTabsFragment)
    fun inject(target: SettingsFragment)
}