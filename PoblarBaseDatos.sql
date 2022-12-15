INSERT INTO public.ubicacion_geografica(
    comuna, direccion, region)
VALUES
    ('La Florida', 'Walker Martinez 980', 'Metropolitana'),
    ('Maipu', 'Héctor Fuenzalida 1641-1659', 'Metropolitana'),
    ('Florida', 'Las Hortensias 1113', 'BioBío'),
    ('Chillán', '1000', 'Ñuble'),
    ('Macul', 'Av. Macul 4701', 'Metropolitana');

INSERT INTO public.empresa(
    nombre_empresa, restriccion_edad, id_ubicacion)
VALUES
    ('Verduras Inc.', 18, 1),
    ('Alimentos Inc.', 17, 5),
    ('DBD Inc.', 12, 3),
    ('USACH Inc.', 10, 4),
    ('MILO In.c', 17, 2),
    ('JOSE Inc.', 17, 4),
    ('Javier Inc', 18, 1),
    ('Frutas Inc.', 18, 3),
    ('Chile Inc.', 18, 4),
    ('HolaMundo Inc.', 18, 5);

INSERT INTO public.rol(
    id, alias_rol, nombre_rol)
VALUES
    (1, 'Admin', 'Administrador'),
    (2, 'User', 'Cliente'),
    (3, 'Emp', 'Empresa');

INSERT INTO public.usuario(
    id_usuario, apellido_usuario, contrasena, correo, fecha_nacimiento, nombre_usuario, id_ubicacion, id_rol)
VALUES
    (218588038, 'Ramirez', '1234', 'diego.ramirez@usach.cl', '2001-01-27', 'Diego', 1, 1),
    (137785170,'Marin', '2341', 'diego.acuna@usach.cl', '2010-02-27', 'Jose', 2, 1),
    (134519665,'Galleta', '1342', 'gustavo.galleta@usach.cl', '2001-03-27', 'Gustavo', 3, 1),
    (160057394,'Escribano', '1243', 'bastian.escribano@usach.cl', '2001-04-27', 'Bastian', 4, 2),
    (160157397,'Soto', '4123', 'macarena.soto@usach.cl', '2001-05-27', 'Macarena', 5, 2),
    (187833752,'Roman', '3124', 'pablo.roman@usach.cl', '2001-06-27', 'Pablo', 5, 2),
    (185433753,'Catalan', '2134', 'gaspar.catalan@usach.cl', '2001-07-27', 'Gaspar', 5, 3),
    (172868266,'Perez', '1324', 'fernando.perez@usach.cl', '2001-08-27', 'Fernando', 4, 3),
    (120970623,'Moreira', '1432', 'ignacio.moreira@usach.cl', '2010-09-27', 'Ignacio', 2, 3),
    (161094366,'Correa', '2143', 'vanina.correa@usach.cl', '2010-10-27', 'Vanina', 4, 1);

INSERT INTO public.empresas_favoritas(
    favorito, id_empresa, id_usuario)
VALUES
    ('true', 1, 218588038),
    ('true', 2, 218588038),
    ('true', 3, 218588038),
    ('true', 4, 137785170),
    ('true', 5, 137785170),
    ('true', 3, 137785170),
    ('true', 5, 134519665),
    ('true', 4, 134519665),
    ('true', 3, 134519665),
    ('true', 1, 160057394),
    ('true', 4, 160057394),
    ('true', 3, 160057394),
    ('true', 4, 160157397),
    ('true', 5, 160157397),
    ('true', 3, 160157397),
    ('true', 6, 187833752),
    ('true', 2, 187833752),
    ('true', 4, 187833752),
    ('true', 5, 185433753),
    ('true', 2, 185433753),
    ('true', 1, 185433753),
    ('true', 4, 172868266),
    ('true', 3, 172868266),
    ('true', 5, 172868266),
    ('true', 1, 120970623),
    ('true', 4, 120970623),
    ('true', 5, 120970623),
    ('true', 9, 161094366),
    ('true', 8, 161094366),
    ('true', 7, 161094366);

INSERT INTO public.carrito_compras(
    id_usuario)
VALUES (218588038),(137785170),(134519665),(160057394),(160157397),(187833752),(185433753),(172868266),(120970623),(161094366);

INSERT INTO public.tipo_producto(nombre_tipo)
VALUES
    ('manzana'),('platano'),('naranja'),('limon'),('tomate'),('zanahoria'),
    ('papa'),('pera'),('frutilla'),('uva'),('cebolla'),('pepino'), ('galletas'),
    ('enlatados');
