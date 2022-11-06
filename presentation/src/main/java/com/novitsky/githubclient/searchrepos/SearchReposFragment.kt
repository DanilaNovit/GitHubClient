package com.novitsky.githubclient.searchrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.novitsky.githubclient.base.BaseFragment
import com.novitsky.githubclient.databinding.FragmentSearchReposBinding

class SearchReposFragment : BaseFragment() {

	override fun onCreatePresenter() = SearchReposPresenter(dependencyProvider.reposManager)

	private lateinit var binding: FragmentSearchReposBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentSearchReposBinding.inflate(layoutInflater, container, false)
		return binding.root
	}
}
