import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Tasks {
	public static void insertItem() throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Item[] item=new Item[50];
		int itemno=0;
		System.out.println("Number of items to be inserted:");
		Integer n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			System.out.println("Item Name:");
			item[itemno]=new Item();
			item[itemno].setName(bf.readLine());
			System.out.println("Price:");
			item[itemno].setPrice(Integer.parseInt(bf.readLine()));
			System.out.println("Quantity:");
			item[itemno].setQuantity(Integer.parseInt(bf.readLine()));
			System.out.println("Expiry Date:");
			item[itemno].setExpiryDate(bf.readLine());
			System.out.println("Manufacturing Date:");
			item[itemno].setManufactureDate(bf.readLine());
			session.save(item[itemno]);
			itemno++;
		}
		session.getTransaction().commit();
		session.close();
	}
	public static void retrieveItems(){ 
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Item");
		List<Item> list= query.getResultList();
		for(Item each:list){
			System.out.println(each.getId()+"   "+each.getName()+"   "+each.getPrice()+"   "+each.getQuantity()+"   "+each.getManufactureDate()+"   "+each.getExpiryDate());
		}
		session.getTransaction().commit();
		session.close();
	}
	public static void updateItem() throws NumberFormatException, IOException{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Item");
		List<Item> list= query.getResultList();
		
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the item id to be updated:");
		int ch=Integer.parseInt(buffer.readLine());
		
		
		for(Item each:list){
			if(ch==each.getId()){
				boolean f=true;
				while(f)
				{
				System.out.println("enter what field you want to change");
				System.out.println("1.Name\t2.Price\t3.Quantity\t4.Expiry Date\t5.Manufacture Date");
				int choice=Integer.parseInt(buffer.readLine());
				switch (choice) {
				case 1:
					System.out.println("Enter the new item name:");
					String name=buffer.readLine();
					each.setName(name);
					break;
				case 2:
					System.out.println("Enter the new Price:");
					int price=Integer.parseInt(buffer.readLine());
					each.setPrice(price);
					break;
				case 3:
					System.out.println("Enter the new Quantity:");
					int quantity=Integer.parseInt(buffer.readLine());
					each.setQuantity(quantity);
					break;
				case 4:
					System.out.println("Enter the new Expiry Date:");
					String expiryDate=buffer.readLine();
					each.setExpiryDate(expiryDate);
					break;
				case 5:
					System.out.println("Enter the new Manufacture Date:");
					String manufactureDate=buffer.readLine();
					each.setManufactureDate(manufactureDate);
					break;

				default:
					f=false;
					break;
				}
				
				
			}}
			
		}
		
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteItem() throws NumberFormatException, IOException{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Entert the item id to be deleted:");
		int ch=Integer.parseInt(bf.readLine());
		Query query=session.createQuery("from Item");
		List<Item> list= query.getResultList();
		for(Item each:list){
			if(ch==each.getId()){
				session.delete(each);
			}
		}
		session.getTransaction().commit();
		session.close();
	}

	
}