INSERT INTO public.producto(descripcion, nombre_producto, precio, stock, tipo, ventas_producto)
VALUES
    ('manzanas rojas y dulces', 'manzana', 2000, 10, 'fruta', 5),
    ('platanos amarillo', 'platano', 2500, 15, 'fruta', 7),
    ('naranjas grandes y sabrosas', 'naranja', 1500, 20, 'fruta', 10),
    ('limon jugoso', 'limon', 1000, 30, 'fruta', 20),
    ('tomate maduro', 'tomate', 1800, 20, 'fruta', 8),
    ('zanahoria grande y bonita', 'zanahoria', 1700, 10, 'verdura', 5),
    ('papas para la cazuela', 'papa', 2000, 12, 'verdura', 5),
    ('peras dulces', 'pera', 2000, 10, 'fruta', 5),
    ('frutillas rojas y dulces', 'frutilla', 2500, 25, 'fruta', 15),
    ('uva sin pepa', 'uva', 2000, 30, 'fruta', 15),
    ('cebolla nueva', 'cebolla', 2000, 40, 'verdura', 15),
    ('pepinos grandes y sanitos', 'pepino', 2100, 20, 'verdura', 14),
    ('atun lomitos, san jose', 'atun', 1230, 40, 'enlatado', 50),
    ('durazno en trocitos, wasil', 'durazno', 2930, 100, 'fruta', 58),
    ('galletas con chocolate en forma de cigarro, costa', 'obsesion', 1000, 100, 'galleta', 70),
    ('galleta con frutilla muy adictiva', 'gretel', 950, 100, 'galleta', 50);

INSERT INTO public.empresa_producto(
    id_producto, id_empresa)
VALUES
    (1, 1),
    (2, 1),
    (3, 3),
    (4, 3),
    (5, 2),
    (6, 2),
    (7, 4),
    (8, 4),
    (9, 5),
    (4, 6),
    (5, 7),
    (6, 8),
    (11, 9),
    (14, 9),
    (10, 10),
    (11, 10),
    (12, 10),
    (13, 10);

INSERT INTO public.carrito_compras_producto(
    cantidad, id_carrito, id_producto)
VALUES
    (2, 1, 1),
    (5, 1, 2),
    (4, 1, 3),
    (2, 2, 12),
    (3, 2, 11),
    (1, 2, 10);

INSERT INTO public.empresa_tipo_producto(
    id_tipo_producto, id_empresa)
VALUES
    (1, 1),
    (2, 1),
    (3, 3),
    (4, 3),
    (5, 2),
    (6, 2),
    (7, 4),
    (8, 4),
    (9, 5),
    (4, 6),
    (5, 7),
    (6, 8),
    (11, 9),
    (14, 9),
    (10, 10),
    (11, 10),
    (12, 10),
    (13, 10);

INSERT INTO public.metodo_pago(
    metodo_pago)
VALUES
    ('Tarjeta de Debito'),
    ('Tarjeta de Credito');

INSERT INTO public.pago(
    monto, id_usuario, id_metodo_pago)
VALUES
    (2000, 218588038, 1),
    (5000, 218588038, 1),
    (10000, 137785170, 2),
    (20000, 160157397, 2),
    (4000, 218588038, 1),
    (5000, 218588038, 1),
    (60000, 137785170, 2),
    (50000, 160157397, 2),
    (3000, 218588038, 1),
    (7000, 161094366, 1),
    (20000, 137785170, 2),
    (54000, 161094366, 2);

INSERT INTO public.permiso(
    permiso, id_rol)
VALUES
    ('Administrar Base de Datos', 1),
    ('Modificar Datos Usuario', 1),
    ('Modificar Datos Empresa', 1),
    ('Modificar Datos Producto', 1),
    ('Dejar valoracion', 2),
    ('Comprar Producto', 2),
    ('Realizar pago', 2),
    ('Subir producto', 3),
    ('Eliminar tipo de producto que vende', 3),
    ('Eliminar producto que vende', 3);

INSERT INTO public.valoracion(
    comentario, estrellas, id_empresa, id_usuario)
VALUES
    ('Entrega rapida', 4, 1, 218588038),
    ('Se demoraron en la entrega, pero llegó bien empaquetado', 3, 2, 137785170),
    ('Buena disposicion por parte del dueño de la empresa, el producto llegó el mismo día', 5, 3, 160057394),
    ('¡Muy buenos productos, siempre de calidad!', 4, 4, 160157397),
    ('Se demoraron en la entrega y algunos alimentos venían podridos', 1, 1, 120970623);