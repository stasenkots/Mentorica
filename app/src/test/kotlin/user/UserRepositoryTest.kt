package user

import com.mentorica.models.LoginData
import com.mentorica.models.User
import com.mentorica.network.api.UserApi
import com.mentorica.user.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import retrofit2.HttpException


class UserRepositoryTest {

    val userApi: UserApi = mockk()
    val expectedUser: User = mockk()
    val httpException: HttpException = mockk()

    val userRepository = UserRepository(userApi)


    @Test
    fun `test current user is null when not initialized`() {
        assertThat(userRepository.currentUser).isNull()
        assertThat(userRepository.isUserLoggedIn()).isFalse
    }

    @Test
    fun `test current user is null when initialization failed`() {
        coEvery { userApi.getCurrentUser() } throws httpException

        runBlocking { userRepository.initCurrentUser() }

        assertThat(userRepository.currentUser).isNull()
        assertThat(userRepository.isUserLoggedIn()).isFalse
    }


    @Test
    fun `test initialization successful`() {
        coEvery { userApi.getCurrentUser() } returns expectedUser

        runBlocking { userRepository.initCurrentUser() }

        assertThat(userRepository.currentUser).isEqualTo(expectedUser)
        assertThat(userRepository.isUserLoggedIn()).isTrue
    }

    @Test
    fun `test sign up`() {
        val loginData = LoginData(LOGIN, PASSWORD)
        coEvery { userApi.signUp(loginData) } returns expectedUser

        runBlocking {
            userRepository.signUp(LOGIN, PASSWORD)
        }

        assertThat(userRepository.currentUser).isEqualTo(expectedUser)
    }

    @Test
    fun `test sign up failed`() {
        val loginData = LoginData(LOGIN, PASSWORD)
        coEvery { userApi.signUp(loginData) } throws httpException

        assertThrows<HttpException> {
            runBlocking {
                userRepository.signUp(LOGIN, PASSWORD)
            }
        }
        assertThat(userRepository.currentUser).isNull()
    }

    @Test
    fun `test login`() {
        coEvery { userApi.login(LOGIN, PASSWORD) } returns expectedUser

        runBlocking {
            userRepository.login(LOGIN, PASSWORD)
        }

        assertThat(userRepository.currentUser).isEqualTo(expectedUser)
    }

    @Test
    fun `test login failed`() {
        coEvery { userApi.login(LOGIN, PASSWORD) } throws httpException

        assertThrows<HttpException> {
            runBlocking {
                userRepository.login(LOGIN, PASSWORD)
            }
        }
        assertThat(userRepository.currentUser).isNull()
    }

    private companion object {
        const val LOGIN = "login"
        const val PASSWORD = "password"
    }
}
