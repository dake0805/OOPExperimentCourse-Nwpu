/**
 * ��Person�Ķ���
 * 
 * @author ������
 *
 */
public class Person {

	protected String name;
	protected String homeTelephone;
	protected String email;

	/**
	 * �޲ι��캯��
	 */
	public Person() {

	}

	/**
	 * �вι��캯��
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
	 * �������name��ֵ
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * �������homeTelephone��ֵ
	 * 
	 * @return homeTelephone
	 */
	public String getHomeTelephone() {
		return this.homeTelephone;
	}

	/**
	 * �������email��ֵ
	 * 
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * ��дequals������name�ж����������Ƿ����
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
	 * ��дtoString��������ӡ�������ԣ������»��߷ָ�
	 * 
	 */
	public String toString() {
		/* ��ֱ�ӵ������ԣ��Ա�֤���Եİ�ȫ */
		return this.getName() + "_" + this.getHomeTelephone() + "_" + this.getEmail();
	}

}
