package jhallman.split.view.ui.tabs

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
 * [FinishTabFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FinishTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FinishTabFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mTitle: String? = null
    private var mID: Int? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mTitle = arguments.getString(ARG_TABNAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_finish_tab, container, false)
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
        private val ARG_TAB_ID = 0
        private val ARG_TABNAME = "Tab name"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param tabTitle the name of the tab
         * @return A new instance of fragment FinishTabFragment.
         */
        fun newInstance(tabTitle: String): FinishTabFragment {
            val fragment = FinishTabFragment()
            val args = Bundle()
            args.putString(ARG_TABNAME, tabTitle)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
