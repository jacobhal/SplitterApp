package jhallman.split.view.ui.contacts

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import jhallman.split.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [EditTabContactsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [EditTabContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditTabContactsFragment : Fragment() {

    // TODO: Rename and change types of parameters
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
        return inflater!!.inflate(R.layout.fragment_edit_tab_contacts, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
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
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
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
         * @return A new instance of fragment EditTabContactsFragment.
         */
        fun newInstance(tabID: Int): EditTabContactsFragment {
            val fragment = EditTabContactsFragment()
            val args = Bundle()
            args.putInt(ARG_TAB_ID, tabID)
            fragment.arguments = args
            return fragment
        }
    }
}
