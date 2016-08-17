package car.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import car.app.maintain.RegisterAppService;
import car.app.maintain.RegisterAppVO;
import car.domain.maintain.RegisterExeception;

public class RegisterTestCase extends BaseTest {

	@Autowired
	private RegisterAppService registerAppService;

	@Test
	public void testRegist() throws RegisterExeception {

		RegisterAppVO registerPageVO = new RegisterAppVO();
		
		registerAppService.create(registerPageVO);
	}

}
