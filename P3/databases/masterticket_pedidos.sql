-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 01-12-2017 a las 18:47:39
-- Versión del servidor: 5.7.20-0ubuntu0.17.10.1
-- Versión de PHP: 5.6.31-6+ubuntu17.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `masterticket_pedidos`
--

-- --------------------------------------------------------

/*CREATE DATABASE masterticket_pedidos;*/

--
-- Estructura de tabla para la tabla `eventopedidos`
--

CREATE TABLE `eventopedidos` (
  `id` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `num_entradas_compradas` int(5) NOT NULL,
  `precio` int(10) NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `eventopedidos`
--

INSERT INTO `eventopedidos` (`id`, `id_evento`, `id_pedido`, `id_usuario`, `num_entradas_compradas`, `precio`, `created`, `modified`) VALUES
(4, 17, 2, 3, 8, 96, '2017-11-12 00:00:00', '2017-11-12 00:00:00'),
(5, 17, 2, 3, 6, 72, '2017-11-16 00:00:00', '2017-11-16 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `precio` int(100) NOT NULL,
  `num_tarjeta` varchar(16) COLLATE utf8_spanish_ci NOT NULL,
  `cv2_tarjeta` int(3) NOT NULL,
  `caducidad_tarjeta` date NOT NULL,
  `pagado` tinyint(1) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `id_usuario`, `precio`, `num_tarjeta`, `cv2_tarjeta`, `caducidad_tarjeta`, `pagado`, `created`, `modified`) VALUES
(2, 3, 96, '1111111111111111', 111, '2017-10-18', 1, '2017-11-12 00:00:00', '2017-11-12 00:00:00'),
(3, 3, 72, '87876458778787', 343, '2017-10-17', 1, '2017-11-16 00:00:00', '2017-11-16 00:00:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventopedidos`
--
ALTER TABLE `eventopedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_evento` (`id_evento`),
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventopedidos`
--
ALTER TABLE `eventopedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
