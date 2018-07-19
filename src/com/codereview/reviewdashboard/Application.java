package com.codereview.reviewdashboard;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.codereview.reviewdashboard.dashboard.DashboardGenerator;

@SpringBootApplication(scanBasePackages={"com.codereview.reviewdashboard"})
public class Application {
	
	//Entry point for the application
	public static void main(String [] args){
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
		SpringApplication.exit(ctx, () -> 0);
	}
	
	@Bean
	public CommandLineRunner run(ApplicationContext ctx){
		
		return args -> {
            
            DashboardGenerator dbGenerator = ctx.getBean(DashboardGenerator.class);
            dbGenerator.generateReviewDashboard();
		};
		
	}

}
