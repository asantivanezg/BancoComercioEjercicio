package com.banco.comercio.data.mapper

import com.banco.comercio.data.datasource.rest.entities.UserRestEntity
import com.banco.comercio.domain.model.User

class UserMapper : BaseMapper<UserRestEntity, User> {
    override fun mapperFromWsToModel(item: UserRestEntity): User {
        return User(
            id = item.id,
            nombre = item.nombre,
            email = item.email,
            telefono = item.telefono,
            paginaWeb = item.paginaWeb
        )
    }

    override fun mapperFromListWsToModel(itemList: List<UserRestEntity>): List<User> {
        val mapper = UserMapper()
        return itemList.map { mapper.mapperFromWsToModel(it) }
    }

    override fun mapperFromModelToWs(item: User): UserRestEntity {
        TODO("Not yet implemented")
    }

    override fun mapperFromListModelToWs(itemList: List<User>): List<UserRestEntity> {
        TODO("Not yet implemented")
    }

}