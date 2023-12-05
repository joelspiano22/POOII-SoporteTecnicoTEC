/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - sistema
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sistema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `sistema`;

/*Table structure for table `administrador` */

DROP TABLE IF EXISTS `administrador`;

CREATE TABLE `administrador` (
  `id_admin` INT(3) UNSIGNED DEFAULT NULL AUTO_INCREMENT,
  `user_admin` CHAR(20) DEFAULT NULL,
  `password_admin` CHAR(20) DEFAULT NULL,
  PRIMARY KEY (id_admin)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `administrador` */

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE cliente (
  `id_cliente` INT(3) UNSIGNED DEFAULT NULL AUTO_INCREMENT,
  `nombre_cliente` CHAR(15) DEFAULT NULL,
  `apellido_cliente` CHAR(15) DEFAULT NULL,
  `dni_cliente` INT(8) DEFAULT NULL,
  `direccion_cliente` CHAR(15) DEFAULT NULL,
  `telefono_cliente` INT(9) DEFAULT NULL,
  `userCliente` CHAR(20) DEFAULT NULL,
  `passCliente` CHAR(20) DEFAULT NULL,
  PRIMARY KEY (id_cliente)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*Data for the table `cliente` */

/*Table structure for table `equipo` */

DROP TABLE IF EXISTS `equipo`;

CREATE TABLE `equipo` (
  `id_equipo` INT(3) UNSIGNED DEFAULT NULL AUTO_INCREMENT,
  `descripcion_equipo` CHAR(20) DEFAULT NULL,
  PRIMARY KEY (id_equipo)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `equipo` */

/*Table structure for table `servicio` */

DROP TABLE IF EXISTS `servicio`;

CREATE TABLE `servicio` (
  `id_servicio` INT(3) UNSIGNED DEFAULT NULL AUTO_INCREMENT,
  `descripcion_servicio` CHAR(50) DEFAULT NULL,
  `precio_servicio` DOUBLE DEFAULT NULL,
  PRIMARY KEY (id_servicio)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `servicio` */

/*Table structure for table `soporte` */

DROP TABLE IF EXISTS `soporte`;

CREATE TABLE `soporte` (
  `id_soporte` INT(3) UNSIGNED DEFAULT NULL AUTO_INCREMENT,
  `monto_soporte` DOUBLE DEFAULT NULL,
  `descripcion_soporte` CHAR(150) DEFAULT NULL,
  `id_cliente` INT(25) DEFAULT NULL,
  `id_equipo` INT(25) DEFAULT NULL,
  `id_servicio` INT(25) DEFAULT NULL,
  `estado_soporte` CHAR(50) DEFAULT NULL,
  `solucion_soporte` CHAR(150) DEFAULT NULL,
  PRIMARY KEY (id_soporte)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `soporte` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


/*CLIENTEEEEEEEEEEEEEEEE*/
	/*PROCEDIMIENTO ALMACENADO PARA LISTAR EL CLIENTE*/
	CREATE PROCEDURE USPListarCli()
		SELECT id_cliente,nombre_cliente,apellido_cliente,dni_cliente,direccion_cliente,telefono_cliente,userCliente,passCliente
		FROM cliente

	/*INSERTAR UN NUEVO CLIENTE*/
	CREATE PROCEDURE UspInsertarCli(IN codigo INT(3),IN nombre CHAR(15),IN apellido CHAR(15),IN dni INT(8),IN direccion CHAR(15),IN telefono INT(9),IN usuario CHAR(20),IN pass CHAR(20))
		INSERT INTO cliente VALUES(codigo,nombre,apellido,dni,direccion,telefono,usuario,pass)
		
	/*ELIMINAR UN CLIENTE*/	
	CREATE PROCEDURE UspRemoveCli(IN codigo INT(3))
		DELETE FROM cliente WHERE id_cliente = codigo 

	/*MODIFICAR UN CLIENTE*/
	CREATE PROCEDURE UspUpdateCli(IN codigo INT(3),IN nombre CHAR(15),IN apellido CHAR(15),IN dni INT(8),IN direccion CHAR(15),IN telefono INT(9),IN usuario CHAR(20),IN pass CHAR(20))
		UPDATE cliente SET nombre_cliente=nombre,apellido_cliente=apellido,dni_cliente=dni,direccion_cliente=direccion,telefono_cliente=telefono,userCliente=usuario,passCliente=pass WHERE id_cliente=codigo

	/*BUSCAR UN CLIENTE POR ID*/
	CREATE PROCEDURE UspBuscarClientebyID(IN cod INT(3))
		SELECT id_cliente, nombre_cliente, apellido_cliente,dni_cliente,direccion_cliente,telefono_cliente,userCliente,passCliente FROM cliente WHERE id_cliente=cod

	/*METODO PARA VALIDAR USUARIO Y CONTRASEÑA*/
	CREATE PROCEDURE UspBuscarUsPa(IN cod CHAR(20), IN pass CHAR(20))
		SELECT * FROM cliente WHERE cod = userCliente AND pass = passCliente
		
	CREATE PROCEDURE UspBusquedaClientebyUserPass(IN usuario CHAR(20), IN pass CHAR(20))
		SELECT id_cliente, nombre_cliente, apellido_cliente,dni_cliente,direccion_cliente,telefono_cliente,userCliente,passCliente FROM cliente WHERE usuario = userCliente AND pass = passCliente	
		
		
/*ADMINNNNNNNNNNNNNNNNNNNN*/
	/*PROCEDIMIENTO ALMACENADO PARA LISTAR AL ADMIN*/
	CREATE PROCEDURE UspListarAdmin()
		SELECT id_admin,user_admin
		FROM administrador
		
	/*INSERTAR UN ADMIN*/
	CREATE PROCEDURE UspInsertarAdmin(IN id INT(3),IN usuario CHAR(20),IN contra CHAR(20))
		INSERT INTO administrador VALUES(id,usuario,contra)
	
	/*MEOTODO PARA VALIDAR USUARIO Y CONTRASEÑA*/
	CREATE PROCEDURE UspBuscarUsPaAdmin(IN cod CHAR(20),IN pass CHAR(20))
		SELECT * FROM administrador WHERE cod=user_admin AND pass=password_admin
		
		
/*EQUIPOOOOOOOOOOOOOOOOO*/	
	/*PROCEDIMIENTO ALMACENADO PARA LISTAR EL EQUIPO*/
	CREATE PROCEDURE USPListarEquipo()
		SELECT id_equipo,descripcion_equipo
		FROM equipo
		
	/*INSERTAR UN EQUIPO*/
	CREATE PROCEDURE UspInsertarEquipo(IN idEqui INT(3),IN desEqui CHAR(20))
		INSERT INTO equipo VALUES(idEqui,desEqui)

	/*ELIMINAR UN EQUIPO*/
	CREATE PROCEDURE UspRemoveEquipo(IN idEqui INT(3))
		DELETE FROM equipo WHERE id_equipo = idEqui

	/*MODIFICAR UN EQUIPO*/
	CREATE PROCEDURE UspUpdateEqui(IN idEqui INT(3),IN desEqui CHAR(20))
		UPDATE equipo SET descripcion_equipo=desEqui WHERE id_equipo=idEqui
		
	/*BUSCAR UN EQUIPO*/
	CREATE PROCEDURE UspBuscarEquipobyID(IN cod INT(3))
		SELECT id_equipo, descripcion_equipo FROM equipo WHERE id_equipo=cod

	CREATE PROCEDURE UspBuscarEquipobyDescripcion(IN des CHAR(50))
		SELECT id_equipo, descripcion_equipo FROM equipo WHERE descripcion_equipo=des

/*SERVICIOOOOOOOOOOOOOOOO*/
	/*PROCEDIMIENTO ALMACENADO PARA LISTAR EL SERVICIO*/
	CREATE PROCEDURE UspListarSer()
		SELECT ID_SERVICIO, DESCRIPCION_SERVICIO,PRECIO_SERVICIO
		FROM SERVICIO
	
	/*INSERTAR UN SERVICIO*/
	CREATE PROCEDURE UspInsertarSer(IN id INT(3), descripcion CHAR(50),precio DOUBLE)
		INSERT INTO SERVICIO VALUES(id, descripcion,precio)
	
	/*ELIMINAR UN SERVICIO*/
	CREATE PROCEDURE UspRemoveSer(IN id INT(3))
		DELETE FROM SERVICIO WHERE id_servicio = id
	
	/*MODIFICAR UN SERVICIO*/
	CREATE PROCEDURE UspUpdateSer(IN id INT(3), descripcion CHAR(50),precio DOUBLE)
		UPDATE SERVICIO SET descripcion_servicio=descripcion,precio_servicio=precio WHERE id_servicio=id

	/*BUSCAR UN SERVICIO*/
	CREATE PROCEDURE UspBuscarServiciobyID(IN cod INT(3))
		SELECT id_servicio, descripcion_servicio, precio_servicio FROM servicio WHERE id_servicio=cod
	
	CREATE PROCEDURE UspBuscarServiciobyDescripcion(IN des CHAR(50))
		SELECT id_servicio, descripcion_servicio, precio_servicio FROM servicio WHERE descripcion_servicio=des
	
	
/*SOPORTEEEEEEEEEEEEEEEEE*/
	/*PROCEDIMIENTO ALMACENADO PARA LISTAR EL SOPORTE*/
	CREATE PROCEDURE UspListarSop()
		SELECT ID_SOPORTE, MONTO_SOPORTE, DESCRIPCION_SOPORTE, ID_CLIENTE, ID_EQUIPO, ID_SERVICIO, ESTADO_SOPORTE, SOLUCION_SOPORTE
		FROM SOPORTE
	
	/*INSERTAR UN SOPORTE*/
	CREATE PROCEDURE UspInsertarSop(IN id INT(3), monto DOUBLE, descripcion CHAR(150), idcliente INT(25), idequipo INT(25), idservicio INT(25), estado CHAR(50), solucion CHAR(150))
		INSERT INTO SOPORTE VALUES(id, monto, descripcion, idcliente, idequipo, idservicio, estado, solucion)
	
	/*ELIMINAR UN SOPORTE*/
	CREATE PROCEDURE UspRemoveSop(IN id INT(3))
		DELETE FROM soporte WHERE id_soporte = id
	
	/*MODIFICAR UN SOPORTE*/
	CREATE PROCEDURE UspUpdateSop(IN id INT(3), monto DOUBLE, descripcion CHAR(150), idcliente INT(25), idequipo INT(25), idservicio INT(25), estado CHAR(50), solucion CHAR(150))
		UPDATE soporte SET monto_soporte=monto,descripcion_soporte=descripcion,id_cliente=idcliente,id_equipo=idequipo,id_servicio=idservicio,estado_soporte=estado,solucion_soporte=solucion WHERE id_soporte=id
	
	/*BUSCAR UN SOPORTE*/
	CREATE PROCEDURE UspBuscarSop(IN cod INT(3))
		SELECT id_soporte,monto_soporte,descripcion_soporte,id_cliente,id_equipo,id_servicio,estado_soporte,solucion_soporte FROM soporte WHERE id_soporte=cod		