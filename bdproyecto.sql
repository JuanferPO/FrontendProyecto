-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 09-05-2023 a las 15:13:25
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
  `nombrePaciente` varchar(50) NOT NULL,
  `procedimiento` varchar(30) NOT NULL,
  `nombreEspecialista` varchar(50) NOT NULL,
  `fechaAtencion` date NOT NULL,
  `horaAtencion` varchar(25) NOT NULL,
  `consultorio` varchar(30) NOT NULL,
  `horaAtencionInicio` time NOT NULL,
  `horaAtencionFin` time NOT NULL,
  `fechaAtencionDia` int(11) NOT NULL,
  `fechaAtencionMes` varchar(10) NOT NULL,
  `fechaAtencionAno` int(11) NOT NULL,
  `horaAtencionInicioH` int(11) NOT NULL,
  `horaAtencionInicioM` int(11) NOT NULL,
  `horaAtencionInicioA` varchar(12) NOT NULL,
  `horaAtencionFinH` int(11) NOT NULL,
  `horaAtencionFinM` int(11) NOT NULL,
  `horaAtencionFinA` varchar(12) NOT NULL
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
  `horarioInicio` time NOT NULL,
  `horarioFin` time NOT NULL,
  `horarioInicioH` int(11) NOT NULL,
  `horarioInicioM` int(11) NOT NULL,
  `horarioInicioA` varchar(5) NOT NULL,
  `horarioFinH` int(11) NOT NULL,
  `horarioFinM` int(11) NOT NULL,
  `horarioFinA` varchar(5) NOT NULL,
  `horarioDia1` tinyint(1) NOT NULL,
  `horarioDia2` tinyint(1) NOT NULL,
  `horarioDia3` tinyint(1) NOT NULL,
  `horarioDia4` tinyint(1) NOT NULL,
  `horarioDia5` tinyint(1) NOT NULL,
  `horarioDia6` tinyint(1) NOT NULL,
  `horarioDia7` tinyint(1) NOT NULL
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
