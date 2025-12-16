-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 16 déc. 2025 à 10:09
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `truckfinder1`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresses_foodtruck`
--

DROP TABLE IF EXISTS `adresses_foodtruck`;
CREATE TABLE IF NOT EXISTS `adresses_foodtruck` (
  `id_adresse` int NOT NULL AUTO_INCREMENT,
  `id_foodtruck` int NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `est_actuelle` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_adresse`),
  KEY `id_foodtruck` (`id_foodtruck`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `adresses_foodtruck`
--

INSERT INTO `adresses_foodtruck` (`id_adresse`, `id_foodtruck`, `adresse`, `est_actuelle`) VALUES
(1, 1, '12 Rue de la Gare, Paris', 1),
(2, 1, '45 Rue de Rivoli, Paris', 0),
(3, 2, '45 Avenue des Champs, Lyon', 1),
(4, 2, '10 Rue de la République, Lyon', 0),
(5, 3, '78 Boulevard de la Mer, Nice', 1),
(6, 4, '3 Rue du Commerce, Bordeaux', 1);

--
-- Déclencheurs `adresses_foodtruck`
--
DROP TRIGGER IF EXISTS `set_adresse_actuelle`;
DELIMITER $$
CREATE TRIGGER `set_adresse_actuelle` BEFORE UPDATE ON `adresses_foodtruck` FOR EACH ROW BEGIN
    IF NEW.est_actuelle = 1 THEN
        UPDATE adresses_foodtruck
        SET est_actuelle = 0
        WHERE id_foodtruck = NEW.id_foodtruck
        AND id_adresse != NEW.id_adresse;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

DROP TABLE IF EXISTS `avis`;
CREATE TABLE IF NOT EXISTS `avis` (
  `id_avis` int NOT NULL AUTO_INCREMENT,
  `id_client` int NOT NULL,
  `id_foodtruck` int NOT NULL,
  `note` int NOT NULL,
  `commentaire` text,
  `date_avis` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_avis`),
  KEY `id_client` (`id_client`),
  KEY `id_foodtruck` (`id_foodtruck`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `avis`
--

INSERT INTO `avis` (`id_avis`, `id_client`, `id_foodtruck`, `note`, `commentaire`, `date_avis`) VALUES
(1, 6, 1, 5, 'Excellent barbecue, je recommande !', '2025-11-08 12:30:00'),
(2, 7, 1, 4, 'Très bon, mais un peu long à servir.', '2025-11-08 13:30:00'),
(3, 8, 4, 5, 'La cuisine asiatique est délicieuse.', '2025-11-08 14:30:00'),
(4, 9, 2, 3, 'Burger correct, mais pourrait être mieux.', '2025-11-08 15:30:00');

-- --------------------------------------------------------

--
-- Structure de la table `demandesinscription`
--

DROP TABLE IF EXISTS `demandesinscription`;
CREATE TABLE IF NOT EXISTS `demandesinscription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commentaire_admin` text,
  `date_demande` datetime(6) DEFAULT NULL,
  `statut` enum('APPROUVE','EN_ATTENTE','REJETE') NOT NULL,
  `id_foodtruck` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `foodtrucks`
--

DROP TABLE IF EXISTS `foodtrucks`;
CREATE TABLE IF NOT EXISTS `foodtrucks` (
  `id_foodtruck` int NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int NOT NULL,
  `nom_foodtruck` varchar(100) NOT NULL,
  `description` text,
  `type_cuisine` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `menu` json DEFAULT NULL,
  `statut` enum('en_attente','approuvé','rejeté') DEFAULT 'en_attente',
  `est_ouvert` tinyint(1) DEFAULT '0',
  `adresse` varchar(255) DEFAULT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id_foodtruck`),
  KEY `id_utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `foodtrucks`
--

INSERT INTO `foodtrucks` (`id_foodtruck`, `id_utilisateur`, `nom_foodtruck`, `description`, `type_cuisine`, `telephone`, `logo`, `menu`, `statut`, `est_ouvert`, `adresse`, `date_creation`, `nom`) VALUES
(1, 2, 'Le Camion Qui Fume', 'Spécialisé en barbecue fumé et viandes marinées.', 'Barbecue', '0612345678', '/logos/lecamionquifume.png', NULL, 'approuvé', 1, NULL, NULL, ''),
(2, 3, 'Burger Nomade', 'Burgers artisanaux et frites maison.', 'Burger', '0687654321', '/logos/burgernomade.png', NULL, 'en_attente', 0, NULL, NULL, ''),
(3, 4, 'Tacos El Paso', 'Tacos et burritos authentiques.', 'Mexicaine', '0611223344', '/logos/tacoselpaso.png', NULL, 'rejeté', 0, NULL, NULL, ''),
(4, 5, 'Wok & Roll', 'Cuisine asiatique rapide et fraîche.', 'Asiatique', '0655667788', '/logos/wokandroll.png', NULL, 'approuvé', 1, NULL, NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `id_message` int NOT NULL AUTO_INCREMENT,
  `id_client` int NOT NULL,
  `id_foodtruck` int NOT NULL,
  `contenu` text NOT NULL,
  `date_envoi` datetime DEFAULT CURRENT_TIMESTAMP,
  `reponse` text,
  `date_reponse` datetime DEFAULT NULL,
  PRIMARY KEY (`id_message`),
  KEY `id_client` (`id_client`),
  KEY `id_foodtruck` (`id_foodtruck`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `messages`
--

INSERT INTO `messages` (`id_message`, `id_client`, `id_foodtruck`, `contenu`, `date_envoi`, `reponse`, `date_reponse`) VALUES
(1, 6, 1, 'Est-ce que vous proposez des menus végétariens ?', '2025-11-08 12:00:00', 'Oui, nous avons des options végétariennes.', '2025-11-08 12:30:00'),
(2, 7, 2, 'Quels sont vos horaires d\'ouverture ?', '2025-11-08 13:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id_utilisateur` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `role` int NOT NULL,
  `date_creation` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_utilisateur`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id_utilisateur`, `nom`, `email`, `mot_de_passe`, `role`, `date_creation`) VALUES
