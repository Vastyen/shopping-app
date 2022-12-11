package com.backend.backend.Controllers;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.CarritoComprasProductoEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Services.CarritoComprasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/carritoComprasProducto")
public class CarritoComprasProductoController {

    @Autowired
    CarritoComprasProductoService carritoComprasProductoService;

    @GetMapping("/getAllCarritoComprasProducto")
    public ResponseEntity<ArrayList<CarritoComprasProductoEntity>> getAllCarritoComprasProducto() {
        ArrayList<CarritoComprasProductoEntity> carritoComprasProductoEntities = carritoComprasProductoService.getAllCarritoComprasProducto();
        if (carritoComprasProductoEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasProductoEntities);
    }
    @GetMapping("/getProductosByIdCarritoCompras/{id_carrito}")
    public ResponseEntity<ArrayList<CarritoComprasProductoEntity>> getProductosByIdCarritoCompras(@PathVariable("id_carrito") Integer id_carrito) {
        ArrayList<CarritoComprasProductoEntity> CarritoCompras = carritoComprasProductoService.getProductosByIdCarritoCompras(id_carrito);
        if (CarritoCompras == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CarritoCompras);
    }
    @GetMapping("/addProductoToMyCart/{id_carrito}/{id_producto}/{cantidad}")
    public ResponseEntity<CarritoComprasProductoEntity> addProductoToMyCart(@PathVariable("id_producto") Integer id_producto, @PathVariable("id_carrito") Integer id_carrito, @PathVariable("cantidad") Integer cantidad) {
        CarritoComprasProductoEntity carritoComprasProductoEntity = carritoComprasProductoService.addProductoToMyCart(id_producto, id_carrito, cantidad);
        if (carritoComprasProductoEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasProductoEntity);
    }
}
