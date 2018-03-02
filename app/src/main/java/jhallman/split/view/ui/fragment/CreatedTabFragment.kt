package jhallman.split.view.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_created_tab.*
import jhallman.split.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CreatedTabFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CreatedTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreatedTabFragment : Fragment() {

    // TODO: Rename and change types of parameters for db usage
    private var mTabID: Int? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mTabID = arguments.getInt(ARG_TAB_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_created_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        // TODO: Set Heading to tab name from db instead of the id
        tv_heading.text = this.mTabID.toString()
        fab_edit_tab.setOnClickListener {
            onEditTabButtonPressed(mTabID!!)
        }
        fab_new_receipt.setOnClickListener {
            onNewReceiptButtonPressed(mTabID!!)
        }
        super.onActivityCreated(savedInstanceState)
    }

    // Edit tab button pressed
    fun onEditTabButtonPressed(tabID: Int) {
        if (mListener != null) {
            mListener!!.onEditTab(tabID)
        }
    }

    // New purchase button pressed
    fun onNewReceiptButtonPressed(tabID: Int) {
        if (mListener != null) {
            mListener!!.onNewReceipt(tabID)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

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
        fun onEditTab(tabID: Int)
        fun onNewReceipt(tabID: Int)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_TAB_ID = "Tab ID"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param tabID the id of the tab
         * @return A new instance of fragment CreatedTabFragment.
         */
        fun newInstance(tabID: Int): CreatedTabFragment {
            val fragment = CreatedTabFragment()
            val args = Bundle()
            args.putInt(ARG_TAB_ID, tabID)
            fragment.arguments = args
            return fragment
        }
    }
}
