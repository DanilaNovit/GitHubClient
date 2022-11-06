package com.novitsky.githubclient.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

abstract class BaseFragment : Fragment(), LifecycleOwner {

	private var _presenter: BasePresenter? = null
	private lateinit var lifecycleRegistry: LifecycleRegistry

	val dependencyProvider
		get() = requireBaseActivity().dependencyProvider

	val presenter
		get() = _presenter ?: throw NullPointerException("The presenter hasn't init yet")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		_presenter = onCreatePresenter()

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


	abstract fun onCreatePresenter(): BasePresenter


	private fun setCurrentState(state: Lifecycle.State) {
		lifecycleRegistry.currentState = state
	}

	private fun requireBaseActivity(): RootActivity {
		return (activity as RootActivity?) ?: throw IllegalStateException("Activity isn't attached to $this fragment.")
	}
}
