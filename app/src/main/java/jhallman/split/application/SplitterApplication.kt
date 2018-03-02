package jhallman.split.application

import android.app.Application
import jhallman.split.di.AppComponent
import jhallman.split.di.AppModule
import jhallman.split.di.DaggerAppComponent



/**
 * Created by Jacob on 2018-02-16.
 */

class SplitterApplication : Application() {

    // lateinit var mGoogleAPIComponent: GoogleAPIComponent
    lateinit var mAppComponent: DaggerAppComponent

    override fun onCreate() {
        super.onCreate()
        mAppComponent = initDagger(this) as DaggerAppComponent
    }

    private fun initDagger(app: SplitterApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()

}