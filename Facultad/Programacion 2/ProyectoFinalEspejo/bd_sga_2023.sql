/*
SQLyog Ultimate v9.02 
MySQL - 8.0.30 : Database - pfiprog22023
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pfiprog2`  /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pfiprog2`;

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `alu_dni` int NOT NULL,
  `alu_nombre` varchar(45) DEFAULT NULL,
  `alu_apellido` varchar(45) DEFAULT NULL,
  `alu_fec_nac` date DEFAULT NULL,
  `alu_domicilio` varchar(45) DEFAULT NULL,
  `alu_telefono` varchar(45) DEFAULT NULL,
  `alu_insc_cod` int DEFAULT NULL,
  PRIMARY KEY (`alu_dni`),
  UNIQUE KEY `alu_dni_UNIQUE` (`alu_dni`),
  KEY `FK_inscripcion_idx` (`alu_insc_cod`),
  CONSTRAINT `FK_inscripcion` FOREIGN KEY (`alu_insc_cod`) REFERENCES `inscripcion` (`insc_cod`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumno` */

insert  into `alumno`(`alu_dni`,`alu_nombre`,`alu_apellido`,`alu_fec_nac`,`alu_domicilio`,`alu_telefono`,`alu_insc_cod`) values (9564857,'Rut','Romera','2012-06-21','San Juan','+2647564657',4432),(13457345,'Carmelo','Del Rio','2012-06-21','San Juan','+2647564657',NULL),(43678645,'Joseba','Infante','2020-06-11','Mendoza','+2617564657',1123),(45678345,'Maria','Freire','2020-06-11','Mendoza','+2617564657',NULL),(78465756,'Erika','Poveda','2020-06-11','Mendoza','+2617564657',NULL),(84293483,'Amadeo','Romera','2012-06-21','San Juan','+2647564657',NULL),(85351098,'Geronimo','Del Castillo','2012-06-21','San Juan','+2647564657',NULL),(85647564,'IÃ±igo','Barbera','2020-06-11','Mendoza','+2617564657',NULL),(94536574,'Nicolasa','Padilla','2012-06-21','Mendoza','+2617564657',NULL);

/*Table structure for table `carrera` */

DROP TABLE IF EXISTS `carrera`;

CREATE TABLE `carrera` (
  `car_cod` int NOT NULL,
  `car_nombre` varchar(45) DEFAULT NULL,
  `car_duracion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`car_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `carrera` */

insert  into `carrera`(`car_cod`,`car_nombre`,`car_duracion`) values (32,'Ciencias De La Computacion','5 AÃ±os'),(323,'Ingenieria Civil','5 AÃ±os'),(546,'Licenciatura en Higiene y Seguridad','2 AÃ±os'),(5464,'Licenciatura en EnologÃ­a','2 AÃ±os'),(35464,'Tec. Superior en ProgramaciÃ³n','2 AÃ±os');

/*Table structure for table `cursado` */

DROP TABLE IF EXISTS `cursado`;

CREATE TABLE `cursado` (
  `cur_alu_dni` int NOT NULL,
  `cur_mat_cod` int NOT NULL,
  `cur_nota` double DEFAULT NULL,
  PRIMARY KEY (`cur_alu_dni`,`cur_mat_cod`),
  KEY `FK_materia_idx` (`cur_mat_cod`),
  CONSTRAINT `FK_cursado` FOREIGN KEY (`cur_mat_cod`) REFERENCES `materia` (`mat_cod`),
  CONSTRAINT `FK_cursado_1` FOREIGN KEY (`cur_alu_dni`) REFERENCES `alumno` (`alu_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cursado` */

insert  into `cursado`(`cur_alu_dni`,`cur_mat_cod`,`cur_nota`) values (9564857,135,8),(78465756,136,10);

/*Table structure for table `inscripcion` */

DROP TABLE IF EXISTS `inscripcion`;

CREATE TABLE `inscripcion` (
  `insc_cod` int NOT NULL,
  `insc_nombre` varchar(45) DEFAULT NULL,
  `insc_fecha` date DEFAULT NULL,
  `insc_car_cod` int DEFAULT NULL,
  PRIMARY KEY (`insc_cod`),
  KEY `FK_carrera_idx` (`insc_car_cod`),
  CONSTRAINT `FK_carrera` FOREIGN KEY (`insc_car_cod`) REFERENCES `carrera` (`car_cod`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `inscripcion` */

insert  into `inscripcion`(`insc_cod`,`insc_nombre`,`insc_fecha`,`insc_car_cod`) values (1123,'Joseba Infante','2020-06-12',5464),(4432,'Rut Romera','2020-06-12',32);

/*Table structure for table `materia` */

DROP TABLE IF EXISTS `materia`;

CREATE TABLE `materia` (
  `mat_cod` int NOT NULL,
  `mat_nombre` varchar(45) DEFAULT NULL,
  `mat_prof_dni` int DEFAULT NULL,
  PRIMARY KEY (`mat_cod`),
  KEY `FK_profesor_idx` (`mat_prof_dni`),
  CONSTRAINT `FK_profesor` FOREIGN KEY (`mat_prof_dni`) REFERENCES `profesor` (`prof_dni`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `materia` */

insert  into `materia`(`mat_cod`,`mat_nombre`,`mat_prof_dni`) values (134,'Matematica',35112416),(135,'Quimica',47112111),(136,'Robotica',47112111),(137,'Fisica Nuclear',47118211);

/*Table structure for table `profesor` */

DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `prof_dni` int NOT NULL,
  `prof_nombre` varchar(45) DEFAULT NULL,
  `prof_apellido` varchar(45) DEFAULT NULL,
  `prof_fec_nac` varchar(45) DEFAULT NULL,
  `prof_domicilio` varchar(45) DEFAULT NULL,
  `prof_telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`prof_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profesor` */

insert  into `profesor`(`prof_dni`,`prof_nombre`,`prof_apellido`,`prof_fec_nac`,`prof_domicilio`,`prof_telefono`) values (35112416,'Maximino','De La Fuente','2020-06-17','Neuquen','+235854732'),(47112111,'Geronimo','Chen','2020-06-17','Neuquen','+235854732'),(47118211,'Ernesto','Vera','2020-06-17','Neuquen','+235854732'),(47118232,'Eloi','Arjona','2020-06-17','Neuquen','+235854732'),(47238232,'Marcos','Dionisio','2020-06-17','Neuquen','+235854732'),(47238432,'Daniel','Aroca','2020-06-17','Neuquen','+235854732');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
