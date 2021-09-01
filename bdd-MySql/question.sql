-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 01 Septembre 2021 à 19:05
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `question`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `id_etudiant` char(7) NOT NULL,
  `id_groupe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `affectation`
--

INSERT INTO `affectation` (`id_etudiant`, `id_groupe`) VALUES
('3333333', 'G1201'),
('3333333', 'G1530'),
('3333333', 'ggg'),
('3481000', 'G1201'),
('3863871', 'G1201'),
('3863871', 'G1530'),
('8540820', 'g123');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `id_enseignant` char(7) NOT NULL,
  `salaire` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `enseignant`
--

INSERT INTO `enseignant` (`id_enseignant`, `salaire`) VALUES
('1573975', NULL),
('8453139', NULL),
('912174', NULL),
('9373794', NULL),
('1111111', 70000),
('2222222', 71000);

-- --------------------------------------------------------

--
-- Structure de la table `erreur_image`
--

CREATE TABLE `erreur_image` (
  `id_question` char(11) NOT NULL,
  `url_image` varchar(100) NOT NULL,
  `num_ligne` int(11) NOT NULL,
  `erreur` varchar(30) NOT NULL,
  `correction` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `erreur_image`
--

INSERT INTO `erreur_image` (`id_question`, `url_image`, `num_ligne`, `erreur`, `correction`) VALUES
('18', '/ImageErreurs/question18.png', 5, 'throw', 'throws'),
('19', '/ImageErreurs/question19.png', 8, 'throws', 'throw'),
('20', '/ImageErreurs/question20.png', 5, 'arg', 'args'),
('21', '/ImageErreurs/question21.png', 1, 'int', 'double'),
('22', '/ImageErreurs/question22.png', 2, '==', '='),
('23', '/ImageErreurs/question23.png', 1, 'extends', 'implements'),
('24', '/ImageErreurs/question24.png', 4, 'abstract', 'static'),
('29', '/ImageErreurs/question29.png', 1, 'rrr', 'ccc'),
('6', '/ImageErreurs/question6.png', 6, 'return', 'return'),
('9', '/ImageErreurs/question9.png', 1, 'extend', 'extends');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id_etudiant` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`) VALUES
('3333333'),
('3481000'),
('3863871'),
('5250861'),
('6755045'),
('8540820'),
('9198262');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `id_groupe` varchar(10) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `id_enseignant` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`id_groupe`, `titre`, `id_enseignant`) VALUES
('dfgdfg', 'nouveau gr', '1111111'),
('G1201', 'Analyste programmeur', '1111111'),
('g123', 'nouveau titre3', '1111111'),
('G1530', 'Testeur des logiciels', '1111111'),
('ggg', 'groupe test', '1111111');

-- --------------------------------------------------------

--
-- Structure de la table `invitation`
--

CREATE TABLE `invitation` (
  `id_enseignant` char(7) NOT NULL,
  `id_etudiant` char(7) NOT NULL,
  `id_groupe` varchar(10) NOT NULL,
  `date` char(10) NOT NULL,
  `heure` char(5) NOT NULL,
  `commentaire` varchar(250) DEFAULT NULL,
  `statut` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `invitation`
--

INSERT INTO `invitation` (`id_enseignant`, `id_etudiant`, `id_groupe`, `date`, `heure`, `commentaire`, `statut`) VALUES
('1111111', '3333333', 'G1201', '07-04-2021', '16:42', 'Vous avez recu une invitation de la part de : Flouflou Alain ,pour joindre le groupe Analyste programmeur (ID: G1201)', 'true'),
('1111111', '3333333', 'g123', '26-08-2021', '17:35', 'Vous avez recu une invitation de la part de : Flouflou Alain ,pour joindre le groupe nouveau titre3 (ID: g123)', NULL),
('1111111', '3333333', 'G1530', '07-04-2021', '16:42', 'Vous avez recu une invitation de la part de : Flouflou Alain ,pour joindre le groupe Testeur des logiciels (ID: G1530)', 'true'),
('1111111', '3333333', 'ggg', '29/04/21', '15:17', 'Vous avez recu une invitation de la part de : 1111111 ,pour joindre le groupe  (ID: ggg)', 'true'),
('1111111', '3481000', 'G1201', '18-04-2021', '09:39', 'Vous avez recu une invitation de la part de : Flouflou Alain ,pour joindre le groupe Analyste programmeur (ID: G1201)', 'true'),
('1111111', '3481000', 'ggg', '23/04/21', '19:28', 'Vous avez recu une invitation de la part de : 1111111 ,pour joindre le groupe  (ID: ggg)', NULL),
('1111111', '3863871', 'g123', '23/04/21', '17:32', 'Vous avez recu une invitation de la part de : 1111111 ,pour joindre le groupe  (ID: g123)', NULL),
('1111111', '5250861', 'G1201', '25/04/21', '19:13', 'Vous avez recu une invitation de la part de : 1111111 ,pour joindre le groupe  (ID: G1201)', NULL),
('1111111', '5250861', 'ggg', '09/05/21', '15:11', 'Vous avez recu une invitation de la part de : 1111111 ,pour joindre le groupe  (ID: ggg)', NULL),
('1111111', '8540820', 'g123', '07-04-2021', '22:10', 'Vous avez recu une invitation de la part de : Flouflou Alain ,pour joindre le groupe Un test n#1 (ID: g123)', 'true');

-- --------------------------------------------------------

--
-- Structure de la table `liste_choix`
--

CREATE TABLE `liste_choix` (
  `id_question` char(11) NOT NULL,
  `choix` varchar(200) NOT NULL,
  `statut_choix` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `liste_choix`
--

INSERT INTO `liste_choix` (`id_question`, `choix`, `statut_choix`) VALUES
('1', 'Dans la plupart des cas, on peut récupérer d’une erreur alors qu’une exception est une condition irrécupérable', 'false'),
('1', 'Dans la plupart des cas, on peut récupérer d’une exception alors qu’une erreur est une condition irrécupérable', 'true'),
('1', 'Une erreur et une exception héritent de Error et donc ne sont pas différentes', 'false'),
('1', 'Une erreur et une exception héritent de Exception et donc ne sont pas différentes', 'false'),
('10', 'Non, on ne doit pas gérer ce genre d’Exception', 'false'),
('10', 'Oui, il faut qu’on la gère dans notre code', 'true'),
('10', 'Pas vraiment, on peut choisir de ne pas la gérer', 'false'),
('10', 'Toutes les réponses ci-dessus sont correctes.', 'false'),
('11', 'Faux', 'true'),
('11', 'Vrai', 'false'),
('12', 'Les deux sont utilisées dans le corps de la méthode dans le cas où plusieurs exceptions risquent d’être levées', 'false'),
('12', 'throw est utilisé dans le corps de la méthode pour lever une exception alors que throws est utilisé dans l’entête de la méthode pour indiquer que la méthode peut jeter cette exception', 'true'),
('12', 'throws est utilisé dans le corps de la méthode pour lever une exception alors que throw est utilisé dans l’entête de la méthode pour indiquer que la méthode peut jeter cette exception', 'false'),
('12', 'Toutes les réponses ci-dessus sont correctes', 'false'),
('13', 'Faux', 'true'),
('13', 'Vrai', 'false'),
('13', 'Vrai si la classe n’a pas hérité d’une autre classe', 'false'),
('14', 'Faux', 'true'),
('14', 'Seul le constructeur par défaut du parent peut être hérité', 'false'),
('14', 'Vrai', 'false'),
('15', 'Il n’y a aucun interet d’utiliser le BufferedReader', 'false'),
('15', 'Non, le FileReader ne peut pas être utilisé avec le BufferedReader', 'false'),
('15', 'Oui, parcequ’on va bénéficier des méthodes spécifique de BufferedReader( lecture par ligne par exemple)', 'true'),
('16', 'Faux', 'false'),
('16', 'Vrai', 'true'),
('17', 'base.nomMethode()', 'false'),
('17', 'override.nomMethode()', 'false'),
('17', 'super.nomMethode()', 'true'),
('17', 'virtual.nomMethode()', 'false'),
('2', 'On ne peut rien faire car Java ne permet pas l’héritage multiple', 'true'),
('2', 'On peut ajouter la sous-classe Exception en séparant la classe mère héritée par une virgule', 'false'),
('2', 'Toutes les réponses ci-dessus', 'false'),
('28', '14', 'false'),
('28', '15', 'true'),
('28', '16', 'false'),
('28', '17', 'false'),
('3', 'contient 5 régions de placement', 'true'),
('3', 'est le gestionnaire par défaut d’un JFrame', 'true'),
('3', 'place les composants selon un flot de gauche à droite sur le JPanel', 'false'),
('3', 'Toutes les réponses ci-dessus sont correctes', 'false'),
('4', 'Créant la classe qui hérite de Error', 'false'),
('4', 'Créant la classe qui hérite de la classe Exception', 'true'),
('4', 'Créant la classe qui hérite d’une sous-classe de Exception', 'true'),
('4', 'Toutes les réponses ci-dessus', 'false'),
('5', 'qui est le gestionnaire par défaut d’un JFrame', 'false'),
('5', 'qui peut avoir une des régions basées sur un GridLayout', 'false'),
('5', 'qui peut être une des régions d’un BorderLayout', 'true'),
('5', 'Toutes les réponses ci-dessus sont correctes', 'false');

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `id_matiere` char(10) NOT NULL,
  `titre` varchar(25) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `matiere`
--

INSERT INTO `matiere` (`id_matiere`, `titre`, `description`) VALUES
('420-A07-BB', 'Java SE', 'PROGRAMMATION PAR COMPOSANTS I'),
('420-A10-BB', 'JAVA JDBC', 'PROGRAMMATION-OBJET ET BASES DE DONNEES'),
('420-A11-BB', 'JAVA EE', 'PROGRAMMATION D\'APPLICATIONS WEB'),
('420-A12-BB', 'C#', 'PROGRAMMATION PAR COMPOSANTS II');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_personne` char(7) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `courriel` varchar(50) NOT NULL,
  `motPasse` varchar(15) NOT NULL,
  `etat` varchar(5) NOT NULL DEFAULT 'true',
  `TYPEPERS` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom`, `prenom`, `courriel`, `motPasse`, `etat`, `TYPEPERS`) VALUES
('1111111', 'Alain', 'Flouflou', 'hfghfgh@yahoo.com', '11111111', 'true', NULL),
('1573975', 'Alain', 'Flou', 'alain@exemple.com', '12345678', 'true', NULL),
('2222222', 'Flou', 'Alain', 'flou@exemple.com', '22222222', 'true', NULL),
('3333333', 'Flou', 'Clair', 'etud1@exemple.com', '33333333', 'true', NULL),
('3481000', 'Imed', 'Imad', 'dfgdfgdfg@yahoo.com', 'llllllll', 'true', NULL),
('3863871', 'Alain', 'Flou', 'alain@exemple.com', '12345678', 'true', NULL),
('5250861', 'Zitouni', 'Amir', 'hfghfgh@yahoo.com', 'bananehuit', 'true', NULL),
('6755045', 'Amir', 'Flou', 'Amir@exemple.com', '123456789', 'true', NULL),
('8453139', 'Alain', 'Flou', 'alain@exemple.com', '12345678', 'true', NULL),
('8540820', 'Ferfar', 'Imed', 'alain@exemple.com', '00000000', 'true', NULL),
('912174', 'Alain', 'Flou', 'alain@exemple.com', '12345678', 'true', NULL),
('9198262', 'FERFAR', 'Imad', 'dfgdfgdfg@sdfsdf.com', '00000000', 'true', NULL),
('9373794', 'Alain', 'Imed', 'imed@exemple.com', '123456789', 'true', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `programmeur`
--

CREATE TABLE `programmeur` (
  `courriel` varchar(50) NOT NULL DEFAULT '',
  `nom` varchar(50) DEFAULT NULL,
  `langages` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `programmeur`
--

INSERT INTO `programmeur` (`courriel`, `nom`, `langages`) VALUES
('bbrowett0@hexun.com', 'Byrle Browett', 'javascript,java,python'),
('dallix1@g.co', 'Dilan Allix', 'c++,c,java,c#'),
('dsomerled2@va.gov', 'Dal Somerled', 'swift,c#'),
('tgorcke3@simplemachines.org', 'Toiboid Gorcke', 'sql,perl,c++'),
('cvowdon4@sina.com.cn', 'Christye Vowdon', 'c++,vb.net,vb6'),
('apitrasso5@infoseek.co.jp', 'Arleyne Pitrasso', 'python,php,perl'),
('lblacksell6@creativecommons.org', 'Lonni Blacksell', 'c++,java'),
('emarc7@cam.ac.uk', 'Ethelyn Marc', 'c,javascript,typescript'),
('amacauley8@people.com.cn', 'Agna Macauley', 'typescript,c#'),
('mabys9@ucoz.ru', 'Maire Abys', 'objective-c'),
('galpsa@smh.com.au', 'Gwenny Alps', 'pl-sql,c#,sql'),
('gmockesrq@hibu.com', 'Glynnis Mockes', 'python,swift'),
('houda@gmail.com', 'Jemili Houda', 'c++,python,html,javascript,java,c#,php'),
('anas@gmail.com', 'Anas Rahim', 'java,c++,c#,javascript,typescript,sql');

-- --------------------------------------------------------

--
-- Structure de la table `qcm`
--

CREATE TABLE `qcm` (
  `id_question` char(11) NOT NULL,
  `la_question` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `qcm`
--

INSERT INTO `qcm` (`id_question`, `la_question`) VALUES
('1', 'Quelle est la différence entre une erreur et une exception ?'),
('10', 'Une exception contrôlée doit être prise en charge dans votre application'),
('11', 'Une interface peut disposer d’un nombre limité d’attributs'),
('12', 'La différence entre throws et throw dans la gestion des exceptions est :'),
('13', 'Une classe abstract peut hériter d’une interface'),
('14', 'Une classe enfant hérite du constructeur de son parent'),
('15', 'Dans une utilisation de lecture de fichier, il est important d’utiliser BufferedReader avec FileReader'),
('16', 'Une classe Java peut hériter de plusieurs classes'),
('17', 'Pour appeler la méthode nomMethode() d’une classe parent à partir de la classe enfant, on utilise le mot clé :'),
('2', 'Si une classe hérite déjà d’une classe et je veux qu’une instance de cette classe soit jetée (thrown) comme un objet exception, que doit-on faire ?'),
('28', '1 + 5 +9 ='),
('3', 'Le BorderLayout est un gestionnaire de placement qui :'),
('4', 'On peut créer une exception personnalisée en :'),
('5', 'Le FlowLayout est un gestionnaire de placement :');

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `id_question` char(11) NOT NULL,
  `titre` varchar(70) NOT NULL,
  `ponderation` varchar(1) NOT NULL,
  `partage` char(5) NOT NULL,
  `id_enseignant` char(7) NOT NULL,
  `id_matiere` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`id_question`, `titre`, `ponderation`, `partage`, `id_enseignant`, `id_matiere`) VALUES
('1', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('10', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('11', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('12', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('13', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('14', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('15', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('16', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('17', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('18', 'Trouver l\'erreur dans ce code', '2', 'true', '1111111', '420-A07-BB'),
('19', 'Trouver l\'erreur dans ce code', '2', 'true', '1111111', '420-A07-BB'),
('2', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('20', 'Trouver l\'erreur dans ce code', '2', 'true', '1111111', '420-A07-BB'),
('21', 'Trouver l\'erreur dans ce code', '2', 'true', '1111111', '420-A07-BB'),
('22', 'Trouver l\'erreur dans ce code', '2', 'true', '1111111', '420-A07-BB'),
('23', 'Trouver l\'erreur dans ce code', '3', 'true', '1111111', '420-A07-BB'),
('24', 'Trouver l\'erreur dans ce code', '3', 'true', '1111111', '420-A07-BB'),
('25', 'Trouver le resultat d\'execution de ce code', '1', 'true', '1111111', '420-A07-BB'),
('26', 'Trouver le resultat d\'execution de ce code', '1', 'true', '1111111', '420-A07-BB'),
('27', 'Trouver le resultat d\'execution de ce code', '1', 'true', '1111111', '420-A07-BB'),
('28', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('29', 'Trouver l\'erreur dans ce code', '1', 'true', '1111111', '420-A07-BB'),
('3', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('4', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('5', 'Choisir la ou les bonnes réponses', '1', 'true', '1111111', '420-A07-BB'),
('6', 'Trouver l\'erreur dans ce code', '2', 'true', '2222222', '420-A07-BB'),
('7', 'Trouver le resultat d\'execution de ce code', '1', 'true', '1111111', '420-A07-BB'),
('9', 'Trouver l\'erreur dans ce code', '1', 'true', '1111111', '420-A07-BB');

-- --------------------------------------------------------

--
-- Structure de la table `resultat`
--

CREATE TABLE `resultat` (
  `id_resultat` char(17) NOT NULL,
  `nbr_questions` int(11) NOT NULL,
  `nbr_bonnes_rep` int(11) NOT NULL,
  `note` double NOT NULL,
  `date` char(8) NOT NULL,
  `heure` char(5) NOT NULL,
  `id_etudiant` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `resultat_execution`
--

CREATE TABLE `resultat_execution` (
  `id_question` char(11) NOT NULL,
  `le_code` varchar(300) NOT NULL,
  `reponse` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `resultat_execution`
--

INSERT INTO `resultat_execution` (`id_question`, `le_code`, `reponse`) VALUES
('25', 'String message = "bonjour";\nSystem.out.println(message.toUpperCase());', 'bonjour'),
('26', 'int val = (int) (Math.random() * (2));\nSystem.out.println("val");', 'val'),
('27', 'int val = 10 / 3 ;\nSystem.out.println(val);', '3'),
('7', 'String message = "bonjour";\nSystem.out.println(message.toUpperCase());', 'BONJOUR');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`id_etudiant`,`id_groupe`),
  ADD KEY `id_etudiant` (`id_etudiant`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id_enseignant`),
  ADD KEY `index_salaire` (`salaire`);

