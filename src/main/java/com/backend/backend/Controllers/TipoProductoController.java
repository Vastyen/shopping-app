package com.backend.backend.Controllers;

import com.backend.backend.Entities.TipoProductoEntity;
import com.backend.backend.Services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/tipoProducto")
public class TipoProductoController {
    @Autowired
    TipoProductoService tipoProductoService;

    @GetMapping("/getAllTipoProducto")
    public ResponseEntity<ArrayList<TipoProductoEntity>> getAllTipoProducto() {
        ArrayList<TipoProductoEntity> tipoProductoEntities = tipoProductoService.getAllTipoProducto();
        if (tipoProductoEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoProductoEntities);
    }
    @GetMapping("/getTipoProductoById/{id_tipo_producto}")
    public ResponseEntity<TipoProductoEntity> getTipoProductoById(@PathVariable("id_tipo_producto") Integer id_tipo_producto) {
        TipoProductoEntity tipoProductoEntity = tipoProductoService.getTipoProductoById(id_tipo_producto);
        if (tipoProductoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoProductoEntity);
    }

    @PutMapping("/updateTipoProductoById/{id_tipo_producto}")
    public ResponseEntity<TipoProductoEntity> updateTipoProductoById(@PathVariable("id_tipo_producto") Integer id_tipo_producto, @RequestBody TipoProductoEntity tipoProductoEntity) {
        TipoProductoEntity tipoProductoEntity1 = tipoProductoService.getTipoProductoById(id_tipo_producto);
        if (tipoProductoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        tipoProductoService.saveTipoProducto(tipoProductoEntity);
        return ResponseEntity.ok(tipoProductoEntity);
    }

    @PostMapping("/createTipoProducto")
    public ResponseEntity<TipoProductoEntity> createTipoProducto(@RequestBody TipoProductoEntity tipoProductoEntity) {
        TipoProductoEntity tipoProductoEntity1 = tipoProductoService.createTipoProducto(tipoProductoEntity);
        if (tipoProductoEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoProductoEntity1);
    }

    @DeleteMapping("/deleteTipoProductoById/{id_tipo_producto}")
    public ResponseEntity<TipoProductoEntity> deleteTipoProductoById(@PathVariable("id_tipo_producto") Integer id_tipo_producto) {
        TipoProductoEntity tipoProductoEntity = tipoProductoService.getTipoProductoById(id_tipo_producto);
        if (tipoProductoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        tipoProductoService.deleteTipoProducto(tipoProductoEntity);
        return ResponseEntity.ok(tipoProductoEntity);
    }
}
