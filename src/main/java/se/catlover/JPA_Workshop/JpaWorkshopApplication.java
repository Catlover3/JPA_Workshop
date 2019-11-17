package se.catlover.JPA_Workshop;
	/*
	Varför har man collections och databaser samtidigt, borde man inte använda det ena eller det andra?
	Uppgiften "Add functionality to find ProductOrders by DATE. Refactoring may be
needed." Gör man sorteringen via SQL queryn eller sorterar man listan efteråt i programmet?
	*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaWorkshopApplication.class, args);
	}

}
