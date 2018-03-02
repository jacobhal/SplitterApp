package jhallman.split.view.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import jhallman.split.R
import jhallman.split.application.SplitterApplication
import jhallman.split.utils.*
import jhallman.split.view.ui.fragment.AddReceiptFragment
import jhallman.split.view.ui.fragment.EditReceiptFragment
import jhallman.split.view.ui.fragment.*
import jhallman.split.viewmodel.ReceiptViewModel
import jhallman.split.viewmodel.TabViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

/**
 * This Activity handles navigation between all fragments in the app
 * A view (Fragment/Activity) observes only one observable (i.e. LiveData) within the view-model.
 */
class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener,
        AddPersonFragment.OnFragmentInteractionListener,
        AddReceiptFragment.OnFragmentInteractionListener,
        CreatedTabFragment.OnFragmentInteractionListener,
        EditReceiptFragment.OnFragmentInteractionListener,
        EditTabContactsFragment.OnFragmentInteractionListener,
        EditTabFragment.OnFragmentInteractionListener,
        FinishTabFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener,
        AwaitingPaymentTabsFragment.OnFragmentInteractionListener,
        RunningTabsFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set toolbar and drawer toggle
        setSupportActionBar(toolbar)
        supportActionBar!!.title = null
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        // Initiate navigation to this context
        nav_view.setNavigationItemSelectedListener(this)

        // TODO: Create proper viewModels and instantiate each of them in respective fragment or in this activity
        // mviewModel = ViewModelProviders.of(this, mViewModelFactory).get(TabViewModel::class.java)


        // Display home fragment
        displayFragment(R.id.nav_home)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // Handle items directly on the actionbar here
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
        */
        return super.onOptionsItemSelected(item)
    }


    private fun displayFragment(navItemIndex: Int) {
        lateinit var fragment: Fragment

        when (navItemIndex) {
            R.id.nav_home -> {
                fragment = HomeFragment()
            }
            R.id.nav_all_tabs -> {
                fragment = RunningTabsFragment()
            }
            R.id.nav_settings -> {
                fragment = SettingsFragment()
            }
            else -> {
                fragment = HomeFragment()
            }
        }

        replaceFragment(fragment, R.id.frameLayout_main)

        drawer_layout.closeDrawer(GravityCompat.START)
    }

    /*
     * IMPLEMENT FRAGMENT INTERFACE FUNCTIONS BELOW
     */

    // Navigation
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        displayFragment(item.itemId)
        return true
    }

    // HomeFragment
    override fun onNewTabCreation(tabID: Int) {
        val newFragment = CreatedTabFragment.newInstance(tabID)
        replaceFragment(newFragment, R.id.frameLayout_main)
    }

    // CreatedTabFragment
    override fun onEditTab(tabID: Int) {
        val newFragment = EditTabFragment.newInstance(tabID)
        replaceFragment(newFragment, R.id.frameLayout_main)
    }

    // CreatedTabFragment
    override fun onNewReceipt(tabID: Int) {
        val newFragment = AddReceiptFragment.newInstance(tabID)
        replaceFragment(newFragment, R.id.frameLayout_main)
    }

    // EditTabFragment
    override fun onEditReceipt(receiptID: Int) {
        val newFragment = EditReceiptFragment.newInstance(receiptID)
        replaceFragment(newFragment, R.id.frameLayout_main)
    }

    // EditTabFragment
    override fun onEditTabContacts(tabID: Int) {
        val newFragment = EditTabContactsFragment.newInstance(tabID)
        replaceFragment(newFragment, R.id.frameLayout_main)
    }

    // EditReceiptFragment
    override fun onDeleteReceipt() {
        // TODO: Delete receipt from db before going back
        supportFragmentManager.popBackStack()
    }

    // EditReceiptFragment
    override fun onSaveReceipt() {
        // TODO: Save edited receipt to db before going back
        supportFragmentManager.popBackStack()
    }

    // AddReceiptFragment
    override fun onAddReceipt() {
        // TODO: Add receipt to db before going back
        supportFragmentManager.popBackStack()
    }

    // AddReceiptFragment
    override fun onAddPersonToReceipt() {
        // TODO: Add person to receipt in db (THIS SHOULD BE DONE IN THE FRAGMENT ITSELF SINCE OTHER FRAGMENTS DONT NEED THAT INFORMATION)
    }

    // AddPersonFragment
    override fun onAddPersonToTab() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // AddPersonFragment
    override fun onCancelAddPersonToTab() {
        supportFragmentManager.popBackStack()
    }

    // TODO: Replace placeholder fragment interaction functions for FinishTabFragment and EditTabContactsFragment
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // AwaitingPaymentTabsFragment
    override fun onAwaitingPaymentTabSelected(tabID: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // RunningTabsFragment
    override fun onRunningTabSelected(tabID: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
