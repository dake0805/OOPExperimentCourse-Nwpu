/**
 * ��IndividualCustomer�Ķ��壬��ʵ��Customer�ӿ�
 * 
 * @author ������
 *
 */
public class IndividualCustomer implements Customer {

	/* ���Զ��� */
	private String customerId;
	private Person person;
	
	/**
	 * �޲ι��캯��
	 */
	public IndividualCustomer() {
		
	}
	
	/**
	 * �вι��캯�������Խ��г�ʼ��
	 * 
	 * @param initialCustomerId
	 * @param initialPerson
	 */
	public IndividualCustomer(String initialCustomerId, Person initialPerson) {
		this.customerId = initialCustomerId;
		this.person = initialPerson;
	}

	/**
	 * ���Person���Ե�ֵ
	 * 
	 * @return Person
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * �Խӿڷ�������ʵ��
	 * 
	 * @return customerId
	 */
	@Override
	public String getCustomerId() {
		// TODO Auto-generated method stub
		return this.customerId;
	}

}
