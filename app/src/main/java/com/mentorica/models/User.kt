package com.mentorica.models

data class User(
    val id:String,
    val photo: String,
    val name: String,
    val surname: String,
    val description: String,
    val position: String,
    val company: String,
    val isMentor: Boolean,
    val payment: Double?,
    val technologies: Array<String>,
    val workExperience: Array<WorkExperience>,
    val education: Array<String>,
    val links: Array<String>,
    val favorites:List<String>
) {

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as User

        if(photo != other.photo) return false
        if(name != other.name) return false
        if(surname != other.surname) return false
        if(position != other.position) return false
        if(company != other.company) return false
        if(isMentor != other.isMentor) return false
        if(payment != other.payment) return false
        if(!technologies.contentEquals(other.technologies)) return false
        if(!workExperience.contentEquals(other.workExperience)) return false
        if(!education.contentEquals(other.education)) return false
        if(!links.contentEquals(other.links)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = photo.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + company.hashCode()
        result = 31 * result + isMentor.hashCode()
        result = 31 * result + (payment?.hashCode() ?: 0)
        result = 31 * result + technologies.contentHashCode()
        result = 31 * result + workExperience.contentHashCode()
        result = 31 * result + education.contentHashCode()
        result = 31 * result + links.contentHashCode()
        return result
    }
}

fun setCurrentUser(
    id:String,
    photo: String,
    name: String,
    surname: String,
    description: String,
    position: String,
    company: String,
    isMentor: Boolean,
    payment: Double?,
    technologies: Array<String>,
    workExperience: Array<WorkExperience>,
    education: Array<String>,
    links: Array<String>,
    favorites:List<String>
) {
    _currentUser = User(
        id = id,
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

private var _currentUser: User? = null

val currentUser: User
    get() = _currentUser!!
