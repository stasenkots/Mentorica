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
        val payment = data[UserLogin.payment] as Double?
        val technologies = data[UserLogin.technologies] as Array<String>
        val workExperience = data[UserLogin.workExperience] as Array<WorkExperience>
        val education = data[UserLogin.education] as Array<String>
        val links = data[UserLogin.links] as Array<String>

        setCurrentUser(
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
        )
    }

    fun userInitiation() {
        setCurrentUser(
            photo = ParseUser.getCurrentUser()[UserLogin.photo] as String,
            name = ParseUser.getCurrentUser()[UserLogin.name] as String,
            surname = ParseUser.getCurrentUser()[UserLogin.surname] as String,
            description = ParseUser.getCurrentUser()[UserLogin.description] as String,
            position = ParseUser.getCurrentUser()[UserLogin.position] as String,
            company = ParseUser.getCurrentUser()[UserLogin.company] as String,
            isMentor = ParseUser.getCurrentUser()[UserLogin.isMentor] as Boolean,
            payment = ParseUser.getCurrentUser()[UserLogin.payment] as Double,
            technologies = ParseUser.getCurrentUser()[UserLogin.technologies] as Array<String>,
            workExperience = ParseUser.getCurrentUser()[UserLogin.workExperience] as Array<WorkExperience>,
            education = ParseUser.getCurrentUser()[UserLogin.education] as Array<String>,
            links = ParseUser.getCurrentUser()[UserLogin.links] as Array<String>,
        )
    }
}
