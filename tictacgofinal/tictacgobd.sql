-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 08 mars 2023 à 20:17
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tictacgobd`
--

-- --------------------------------------------------------

--
-- Structure de la table `assurance`
--

CREATE TABLE `assurance` (
  `id_assurance` int(9) NOT NULL,
  `date_validité` varchar(255) NOT NULL,
  `immatriculation` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

CREATE TABLE `chauffeur` (
  `idc` int(9) NOT NULL,
  `nomc` varchar(255) NOT NULL,
  `prenomc` varchar(255) NOT NULL,
  `numc` int(9) NOT NULL,
  `adressec` varchar(255) NOT NULL,
  `emailc` varchar(255) NOT NULL,
  `idd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `chauffeur`
--

INSERT INTO `chauffeur` (`idc`, `nomc`, `prenomc`, `numc`, `adressec`, `emailc`, `idd`) VALUES
(33, 'sarra', 'bellassoued', 14555, '4ddd', 'jj@yahoo.com', 8555),
(34, 'salih', 'jdjdjdjd', 555555, 'dndndndn', 'sarra.bellassoued@espti.com', 2001),
(36, 'poooo', 'laaaaa', 75555, 'dhdhd', 'mm@gmail.com', 2001),
(39, 'semah', 'achraf', 65892, 'heuuee5', 'aaa@yahoo.com', 2001),
(40, 'mmm', 'ou', 45, 'iiii', 'aaa@gmail.com', 2001),
(47, 'aaa', 'aaaa', 4587, 'dtetet', 'med@iiii.com', 2001),
(48, 'aaaa', 'aa', 9658, 'aaaa', 'aaa@yamli.com', 8555),
(49, 'achraf', 'derbel', 8524, 'aaaaa', 'oooo@uuu.com', 2001),
(50, 'zzz', 'zooo', 544, 'mm', 'mm@gmail.com', 2001),
(51, 'mmmmmm', 'blooooo', 25666, 'dhjdjjd', 'co@gmail.com', 2001),
(52, 'salihhh', 'salah', 5487, 'aafe', 'aaa@gmail.com', 2001);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_compte` int(9) NOT NULL,
  `type_user` varchar(15) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `type_user`, `nom`, `email`, `mot_de_passe`) VALUES
(44, 'passager', 'rayen', 'rayen@esprit.tn', 'rayen1234'),
(45, 'chauffeur', 'achref', 'achref@esprit.tn', 'achref123');

-- --------------------------------------------------------

--
-- Structure de la table `covoiturage`
--

CREATE TABLE `covoiturage` (
  `id_cov` int(11) NOT NULL,
  `idc` int(11) NOT NULL,
  `depart` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `date_covoiturage` varchar(20) NOT NULL,
  `Prix` int(11) DEFAULT NULL,
  `nbrplace` int(11) NOT NULL,
  `vehicule` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `destination`
--

CREATE TABLE `destination` (
  `idd` int(11) NOT NULL,
  `gouvernorat` varchar(255) NOT NULL,
  `adressed` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `destination`
--

INSERT INTO `destination` (`idd`, `gouvernorat`, `adressed`) VALUES
(478, 'bbbbb ', 'rayen'),
(2001, 'bbbbb ', 'rayen'),
(4748, 'bbbbb ', 'rayen'),
(6987, 'bbbbb ', 'rayen'),
(8555, 'bbbbb ', 'rayen'),
(78888, 'bbbbb ', 'rayen'),
(78946, 'fhddf', 'dfhgd'),
(78947, 'jjhl', 'jlkj'),
(78948, 'Beja', ', nahj el lima');

-- --------------------------------------------------------

--
-- Structure de la table `infotrafic`
--

CREATE TABLE `infotrafic` (
  `idi` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `idc` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `infotrafic`
--

INSERT INTO `infotrafic` (`idi`, `type`, `description`, `idc`) VALUES
(641, 'mmm', 'asba', 47),
(642, 'aaa', 'aaa', 47),
(643, 'aaa', 'test', 47);

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `idpy` int(9) NOT NULL,
  `Prix` int(10) NOT NULL,
  `descp` varchar(255) NOT NULL,
  `datepaiement` date NOT NULL,
  `paiementValide` tinyint(1) NOT NULL,
  `M_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`idpy`, `Prix`, `descp`, `datepaiement`, `paiementValide`, `M_id`) VALUES
