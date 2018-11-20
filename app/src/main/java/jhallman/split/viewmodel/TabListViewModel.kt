package jhallman.split.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import jhallman.split.data.repository.tab.Tab
import jhallman.split.data.repository.tab.TabDao
import jhallman.split.data.repository.tab.TabRepository
import javax.inject.Inject


/**
 * Created by Jacob on 2018-02-18.
 * Acts as a bridge between the View and the Model
 * Requests/aggregates data from the Model, and transforms it for the View
 */

class TabListViewModel @Inject constructor (val tabRepository: TabRepository) : ViewModel() {

    private var tabsLiveData: LiveData<List<Tab>>

    init {
        tabsLiveData = fetchTabs()
    }

    fun fetchTabs(): LiveData<List<Tab>> {
        return tabRepository.getTabs()
    }
}