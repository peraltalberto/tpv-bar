-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-09-2016 a las 17:22:06
-- Versión del servidor: 5.5.47
-- Versión de PHP: 5.4.45-0+deb7u1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arqueos`
--

DROP TABLE IF EXISTS `arqueos`;
CREATE TABLE IF NOT EXISTS `arqueos` (
  `idArqueo` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `Diferencia` double NOT NULL DEFAULT '0',
  `IdCaja` int(11) NOT NULL,
  PRIMARY KEY (`idArqueo`),
  KEY `fk_Arqueos_caja1` (`IdCaja`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `arqueos`
--

INSERT INTO `arqueos` (`idArqueo`, `Fecha`, `Diferencia`, `IdCaja`) VALUES
(1, '2016-09-20 11:12:09', 0, 5),
(2, '2016-09-20 11:12:09', 0, 6),
(3, '2016-09-20 11:46:25', 0, 17),
(4, '2016-09-20 11:46:25', 0, 18),
(5, '2016-09-23 13:20:46', 0, 20),
(6, '2016-09-23 13:20:46', 0, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `atipicas`
--

DROP TABLE IF EXISTS `atipicas`;
CREATE TABLE IF NOT EXISTS `atipicas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` int(11) NOT NULL DEFAULT '0',
  `precio` double DEFAULT NULL,
  `bloqueubicacion` int(11) NOT NULL,
  `productos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_atipicas_bloqueubicacion1` (`bloqueubicacion`),
  KEY `fk_atipicas_productos1` (`productos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `atipicas`
--

