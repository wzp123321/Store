import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;

public class TestAddresss {
	AbstractXmlApplicationContext ac;
	AddressMapper addressMapper;
	
	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-dao.xml");

		addressMapper = ac.getBean("addressMapper", AddressMapper.class);

	}

	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("¡ı¿œ ¶");
		Integer rows = addressMapper.insert(address);
		System.out.println("rows=" + rows);
	}

	@After
	public void after() {
		ac.close();
	}
}
