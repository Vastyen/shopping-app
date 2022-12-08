package com.backend.backend.Services;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;
    public EmpresaEntity getEmpresaById(Integer id_empresa) {
        
    }

    public void saveEmpresa(EmpresaEntity empresaEntity) {
        
    }

    public EmpresaEntity createEmpresa(EmpresaEntity empresaEntity) {
    }

    public void deleteEmpresa(EmpresaEntity empresaEntity) {
    }

    public ArrayList<EmpresaEntity> getAllEmpresas() {
    }
}