--
-- Index pour la table `erreur_image`
--
ALTER TABLE `erreur_image`
  ADD PRIMARY KEY (`id_question`),
  ADD UNIQUE KEY `url_image` (`url_image`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_etudiant`),
  ADD UNIQUE KEY `index_id_groupe` (`id_etudiant`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`id_groupe`),
  ADD KEY `id_enseignant` (`id_enseignant`);

--
-- Index pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD PRIMARY KEY (`id_etudiant`,`id_groupe`),
  ADD KEY `id_groupe` (`id_groupe`),
  ADD KEY `id_groupe_2` (`id_groupe`),
  ADD KEY `id_etudiant` (`id_etudiant`),
  ADD KEY `id_etudiant_2` (`id_etudiant`),
  ADD KEY `id_enseignant` (`id_enseignant`);

--
-- Index pour la table `liste_choix`
--
ALTER TABLE `liste_choix`
  ADD PRIMARY KEY (`id_question`,`choix`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id_matiere`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- Index pour la table `programmeur`
--
ALTER TABLE `programmeur`
  ADD PRIMARY KEY (`courriel`);

--
-- Index pour la table `qcm`
--
ALTER TABLE `qcm`
  ADD PRIMARY KEY (`id_question`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_question`),
  ADD KEY `index_id_enseignant` (`id_enseignant`),
  ADD KEY `id_matiere` (`id_matiere`);

--
-- Index pour la table `resultat`
--
ALTER TABLE `resultat`
  ADD PRIMARY KEY (`id_resultat`),
  ADD KEY `id_etudiant` (`id_etudiant`);

--
-- Index pour la table `resultat_execution`
--
ALTER TABLE `resultat_execution`
  ADD PRIMARY KEY (`id_question`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD CONSTRAINT `aff_etud_id_etud_fk` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`),
  ADD CONSTRAINT `aff_groupe_id_etud_fk` FOREIGN KEY (`id_groupe`) REFERENCES `groupe` (`id_groupe`);

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `ense_pers_id_ense_fk` FOREIGN KEY (`id_enseignant`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `erreur_image`
--
ALTER TABLE `erreur_image`
  ADD CONSTRAINT `img_ques_id_ques_fk` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etud_pers_id_ense_fk` FOREIGN KEY (`id_etudiant`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `grou_ense_id_ense_fk` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`);

--
-- Contraintes pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD CONSTRAINT `invi_ensei_id_ensei_fk` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`),
  ADD CONSTRAINT `invi_etud_id_etud_fk` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`),
  ADD CONSTRAINT `invi_grou_id_grou_fk` FOREIGN KEY (`id_groupe`) REFERENCES `groupe` (`id_groupe`);

--
-- Contraintes pour la table `liste_choix`
--
ALTER TABLE `liste_choix`
  ADD CONSTRAINT `choix_qcm_id_ques_fk` FOREIGN KEY (`id_question`) REFERENCES `qcm` (`id_question`);

--
-- Contraintes pour la table `qcm`
--
ALTER TABLE `qcm`
  ADD CONSTRAINT `qcm_ques_id_ques_fk` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `ques_ensei_id_ensei_fk` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`),
  ADD CONSTRAINT `ques_mati_id_mati_fk` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id_matiere`);

--
-- Contraintes pour la table `resultat`
--
ALTER TABLE `resultat`
  ADD CONSTRAINT `resu_etud_id_etu_fk` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`);

--
-- Contraintes pour la table `resultat_execution`
--
ALTER TABLE `resultat_execution`
  ADD CONSTRAINT `exec_quest_id_quest_fk` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
