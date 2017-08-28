
import java.util.List; 
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Authenticate {
		public static boolean checkValidity(User user){
		SessionFactory sf1=new Configuration().configure().buildSessionFactory();
		Session session1=sf1.openSession();
		session1.beginTransaction();
		Query query=session1.createQuery("from User");
		List<User> list= query.getResultList();
		

		for(User each:list){
			String username1=each.getUsername();
			String password1=each.getPassword();
			String username=user.getPassword();
			String password=user.getUsername();
			
			
			if(username1.compareTo(username)==0 && password1.compareTo(password)==0){
				return true;
			}
		}
		return false;
	}
}
