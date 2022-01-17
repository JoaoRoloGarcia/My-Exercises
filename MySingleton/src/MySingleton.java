import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.NestingKind;

public class MySingleton {

	private List<String> shopList;
	private static MySingleton instance = new MySingleton();
	

	private MySingleton() {
		shopList = new ArrayList<>();

		if (instance != null) {
			throw new RuntimeException("Use getInstance() method.");
		}

	}

	public static MySingleton getInstance() {

		if (instance == null) {
			synchronized (MySingleton.class) {
				if (instance == null) {
					instance = new MySingleton();

				}
			}
		}
		return instance;
	}

	public boolean verify(String item) {
		
		for (String s : shopList) {
			
			if (foodOrOtherVerification(item)) {

				System.out.println("Verification for: StartsWith Food/Other passed.");

				if (item.equals(s)) {

					System.out.println("Verification for Item already exists: passed");
					return false;
				}

			} else {
				
				return false;
			}

		}
		return true;
	}

	//Adding to the List if argument passes tests
	
	public boolean add(String item) {
		
		if (shopList.isEmpty()) {
			
			if (foodOrOtherVerification(item)) {
				
				shopList.add(item);
				return true;

			} else {
				
				return false;
			}
		}
		
		if (verify(item)) {
			shopList.add(item);
			return true;
			
		}
		return false;
	}
	
	// Getting ListSize to see if it adds the elements

	public int getListSize() {
		return shopList.size();
	}
	
	// Verification if arguments starts with Food || Other

	private boolean foodOrOtherVerification(String item) {
		if (item.startsWith("Food") || item.startsWith("Other")) {
			return true;
		} else {
			return false;
		}
	}
	
	//printing items that start with Food
	
	public void getAllFood() {
		
		List<String> foodList = shopList.stream()
				.filter(s -> s.startsWith("Food"))
				.collect(Collectors.toList());
			System.out.println(foodList.toString());
	}
	
	
	//printing items that start with Other

	public void getAllOther() {
		
		List<String> otherList = shopList.stream()
				.filter(s -> s.startsWith("Other"))
				.collect(Collectors.toList());
		System.out.println(otherList.toString());
	}
}
