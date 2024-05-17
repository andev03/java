package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembersShipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao theAccountDao, MembersShipDao theMembersShipDao){

		return runner -> {
			demoTheBeforeAdvice(theAccountDao, theMembersShipDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDao theAccountDao, MembersShipDao theMembersShipDao) {

		// call the business method
		theAccountDao.addAccount();

		// call the membership business method
		theMembersShipDao.addAccount();

	}
}
