package com.novitsky.githubclient.searchrepos

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.novitsky.domain.repos.ReposManager
import com.novitsky.githubclient.base.BasePresenter

class SearchReposPresenter(
	private val reposManager: ReposManager,
) : BasePresenter() {
	override fun subscribe() {
		reposManager.reposSearchResult
			.subscribe { list ->
				list.forEach { Log.d("BBBBBB", it.ownerName) }
			}
	}

	override fun onCreate(owner: LifecycleOwner) {
		super.onCreate(owner)
		reposManager.searchRepos("Search")
	}
}