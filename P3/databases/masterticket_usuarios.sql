-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 01-12-2017 a las 18:47:44
-- Versión del servidor: 5.7.20-0ubuntu0.17.10.1
-- Versión de PHP: 5.6.31-6+ubuntu17.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `masterticket_usuarios`
--

/*CREATE DATABASE masterticket_usuarios;*/

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` enum('admin','comprador') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'comprador',
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `tipo`, `email`, `password`, `created`, `modified`) VALUES
(1, 'admin1', 'admin1', 'admin', 'admin1@correo.es', '81dc9bdb52d04dc20036dbd8313ed055', '2017-11-12 15:24:39', '2017-11-12 15:24:39'),
(2, 'admin2', 'admin2', 'admin', 'admin2@correo.es', '81dc9bdb52d04dc20036dbd8313ed055', '2017-11-12 15:24:39', '2017-11-12 15:24:39'),
(3, 'comprador1', 'comprador1', 'comprador', 'comprador1@correo.es', '81dc9bdb52d04dc20036dbd8313ed055', '2017-11-12 15:26:11', '2017-11-12 15:26:11'),
(4, 'comprador2', 'comprador2', 'comprador', 'comprador2@correo.es', '81dc9bdb52d04dc20036dbd8313ed055', '2017-11-12 15:26:11', '2017-11-12 15:26:11'),
(5, 'moha', 'zariohi', 'comprador', 'aaaaaa@blkabla.com', '81dc9bdb52d04dc20036dbd8313ed055', '2017-11-16 15:15:57', '2017-11-16 15:15:57');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
