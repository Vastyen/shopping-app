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
        return empresaRepository.findById(id_empresa).orElse(null);
    }

    public void saveEmpresa(EmpresaEntity empresaEntity) {
        empresaRepository.save(empresaEntity);
    }

    public EmpresaEntity createEmpresa(EmpresaEntity empresaEntity) {
        return empresaRepository.save(empresaEntity);
    }

    public void deleteEmpresa(EmpresaEntity empresaEntity) {
        empresaRepository.delete(empresaEntity);
    }

    public ArrayList<EmpresaEntity> getAllEmpresas() {
        return (ArrayList<EmpresaEntity>) empresaRepository.findAll();
    }
}
