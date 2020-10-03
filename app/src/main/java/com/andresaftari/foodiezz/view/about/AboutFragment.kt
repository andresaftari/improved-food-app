package com.andresaftari.foodiezz.view.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andresaftari.foodiezz.R
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_about, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the textview with my contact
        tv_nameAbout.text = getString(R.string.profile_name)
        tv_linkedIn.text = getString(R.string.profile_link)
        tv_emailAbout.text = getString(R.string.profile_email)
        tv_contactAbout.text = getString(R.string.profile_instagram)

        // Redirect the user to my LinkedIn page
        tv_linkedIn.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW).setData(
                    Uri.parse(getString(R.string.profile_link))
                )
            )
        }

        // Redirect the user to my Instagram profile
        tv_contactAbout.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW).setData(
                    Uri.parse(getString(R.string.profile_instagram))
                )
            )
        }
    }
}