

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {

	public static void main(String[] args){
		Contact contact = new Contact();
		contact.setId(13);
		contact.setFirstName("Farhan");
		contact.setLastName("Jailani");
		contact.setEmailId("random@random.com");
		contact.setPhoneNo(9876543211L);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
		session.close();
	}

}





