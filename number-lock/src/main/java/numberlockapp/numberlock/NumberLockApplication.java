package numberlockapp.numberlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberLockApplication {

	public static final int NUM = 4;
	public static final int BASE = 10;

	public static void main(String[] args) {
		SpringApplication.run(NumberLockApplication.class, args);
	}

}
