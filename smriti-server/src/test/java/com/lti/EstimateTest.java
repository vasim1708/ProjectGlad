package com.lti;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.entity.Premium;
import com.lti.repository.EstimateRepository;
import com.lti.repository.EstimateRepositoryImpl;

@SpringBootTest
@Rollback(true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EstimateTest {
	
	@Autowired
	private EstimateRepository estimateRepo;
		@Test
		public void addPremium() {
			Premium newPremium = new Premium();
			//EstimateRepositoryImpl estRepo = new EstimateRepositoryImpl();
			
			newPremium.setId(6);
			newPremium.setAge(4);
			newPremium.setAmount(3000);
			newPremium.setDepreciationRate(10);
			newPremium.setModel("Dio");
			newPremium.setType("2-Wheeler");
			newPremium.setDuration(1);
			newPremium.setLossSuffered(10000.0);
			newPremium.setTotalCostOfVehicle(70000.0);
			
			estimateRepo.save(newPremium);
		}
}
