package entity;

public class Flower {
     
	private int id;
	
	private String name;
	
	private String nickName;
	
	private String property;
	
	private float price;
	
	private String production;

	public Flower(int id, String name, String nickName, String property,
			float price, String production) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.property = property;
		this.price = price;
		this.production = production;
	}

	public Flower() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}
	
	
     
}
