
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `teamdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `CATEGORY`
--

CREATE TABLE `CATEGORY` (
  `PK_CAT_ID` int(11) NOT NULL,
  `CAT_NAME` varchar(30) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `CATEGORY`
--

INSERT INTO `CATEGORY` (`PK_CAT_ID`, `CAT_NAME`) VALUES
(1, 'Football'),
(2, 'Basketball');

-- --------------------------------------------------------

--
-- Table structure for table `TEAM`
--

CREATE TABLE `TEAM` (
  `PK_TEAM_ID` int(11) NOT NULL,
  `NAME` varchar(30) COLLATE utf8_turkish_ci DEFAULT NULL,
  `CITY` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `RANKING` int(11) DEFAULT NULL,
  `FK_CATEGORY_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `TEAM`
--

INSERT INTO `TEAM` (`PK_TEAM_ID`, `NAME`, `CITY`, `RANKING`, `FK_CATEGORY_ID`) VALUES
(1, 'Galatasaray', 'Istanbul', 92, 1),
(2, 'Fenerbahçe', 'Istanbul', 90, 1),
(3, 'Beşiktaş', 'Istanbul', 88, 1),
(4, 'Trabzonspor', 'Trabzon', 85, 1),
(5, 'Houston Rockets', 'Houston', 92, 2),
(6, 'Golden State Warriors', 'San Francisco', 96, 2),
(7, 'Cleveland Cavaliers', 'Cleveland', 94, 2),
(8, 'Boston Celtics', 'Boston', 94, 2),
(9, 'Chelsea', 'London', 94, 1),
(10, 'Liverpool', 'Liverpool', 96, 1),
(11, 'Real Madrid', 'Madrid', 99, 1);

-- --------------------------------------------------------

--
-- Table structure for table `USER`
--

CREATE TABLE `USER` (
  `PK_USER_ID` int(11) NOT NULL,
  `NAME` varchar(30) COLLATE utf8_turkish_ci DEFAULT NULL,
  `SURNAME` varchar(30) COLLATE utf8_turkish_ci DEFAULT NULL,
  `CITY` varchar(30) COLLATE utf8_turkish_ci DEFAULT NULL,
  `GENDER` varchar(10) COLLATE utf8_turkish_ci DEFAULT NULL,
  `FK_TEAM_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`PK_USER_ID`, `NAME`, `SURNAME`, `CITY`, `GENDER`, `FK_TEAM_ID`) VALUES
(16, 'Can', 'Yuva', 'Ankara', 'Male', 1),
(17, 'Ahmet', 'Y?lmaz', 'Londra', 'Male', 10),
(18, 'Jennifer', 'Lopez', 'Barcelona', 'Female', 4),
(19, 'Bart', 'Simpson', 'Los Angeles', 'Male', 1),
(20, 'Willy', 'Wonka', 'Machester', 'Male', 7),
(21, 'Angelina', 'Jolie', 'New York', 'Female', 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CATEGORY`
--
ALTER TABLE `CATEGORY`
  ADD PRIMARY KEY (`PK_CAT_ID`);

--
-- Indexes for table `TEAM`
--
ALTER TABLE `TEAM`
  ADD PRIMARY KEY (`PK_TEAM_ID`),
  ADD KEY `category_id` (`FK_CATEGORY_ID`);

--
-- Indexes for table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`PK_USER_ID`),
  ADD KEY `team_id` (`FK_TEAM_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CATEGORY`
--
ALTER TABLE `CATEGORY`
  MODIFY `PK_CAT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `TEAM`
--
ALTER TABLE `TEAM`
  MODIFY `PK_TEAM_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `USER`
--
ALTER TABLE `USER`
  MODIFY `PK_USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `TEAM`
--
ALTER TABLE `TEAM`
  ADD CONSTRAINT `TEAM_ibfk_1` FOREIGN KEY (`FK_CATEGORY_ID`) REFERENCES `CATEGORY` (`PK_CAT_ID`);

--
-- Constraints for table `USER`
--
ALTER TABLE `USER`
  ADD CONSTRAINT `USER_ibfk_1` FOREIGN KEY (`FK_TEAM_ID`) REFERENCES `TEAM` (`PK_TEAM_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
