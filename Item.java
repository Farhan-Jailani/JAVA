
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="PRICE")
	private float price;
	@Column(name="QUANTITY")
	private Integer quantity;
	@Column(name="MANUFACTURE_DATE")
	private String manufactureDate;
	@Column(name="EXPIRY_DATE")
	private String expiryDate;
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
