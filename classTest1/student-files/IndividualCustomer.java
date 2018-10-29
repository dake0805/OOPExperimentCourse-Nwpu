/**
 * 类IndividualCustomer的定义，并实现Customer接口
 * 
 * @author 陈泫文
 *
 */
public class IndividualCustomer implements Customer {

	/* 属性定义 */
	private String customerId;
	private Person person;
	
	/**
	 * 无参构造函数
	 */
	public IndividualCustomer() {
		
	}
	
	/**
	 * 有参构造函数对属性进行初始化
	 * 
	 * @param initialCustomerId
	 * @param initialPerson
	 */
	public IndividualCustomer(String initialCustomerId, Person initialPerson) {
		this.customerId = initialCustomerId;
		this.person = initialPerson;
	}

	/**
	 * 获得Person属性的值
	 * 
	 * @return Person
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * 对接口方法进行实现
	 * 
	 * @return customerId
	 */
	@Override
	public String getCustomerId() {
		// TODO Auto-generated method stub
		return this.customerId;
	}

}
