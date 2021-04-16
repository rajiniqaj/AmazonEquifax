package com.mycompany.tests;

import com.mycompany.steps.ApiTestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class API_Get_Delete_Tests {

	
	@Steps
	ApiTestSteps apiTestSteps;
	
	
	@Test
	public void employeeEndToEndTestApi() {

		apiTestSteps.getEmployeeDetails();
		apiTestSteps.verifyStatusCodeForSuccess();
		apiTestSteps.deleteEmployee();
		
	}

}
