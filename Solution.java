

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Solution {

	public static void main(String[] args) throws IOException, SQLException {
		String username;
		String password;
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		System.out.println("Enter the user name:");
		username=buffer.readLine();
		System.out.println("Enter the password:");
		password=buffer.readLine();
		
		User users=new User();
		users.setUsername(username);
		users.setPassword(password);
		try {
			if (Authenticate.checkValidity(users)) {
				System.out.println("Login is Successful Success");
				boolean f = true;
				while (f) {
					System.out.print("1.Create \t 2.Retrieve \t 3.Update \t 4.Delete\n Choice:");
					int ch=Integer.parseInt(buffer.readLine());
					System.out.println(ch);
					switch(ch){
					case 1:
						Tasks.insertItem();
						System.out.println("the values are inserted");
						break;
					case 2:
						Tasks.retrieveItems();
						break;
					case 3:
						Tasks.updateItem();
						System.out.println("Values are Updated");
						break;
					case 4:
						Tasks.deleteItem();
						System.out.println("the values have been deleted");
						break;
					default:
						f=false;
						break;
					}
			}
				
		}
			else{
				System.out.println("Invalid Login");
			}
		}
		catch (Exception e) {
		
	}
		
}

}