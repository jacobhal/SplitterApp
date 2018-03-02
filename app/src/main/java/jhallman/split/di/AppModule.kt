package jhallman.split.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import jhallman.split.data.db.AppDatabase
import javax.inject.Singleton
import jhallman.split.viewmodel.ViewModelFactory
import android.arch.lifecycle.ViewModelProvider
import jhallman.split.data.repository.contact.ContactDao
import jhallman.split.data.repository.contact.ContactRepository
import jhallman.split.data.repository.purchase.PurchaseDao
import jhallman.split.data.repository.purchase.PurchaseRepository
import jhallman.split.data.repository.receipt.ReceiptDao
import jhallman.split.data.repository.receipt.ReceiptRepository
import jhallman.split.data.repository.tab.TabDao
import jhallman.split.data.repository.tab.TabRepository


/**
 * Created by Jacob on 2018-02-16.
 * In Dagger 2, classes annotated with @Module are responsible for providing objects which can be injected.
 * The @Module annotation tells Dagger that the AppModule class will provide dependencies for a part of the application.
 * It is normal to have multiple Dagger modules in a project, and it is typical for one of them to provide app-wide dependencies.
 */

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesAppContext() = context

    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "splitter-db").allowMainThreadQueries().build()

    // Daos
    @Provides
    fun providesTabDao(database: AppDatabase) = database.tabDao()

    @Provides
    fun providesReceiptDao(database: AppDatabase) = database.receiptDao()

    @Provides
    fun providesPurchaseDao(database: AppDatabase) = database.purchaseDao()

    @Provides
    fun providesContactDao(database: AppDatabase) = database.contactDao()

    // Repositories
    @Provides
    fun providesTabRepository(tabDao: TabDao) = TabRepository(tabDao)

    @Provides
    fun providesReceiptRepository(receiptDao: ReceiptDao) = ReceiptRepository(receiptDao)

    @Provides
    fun providesPurchaseRepository(purchaseDao: PurchaseDao) = PurchaseRepository(purchaseDao)

    @Provides
    fun providesContactRepository(contactDao: ContactDao) = ContactRepository(contactDao)

    // Factory
    @Provides
    fun providesViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }
}