package car.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:META-INF/spring-test-context/test-context.xml" })
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

}
