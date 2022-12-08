package com.backend.backend.Controllers;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/getEmpresaById/{id_empresa}")
    public ResponseEntity<EmpresaEntity> getEmpresaById(@PathVariable("id_empresa") Integer id_empresa) {
        EmpresaEntity empresaEntity = empresaService.getEmpresaById(id_empresa);
        if (empresaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresaEntity);
    }

    @PutMapping("/updateEmpresaById/{id_empresa}")
    public ResponseEntity<EmpresaEntity> updateEmpresaById(@PathVariable("id_empresa") Integer id_empresa, @RequestBody EmpresaEntity empresaEntity) {
        EmpresaEntity empresaEntity1 = empresaService.getEmpresaById(id_empresa);
        if (empresaEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        empresaEntity1.setNombre_empresa(empresaEntity.getNombre_empresa());
        empresaEntity1.setProductos(empresaEntity.getProductos());
        empresaService.saveEmpresa(empresaEntity);
        return ResponseEntity.ok(empresaEntity);
    }

    @PostMapping("/createEmpresa")
    public ResponseEntity<EmpresaEntity> createEmpresa(@RequestBody EmpresaEntity empresaEntity) {
        EmpresaEntity empresaEntity1 = empresaService.createEmpresa(empresaEntity);
        if (empresaEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresaEntity1);
    }

    @DeleteMapping("/deleteEmpresaById/{id_empresa}")
    public ResponseEntity<EmpresaEntity> deleteEmpresaById(@PathVariable("id_empresa") Integer id_empresa) {
        EmpresaEntity empresaEntity = empresaService.getEmpresaById(id_empresa);
        if (empresaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        empresaService.deleteEmpresa(empresaEntity);
        return ResponseEntity.ok(empresaEntity);
    }

    @GetMapping("/getAllEmpresas")
    public ResponseEntity<ArrayList<EmpresaEntity>> getAllEmpresas() {
        ArrayList<EmpresaEntity> empresaEntityList = empresaService.getAllEmpresas();
        if (empresaEntityList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresaEntityList);
    }

}
