package com.novitsky.githubclient.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.novitsky.githubclient.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {
	private var _dependencyProvider: DependencyProvider? = null

	val dependencyProvider
		get() = _dependencyProvider?: throw NullPointerException("Dependency provider haven't init yet")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = ActivityRootBinding.inflate(layoutInflater)
		setContentView(binding.root)

		_dependencyProvider = DependencyProvider(supportFragmentManager, binding.rootContainer.id)

		// tmp
		dependencyProvider.router.openSearchReposFragment()
	}
}