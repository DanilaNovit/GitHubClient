package com.novitsky.githubclient.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

abstract class BaseFragment : Fragment(), LifecycleOwner {

	abstract val presenter: BasePresenter
	private lateinit var lifecycleRegistry: LifecycleRegistry

	val dependencyProvider
		get() = requireBaseActivity().dependencyProvider


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		lifecycleRegistry = LifecycleRegistry(this)
		lifecycleRegistry.addObserver(presenter)
		setCurrentState(Lifecycle.State.CREATED)
	}

	override fun onResume() {
		super.onResume()
		setCurrentState(Lifecycle.State.RESUMED)
	}

	override fun onStart() {
		super.onStart()
		setCurrentState(Lifecycle.State.STARTED)
	}

	override fun onDestroy() {
		super.onDestroy()
		setCurrentState(Lifecycle.State.DESTROYED)
		lifecycleRegistry.removeObserver(presenter)
	}


	private fun setCurrentState(state: Lifecycle.State) {
		lifecycleRegistry.currentState = state
	}

	private fun requireBaseActivity(): RootActivity {
		return (activity as RootActivity?) ?: throw IllegalStateException("Activity isn't attached to \$this fragment.")
	}
}
