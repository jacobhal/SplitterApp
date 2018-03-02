package jhallman.split.view.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import jhallman.split.R
import kotlinx.android.synthetic.main.fragment_edit_receipt.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [EditReceiptFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [EditReceiptFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditReceiptFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mReceiptID: Int? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mReceiptID = arguments.getInt(ARG_RECEIPT_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_edit_receipt, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        fab_delete_receipt.setOnClickListener {
            onDeleteReceiptButtonPressed()
        }
        fab_save_receipt.setOnClickListener {
            onSaveReceiptButtonPressed()
        }
        // TODO: Use adapter and fill list of persons + link each delete button to each person
        // TODO: Add the possibility

        super.onActivityCreated(savedInstanceState)
    }

    fun onDeleteReceiptButtonPressed() {
        if (mListener != null) {
            mListener!!.onDeleteReceipt()
        }
    }

    fun onSaveReceiptButtonPressed() {
        if (mListener != null) {
            mListener!!.onSaveReceipt()
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
        fun onDeleteReceipt()
        fun onSaveReceipt()
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_RECEIPT_ID = "Receipt ID"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param tabID the id of the tab
         * @return A new instance of fragment EditReceiptFragment.
         */
        fun newInstance(tabID: Int): EditReceiptFragment {
            val fragment = EditReceiptFragment()
            val args = Bundle()
            args.putInt(ARG_RECEIPT_ID, tabID)
            fragment.arguments = args
            return fragment
        }
    }
}
