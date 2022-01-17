
public class Main {

	public static void main(String[] args) {
		
		MySingleton instance = MySingleton.getInstance();
		
		
		instance.add("Food");
		instance.add("Estrelitas");
		instance.add("OtherThings");
		
		System.out.println(instance.getListSize());
		
		instance.getAllFood();
		instance.getAllOther();

	}

}
