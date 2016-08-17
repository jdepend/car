package car.test;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import car.infrastructure.util.ApplicationContextUtil;

@ContextConfiguration(locations = { "classpath:META-INF/spring-test-context/test-context.xml" })
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Before
	public void init(){
		ApplicationContextUtil.setApplicationContext(this.applicationContext);
	}

}
