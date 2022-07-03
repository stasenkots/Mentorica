package nav

import com.mentorica.nav.NavUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class NavUtilsTest {

    @ParameterizedTest
    @MethodSource("data")
    fun testPathWithArgs(args: List<String>, expected: String) {
        val path = NavUtils.composePath("screen", args)
        assertThat(path).isEqualTo(expected)
    }



    companion object {

        @JvmStatic
        fun data(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(listOf("arg1", "arg2", "arg3"), "$SCREEN_NAME/{arg1}/{arg2}/{arg3}"),
                Arguments.of(listOf("arg1"), "$SCREEN_NAME/{arg1}"),
                Arguments.of(emptyList<String>(), SCREEN_NAME),
            )
        }

        const val SCREEN_NAME = "screen"
    }
}
