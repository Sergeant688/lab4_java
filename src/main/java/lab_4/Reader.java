package lab_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для чтения данных сотрудников из файла.
 */
public class Reader
{

    private static DateTimeFormatter date_form = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Метод для чтения списка людей из файла, находящегося в ресурсах проекта.
     *
     * @param filePath  путь к файлу
     * @param separator разделитель
     * @return Список объектов {@link Person}
     * @throws IOException если возникают проблемы при чтении файла
     */
    public List<Person> read(String filePath, char separator) throws IOException
    {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(filePath))
        {
            return readPersons(in, separator);
        }
    }

    /**
     * Вспомогательный метод для чтения.
     *
     * @param in поток данных
     * @param separator разделитель
     * @return список загруженных людей
     */
    public List<Person> readPersons(InputStream in, char separator) throws IOException 
    {
        List<Person> persons = new ArrayList<>();
        Map<String, Division> divisionCache = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) 
        {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) 
            {
                if (isHeader) 
                {
                    isHeader = false;
                    continue;
                }
                String[] nextLine = line.split(String.valueOf(separator));

                if (nextLine.length < 6) 
                {
                    continue;
                }

                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                LocalDate birthday = LocalDate.parse(nextLine[3], date_form);
                String divisionName = nextLine[4];
                BigDecimal salary = new BigDecimal(nextLine[5]);

                Division division = divisionCache.computeIfAbsent(divisionName, 
                        key -> new Division(divisionCache.size() + 1, key));

                Person person = new Person(id, name, gender, birthday, division, salary);
                persons.add(person);
            }
        }
        return persons;
    }
}