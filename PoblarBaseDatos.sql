INSERT INTO public.ubicacion_geografica(
	id_ubicacion, comuna, direccion, region)
	VALUES 
	(1,'La Florida', 'Walker Martinez 980', 'Metropolitana'),
	(2,'Maipu', 'Satelite', 'Los Lagos'),
	(3,'Florida', '', 'Nuble'),
	(4,'Estacion Central', '1', 'Metropolitana'),
	(5,'Macul', '1', 'Metropolitana');
	
INSERT INTO public.empresa(
	nombre_empresa, restriccion_edad, id_ubicacion)
	VALUES 
	('Diego Inc', 18, 1),
	('Ale Inc', 17, 1),
	('Jose Inc', 17, 1),
	('Mel Inc', 17, 1),
	('Mario Inc', 17, 1),
	('Manuel Inc', 17, 1),
	('Javier Inc', 18, 1),
	('Pablo Inc', 18, 1),
	('Paolo Inc', 18, 1),
	('Bastian Inc', 18, 1);
	
INSERT INTO public.rol(
	id, alias_rol, nombre_rol)
	VALUES 
	(1, 'Admin', 'Administrador'),
	(2, 'User', 'Cliente'),
	(3, 'Emp', 'Empresa');
	
INSERT INTO public.usuario(
	id_usuario, apellido_usuario, contrasena, correo, fecha_nacimiento, nombre_usuario, id_ubicacion, id_rol)
	VALUES 
	(1, 'Ramirez', '1234', 'diego.ramirez@usach.cl', '2001-01-27', 'Diego', 1, 1),
	(2, 'Marin', '2341', 'diego.acuna@usach.cl', '2010-02-27', 'Jose', 2, 1),
	(3, 'Galleta', '1342', 'gustavo.galleta@usach.cl', '2001-03-27', 'Gustavo', 3, 1),
	(4, 'Escribano', '1243', 'bastian.escribano@usach.cl', '2001-04-27', 'Bastian', 4, 2),
	(5, 'Soto', '4123', 'macarena.soto@usach.cl', '2001-05-27', 'Macarena', 5, 2),
	(6, 'Roman', '3124', 'pablo.roman@usach.cl', '2001-06-27', 'Pablo', 5, 2),
	(7, 'Catalan', '2134', 'gaspar.catalan@usach.cl', '2001-07-27', 'Gaspar', 5, 3),
	(8, 'Perez', '1324', 'fernando.perez@usach.cl', '2001-08-27', 'Fernando', 4, 3),
	(9, 'Moreria', '1432', 'ignacio.moreira@usach.cl', '2010-09-27', 'Ignacio', 2, 3),
	(10, 'Correa', '2143', 'vanina.correa@usach.cl', '2010-10-27', 'Vanina', 4, 1);
	
INSERT INTO public.empresas_favoritas(
	favorito, id_empresa, id_usuario)
	VALUES 
	('true', 1, 1),
	('true', 2, 1),
	('true', 3, 1),
	('true', 4, 2),
	('true', 5, 2),
	('true', 3, 2),
	('true', 5, 3),
	('true', 4, 3),
	('true', 3, 3),
	('true', 1, 4),
	('true', 4, 4),
	('true', 3, 4),
	('true', 1, 5),
	('true', 5, 5),
	('true', 3, 5),
	('true', 1, 6),
	('true', 2, 6),
	('true', 4, 6),
	('true', 5, 7),
	('true', 2, 7),
	('true', 1, 7),
	('true', 4, 8),
	('true', 3, 8),
	('true', 5, 8),
	('true', 1, 9),
	('true', 4, 9),
	('true', 5, 9),
	('true', 5, 10),
	('true', 2, 10),
	('true', 3, 10);
	
INSERT INTO public.carrito_compras(
	id_carrito, id_usuario)
	VALUES (1, 1),(2, 2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);

INSERT INTO public.tipo_producto(id_tipo_producto, nombre_tipo)
	VALUES 
	(1,'manzana'),(2,'platano'),(3,'naranja'),(4,'limon'),(5,'tomate'),(6,'zanahoria'),
	(7,'papa'),(8,'pera'),(9,'frutilla'),(10,'uva'),(11,'cebolla'),(12,'pepino');

INSERT INTO public.producto(id_producto, descripcion, nombre_producto, precio, stock, tipo, ventas_producto)
	VALUES 
	(1,'manzanas rojas y dulces', 'manzana', 2000, 10, 'fruta', 5),
	(2,'platanos amarillo', 'platano', 2500, 15, 'fruta', 7),
	(3,'naranjas grandes y sabrosas', 'naranja', 1500, 20, 'fruta', 10),
	(4,'limon jugoso', 'limon', 1000, 30, 'fruta', 20),
	(5,'tomate maduro', 'tomate', 1800, 20, 'fruta', 8),
	(6,'zanahoria grande y bonita', 'zanahoria', 1700, 10, 'verdura', 5),
	(7,'papas para la cazuela', 'papa', 2000, 12, 'verdura', 5),
	(8,'peras dulces', 'pera', 2000, 10, 'fruta', 5),
	(9,'frutillas rojas y dulces', 'frutilla', 2500, 25, 'fruta', 15),
	(10,'uva sin pepa', 'uva', 2000, 30, 'fruta', 15),
	(11,'cebolla nueva', 'cebolla', 2000, 40, 'verdura', 15),
	(12,'pepinos grandes y sanitos', 'pepino', 2100, 20, 'verdura', 14);

INSERT INTO public.empresa_producto(
	id_producto, id_empresa)
	VALUES 
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(1, 2),
	(2, 2);

INSERT INTO public.carrito_compras_producto(
	cantidad, id_carrito, id_producto)
	VALUES 
	(2, 1, 1),
	(5, 1, 2),
	(4, 1, 3),
	(2, 2, 12),
	(3, 2, 11),
	(1, 2, 10);