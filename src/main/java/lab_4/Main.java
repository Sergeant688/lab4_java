package lab_4;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        Reader readerUtil = new Reader();
        String fileName = "foreign_names.csv";
       
        List<Person> persons = readerUtil.read(fileName, ';');
            
        System.out.println("Успешно считано людей: " + persons.size());
        System.out.println("\n--- Список сотрудников ---");
        System.out.printf("%-8s %-20s %-10s %-15s %-15s %-10s%n", 
                "ID", "Name", "Gender", "Birthday", "Division", "Salary");
        
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        int count = 0;
        for (Person person : persons) 
        {
            if (count >= 300) 
            {
                break;
            }
            System.out.printf("%-8d %-20s %-10s %-15s %-15s %-10s%n",
                    person.getId(), person.getName(), person.getGender(),
                    person.getBirthday().format(form), person.getDivision().getName(), person.getSalary());
            count++;
        }
    }
}