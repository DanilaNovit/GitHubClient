package com.novitsky.githubclient.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

abstract class BasePresenter : DefaultLifecycleObserver {
	abstract fun subscribe()

	override fun onCreate(owner: LifecycleOwner) {
		super.onCreate(owner)
		subscribe()
	}
}