INSERT INTO `atipicas` (`id`, `tipo`, `precio`, `bloqueubicacion`, `productos`) VALUES
(1, 0, 1.25, 1, 1),
(2, 0, 2.5, 3, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bloqueubicacion`
--

DROP TABLE IF EXISTS `bloqueubicacion`;
CREATE TABLE IF NOT EXISTS `bloqueubicacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `bloqueubicacion`
--

INSERT INTO `bloqueubicacion` (`id`, `Nombre`, `Descripcion`, `imagen`) VALUES
(1, 'Terraza', 'Terraza', 'C:\\tpv\\img\\iconoTerraza.png'),
(2, 'Comedor', 'Comedor', 'C:\\tpv\\img\\iconoComedor.png'),
(3, 'Barra', 'Barra', 'C:\\tpv\\img\\iconoBarra.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabezera`
--

DROP TABLE IF EXISTS `cabezera`;
CREATE TABLE IF NOT EXISTS `cabezera` (
  `IdCabezera` int(11) NOT NULL AUTO_INCREMENT,
  `Total` double DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `IdCamarero` int(11) NOT NULL,
  `cod` int(11) NOT NULL,
  PRIMARY KEY (`IdCabezera`),
  KEY `fk_Cabezera_Camarero1` (`IdCamarero`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Volcado de datos para la tabla `cabezera`
--

INSERT INTO `cabezera` (`IdCabezera`, `Total`, `Estado`, `Fecha`, `IdCamarero`, `cod`) VALUES
(1, 0, 1, '2016-09-19 09:39:05', 1, 1),
(2, 0, 1, '2016-09-19 10:00:35', 1, 2),
(3, 11.75, 1, '2016-09-19 10:18:03', 1, 3),
(4, 0, 1, '2016-09-19 10:18:34', 2, 4),
(5, 0, 3, '2016-09-19 10:18:36', 1, 5),
(6, 2.5, 1, '2016-09-19 10:26:40', 1, 6),
(7, 1.25, 1, '2016-09-20 11:14:52', 1, 7),
(8, 1, 1, '2016-09-20 11:16:10', 1, 8),
(9, 0, 1, '2016-09-20 11:16:23', 1, 9),
(10, 0, 1, '2016-09-20 11:17:14', 2, 10),
(11, 0, 1, '2016-09-20 11:17:16', 1, 11),
(12, 2.4000000000000004, 1, '2016-09-20 11:37:11', 1, 12),
(13, 7.5, 1, '2016-09-20 11:38:44', 1, 13),
(14, 3, 1, '2016-09-20 11:40:30', 1, 14),
(15, 7, 1, '2016-09-20 11:40:50', 1, 15),
(16, 2.5, 1, '2016-09-20 11:45:17', 2, 16),
(17, 1.25, 1, '2016-09-20 11:45:34', 2, 17),
(18, 0, 3, '2016-09-23 08:59:34', 2, 18),
(19, 3.5, 1, '2016-09-23 11:24:24', 1, 19),
(20, 0, 1, '2016-09-23 11:24:38', 2, 20),
(21, 18.5, 1, '2016-09-23 11:25:12', 1, 21),
(22, 0, 1, '2016-09-23 11:31:38', 2, 22),
(23, 3.75, 1, '2016-09-23 11:44:32', 1, 23),
(24, 6.25, 1, '2016-09-23 11:45:34', 1, 24),
(25, 14.950000000000001, 1, '2016-09-23 12:14:02', 1, 25),
(26, 5.75, 1, '2016-09-23 12:16:35', 1, 26),
(27, 16.05, 1, '2016-09-23 12:21:10', 1, 27),
(28, 9.5, 1, '2016-09-23 12:22:27', 1, 28),
(29, 11.25, 1, '2016-09-23 12:24:08', 1, 29),
(30, 9.5, 1, '2016-09-23 12:25:08', 1, 30),
(31, 10.75, 1, '2016-09-23 12:26:06', 1, 31),
(32, 13.75, 1, '2016-09-23 12:27:59', 1, 32),
(33, 9.05, 1, '2016-09-23 12:29:56', 1, 33),
(34, 9.5, 1, '2016-09-23 12:31:47', 1, 34),
(35, 10.05, 1, '2016-09-23 12:33:53', 1, 35),
(36, 10.6, 1, '2016-09-23 12:36:02', 1, 36),
(37, 40.75, 1, '2016-09-26 08:54:53', 1, 37),
(38, 8.75, 1, '2016-09-26 09:05:38', 1, 38);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

DROP TABLE IF EXISTS `caja`;
CREATE TABLE IF NOT EXISTS `caja` (
  `idCaja` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `movimiento` double NOT NULL,
  `saldo` double NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `IdCabezera` int(11) DEFAULT NULL,
  `IdCamarero` int(11) NOT NULL,
  `cajaPago` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCaja`),
  KEY `fk_caja_cabezera1` (`IdCabezera`),
  KEY `fk_caja_camarero1` (`IdCamarero`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`idCaja`, `fecha`, `movimiento`, `saldo`, `descripcion`, `IdCabezera`, `IdCamarero`, `cajaPago`) VALUES
(1, '2016-09-19 10:18:03', 11.75, 11.75, NULL, 3, 1, 0),
(2, '2016-09-19 10:18:24', 0, 11.75, NULL, 2, 1, 0),
(3, '2016-09-19 10:18:34', 0, 11.75, NULL, 4, 2, 0),
(4, '2016-09-19 10:27:50', 2.5, 14.25, NULL, 6, 1, 0),
(5, '2016-09-20 11:12:09', 0, 14.25, 'Arqueo caja 1 Camarero Alberto, Peralta', NULL, 1, 0),
(6, '2016-09-20 11:12:09', 0, 0, 'Arqueo datafono 2 Camarero Alberto, Peralta', NULL, 1, 1),
(7, '2016-09-20 11:15:17', 1.25, 15.5, NULL, 7, 1, 0),
(8, '2016-09-20 11:16:20', 1, 16.5, NULL, 8, 1, 0),
(9, '2016-09-20 11:38:07', 2.4000000000000004, 18.9, NULL, 12, 1, 0),
(10, '2016-09-20 11:38:55', 7.5, 26.4, NULL, 13, 1, 0),
(11, '2016-09-20 11:39:21', 0, 26.4, NULL, 9, 1, 0),
(12, '2016-09-20 11:39:21', 0, 26.4, NULL, 10, 1, 0),
(13, '2016-09-20 11:40:35', 3, 29.4, NULL, 14, 1, 0),
(14, '2016-09-20 11:45:51', 1.25, 1.25, NULL, 17, 1, 1),
(15, '2016-09-20 11:45:55', 2.5, 3.75, NULL, 16, 1, 1),
(16, '2016-09-20 11:45:57', 7, 10.75, NULL, 15, 1, 1),
(17, '2016-09-20 11:46:25', 0, 0, 'Arqueo caja 3 Camarero Alberto, Peralta', NULL, 1, 0),
(18, '2016-09-20 11:46:25', 0, 10.75, 'Arqueo datafono 4 Camarero Alberto, Peralta', NULL, 1, 1),
(19, '2016-09-23 11:53:45', 6.25, 6.25, NULL, 24, 1, 0),
(20, '2016-09-23 13:20:46', 0, 6.25, 'Arqueo caja 5 Camarero Alberto, Peralta', NULL, 1, 0),
(21, '2016-09-23 13:20:46', 0, 0, 'Arqueo datafono 6 Camarero Alberto, Peralta', NULL, 1, 1),
(22, '2016-09-26 09:05:48', 8.75, 15, NULL, 38, 1, 0),
(23, '2016-09-26 09:06:19', 3.5, 18.5, NULL, 19, 1, 0),
(24, '2016-09-26 09:06:20', 0, 18.5, NULL, 20, 1, 0),
(25, '2016-09-26 09:06:20', 18.5, 37, NULL, 21, 1, 0),
(26, '2016-09-26 09:06:20', 0, 37, NULL, 22, 1, 0),
(27, '2016-09-26 09:06:20', 3.75, 40.75, NULL, 23, 1, 0),
(28, '2016-09-26 09:06:20', 14.950000000000001, 55.7, NULL, 25, 1, 0),
(29, '2016-09-26 09:06:20', 5.75, 61.45, NULL, 26, 1, 0),
(30, '2016-09-26 09:06:20', 16.05, 77.5, NULL, 27, 1, 0),
(31, '2016-09-26 09:06:20', 9.5, 87, NULL, 28, 1, 0),
(32, '2016-09-26 09:06:20', 11.25, 98.25, NULL, 29, 1, 0),
(33, '2016-09-26 09:06:20', 9.5, 107.75, NULL, 30, 1, 0),
(34, '2016-09-26 09:06:20', 10.75, 118.5, NULL, 31, 1, 0),
(35, '2016-09-26 09:06:20', 13.75, 132.25, NULL, 32, 1, 0),
(36, '2016-09-26 09:06:20', 9.05, 141.3, NULL, 33, 1, 0),
(37, '2016-09-26 09:06:20', 9.5, 150.8, NULL, 34, 1, 0),
(38, '2016-09-26 09:06:20', 10.05, 160.85000000000002, NULL, 35, 1, 0),
(39, '2016-09-26 09:06:20', 10.6, 171.45000000000002, NULL, 36, 1, 0),
(40, '2016-09-26 09:06:20', 40.75, 212.20000000000002, NULL, 37, 1, 0),
(41, '2016-09-26 09:10:02', 5, 217.20000000000002, '', NULL, 1, 0),
(42, '2016-09-26 12:12:22', -25, 192.20000000000002, 'Pago de factura desde caja', NULL, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camarero`
--

DROP TABLE IF EXISTS `camarero`;
CREATE TABLE IF NOT EXISTS `camarero` (
  `IdCamarero` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(100) DEFAULT NULL,
  `Telefono` int(9) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '1',
  `IdEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`IdCamarero`),
  KEY `fk_camarero_Empresas1` (`IdEmpresa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `camarero`
--

INSERT INTO `camarero` (`IdCamarero`, `Nombre`, `Apellidos`, `Telefono`, `Activo`, `IdEmpresa`) VALUES
(1, 'Alberto', 'Peralta', 685821052, 1, 0),
(2, 'Hugo', 'Cercos', 666666666, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `IdCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '1',
  `Color` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IdCategoria`, `Nombre`, `Activo`, `Color`) VALUES
(1, 'CAFES', 1, -6724096),
(2, 'ALMUERZOS', 1, -10053121),
(3, 'LICORES Y CUBATAS', 1, -10092340),
(4, 'CERVEZAS', 1, -26317),
(5, 'VERMUT', 1, -26317),
(6, 'COPAS DE VINO', 1, -6750106),
(7, 'BOTELLAS DE VINO', 1, -6750106),
(8, 'REFRESCOS', 1, -13395457),
(9, 'TABLAS', 1, -26215),
(10, 'ENSALADAS', 1, -10053376),
(11, 'SARTENES', 1, -39373),
(12, 'TAPAS', 1, -39424),
(13, 'TOSTADAS', 1, -13210),
(14, 'BOCADILLOS', 1, -13261),
(15, 'JARRAS', 1, -13261),
(16, 'Varios', 1, -65536);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

DROP TABLE IF EXISTS `configuracion`;
CREATE TABLE IF NOT EXISTS `configuracion` (
  `id` int(11) NOT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`id`, `clave`, `value`) VALUES
(0, 'codTicket', '38'),
(1, 'impresora1', 'Microsoft Print to PDF'),
(2, 'abrircajon', 'BIXOLON SRP-350-A'),
(3, 'nombre', 'Tu tienda'),
(4, 'nif', '18417932S'),
(5, 'cif', '0'),
(6, 'Telefono', '0'),
(7, 'Fax', '0'),
(8, 'direccion', 'Avd. Aragón 9'),
(9, 'Correo', 'Pruebac'),
(10, 'cp', '44002'),
(11, 'pass', '4321'),
(12, 'imagen', 'C:\\tpv\\img\\logo.jpg'),
(13, 'cierre', '36'),
(14, 'TPV_HOME', 'c:\\tpv\\');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

DROP TABLE IF EXISTS `empresas`;
CREATE TABLE IF NOT EXISTS `empresas` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Cif` varchar(45) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  `Fax` int(11) DEFAULT NULL,
  `ContadorCod` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id`, `Nombre`, `Direccion`, `Cif`, `Telefono`, `Mail`, `Fax`, `ContadorCod`) VALUES
(0, 'Cero', NULL, NULL, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea`
--

DROP TABLE IF EXISTS `linea`;
CREATE TABLE IF NOT EXISTS `linea` (
  `IdLinea` int(11) NOT NULL AUTO_INCREMENT,
  `Precio` double DEFAULT NULL,
  `catidad` double DEFAULT NULL,
  `Total` double DEFAULT NULL,
  `IdCabezera` int(11) DEFAULT NULL,
  `IdProductos` int(11) NOT NULL,
  `cobrado` int(11) NOT NULL DEFAULT '0',
  `IdUbicacion` int(11) NOT NULL,
  `Invitacion` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdLinea`),
  KEY `fk_Linea_Cabezera1` (`IdCabezera`),
  KEY `fk_Linea_Ubicacion1` (`IdUbicacion`),
  KEY `fk_Linea_Productos1` (`IdProductos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=127 ;

--
-- Volcado de datos para la tabla `linea`
--

INSERT INTO `linea` (`IdLinea`, `Precio`, `catidad`, `Total`, `IdCabezera`, `IdProductos`, `cobrado`, `IdUbicacion`, `Invitacion`) VALUES
(1, 3.5, 1, 3.5, 3, 137, 1, 2, 0),
(2, 3.75, 1, 3.75, 3, 139, 1, 2, 0),
(3, 4.5, 1, 4.5, 3, 57, 1, 2, 0),
(4, 1, 1, 1, 8, 1, 1, 3, 0),
(5, 1.25, 1, 1.25, 6, 1, 1, 1, 0),
(6, 1.25, 1, 1.25, 6, 1, 1, 1, 0),
(7, 1.25, 1, 1.25, 7, 1, 1, 1, 0),
(8, 2, 1, 2, NULL, 1, 0, 2, 0),
(9, 2, 1, 2, NULL, 1, 0, 2, 0),
(10, 1, 1, 1, NULL, 1, 0, 2, 0),
(11, 1, 1, 1, NULL, 1, 0, 2, 0),
(12, 1, 1, 1, NULL, 1, 0, 2, 0),
(13, 1, 1, 1, NULL, 1, 0, 2, 0),
(14, 1, 1, 1, NULL, 1, 0, 2, 0),
(15, 1, 1, 1, NULL, 1, 0, 2, 0),
(16, 1, 1, 1, NULL, 1, 0, 2, 0),
(17, 1, 1, 1, NULL, 1, 0, 2, 0),
(18, 1, 1, 1, NULL, 1, 0, 2, 0),
(19, 1.1, 1, 1.1, 12, 2, 1, 3, 0),
(20, 1.3, 1, 1.3, 12, 4, 1, 3, 0),
(21, 3.75, 1, 3.75, 13, 138, 1, 3, 0),
(22, 3.75, 1, 3.75, 13, 139, 1, 3, 0),
(23, 1, 1, 1, 15, 1, 1, 3, 0),
(24, 1, 1, 1, 14, 1, 1, 3, 0),
(25, 1, 1, 1, 14, 1, 1, 3, 0),
(26, 1, 1, 1, 14, 1, 1, 3, 0),
(27, 1, 1, 1, 15, 1, 1, 3, 0),
(28, 1, 1, 1, 15, 1, 1, 3, 0),
(29, 1, 1, 1, 15, 1, 1, 3, 0),
(30, 1, 1, 1, 15, 1, 1, 3, 0),
(31, 1, 1, 1, 15, 1, 1, 3, 0),
(32, 1, 1, 1, 15, 1, 1, 3, 0),
(33, 1.25, 1, 1.25, 16, 1, 1, 1, 0),
(34, 1.25, 1, 1.25, 16, 1, 1, 1, 0),
(35, 1.25, 1, 1.25, 17, 1, 1, 1, 0),
(41, 1, 1, 1, 19, 1, 1, 1, 0),
(42, 1.25, 2, 2.5, 19, 1, 1, 1, 0),
(43, 4.5, 1, 4.5, 21, 57, 1, 1, 0),
(44, 1, 2, 2, 21, 45, 1, 1, 0),
(47, 1, 2, 1, 21, 45, 1, 1, 0),
(48, 2, 2, 4, 21, 31, 1, 1, 0),
(49, 3.5, 2, 7, 21, 137, 1, 1, 0),
(50, 1.25, 1, 1.25, 23, 1, 1, 1, 0),
(51, 1.25, 1, 1.25, 23, 1, 1, 1, 0),
(52, 1.25, 1, 1.25, 23, 1, 1, 1, 0),
(53, 1.25, 5, 6.25, 24, 1, 1, 1, 0),
(54, 1, 2, 2, 25, 1, 1, 1, 0),
(55, 1.25, 5, 6.25, 25, 1, 1, 1, 0),
(58, 1.4, 1, 1.4, 25, 5, 1, 1, 0),
(59, 1.4, 1, 1.4, 25, 5, 1, 1, 0),
(60, 1.4, 1, 1.4, 25, 5, 1, 1, 0),
(61, 1.25, 1, 1.25, 25, 1, 1, 1, 0),
(62, 1.25, 1, 1.25, 25, 1, 1, 1, 0),
(63, 1.25, 1, 1.25, 26, 1, 1, 1, 0),
(64, 1.25, 1, 1.25, 26, 1, 1, 1, 0),
(65, 2, 1, 2, 26, 1, 1, 1, 0),
(66, 1.25, 1, 1.25, 26, 1, 1, 1, 0),
(67, 1.25, 4, 5, 27, 1, 1, 1, 0),
(68, 2, 3, 6, 27, 1, 1, 1, 0),
(69, 1.3, 1, 1.3, 27, 4, 1, 1, 0),
(70, 1.25, 1, 1.25, 27, 1, 1, 1, 0),
(71, 1.25, 1, 1.25, 27, 1, 1, 1, 0),
(72, 1.25, 1, 1.25, 27, 1, 1, 1, 0),
(73, 1.25, 4, 5, 28, 1, 1, 1, 0),
(74, 2, 1, 2, 28, 1, 1, 1, 0),
(75, 1.25, 1, 1.25, 28, 1, 1, 1, 0),
(76, 1.25, 1, 1.25, 28, 1, 1, 1, 0),
(77, 1.25, 4, 5, 29, 1, 1, 1, 0),
(78, 5, 1, 5, 29, 1, 1, 1, 0),
(79, 1.25, 1, 1.25, 29, 1, 1, 1, 0),
(80, 1.25, 1, 1.25, 30, 1, 1, 1, 0),
(81, 1.25, 5, 6.25, 30, 1, 1, 1, 0),
(82, 2, 1, 2, 30, 1, 1, 1, 0),
(83, 1.25, 1, 1.25, 31, 1, 1, 1, 0),
(84, 2, 1, 2, 31, 1, 1, 1, 0),
(85, 1.25, 5, 6.25, 31, 1, 1, 1, 0),
(86, 1.25, 1, 1.25, 31, 1, 1, 1, 0),
(87, 1.25, 1, 1.25, 32, 1, 1, 1, 0),
(88, 1.25, 5, 6.25, 32, 1, 1, 1, 0),
(89, 5, 1, 5, 32, 1, 1, 1, 0),
(90, 1.25, 1, 1.25, 32, 1, 1, 1, 0),
(91, 1.25, 1, 1.25, 33, 1, 1, 1, 0),
(92, 1.25, 1, 1.25, 33, 1, 1, 1, 0),
(93, 0.5, 6, 3, 33, 1, 1, 1, 0),
(94, 1, 1, 1, 33, 4, 1, 1, 0),
(95, 1.3, 1, 1.3, 33, 4, 1, 1, 0),
(96, 1.25, 1, 1.25, 33, 1, 1, 1, 0),
(97, 1.25, 1, 1.25, 34, 1, 1, 1, 0),
(98, 2, 1, 2, 34, 1, 1, 1, 0),
(99, 1.25, 4, 5, 34, 1, 1, 1, 0),
(100, 1.25, 1, 1.25, 34, 1, 1, 1, 0),
(101, 1.3, 1, 1.3, 35, 4, 1, 1, 0),
(102, 1, 1, 1, 35, 4, 1, 1, 0),
(103, 1.25, 1, 1.25, 35, 1, 1, 1, 0),
(104, 1.3, 5, 6.5, 35, 4, 1, 1, 0),
(105, 1.25, 1, 1.25, 36, 1, 1, 1, 0),
(106, 1, 3, 3, 36, 1, 1, 1, 0),
(107, 1.3, 2, 2.6, 36, 4, 1, 1, 0),
(108, 1.25, 1, 1.25, 36, 1, 1, 1, 0),
(109, 1.25, 1, 1.25, 36, 1, 1, 1, 0),
(110, 1.25, 1, 1.25, 36, 1, 1, 1, 0),
(111, 1.25, 1, 1.25, 37, 1, 1, 1, 0),
(112, 1.25, 1, 1.25, 37, 1, 1, 1, 0),
(113, 1.5, 1, 1.5, 37, 8, 1, 1, 0),
(114, 1.5, 1, 1.5, 37, 8, 1, 1, 0),
(115, 1.5, 1, 1.5, 37, 8, 1, 1, 0),
(116, 1, 1, 1, 37, 48, 1, 1, 0),
(121, 3.5, 1, 3.5, 37, 137, 1, 1, 0),
(122, 3.75, 1, 3.75, 37, 139, 1, 1, 0),
(123, 3.75, 2, 7.5, 37, 138, 1, 1, 0),
(124, 4.5, 4, 18, 37, 57, 1, 1, 0),
(125, 5, 1, 5, 38, 58, 1, 1, 0),
(126, 3.75, 1, 3.75, 38, 144, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `IdProductos` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `IdCategoria` int(11) NOT NULL,
  `textoBT` varchar(45) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '1',
  `Color` int(11) DEFAULT NULL,
  `txtImg` int(11) NOT NULL DEFAULT '0',
  `pathImg` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdProductos`),
  KEY `fk_Productos_Categoria` (`IdCategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=151 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`IdProductos`, `Nombre`, `Precio`, `IdCategoria`, `textoBT`, `Activo`, `Color`, `txtImg`, `pathImg`) VALUES
(1, 'CAFE SOLO', 1, 1, 'CAFE SOLO', 1, -4960201, 1, 'C:\\tpv\\img\\cup16.png'),
(2, 'CORTADO', 1.1, 1, 'CORTADO', 1, NULL, 0, NULL),
(3, 'CAFE CON LECHE', 1.2, 1, 'CON LECHE', 1, NULL, 0, NULL),
(4, 'BOMBON', 1.3, 1, 'BOMBON', 1, NULL, 0, NULL),
(5, 'AMERICANO', 1.4, 1, 'AMERICANO', 1, NULL, 0, NULL),
(6, 'IRLANDES', 3, 1, 'IRLANDES', 1, NULL, 0, NULL),
(7, 'CAPUCHINO', 1.5, 1, 'CAPUCHINO', 1, NULL, 0, NULL),
(8, 'COLACAO', 1.5, 1, 'COLACAO', 1, NULL, 0, NULL),
(9, 'VASO LECHE', 1, 1, 'VASO LECHE', 1, NULL, 0, NULL),
(10, 'CHOCOLATES', 2, 1, 'CHOCOLATES', 1, NULL, 0, NULL),
(11, 'CHOCO-NATA', 2.5, 1, 'CHOCO-NATA', 1, NULL, 0, NULL),
(12, 'TE', 1, 1, 'TE', 1, NULL, 0, NULL),
(13, 'MANZANILLA', 1, 1, 'MANZANILLA', 1, NULL, 0, NULL),
(14, 'POLEO', 1, 1, 'POLEO', 1, NULL, 0, NULL),
(15, 'TILA', 1, 1, 'TILA', 1, NULL, 0, NULL),
(16, 'INFUSION EXP', 1.3, 1, 'INFUSION EXP', 1, NULL, 0, NULL),
(17, 'DESAYUNOS', 2, 1, 'DESAYUNOS', 1, NULL, 0, NULL),
(18, 'REPOSTERIA', 1, 1, 'REPOSTERIA', 1, NULL, 0, NULL),
(19, 'CHURROS 2U', 0.5, 1, 'CHURROS 2U', 1, NULL, 0, NULL),
(20, 'CARAJILLO', 1.5, 1, 'CARAJILLO', 1, NULL, 0, NULL),
(21, 'SUPLE-TOCADO', 0.3, 1, 'SUPLE-TOCADO', 1, NULL, 0, NULL),
(22, '1/2 ALMUERZO', 3.5, 2, '1/2 ALMUERZO', 1, NULL, 0, NULL),
(23, 'ALMUERZO', 4.5, 2, 'ALMUERZO', 1, NULL, 0, NULL),
(24, 'COPAS ALMU', 1.8, 2, 'COPAS ALMU', 1, NULL, 0, NULL),
(25, 'CHUPIS ALMU', 1, 2, 'CHUPIS ALMU', 1, NULL, 0, NULL),
(26, 'BEBIDA ALMU', 2, 2, 'BEBIDA ALMU', 1, NULL, 0, NULL),
(27, 'BRANDI TERRY', 2, 3, 'BRANDI TERRY', 1, NULL, 0, NULL),
(28, 'VETERANO', 2, 3, 'VETERANO', 1, NULL, 0, NULL),
(29, 'CARLOS III', 2.5, 3, 'CARLOS III', 1, NULL, 0, NULL),
(30, 'ANISES', 2, 3, 'ANISES', 1, NULL, 0, NULL),
(31, 'PACHARAN', 2, 3, 'PACHARAN', 1, NULL, 0, NULL),
(32, 'PONCHE', 2, 3, 'PONCHE', 1, NULL, 0, NULL),
(33, 'P.BAINES', 2.8, 3, 'P.BAINES', 1, NULL, 0, NULL),
(34, 'WHISKY J&B', 2.8, 3, 'WHISKY J&B', 1, NULL, 0, NULL),
(35, 'BALLANTINES', 2.8, 3, 'BALLANTINES', 1, NULL, 0, NULL),
(36, 'ETIQUETA NEGRA', 3.5, 3, 'ETIQUETA NEGRA', 1, NULL, 0, NULL),
(37, 'BAYLIS', 3, 3, 'BAYLIS', 1, NULL, 0, NULL),
(38, 'LICORES', 2.5, 3, 'LICORES', 1, NULL, 0, NULL),
(39, 'CHUPITO', 1.2, 3, 'CHUPITO', 1, NULL, 0, NULL),
(40, 'VAQUERITO', 1.5, 3, 'VAQUERITO', 1, NULL, 0, NULL),
(41, 'CUBATA-NORM', 4.5, 3, 'CUBATA-NORM', 1, NULL, 0, NULL),
(42, 'CUBATA EXP', 5.5, 3, 'CUBATA EXP', 1, NULL, 0, NULL),
(43, 'MOJITO', 4, 3, 'MOJITO', 1, NULL, 0, NULL),
(44, 'COCTELES', 4, 3, 'COCTELES', 1, NULL, 0, NULL),
(45, 'CAÑA', 1, 4, 'CAÑA', 1, NULL, 0, NULL),
(46, 'TUBO', 1.2, 4, 'TUBO', 1, NULL, 0, NULL),
(47, 'BALON', 1.4, 4, 'BALON', 1, NULL, 0, NULL),
(48, 'QUINTO', 1, 4, 'QUINTO', 1, NULL, 0, NULL),
(49, 'QUINTO SIN', 1, 4, 'QUINTO SIN', 1, NULL, 0, NULL),
(50, 'TERCIO', 1.4, 4, 'TERCIO', 1, NULL, 0, NULL),
(51, 'TERCIO EXP', 2, 4, 'TERCIO EXP', 1, NULL, 0, NULL),
(52, 'HENIKER', 1.2, 4, 'HENIKER', 1, NULL, 0, NULL),
(53, 'JARRA 1/2', 2.3, 4, 'JARRA 1/2', 1, NULL, 0, NULL),
(54, 'SIDRA', 1.5, 4, 'SIDRA', 1, NULL, 0, NULL),
(55, 'MINICAÑA', 0.7, 4, 'MINICAÑA', 1, NULL, 0, NULL),
(56, 'JARRA DE SIDRA', 3, 15, 'JARRA DE SIDRA', 1, NULL, 0, NULL),
(57, 'JARRA DE CERVEZA', 4.5, 15, 'JARRA DE CERVEZA', 1, NULL, 0, NULL),
(58, 'JARRA DE SANGRIA', 5, 15, 'JARRA DE SANGRIA', 1, NULL, 0, NULL),
(59, 'MARTINI', 2.2, 5, 'MARTINI', 1, NULL, 0, NULL),
(60, 'VERMUT CASERO', 1, 5, 'VERMUT CASERO', 1, NULL, 0, NULL),
(61, 'R.BILBAO', 1.8, 6, 'R.BILBAO', 1, NULL, 0, NULL),
(62, 'LAMBRUSCO', 1.2, 6, 'LAMBRUSCO', 1, NULL, 0, NULL),
(63, 'GUANTE B', 1, 6, 'GUANTE B', 1, NULL, 0, NULL),
(64, 'LAN', 1.8, 6, 'LAN', 1, NULL, 0, NULL),
(65, 'AZABACHE', 1.8, 6, 'AZABACHE', 1, NULL, 0, NULL),
(66, 'ENATE TAPAS', 1.8, 6, 'ENATE TAPAS', 1, NULL, 0, NULL),
(67, 'VIÑAS DEL VERO', 1, 6, 'VIÑAS DEL VERO', 1, NULL, 0, NULL),
(68, 'CARE', 1.2, 6, 'CARE', 1, NULL, 0, NULL),
(69, 'VIÑA ADELA', 1, 6, 'VIÑA ADELA', 1, NULL, 0, NULL),
(70, 'PROTOS', 1.8, 6, 'PROTOS', 1, NULL, 0, NULL),
(71, 'HOMENAJE R', 1, 6, 'HOMENAJE R', 1, NULL, 0, NULL),
(72, 'HOMENAJE B', 1, 6, 'HOMENAJE B', 1, NULL, 0, NULL),
(73, 'MARIAN', 1, 6, 'MARIAN', 1, NULL, 0, NULL),
(74, 'GUANTE R', 1, 6, 'GUANTE R', 1, NULL, 0, NULL),
(75, 'R.BILBAO', 12, 7, 'R.BILBAO', 1, NULL, 0, NULL),
(76, 'LAN', 12, 7, 'LAN', 1, NULL, 0, NULL),
(77, 'AZABACHE', 12, 7, 'AZABACHE', 1, NULL, 0, NULL),
(78, 'ENATE TAPAS', 9, 7, 'ENATE TAPAS', 1, NULL, 0, NULL),
(79, 'VIÑAS DEL VERO', 7, 7, 'VIÑAS DEL VERO', 1, NULL, 0, NULL),
(80, 'CARE', 9, 7, 'CARE', 1, NULL, 0, NULL),
(81, 'VIÑA ADELA', 7, 7, 'VIÑA ADELA', 1, NULL, 0, NULL),
(82, 'PROTOS', 12, 7, 'PROTOS', 1, NULL, 0, NULL),
(83, 'HOMENAJE R', 7, 7, 'HOMENAJE R', 1, NULL, 0, NULL),
(84, 'HOMENAJE B', 7, 7, 'HOMENAJE B', 1, NULL, 0, NULL),
(85, 'MARIAM', 7, 7, 'MARIAM', 1, NULL, 0, NULL),
(86, 'GUANTE R', 7, 7, 'GUANTE R', 1, NULL, 0, NULL),
(87, 'GUANTE B', 7, 7, 'GUANTE B', 1, NULL, 0, NULL),
(88, 'LAMBRUSCO', 8, 7, 'LAMBRUSCO', 1, NULL, 0, NULL),
(89, 'COCA-COLA P', 1.5, 8, 'COCA-COLA P', 1, NULL, 0, NULL),
(90, 'FANTA NARANJA', 1.5, 8, 'FANTA NARANJA', 1, NULL, 0, NULL),
(91, 'FANTA LIMON', 1.5, 8, 'FANTA LIMON', 1, NULL, 0, NULL),
(92, 'BITER', 1.5, 8, 'BITER', 1, NULL, 0, NULL),
(93, 'TONICA', 1.5, 8, 'TONICA', 1, NULL, 0, NULL),
(94, 'ZUMO PIÑA', 1.5, 8, 'ZUMO PIÑA', 1, NULL, 0, NULL),
(95, 'ZUMO NARANJA', 1.5, 8, 'ZUMO NARANJA', 1, NULL, 0, NULL),
(96, 'ZUMO MELOCOTON', 1.5, 8, 'ZUMO MELOCOTON', 1, NULL, 0, NULL),
(97, 'ZUMO TOMATE', 1.5, 8, 'ZUMO TOMATE', 1, NULL, 0, NULL),
(98, 'BATIDO', 1.5, 8, 'BATIDO', 1, NULL, 0, NULL),
(99, 'ACUARIUS N', 1.7, 8, 'ACUARIUS N', 1, NULL, 0, NULL),
(100, 'ACUARIUS L', 1.7, 8, 'ACUARIUS L', 1, NULL, 0, NULL),
(101, 'NESTEA', 1.7, 8, 'NESTEA', 1, NULL, 0, NULL),
(102, 'RED BULL', 2.5, 8, 'RED BULL', 1, NULL, 0, NULL),
(103, 'COLA  LAIG G', 1.7, 8, 'COLA  LAIG G', 1, NULL, 0, NULL),
(104, 'COLA ZERO', 1.7, 8, 'COLA ZERO', 1, NULL, 0, NULL),
(105, 'AGUA PEQUEÑA', 1, 8, 'AGUA PEQUEÑA', 1, NULL, 0, NULL),
(106, 'AGUA GRANDE', 2, 8, 'AGUA GRANDE', 1, NULL, 0, NULL),
(107, 'AGUA CON GAS', 1.2, 8, 'AGUA CON GAS', 1, NULL, 0, NULL),
(108, 'GRANIZADOS', 2, 8, 'GRANIZADOS', 1, NULL, 0, NULL),
(109, 'HORCHATA', 2, 8, 'HORCHATA', 1, NULL, 0, NULL),
(110, 'GASEOSA', 1, 8, 'GASEOSA', 1, NULL, 0, NULL),
(111, 'ZUMO NATURAL', 2, 8, 'ZUMO NATURAL', 1, NULL, 0, NULL),
(112, 'MOSTO', 1.5, 8, 'MOSTO', 1, NULL, 0, NULL),
(113, 'TABLA JAMON', 8, 9, 'TABLA JAMON', 1, NULL, 0, NULL),
(114, 'TABLA QUESO', 8, 9, 'TABLA QUESO', 1, NULL, 0, NULL),
(115, 'JAMON Y QUESO', 8, 9, 'JAMON Y QUESO', 1, NULL, 0, NULL),
(116, 'CECINA', 8, 9, 'CECINA', 1, NULL, 0, NULL),
(117, 'TABLA Y SIDRA', 10, 9, 'TABLA Y SIDRA', 1, NULL, 0, NULL),
(118, 'ENSALADA', 6, 10, 'ENSALADA', 1, NULL, 0, NULL),
(119, 'TRES QUESOS', 6, 10, 'TRES QUESOS', 1, NULL, 0, NULL),
(120, 'RUSTICA', 6, 10, 'RUSTICA', 1, NULL, 0, NULL),
(121, 'ARCO IRIS', 6, 10, 'ARCO IRIS', 1, NULL, 0, NULL),
(122, 'H.R JAMON', 2, 11, 'H.R JAMON', 1, NULL, 0, NULL),
(123, 'H.R CHISTORRA', 2, 11, 'H.R CHISTORRA', 1, NULL, 0, NULL),
(124, 'REVUELTO SET', 2.5, 11, 'REVUELTO SET', 1, NULL, 0, NULL),
(125, 'CARACOLES', 2.5, 11, 'CARACOLES', 1, NULL, 0, NULL),
(126, 'ALBONDIGAS', 2.5, 11, 'ALBONDIGAS', 1, NULL, 0, NULL),
(127, 'PESCADITO', 2.5, 11, 'PESCADITO', 1, NULL, 0, NULL),
(128, 'CHAMPIÑON', 5, 12, 'CHAMPIÑON', 1, NULL, 0, NULL),
(129, 'CALLOS', 5, 12, 'CALLOS', 1, NULL, 0, NULL),
(130, 'OREJA', 5, 12, 'OREJA', 1, NULL, 0, NULL),
(131, 'CRUJIENTES IB', 5, 12, 'CRUJIENTES IB', 1, NULL, 0, NULL),
(132, 'CRUJIENTE QUESO', 4, 12, 'CRUJIENTE QUESO', 1, NULL, 0, NULL),
(133, 'MORRO FRITO', 5, 12, 'MORRO FRITO', 1, NULL, 0, NULL),
(134, 'PATATAS BRAVAS', 5, 12, 'PATATAS BRAVAS', 1, NULL, 0, NULL),
(135, 'ALITAS DE POLLO', 6, 12, 'ALITAS DE POLLO', 1, NULL, 0, NULL),
(136, 'SEPIA', 7, 12, 'SEPIA', 1, NULL, 0, NULL),
(137, 'JAMON Y QUESO', 3.5, 13, 'JAMON Y QUESO', 1, NULL, 0, NULL),
(138, 'SALCHICHAS', 3.75, 14, 'SALCHICHAS', 1, NULL, 0, NULL),
(139, 'JAMON Y QUESO', 3.75, 14, 'JAMON Y QUESO', 1, NULL, 0, NULL),
(140, 'ANCHOAS', 3.75, 14, 'ANCHOAS', 1, NULL, 0, NULL),
(141, 'VEGETAL', 3.75, 14, 'VEGETAL', 1, NULL, 0, NULL),
(142, 'SOBRASADA Y', 3.75, 14, 'SOBRASADA Y', 1, NULL, 0, NULL),
(143, 'LOMO Y QUESO', 3.75, 14, 'LOMO Y QUESO', 1, NULL, 0, NULL),
(144, 'LOMO Y PIMIENTOS', 3.75, 14, 'LOMO Y PIMIENTOS', 1, NULL, 0, NULL),
(145, 'BACON Y QUESO', 3.75, 14, 'BACON Y QUESO', 1, NULL, 0, NULL),
(146, 'FRANCESA A GUS', 3.75, 14, 'FRANCESA A GUS', 1, NULL, 0, NULL),
(147, 'TORTILLA PATATA', 3.75, 14, 'TORTILLA PATATA', 1, NULL, 0, NULL),
(148, 'SEPIA', 3.75, 14, 'SEPIA', 1, NULL, 0, NULL),
(149, 'MANCHA COR', 3.75, 14, 'MANCHA COR', 1, NULL, 0, NULL),
(150, 'PECHUGA POLLO', 3.75, 14, 'PECHUGA POLLO', 1, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
CREATE TABLE IF NOT EXISTS `ubicacion` (
  `IdUbicacion` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `IdBloqueUbicacion` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`IdUbicacion`),
  KEY `fk_Ubicacion_BloqueUbicacion1` (`IdBloqueUbicacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`IdUbicacion`, `Nombre`, `Descripcion`, `IdBloqueUbicacion`, `Activo`) VALUES
(1, 'defecto', 'defecto', 1, 1),
(2, 'defecto', 'defecto', 2, 1),
(3, 'defecto', 'defecto', 3, 1),
(4, 'mesa 2', 'mesa 2', 2, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `arqueos`
--
ALTER TABLE `arqueos`
  ADD CONSTRAINT `fk_Arqueos_caja1` FOREIGN KEY (`IdCaja`) REFERENCES `caja` (`idCaja`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `atipicas`
--
ALTER TABLE `atipicas`
  ADD CONSTRAINT `fk_atipicas_bloqueubicacion1` FOREIGN KEY (`bloqueubicacion`) REFERENCES `bloqueubicacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_atipicas_productos1` FOREIGN KEY (`productos`) REFERENCES `productos` (`IdProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cabezera`
--
ALTER TABLE `cabezera`
  ADD CONSTRAINT `fk_Cabezera_Camarero1` FOREIGN KEY (`IdCamarero`) REFERENCES `camarero` (`IdCamarero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `caja`
--
ALTER TABLE `caja`
  ADD CONSTRAINT `fk_caja_cabezera1` FOREIGN KEY (`IdCabezera`) REFERENCES `cabezera` (`IdCabezera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_caja_camarero1` FOREIGN KEY (`IdCamarero`) REFERENCES `camarero` (`IdCamarero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `camarero`
--
ALTER TABLE `camarero`
  ADD CONSTRAINT `fk_camarero_Empresas1` FOREIGN KEY (`IdEmpresa`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `linea`
--
ALTER TABLE `linea`
  ADD CONSTRAINT `fk_Linea_Cabezera1` FOREIGN KEY (`IdCabezera`) REFERENCES `cabezera` (`IdCabezera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Linea_Productos1` FOREIGN KEY (`IdProductos`) REFERENCES `productos` (`IdProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Linea_Ubicacion1` FOREIGN KEY (`IdUbicacion`) REFERENCES `ubicacion` (`IdUbicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_Productos_Categoria` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD CONSTRAINT `fk_Ubicacion_BloqueUbicacion1` FOREIGN KEY (`IdBloqueUbicacion`) REFERENCES `bloqueubicacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
