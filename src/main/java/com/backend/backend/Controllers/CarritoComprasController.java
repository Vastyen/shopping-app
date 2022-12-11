package com.backend.backend.Controllers;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Services.CarritoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/carritoCompras")
public class CarritoComprasController {

    @Autowired
    CarritoComprasService carritoComprasService;

    @GetMapping("/getAllCarritoCompras")
    public ResponseEntity<ArrayList<CarritoComprasEntity>> getAllCarritoCompras() {
        ArrayList<CarritoComprasEntity> carritoComprasEntities = carritoComprasService.getAllCarritoCompras();
        if (carritoComprasEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasEntities);
    }
    @GetMapping("/getCarritoComprasById/{id_carrito}")
    public ResponseEntity<CarritoComprasEntity> getCarritoComprasById(@PathVariable("id_carrito") Integer id_carrito) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasService.getCarritoComprasById(id_carrito);
        if (carritoComprasEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasEntity);
    }
    @GetMapping("/getCarritoComprasByIdUsuario/{id_usuario}")
    public ResponseEntity<CarritoComprasEntity> getCarritoComprasByIdUsuario(@PathVariable("id_usuario") Integer id_usuario) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasService.getCarritoComprasByIdUsuario(id_usuario);
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
        carritoComprasService.updateCarritoCompras(carritoComprasEntity, id_carrito);
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
    @GetMapping("/getProductosByIdUsuario/{id_usuario}")
    public String getProductos(@PathVariable("id_usuario") Integer id_usuario) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasService.getCarritoComprasByIdUsuario(id_usuario);
        if (carritoComprasEntity == null) {
            return null;
        }
        return "redirect:/carritoComprasProducto/getProductosByIdCarritoCompras/" + carritoComprasEntity.getId();

    }
}
