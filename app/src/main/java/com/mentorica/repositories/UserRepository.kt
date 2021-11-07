package com.mentorica.repositories

import com.mentorica.models.*
import com.mentorica.services.ParseService
import com.mentorica.services.UserLogin
import com.parse.ParseUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val parseService: ParseService) {

    fun isUserLoggedIn() = ParseUser.getCurrentUser() != null

    suspend fun authenticate(data: Map<String, Any>) {
        val username = data[UserLogin.username] as String
        val password = data[UserLogin.password] as String
        val authType = data[UserLogin.authType] as AuthType
        if(authType == AuthType.login) {
            parseService.login(username, password)
        } else if(authType == AuthType.register) {
            parseService.register(username, password)
        }

        val photo = data[UserLogin.photo] as String
        val name = data[UserLogin.name] as String
        val surname = data[UserLogin.surname] as String
        val position = data[UserLogin.position] as String
        val description = data[UserLogin.description] as String
        val company = data[UserLogin.company] as String
        val isMentor = data[UserLogin.isMentor] as Boolean
        val favorites = data[UserLogin.favorites] as List<String>
        val payment = data[UserLogin.payment] as Double?
        val technologies = data[UserLogin.technologies] as List<String>
        val workExperience = data[UserLogin.workExperience] as List<Experience>
        val education = data[UserLogin.education] as List<Experience>
        val links = data[UserLogin.links] as List<String>

        setCurrentUser(
            id = ParseUser.getCurrentUser().objectId,
            photo = photo,
            name = name,
            surname = surname,
            description = description,
            position = position,
            company = company,
            isMentor = isMentor,
            payment = payment,
            technologies = technologies,
            workExperience = workExperience,
            education = education,
            links = links,
            favorites = favorites
        )
    }

    fun initCurrentUser() {
        val user = ParseUser.getCurrentUser()
        setCurrentUser(
            id = user.objectId,
            photo = user[UserLogin.photo] as String,
            name = user[UserLogin.name] as String,
            surname = user[UserLogin.surname] as String,
            description = user[UserLogin.description] as String,
            position = user[UserLogin.position] as String,
            company = user[UserLogin.company] as String,
            isMentor = user[UserLogin.isMentor] as Boolean,
            payment = user[UserLogin.payment] as Double?,
            technologies = user[UserLogin.technologies] as List<String>,
            workExperience = user[UserLogin.workExperience] as List<Experience>,
            education = user[UserLogin.education] as List<Experience>,
            links = user[UserLogin.links] as List<String>,
            favorites = user[UserLogin.favorites] as List<String>
        )
    }
}
