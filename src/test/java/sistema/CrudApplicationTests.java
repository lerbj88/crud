package sistema;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sistema.services.FacturasService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTests {

	@Autowired
	//ClientesDao clientesDao;
	//PuntoventaService puntoventaService;
	//		FacturasDao facturasDao;
	//CortecajaDao cortecajaDao;
	//		NominasDao nominasDao;
	//Nominas_detalleDao nominas_detalleDao;
			FacturasService facturasService;

	@Test
	public void contextLoads() {

		//puntoventaService.obtenerCliente("ABC123");

	//	clientesDao.getClientes();

	//	facturasDao.maxId();

	//	facturasDao.getTotalFacturas();

		//nominasDao.getNomina(1);

	//	nominasDao.getNomina_detalle(1);

	//	nominas_detalleDao.getDetalle_nomina(1);

//		facturasDao.getFactura_lavadores(48);

	//	cortecajaDao.totalRestante();

		facturasService.getLavadoresxfactura(48);

	}

}
