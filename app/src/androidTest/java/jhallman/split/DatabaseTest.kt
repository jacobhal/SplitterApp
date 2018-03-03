package jhallman.split

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import jhallman.split.data.db.AppDatabase
import org.junit.After
import org.junit.Before
import java.io.IOException

/**
 * Created by Jacob on 2018-03-02.
 */

abstract class DatabaseTest {
    protected lateinit var appDatabase: AppDatabase

    @Before
    fun initDb() {
        appDatabase = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                AppDatabase::class.java)
                .build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDatabase.close()
    }
}