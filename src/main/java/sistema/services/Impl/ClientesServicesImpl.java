package sistema.services.Impl;

import sistema.dao.ClientesDao;
import sistema.entity.Clientes;
import sistema.services.ClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ClientesServicesImpl  implements ClientesServices {

@Autowired
ClientesDao clientesDao;

    public Page<Clientes> getPages(Pageable pageable, String txt){

        List<Clientes> lista = clientesDao.getClientes(txt);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Clientes> pages;
        pages = new PageImpl<Clientes>(lista.subList(start, end), pageable, lista.size());

        return pages;
    }
}
