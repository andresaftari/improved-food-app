package com.andresaftari.foodiezz.core.datasource.remote.api

import com.andresaftari.foodiezz.core.datasource.Resource
import kotlinx.coroutines.flow.*

abstract class NetworkBoundRes<ResultType, RequestType> {
    protected open fun onFetchFailed() {}
    protected abstract fun loadFromDB(): Flow<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>
    protected abstract suspend fun saveCallResult(data: RequestType)

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadFromDB().first()

        if (shouldFetch(dbSource)) {
            emit(Resource.Loading())

            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(apiResponse.errorMessage))
                }
                is ApiResponse.Empty -> emitAll(loadFromDB().map { Resource.Success(it) })
            }
        } else emitAll(loadFromDB().map { Resource.Success(it) })
    }

    fun asFlow(): Flow<Resource<ResultType>> = result
}