(1, 56, 'rgre', '2023-02-28', 0, 1),
(2, 999, 'CHANGE', '2023-02-23', 1, 2),
(3, 564, 'fgftgnf', '2023-02-23', 2, 1),
(4, 76, 'CHANGED', '2023-02-22', 0, 1),
(5, 5, 'rhr', '2023-02-23', 2, 1),
(6, 45, 'Hello', '2023-02-22', 1, 1),
(7, 50, 'cest une description', '2023-02-22', 1, 1),
(8, 54, 'erhr', '2023-02-23', 5, 1),
(9, 44, 'Hello', '2023-02-23', 0, 1),
(10, 676, 'eze', '2023-02-23', 1, 1),
(11, 66, 'ftlhrlk', '2023-02-23', 1, 4),
(44, 44, 'rge', '2023-02-28', 1, 1),
(54, 54, 'Try3', '2023-03-01', 1, 1),
(55, 55, 'Voici le payement', '2023-03-01', 1, 1),
(61, 61, 'TODAY', '2023-03-02', 1, 1),
(67, 67, 'Hello', '2023-02-28', 1, 1),
(68, 68, 'MA5AR', '2023-03-01', 1, 1),
(73, 73, 'HELLOOOOOO', '2023-03-02', 1, 1),
(76, 76, 'erg', '2023-02-28', 1, 1),
(77, 77, '5555555555554444', '2023-02-28', 1, 1),
(78, 78, 'ekrjg', '2023-02-28', 1, 1),
(88, 99, 'MA5AR', '2023-03-01', 1, 1),
(90, 56, 'elrkh', '2023-02-28', 1, 1),
(98, 45, 'erlkng', '2023-02-28', 1, 1),
(900, 900, 'Try2', '2023-03-01', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `passager`
--

CREATE TABLE `passager` (
  `idp` int(9) NOT NULL,
  `nomp` varchar(255) NOT NULL,
  `prenomp` varchar(255) NOT NULL,
  `nump` varchar(255) NOT NULL,
  `adressep` varchar(255) NOT NULL,
  `emailp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `passager`
--

INSERT INTO `passager` (`idp`, `nomp`, `prenomp`, `nump`, `adressep`, `emailp`) VALUES
(77797, 'aloo', 'sss', '45555', 'sjjjj', 'mohamedachraf.zribi@esprit.tn'),
(77798, 'aloo', 'sss', '45555', 'sjjjj', 'mohamedachraf.zribi@esprit.tn'),
(77799, 'sarra', 'bellassoued', '53128940', 'medina jadida', 'mohamedachraf.zribi@esprit.tn');

-- --------------------------------------------------------

--
-- Structure de la table `payment_method`
--

CREATE TABLE `payment_method` (
  `M_id` int(10) NOT NULL,
  `UserID` int(10) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `payment_method`
--

INSERT INTO `payment_method` (`M_id`, `UserID`, `type`) VALUES
(3, 66, 99);

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_reclamation` int(9) NOT NULL,
  `description` varchar(250) NOT NULL,
  `date_creation` varchar(255) NOT NULL,
  `nomr` varchar(255) NOT NULL,
  `id_compte` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `review`
--

CREATE TABLE `review` (
  `int_review` int(9) NOT NULL,
  `avis` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `review`
--

INSERT INTO `review` (`int_review`, `avis`) VALUES
(3, 'it was a good experience'),
(5, 'trés bien');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `immatriculation` varchar(12) NOT NULL,
  `modele` varchar(20) NOT NULL,
  `marque` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `idc` int(9) NOT NULL,
  `nb_places` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `assurance`
--
ALTER TABLE `assurance`
  ADD PRIMARY KEY (`id_assurance`),
  ADD KEY `assveh` (`immatriculation`);

--
-- Index pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  ADD PRIMARY KEY (`idc`),
  ADD KEY `fk_foreignD` (`idd`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_compte`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `covoiturage`
--
ALTER TABLE `covoiturage`
  ADD PRIMARY KEY (`id_cov`),
  ADD KEY `fk_utilisateur_covoiturage` (`idc`),
  ADD KEY `covveh` (`vehicule`);

--
-- Index pour la table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`idd`);

--
-- Index pour la table `infotrafic`
--
ALTER TABLE `infotrafic`
  ADD PRIMARY KEY (`idi`),
  ADD KEY `fk_foreignnnnn` (`idc`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`idpy`),
  ADD KEY `fk_Mp` (`M_id`);

--
-- Index pour la table `passager`
--
ALTER TABLE `passager`
  ADD PRIMARY KEY (`idp`),
  ADD UNIQUE KEY `idp` (`idp`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_reclamation`),
  ADD KEY `fk_idc` (`id_compte`);

--
-- Index pour la table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`int_review`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`immatriculation`),
  ADD KEY `vehchauf` (`idc`),
  ADD KEY `marque` (`marque`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `assurance`
--
ALTER TABLE `assurance`
  MODIFY `id_assurance` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  MODIFY `idc` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id_compte` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT pour la table `covoiturage`
--
ALTER TABLE `covoiturage`
  MODIFY `id_cov` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98750;

--
-- AUTO_INCREMENT pour la table `destination`
--
ALTER TABLE `destination`
  MODIFY `idd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78949;

--
-- AUTO_INCREMENT pour la table `infotrafic`
--
ALTER TABLE `infotrafic`
  MODIFY `idi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=644;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `idpy` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=901;

--
-- AUTO_INCREMENT pour la table `passager`
--
ALTER TABLE `passager`
  MODIFY `idp` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77800;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id_reclamation` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `review`
--
ALTER TABLE `review`
  MODIFY `int_review` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `assurance`
--
ALTER TABLE `assurance`
  ADD CONSTRAINT `assveh` FOREIGN KEY (`immatriculation`) REFERENCES `vehicule` (`immatriculation`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  ADD CONSTRAINT `chauffeur_ibfk_1` FOREIGN KEY (`idd`) REFERENCES `destination` (`idd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_foreignD` FOREIGN KEY (`idd`) REFERENCES `destination` (`idd`);

--
-- Contraintes pour la table `covoiturage`
--
ALTER TABLE `covoiturage`
  ADD CONSTRAINT `covchauf` FOREIGN KEY (`idc`) REFERENCES `chauffeur` (`idc`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `covveh` FOREIGN KEY (`vehicule`) REFERENCES `vehicule` (`marque`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `infotrafic`
--
ALTER TABLE `infotrafic`
  ADD CONSTRAINT `fk_foreignnnnn` FOREIGN KEY (`idc`) REFERENCES `chauffeur` (`idc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `comptrec` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehchauf` FOREIGN KEY (`idc`) REFERENCES `chauffeur` (`idc`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
