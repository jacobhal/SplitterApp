package jhallman.split.view.ui.home

import android.app.AlertDialog
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_home.*

import jhallman.split.R
import jhallman.split.application.SplitterApplication
import jhallman.split.data.repository.tab.Tab
import jhallman.split.viewmodel.TabViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

    @Inject lateinit var mViewModelFactory: ViewModelProvider.Factory
    var mtabViewModel: TabViewModel? = null

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity.application as SplitterApplication).mAppComponent.inject(this)
    }

    // Set onClickListeners when activity has been created
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Set up and subscribe (observe) to the ViewModel
        mtabViewModel = ViewModelProviders.of(this, mViewModelFactory).get(TabViewModel::class.java)

        fab_new_tab.setOnClickListener {
            onNewTabButtonPressed()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    // New tab button pressed
    fun onNewTabButtonPressed() {
        if (mListener != null) {
            showTabCreationDialog()
        }
    }

    // Make sure that callback activity has implemented interface
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    // Detach and avoid leaking
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        fun onNewTabCreation(tabId: Long)
    }

    private fun showTabCreationDialog() {
        val dialogBuilder = AlertDialog.Builder(activity, R.style.AlertDialogTheme)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog, null)
        dialogBuilder.setView(dialogView)

        val edt = dialogView.findViewById(R.id.edit_name) as EditText

        dialogBuilder.setTitle(R.string.dialog_tab_title)
        dialogBuilder.setPositiveButton(R.string.dialog_tab_create, { _, _ ->
            // Get the value from EditText field
            val tabTitle = "" + edt.text
            val tab = Tab(title = tabTitle)
            val tabId = mtabViewModel!!.insertTab(tab)
            mListener!!.onNewTabCreation(tabId)

        })
        dialogBuilder.setNegativeButton(R.string.dialog_tab_cancel, { _, _ ->
            // User cancelled
        })
        val b = dialogBuilder.create()

        edt.requestFocus()
        b.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        b.show()
    }
}
