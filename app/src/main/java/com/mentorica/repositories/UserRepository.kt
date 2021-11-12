package com.mentorica.repositories

import com.mentorica.models.*
import com.mentorica.services.ParseService
import com.mentorica.services.UserLogin
import com.parse.ParseUser
import com.parse.ktx.putOrIgnore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val parseService: ParseService) {

    fun isUserLoggedIn() = ParseUser.getCurrentUser() != null

    suspend fun saveUserData(
        name: String,
        surname: String,
        photo: String,
        position: String,
        description: String,
        company: String,
        isMentor: Boolean,
        payment: Payment,
        technologies: List<String>,
        workExperience: List<Experience>,
        education: List<Experience>,
        links: List<Link>
    ) {

        val user = ParseUser.getCurrentUser()

        user.putOrIgnore(UserLogin.name, name)
        user.putOrIgnore(UserLogin.surname, surname)
        user.putOrIgnore(UserLogin.photo, photo)
        user.putOrIgnore(UserLogin.position, position)
        user.putOrIgnore(UserLogin.description, description)
        user.putOrIgnore(UserLogin.company, company)
        user.putOrIgnore(UserLogin.isMentor, isMentor)
        user.putOrIgnore(UserLogin.payment, payment)
        user.putOrIgnore(UserLogin.technologies, technologies)
        user.putOrIgnore(UserLogin.workExperience, workExperience)
        user.putOrIgnore(UserLogin.education, education)
        user.putOrIgnore(UserLogin.links, links)

        setCurrentUser(
            id = user.objectId,
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

        user.save()
    }

    suspend fun authenticate(username: String, password: String, authType: AuthType) {
        if(authType == AuthType.login) {
            parseService.login(username, password)
        } else if(authType == AuthType.register) {
            parseService.register(username, password)
        }
    }
}
