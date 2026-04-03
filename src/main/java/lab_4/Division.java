package lab_4;

/**
 * Класс, представляющий сущность подразделение.
 */
public class Division
{
	private int id;
	private String name;
	
	 /**
     * Конструктор для создания подразделения.
     *
     * @param id   уникальный идентификатор
     * @param name название подразделения
     */
	public Division(int id, String name)
	{
		this.id = id;
		this.name=name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
}