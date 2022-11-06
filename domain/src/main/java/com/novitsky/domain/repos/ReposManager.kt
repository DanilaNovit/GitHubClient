package com.novitsky.domain.repos

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class ReposManager : IReposManager {
	private val _reposSearchResult = BehaviorSubject.createDefault(emptyList<Repos>())


	override val reposSearchResult: Observable<List<Repos>>
		get() = _reposSearchResult.hide()


	override fun searchRepos(searchRequest: String) {
		_reposSearchResult.onNext(
			listOf(
				Repos(
					id = 54741622,
					name = "current-date-yesterday-date-tomorrow-date-in-php",
					ownerName = "mohibulkhan786",
					ownerAvatarUrl = "https://avatars.githubusercontent.com/u/54741622?v=4",
				),

				Repos(
					id = 53411098,
					name = "roulettee",
					ownerName = "krys12345",
					ownerAvatarUrl = "https://avatars.githubusercontent.com/u/17723651?v=4",
				),

				Repos(
					id = 254092833,
					name = "12.css",
					ownerName = "omar3432",
					ownerAvatarUrl = "https://avatars.githubusercontent.com/u/63053735?v=4",
				),

				Repos(
					id = 254091162,
					name = "11.js",
					ownerName = "omar3432",
					ownerAvatarUrl = "https://avatars.githubusercontent.com/u/63053735?v=4",
				),
			)
		)
	}
}