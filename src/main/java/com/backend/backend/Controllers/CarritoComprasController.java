package com.backend.backend.Controllers;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Services.CarritoComprasService;
import com.backend.backend.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carritoCompras")
public class CarritoComprasController {

    @Autowired
    CarritoComprasService carritoComprasService;


    @GetMapping("/getCarritoComprasById/{id_carrito}")
    public ResponseEntity<CarritoComprasEntity> getCarritoComprasById(@PathVariable("id_carrito") Integer id_carrito) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasService.getCarritoComprasById(id_carrito);
        if (carritoComprasEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasEntity);
    }
    @PutMapping("/updateCarritoComprasById/{id_carrito}")
    public ResponseEntity<CarritoComprasEntity> updateCarritoComprasById(@PathVariable("id_carrito") Integer id_carrito, @RequestBody CarritoComprasEntity carritoComprasEntity) {
        CarritoComprasEntity carritoComprasEntity1 = carritoComprasService.getCarritoComprasById(id_carrito);
        if (carritoComprasEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        carritoComprasEntity1.setId_usuario(carritoComprasEntity.getId_usuario());
        carritoComprasEntity1.setProductos(carritoComprasEntity.getProductos());
        carritoComprasService.saveCarritoCompras(carritoComprasEntity);
        return ResponseEntity.ok(carritoComprasEntity);
    }
    @PostMapping("/createCarritoCompras")
    public ResponseEntity<CarritoComprasEntity> createCarritoCompras(@RequestBody CarritoComprasEntity carritoComprasEntity) {
        CarritoComprasEntity carritoComprasEntity1 = carritoComprasService.createCarritoCompras(carritoComprasEntity);
        if (carritoComprasEntity1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasEntity1);
    }
    @DeleteMapping("/deleteCarritoComprasById/{id_carrito}")
    public ResponseEntity<CarritoComprasEntity> deleteCarritoComprasById(@PathVariable("id_carrito") Integer id_carrito) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasService.deleteCarritoComprasById(id_carrito);
        if (carritoComprasEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasEntity);
    }
}
