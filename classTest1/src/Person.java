/**
 * 类Person的定义
 * 
 * @author 陈泫文
 *
 */
public class Person {

	protected String name;
	protected String homeTelephone;
	protected String email;

	/**
	 * 无参构造函数
	 */
	public Person() {

	}

	/**
	 * 有参构造函数
	 * 
	 * @param initialName
	 * @param initialHomeTelephone
	 * @param initialEmail
	 */
	public Person(String initialName, String initialHomeTelephone,
			String initialEmail) {
		this.name = initialName;
		this.homeTelephone = initialHomeTelephone;
		this.email = initialEmail;
	}

	/**
	 * 获得属性name的值
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 获得属性homeTelephone的值
	 * 
	 * @return homeTelephone
	 */
	public String getHomeTelephone() {
		return this.homeTelephone;
	}

	/**
	 * 获得属性email的值
	 * 
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 复写equals，根据name判断两个对象是否相等
	 * 
	 * @param person
	 * @return boolean
	 */
	public boolean equals(Person person) {
		if (person.getName().equals(this.name)) {
			return true;
		}
		return false;
	}

	/**
	 * 复写toString方法，打印各个属性，并以下划线分隔
	 * 
	 */
	public String toString() {
		/* 不直接调用属性，以保证属性的安全 */
		return this.getName() + "_" + this.getHomeTelephone() + "_" + this.getEmail();
	}

}
