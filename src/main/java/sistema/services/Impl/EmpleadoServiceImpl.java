package sistema.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.EmpleadosDao;
import sistema.entity.Empleado;
import sistema.services.EmpleadoService;

import java.util.List;

@Repository
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadosDao empleadosDao;

    public Page<Empleado> getPages(Pageable pageable, String txt){

        List<Empleado> lista = empleadosDao.listarEmpleados(txt);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Empleado> pages;
        pages = new PageImpl<Empleado>(lista.subList(start, end), pageable, lista.size());

        return pages;
    }

    public Page<Empleado> getPages(Pageable pageable){

        List<Empleado> lista = empleadosDao.listarEmpleados();
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Empleado> pages;
        pages = new PageImpl<Empleado>(lista.subList(start, end), pageable, lista.size());

        return pages;
    }

}
