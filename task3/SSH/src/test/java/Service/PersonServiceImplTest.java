package Service;

import Base.BaseClass;

public class PersonServiceImplTest {
	public static PersonService getPersonServiceInstance() {
		return (PersonService) BaseClass.LoadXML().getBean("personServiceImpl");
	}
	public static void main(String[] args) {
		PersonServiceImplTest.getPersonServiceInstance().tran();
	}
}