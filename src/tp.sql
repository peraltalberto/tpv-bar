-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-09-2016 a las 17:03:47
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `atipicas`
--

INSERT INTO `atipicas` (`id`, `tipo`, `precio`, `bloqueubicacion`, `productos`) VALUES
(1, 0, 1.25, 1, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `cabezera`
--

INSERT INTO `cabezera` (`IdCabezera`, `Total`, `Estado`, `Fecha`, `IdCamarero`, `cod`) VALUES
(1, 0, 1, '2016-09-19 09:39:05', 1, 1),
(2, 0, 1, '2016-09-19 10:00:35', 1, 2),
(3, 11.75, 1, '2016-09-19 10:18:03', 1, 3),
(4, 0, 1, '2016-09-19 10:18:34', 2, 4),
(5, 0, 3, '2016-09-19 10:18:36', 1, 5),
(6, 2.5, 1, '2016-09-19 10:26:40', 1, 6);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`idCaja`, `fecha`, `movimiento`, `saldo`, `descripcion`, `IdCabezera`, `IdCamarero`, `cajaPago`) VALUES
(1, '2016-09-19 10:18:03', 11.75, 11.75, NULL, 3, 1, 0),
(2, '2016-09-19 10:18:24', 0, 11.75, NULL, 2, 1, 0),
(3, '2016-09-19 10:18:34', 0, 11.75, NULL, 4, 2, 0),
(4, '2016-09-19 10:27:50', 2.5, 14.25, NULL, 6, 1, 0);

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
(0, 'codTicket', '6'),
(1, 'impresora1', 'Microsoft Print to PDF'),
(2, 'abrircajon', 'BIXOLON SRP-350-A'),
(3, 'nombre', 'La Tasca de Leo'),
(4, 'nif', '18417932S'),
(5, 'cif', '0'),
(6, 'Telefono', '0'),
(7, 'Fax', '0'),
(8, 'direccion', 'Avd. Aragón 9'),
(9, 'Correo', 'Pruebac'),
(10, 'cp', '44002'),
(11, 'pass', '4321');

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
  KEY `fk_Linea_Productos1` (`IdProductos`),
  KEY `fk_Linea_Cabezera1` (`IdCabezera`),
  KEY `fk_Linea_Ubicacion1` (`IdUbicacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `linea`
--

INSERT INTO `linea` (`IdLinea`, `Precio`, `catidad`, `Total`, `IdCabezera`, `IdProductos`, `cobrado`, `IdUbicacion`, `Invitacion`) VALUES
(1, 3.5, 1, 3.5, 3, 137, 1, 2, 0),
(2, 3.75, 1, 3.75, 3, 139, 1, 2, 0),
(3, 4.5, 1, 4.5, 3, 57, 1, 2, 0),
(4, 1, 1, 1, NULL, 1, 0, 3, 0),
(5, 1.25, 1, 1.25, 6, 1, 1, 1, 0),
(6, 1.25, 1, 1.25, 6, 1, 1, 1, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`IdUbicacion`, `Nombre`, `Descripcion`, `IdBloqueUbicacion`, `Activo`) VALUES
(1, 'defecto', 'defecto', 1, 1),
(2, 'defecto', 'defecto', 2, 1),
(3, 'defecto', 'defecto', 3, 1);

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
