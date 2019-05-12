package crud;

import crud.dao.ClientesDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTests {

	@Autowired
	ClientesDao clientesDao;

	@Test
	public void contextLoads() {

		clientesDao.getClientes();

	}

}
