import org.junit.Test
import org.junit.Assert.*
import com.tonpackage.data.local.NinjaEntity

class ChakraTest {

    @Test
    fun chakra_ne_devient_pas_negatif() {
        val chakra = 0
        val result = (chakra - 10).coerceAtLeast(0)
        assertEquals(0, result)
    }
}


class NinjaCreationTest {

    @Test
    fun creation_ninja_correcte() {
        val ninja = NinjaEntity(name = "Naruto", village = "Konoha", chakra = 90)

        assertEquals("Naruto", ninja.name)
        assertEquals("Konoha", ninja.village)
        assertEquals(90, ninja.chakra)
    }
}

class SearchTest {

    @Test
    fun recherche_filtre_correctement() {

        val list = listOf(
            "Naruto",
            "Sasuke",
            "Sakura",
            "Kakashi"
        )

        val query = "sa"

        val result = list.filter {
            it.lowercase().contains(query)
        }

        assertTrue(result.contains("Sasuke"))
        assertTrue(result.contains("Sakura"))
        assertFalse(result.contains("Naruto"))
    }
}