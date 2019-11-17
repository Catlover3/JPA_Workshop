package data;

import org.springframework.boot.CommandLineRunner;

public class CommandLine implements CommandLineRunner {
	
	private ProductRepo productRepo;

	public void ProductRepo(ProductRepo productrepo) {
		this.productRepo = productRepo;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
