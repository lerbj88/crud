package sistema.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.ClientesDao;
import sistema.dao.VehiculosDao;
import sistema.dto.ClienteDto;
import sistema.entity.Clientes;
import sistema.entity.Vehiculos;
import sistema.services.PuntoventaService;

import java.util.logging.Logger;

@Repository
@Transactional
public class PuntoventaServiceImpl implements PuntoventaService {


    @Autowired
    ClientesDao clientesDao;

    @Autowired
    VehiculosDao vehiculosDao;

    private final static Logger logger = Logger.getLogger("sistema.services.Impl.PuntoventaServiceImpl");

    public ClienteDto obtenerCliente(String  fcplacas){

        Clientes cliente=null;
        Vehiculos vehiculo = null;
        ClienteDto clienteDto2 =  new ClienteDto();

        fcplacas = fcplacas.toUpperCase();



            vehiculo = vehiculosDao.obtenerVehiculo(fcplacas);
            cliente = clientesDao.obtenerCliente(fcplacas);
            logger.warning(String.valueOf(vehiculo));

            ClienteDto clienteDto = new ClienteDto(cliente.getFiid(), cliente.getFccliente(), cliente.getFcemail(), cliente.getFctelefono(), vehiculo.getFiid(), vehiculo.getFcplacas(), vehiculo.getFccolor(), vehiculo.getFcmarca());

        return clienteDto;
    }



}