(1, 'Admin Principal', 'admin@foodtruckapp.fr', '$2a$10$N9qo8uLOickgx2ZMRZoMy...', 0, '2025-01-15 08:30:00'),
(2, 'Le Camion Qui Fume', 'contact@lecamionquifume.fr', '$2a$10$T7f6gB9sLk3jD1pQ8xWv...', 1, '2025-02-10 14:20:00'),
(3, 'Burger Nomade', 'burger.nomade@foodtruck.fr', '$2a$10$K5l8mN2oP9qR7sT4uV6w...', 1, '2025-03-05 11:45:00'),
(4, 'Tacos El Paso', 'tacos@elpaso.fr', '$2a$10$A1b2C3d4E5f6G7h8I9j0...', 1, '2025-04-12 16:10:00'),
(5, 'Wok & Roll', 'wokandroll@foodtruck.fr', '$2a$10$Z9y8X7w6V5u4T3s2R1q0...', 1, '2025-05-20 09:15:00'),
(6, 'Jean Dupont', 'jean.dupont@example.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 2, '2025-11-07 10:00:00'),
(7, 'Marie Martin', 'marie.martin@example.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 2, '2025-11-07 11:00:00'),
(8, 'Pierre Durand', 'pierre.durand@example.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 2, '2025-11-07 12:00:00'),
(9, 'Sophie Leroy', 'sophie.leroy@example.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 2, '2025-11-07 13:00:00');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adresses_foodtruck`
--
ALTER TABLE `adresses_foodtruck`
  ADD CONSTRAINT `fk_adresse_foodtruck` FOREIGN KEY (`id_foodtruck`) REFERENCES `foodtrucks` (`id_foodtruck`);

--
-- Contraintes pour la table `avis`
--
ALTER TABLE `avis`
  ADD CONSTRAINT `fk_avis_client` FOREIGN KEY (`id_client`) REFERENCES `utilisateurs` (`id_utilisateur`),
  ADD CONSTRAINT `fk_avis_foodtruck` FOREIGN KEY (`id_foodtruck`) REFERENCES `foodtrucks` (`id_foodtruck`);

--
-- Contraintes pour la table `foodtrucks`
--
ALTER TABLE `foodtrucks`
  ADD CONSTRAINT `fk_foodtruck_utilisateur` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateurs` (`id_utilisateur`);

--
-- Contraintes pour la table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `fk_message_client` FOREIGN KEY (`id_client`) REFERENCES `utilisateurs` (`id_utilisateur`),
  ADD CONSTRAINT `fk_message_foodtruck` FOREIGN KEY (`id_foodtruck`) REFERENCES `foodtrucks` (`id_foodtruck`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
