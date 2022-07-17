package com.mentorica.network.mapping

import com.mentorica.models.Experience
import com.mentorica.models.Link
import com.mentorica.models.Payment
import com.mentorica.models.Skill
import com.mentorica.models.User
import com.mentorica.network.dto.ExperienceDto
import com.mentorica.network.dto.LinkDto
import com.mentorica.network.dto.UserDto
import javax.inject.Inject

class UserMapper @Inject constructor(){

    fun map(userDto: UserDto): User {
        return User(
            id = userDto.id,
            name = userDto.name.orEmpty(),
            surname = userDto.surname.orEmpty(),
            isMentor = userDto.isMentor,
            position = userDto.position,
            payment = Payment(userDto.payment),
            company = userDto.company,
            skills = userDto.skills.map { Skill(it) },
            links = userDto.links.map { map(it) },
            workExperience = userDto.workExperience.map { map(it) },
            education = userDto.workExperience.map { map(it) },
            favorites = userDto.favorites,
            description = userDto.description.orEmpty(),
            photo =  userDto.photo.orEmpty()
        )
    }

    fun map(user: User): UserDto {
        return UserDto(
            id = user.id,
            name = user.name,
            surname = user.surname,
            isMentor = user.isMentor,
            position = user.position,
            payment = user.payment.amount,
            company = user.company,
            skills = user.skills.map { it.skill },
            links = user.links.map { map(it) },
            workExperience = user.workExperience.map { map(it) },
            education = user.workExperience.map { map(it) },
            favorites = user.favorites,
            description = user.description,
            photo = user.photo
        )
    }

    private fun map(linkDto: LinkDto): Link {
        return Link(
            site = linkDto.site,
            link = linkDto.link
        )
    }

    private fun map(experienceDto: ExperienceDto): Experience {
        return Experience(
            companyName = experienceDto.companyName,
            startDate = experienceDto.startDate,
            endDate =  experienceDto.endDate,
            position = experienceDto.position
        )
    }


    private fun map(link: Link): LinkDto {
        return LinkDto(
            site = link.site,
            link = link.link
        )
    }

    private fun map(experience: Experience): ExperienceDto {
        return ExperienceDto(
            companyName = experience.companyName,
            startDate = experience.startDate,
            endDate =  experience.endDate,
            position = experience.position
        )
    }
}
