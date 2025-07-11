
// from Vighneshwar Bhat on linkedin Java Dev Community
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierExamples {
	public static Void public static void main(String[] args) {
	// Lazy Loading with Suppliers
	MySupplier<String> lazyString = () -> {
		System.out.printLn("Computing the String...");
		return "Lazy loaded String...";
	};

	String result = lazyString.get();
	system.out.printLn(result);

	// Dynamic Value Generation
	Supplier<Double> randomDoubleSupplier = Math::random;
	System.out.System.out.println("Random Double: " + randomDoubleSupplier.get());

	// Real World Applications
	Supplier<Integer> timeoutSupplier = () -> {
		// Some logic to fetch the timeout from configuration
		return Integer.parseInt("5000");
	};

	Supplier<Connection> dbConnectionSupplier = () -> {
		try {
			//Logic to create and return a database connection
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase",
"username", "password");
		} catch (Exception e) {
			throw new RuntimeException("Error creating database connection", e);
		}
	};

	// Enhancing Readability in Streams
	List<String> words = Arrays.asList("apple", "bananna", "orange");
	List<String> uppercaseWords = words.stream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());

	System.out.println("Uppercased Words: " + uppercaseWords); 
	}

	@FunctionalInterface
	interface MySupplier<T> {
		T get();
	}
}