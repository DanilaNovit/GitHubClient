package com.novitsky.githubclient.navigation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.novitsky.githubclient.searchrepos.SearchReposFragment

class RootRouter(
	private val manager: FragmentManager,
	private val containerViewID: Int,

) {
	fun openSearchReposFragment() = addToBackStack(SearchReposFragment())

	private fun addToBackStack(fragment: Fragment) {
		val transaction = manager.beginTransaction()
		transaction.add(containerViewID, fragment)
		transaction.addToBackStack(null)
		transaction.commit()
	}
}