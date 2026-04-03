package lab_4;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Класс, представляющий сущность сотрудник.
 */
public class Person
{
	private int id;
	private String name;
	private String gender;
	private BigDecimal salary;
	private Division division;
    private LocalDate birthday;
    
    /**
     * Конструктор для создания объекта Person.
     *
     * @param id        уникальный идентификатор
     * @param name      имя
     * @param gender    пол
     * @param birthDate дата рождения
     * @param division  подразделение
     * @param salary    зарплата
     */
    public Person(int id, String name, String gender, LocalDate birthday, Division division, BigDecimal salary)
    {
    	this.id = id;
    	this.name = name;
    	this.gender = gender;
    	this.salary = salary;
    	this.division=division;
    	this.birthday = birthday;	
    }
    
	public int getId()
    {
    	return id;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String getGender()
    {
    	return gender;
    }
    
    public BigDecimal getSalary()
    {
    	return salary;
    }
    
    public Division getDivision()
    {
    	return division;
    }
    
    public LocalDate getBirthday()
    {
    	return birthday;
    }
}