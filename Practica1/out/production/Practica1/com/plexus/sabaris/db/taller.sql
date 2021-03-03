-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-03-2021 a las 14:39:26
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `taller`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Edad` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellidos`, `Edad`) VALUES
('12345678A', 'Carmen', 'Iglero', 29),
('12345678B', 'Ninfa', 'Garcia', 70),
('12345678C', 'Christian', 'Sabaris Garcia', 42),
('77407298Q', 'Jose Manuel', 'Sabaris Garcia', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparacion`
--

CREATE TABLE `reparacion` (
  `id_reparacion` int(10) NOT NULL,
  `cliente` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `vehiculo` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `tiempo` decimal(10,0) NOT NULL,
  `totalReparacion` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `reparacion`
--

INSERT INTO `reparacion` (`id_reparacion`, `cliente`, `vehiculo`, `descripcion`, `fecha`, `tiempo`, `totalReparacion`) VALUES
(1, '77407298Q', '6786DWS', 'Cambio de las 4 ruedas', '2021-03-03', '4', '250'),
(2, '77407298Q', '1234ABC', 'Cambio de aceite y filtro', '2021-03-01', '2', '46'),
(3, '12345678A', '5577JYX', 'Pintar el coche entero', '2021-03-02', '6', '600');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `Matricula` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `Marca` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Modelo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `año` int(4) NOT NULL,
  `color` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`Matricula`, `Marca`, `Modelo`, `año`, `color`) VALUES
('1234ABC', 'Honda', 'CBR', 2006, 'Negra-Roja'),
('5577JYX', 'Audi', 'A1', 2016, 'Blanco-Negro'),
('5648WER', 'Mercedes', 'Vaneo', 2000, 'Plata'),
('5678GTF', 'Volswagen', 'Polo', 2008, 'Gris'),
('6786DWS', 'Honda', 'Accord', 2007, 'Gris-Azul'),
('8523TRE', 'Ford', 'Mondeo', 2009, 'Blanco');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `reparacion`
--
ALTER TABLE `reparacion`
  ADD PRIMARY KEY (`id_reparacion`),
  ADD KEY `cliente` (`cliente`),
  ADD KEY `vehiculo` (`vehiculo`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`Matricula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reparacion`
--
ALTER TABLE `reparacion`
  MODIFY `id_reparacion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reparacion`
--
ALTER TABLE `reparacion`
  ADD CONSTRAINT `reparacion_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`DNI`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `reparacion_ibfk_2` FOREIGN KEY (`vehiculo`) REFERENCES `vehiculo` (`Matricula`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
