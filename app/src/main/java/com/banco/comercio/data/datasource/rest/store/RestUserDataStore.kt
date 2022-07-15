package com.banco.comercio.data.datasource.rest.store

import com.banco.comercio.data.datasource.IUserDataStore
import com.banco.comercio.data.datasource.rest.ApiService
import com.banco.comercio.data.datasource.rest.entities.UserRestEntity
import com.banco.comercio.util.Resource
import com.banco.comercio.util.Status
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestUserDataStore @Inject constructor(private val apiService: ApiService) : BaseDataStore(), IUserDataStore {
    override suspend fun getUserList(): Resource<List<UserRestEntity>> {
        val resource: Resource<List<UserRestEntity>>? = try {
            val res = getResult { apiService.getUserList() }
            if (res.status == Status.SUCCESS) {
                Resource.success(res.data!!)
            } else {
                Resource.error(res.message!!)
            }
        } catch (e: Exception) {
            Resource.error(e.message!!)
        }
        return resource!!
    }
}