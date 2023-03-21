-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3310
-- Generation Time: Mar 18, 2023 at 11:06 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom_client` varchar(50) NOT NULL,
  `prenom_client` varchar(50) NOT NULL,
  `numero_tel_client` varchar(10) NOT NULL,
  `adresse_client` varchar(50) NOT NULL,
  `code_postal_client` int(11) NOT NULL,
  `ville_client` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `numero_tel_client`, `adresse_client`, `code_postal_client`, `ville_client`) VALUES
(1, 'Boyer', 'Alexandre', '0617413364', '10 boulevard de strasbourg', 31100, 'Toulouse'),
(2, 'Dufour', 'Maxime', '0606060606', '112 avenue de la gloire', 31400, 'Toulouse');

-- --------------------------------------------------------

--
-- Table structure for table `compte_bancaire`
--

CREATE TABLE `compte_bancaire` (
  `numero_compte_bancaire` int(11) NOT NULL,
  `solde_compte_bancaire` int(11) NOT NULL,
  `id_conseiller` int(11) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `compte_bancaire`
--

INSERT INTO `compte_bancaire` (`numero_compte_bancaire`, `solde_compte_bancaire`, `id_conseiller`, `id_client`) VALUES
(1, 9130, 1, 1),
(2, 10469, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `conseiller`
--

CREATE TABLE `conseiller` (
  `id_conseiller` int(11) NOT NULL,
  `nom_conseiller` varchar(50) NOT NULL,
  `prenom_conseiller` varchar(50) NOT NULL,
  `nom_utilisateur_conseiller` varchar(50) NOT NULL,
  `password_conseiller` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conseiller`
--

INSERT INTO `conseiller` (`id_conseiller`, `nom_conseiller`, `prenom_conseiller`, `nom_utilisateur_conseiller`, `password_conseiller`) VALUES
(1, 'Boyer', 'Alexandre', 'a.boyer', 'test1234');

-- --------------------------------------------------------

--
-- Table structure for table `operation_bancaire`
--

CREATE TABLE `operation_bancaire` (
  `id_operation_bancaire` int(11) NOT NULL,
  `date_operation_bancaire` datetime NOT NULL,
  `montant_operation_bancaire` int(11) NOT NULL,
  `id_type_operation` int(11) NOT NULL,
  `numero_compte_bancaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `operation_bancaire`
--

INSERT INTO `operation_bancaire` (`id_operation_bancaire`, `date_operation_bancaire`, `montant_operation_bancaire`, `id_type_operation`, `numero_compte_bancaire`) VALUES
(3, '2023-03-06 00:00:00', 123, 1, 2),
(4, '2023-03-06 00:00:00', 123, 1, 2),
(5, '2023-03-07 00:00:00', 1234, 1, 2),
(6, '2023-03-07 00:00:00', 1234, 1, 2),
(7, '2023-03-08 00:00:00', 1238, 1, 1),
(8, '2023-03-07 00:00:00', 100, 1, 1),
(9, '2023-03-07 00:00:00', 100, 1, 1),
(10, '2023-03-01 00:00:00', 123, 1, 1),
(11, '2023-03-08 00:00:00', 5222, 1, 1),
(12, '2023-03-07 00:00:00', 158, 1, 2),
(13, '2023-02-28 00:00:00', 1445, 1, 1),
(14, '2023-03-06 00:00:00', 145, 1, 1),
(15, '2023-03-06 00:00:00', 456, 1, 2),
(16, '2023-03-07 00:00:00', 14, 1, 1),
(17, '2023-03-07 00:00:00', 145, 1, 1),
(18, '2023-03-06 00:00:00', 789, 1, 1),
(19, '2023-03-07 00:00:00', 789, 1, 1),
(20, '2023-03-07 00:00:00', 14, 1, 1),
(21, '2023-03-07 00:00:00', 852, 1, 1),
(22, '2023-03-07 00:00:00', 78, 1, 1),
(23, '2023-03-07 00:00:00', 100, 1, 1),
(24, '2023-02-27 00:00:00', 1, 1, 1),
(25, '2023-03-07 00:00:00', 1, 1, 1),
(26, '2023-03-08 00:00:00', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `type_operation`
--

CREATE TABLE `type_operation` (
  `id_type_operation` int(11) NOT NULL,
  `libelle_type_operation` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `type_operation`
--

INSERT INTO `type_operation` (`id_type_operation`, `libelle_type_operation`) VALUES
(1, 'Depot'),
(2, 'Retrait');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  ADD PRIMARY KEY (`numero_compte_bancaire`),
  ADD KEY `id_conseiller` (`id_conseiller`),
  ADD KEY `id_client` (`id_client`);

--
-- Indexes for table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id_conseiller`);

--
-- Indexes for table `operation_bancaire`
--
ALTER TABLE `operation_bancaire`
  ADD PRIMARY KEY (`id_operation_bancaire`),
  ADD KEY `id_type_operation` (`id_type_operation`),
  ADD KEY `numero_compte_bancaire` (`numero_compte_bancaire`);

--
-- Indexes for table `type_operation`
--
ALTER TABLE `type_operation`
  ADD PRIMARY KEY (`id_type_operation`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  MODIFY `numero_compte_bancaire` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `id_conseiller` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `operation_bancaire`
--
ALTER TABLE `operation_bancaire`
  MODIFY `id_operation_bancaire` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type_operation`
--
ALTER TABLE `type_operation`
  MODIFY `id_type_operation` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  ADD CONSTRAINT `compte_bancaire_ibfk_1` FOREIGN KEY (`id_conseiller`) REFERENCES `conseiller` (`id_conseiller`),
  ADD CONSTRAINT `compte_bancaire_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Constraints for table `operation_bancaire`
--
ALTER TABLE `operation_bancaire`
  ADD CONSTRAINT `operation_bancaire_ibfk_1` FOREIGN KEY (`id_type_operation`) REFERENCES `type_operation` (`id_type_operation`),
  ADD CONSTRAINT `operation_bancaire_ibfk_2` FOREIGN KEY (`numero_compte_bancaire`) REFERENCES `compte_bancaire` (`numero_compte_bancaire`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
