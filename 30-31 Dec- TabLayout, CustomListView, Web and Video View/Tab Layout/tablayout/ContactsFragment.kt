package com.bmpl.tablayout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContactsFragment : Fragment(){
    //life cycle --> different methods

    //onCreate() --> layout set with backend
    //           --> downcast or initialization

    //layout to be set for fragment
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragmentcontacts, container, false)
    }

    //initialization or downcast or listeners attach
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textView = view!!.findViewById(R.id.contactTextView) as TextView
        textView.text = "Contact Fragment is Running"
    }
}
