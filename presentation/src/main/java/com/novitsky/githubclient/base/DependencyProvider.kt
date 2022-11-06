package com.novitsky.githubclient.base

import androidx.fragment.app.FragmentManager
import com.novitsky.domain.repos.ReposManager
import com.novitsky.githubclient.navigation.RootRouter

class DependencyProvider(
	supportFragmentManager: FragmentManager,
	fragmentContainerId: Int,
) {
	val router = RootRouter(supportFragmentManager, fragmentContainerId)
	val reposManager = ReposManager()
}