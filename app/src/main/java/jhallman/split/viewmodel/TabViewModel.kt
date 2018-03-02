package jhallman.split.viewmodel

import android.arch.lifecycle.*
import jhallman.split.data.repository.tab.Tab
import jhallman.split.data.repository.tab.TabDao
import jhallman.split.data.repository.tab.TabRepository
import javax.inject.Inject

/**
 * Created by Jacob on 2018-02-18.
 * Acts as a bridge between the View and the Model
 * Requests/aggregates data from the Model, and transforms it for the View
 */

class TabViewModel @Inject constructor (val tabRepository: TabRepository): ViewModel() {

    private lateinit var mTab: LiveData<Tab>

    fun getAllTabs() {
        tabRepository.getTabs()
    }

    fun testHello(): String {
        return "Hello"
    }
}