import lab_4.Person;
import lab_4.Reader;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class lab4Test
{

    @Test
    void testReadPersons() throws Exception 
    {
        String data = "id;name;gender;BirtDate;Division;Salary\n" +
                "28281;Aahan;Male;15.05.1970;I;4800\n" +
                "28282;Aala;Female;07.02.1983;J;2600\n" +
                "28283;Aaleahya;Female;15.05.1970;I;1000";
        InputStream input = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        Reader util = new Reader();

        List<Person> persons = util.readPersons(input, ';');

        assertEquals(3, persons.size(), "Должно быть загружено 3 человека");

        Person firstPerson = persons.get(0);
        assertEquals(28281, firstPerson.getId());
        assertEquals("Aahan", firstPerson.getName());
        assertEquals("Male", firstPerson.getGender());
        assertEquals("I", firstPerson.getDivision().getName());

        Person thirdPerson = persons.get(2);
        assertNotNull(firstPerson.getDivision().getId());
        assertEquals(firstPerson.getDivision().getId(), thirdPerson.getDivision().getId(),
                "ID одинаковых подразделений ('I') должны совпадать");
    }
}