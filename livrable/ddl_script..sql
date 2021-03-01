-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 01 mars 2021 à 10:58
-- Version du serveur :  8.0.23
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `crypto_money`
--
CREATE DATABASE IF NOT EXISTS `crypto_money` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


--
-- USER : `CDA1`
--

CREATE USER 'cda1'@'%' IDENTIFIED BY 'Algerie1';

--
-- PRIVILEGES : `CDA1`
--

GRANTE ALL PRIVILEGES ON crypto_money.*  TO 'cda1'@'%';

USE `crypto_money`;

-- --------------------------------------------------------

--
-- Structure de la table `cryptomoney`
--

DROP TABLE IF EXISTS `cryptomoney`;
CREATE TABLE IF NOT EXISTS `cryptomoney` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `label` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Structure de la table `mycryptomoney`
--

DROP TABLE IF EXISTS `mycryptomoney`;
CREATE TABLE IF NOT EXISTS `mycryptomoney` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `nombreUnite` int NOT NULL,
  `prixAchat` float NOT NULL,
  `cryptoId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cryptoId` (`cryptoId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `mycryptomoney`
--
ALTER TABLE `mycryptomoney`
  ADD CONSTRAINT `cryptoId` FOREIGN KEY (`cryptoId`) REFERENCES `cryptomoney` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

