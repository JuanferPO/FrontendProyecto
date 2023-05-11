-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 09-05-2023 a las 19:35:06
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdproyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id` int(11) NOT NULL,
  `procedimiento` varchar(30) NOT NULL,
  `consultorio` varchar(30) NOT NULL,
  `fecha_atencion` date DEFAULT NULL,
  `fecha_atencion_ano` int(11) NOT NULL,
  `fecha_atencion_dia` int(11) NOT NULL,
  `fecha_atencion_mes` varchar(10) DEFAULT NULL,
  `hora_atencion` varchar(25) DEFAULT NULL,
  `hora_atencion_fin` time DEFAULT NULL,
  `hora_atencion_fina` varchar(5) DEFAULT NULL,
  `hora_atencion_finh` int(11) NOT NULL,
  `hora_atencion_finm` int(11) NOT NULL,
  `hora_atencion_inicio` time DEFAULT NULL,
  `hora_atencion_inicioa` varchar(5) DEFAULT NULL,
  `hora_atencion_inicioh` int(11) NOT NULL,
  `hora_atencion_iniciom` int(11) NOT NULL,
  `nombre_especialista` varchar(50) DEFAULT NULL,
  `nombre_paciente` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialista`
--

CREATE TABLE `especialista` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `horario` varchar(75) NOT NULL,
  `horario_dia1` bit(1) NOT NULL,
  `horario_dia2` bit(1) NOT NULL,
  `horario_dia3` bit(1) NOT NULL,
  `horario_dia4` bit(1) NOT NULL,
  `horario_dia5` bit(1) NOT NULL,
  `horario_dia6` bit(1) NOT NULL,
  `horario_dia7` bit(1) NOT NULL,
  `horario_fin` time DEFAULT NULL,
  `horario_fina` varchar(5) DEFAULT NULL,
  `horario_finh` int(11) NOT NULL,
  `horario_finm` int(11) NOT NULL,
  `horario_inicio` time DEFAULT NULL,
  `horario_inicioa` varchar(5) DEFAULT NULL,
  `horario_inicioh` int(11) NOT NULL,
  `horario_iniciom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `especialista`
--
ALTER TABLE `especialista`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especialista`
--
ALTER TABLE `especialista`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
