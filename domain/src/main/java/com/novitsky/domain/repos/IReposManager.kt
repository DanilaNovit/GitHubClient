package com.novitsky.domain.repos

import io.reactivex.rxjava3.core.Observable

interface IReposManager {
	val reposSearchResult: Observable<List<Repos>>

	fun searchRepos(searchRequest: String)
}