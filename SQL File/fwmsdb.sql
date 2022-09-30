-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2022 at 08:13 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fwmsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE `tbladmin` (
  `ID` int(10) NOT NULL,
  `AdminName` varchar(120) DEFAULT NULL,
  `UserName` varchar(120) DEFAULT NULL,
  `MobileNumber` bigint(10) DEFAULT NULL,
  `Email` varchar(120) DEFAULT NULL,
  `Password` varchar(120) DEFAULT NULL,
  `AdminRegdate` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`ID`, `AdminName`, `UserName`, `MobileNumber`, `Email`, `Password`, `AdminRegdate`) VALUES
(1, 'Admin', 'admin', 8989898989, 'admin@gmail.com', 'f925916e2754e5e03f75dd58a5733251', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblcity`
--

CREATE TABLE `tblcity` (
  `ID` int(10) NOT NULL,
  `StateID` int(10) DEFAULT NULL,
  `City` varchar(120) DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblcity`
--

INSERT INTO `tblcity` (`ID`, `StateID`, `City`, `CreationDate`) VALUES
(3, 3, 'Allahabad', '2019-05-07 08:41:08'),
(4, 3, 'Aligarh', '2019-05-07 08:41:20'),
(5, 3, 'Lucknow', '2019-05-07 08:41:28'),
(6, 2, 'Jaipur', '2019-05-07 08:42:16'),
(7, 8, 'Gangtok', '2019-05-07 08:43:10'),
(8, 8, 'Peeling', '2019-05-07 08:43:25'),
(9, 8, 'Namchi', '2019-05-07 08:43:38'),
(10, 8, 'Ravangla', '2019-05-07 08:43:59'),
(11, 8, 'Mangan', '2019-05-07 08:44:16'),
(12, 2, 'Bhopal', '2019-05-07 08:44:45'),
(13, 2, 'Indore', '2019-05-07 08:44:57'),
(14, 2, 'Indore', '2019-05-07 08:45:10'),
(15, 11, 'Chennai', '2019-06-18 18:15:10'),
(16, 4, 'Visakhapatnam', '2021-11-29 05:11:26'),
(17, 3, 'Noida', '2022-01-22 10:09:48'),
(18, 12, 'Amritsar', '2022-01-23 06:32:58');

-- --------------------------------------------------------

--
-- Table structure for table `tblcontact`
--

CREATE TABLE `tblcontact` (
  `ID` int(10) NOT NULL,
  `FirstName` varchar(200) DEFAULT NULL,
  `LastName` varchar(200) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `Phone` bigint(10) DEFAULT NULL,
  `Message` mediumtext DEFAULT NULL,
  `EnquiryDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `IsRead` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblcontact`
--

INSERT INTO `tblcontact` (`ID`, `FirstName`, `LastName`, `Email`, `Phone`, `Message`, `EnquiryDate`, `IsRead`) VALUES
(1, 'Manu', 'Sharma', 'manu@gmail.com', 9879879879, 'Tell me fee of play school', '2021-11-01 04:53:55', 1),
(2, 'Anuj', 'Kumar', 'ak@gmail.com', 1234567890, 'test', '2021-11-09 17:42:29', 1),
(3, 'Devyansh', 'Rai', 'dev@gmail.com', 7977897978, 'yuiyuiyuiueyfiurbyv', '2021-12-08 12:02:22', NULL),
(4, 'Test', 'Tes', 'ddshg@gmail.com', 1234567789, 'dsafsd', '2022-01-23 06:34:03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbldonor`
--

CREATE TABLE `tbldonor` (
  `ID` int(10) NOT NULL,
  `FullName` varchar(200) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `MobileNumber` bigint(10) DEFAULT NULL,
  `Password` varchar(120) DEFAULT NULL,
  `RegDate` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldonor`
--

INSERT INTO `tbldonor` (`ID`, `FullName`, `Email`, `MobileNumber`, `Password`, `RegDate`) VALUES
(1, 'Rahul Singh', 'guru@gmail.com', 9898989898, '202cb962ac59075b964b07152d234b70', '2021-11-29 05:12:21'),
(2, 'Khusbu', 'hj@gmail.com', 8989898988, '202cb962ac59075b964b07152d234b70', '2021-11-29 05:12:21'),
(3, 'John Doe', 'johndoe@gmail.com', 1234567890, 'f925916e2754e5e03f75dd58a5733251', '2021-11-29 05:12:21'),
(4, 'Anuj Kumar', 'anuj@gmail.com', 4877799797, '202cb962ac59075b964b07152d234b70', '2021-11-29 05:12:21'),
(5, 'Rahul kumar Singh', 'rahul@gmail.com', 1236547899, 'f925916e2754e5e03f75dd58a5733251', '2022-01-23 06:25:11');

-- --------------------------------------------------------

--
-- Table structure for table `tblfood`
--

CREATE TABLE `tblfood` (
  `ID` int(10) NOT NULL,
  `DonorID` int(10) DEFAULT NULL,
  `foodId` int(10) DEFAULT NULL,
  `FoodItems` mediumtext DEFAULT NULL,
  `StateName` varchar(200) DEFAULT NULL,
  `CityName` varchar(200) DEFAULT NULL,
  `Description` mediumtext DEFAULT NULL,
  `PickupDate` varchar(200) DEFAULT NULL,
  `PickupAddress` mediumtext DEFAULT NULL,
  `ContactPerson` varchar(200) DEFAULT NULL,
  `CPMobNumber` bigint(10) DEFAULT NULL,
  `Image` varchar(200) DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT current_timestamp(),
  `UpdationDate` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblfood`
--

INSERT INTO `tblfood` (`ID`, `DonorID`, `foodId`, `FoodItems`, `StateName`, `CityName`, `Description`, `PickupDate`, `PickupAddress`, `ContactPerson`, `CPMobNumber`, `Image`, `CreationDate`, `UpdationDate`) VALUES
(2, 4, 330170905, 'Dal,Rice,Roti,Panner', 'Utter Pradesh', 'Allahabad', 'Good Quality Food', '2022-01-23', 'H 23423 Sector 10', 'John', 1478523699, '008f6072e5da05cd7c7bd61a8fd72925.jpg', '2022-01-22 09:24:51', '2022-01-22 09:45:47'),
(3, 3, 372165116, 'Dal Maknhi,Bread,Rice', 'Andra Pradesh', 'Visakhapatnam', 'Nice Quality Food', '2022-01-23', 'J 466 ABC Street', 'Rahul Singh', 9874563210, 'd35fc3840fe988a4d42f5371b1071f8c.jpg', '2022-01-22 10:20:35', NULL),
(4, 5, 244559044, 'Dal,Rice,Mix Veg,Panner', 'Uttar Pradesh', 'Aligarh', 'Nice Quality Food', '2022-01-24', 'A 347583 XYZ Street', 'Amit Kumar', 9852364710, 'd617a5da2739292d34bf867d219b945b.jpg', '2022-01-23 06:26:22', '2022-01-23 06:26:47');

-- --------------------------------------------------------

--
-- Table structure for table `tblfoodrequests`
--

CREATE TABLE `tblfoodrequests` (
  `id` int(11) NOT NULL,
  `requestNumber` bigint(12) DEFAULT NULL,
  `foodId` int(1) DEFAULT NULL,
  `fullName` varchar(150) DEFAULT NULL,
  `mobileNumber` bigint(12) DEFAULT NULL,
  `message` mediumtext DEFAULT NULL,
  `requestDate` timestamp NULL DEFAULT current_timestamp(),
  `status` varchar(120) DEFAULT NULL,
  `donorRemark` mediumtext DEFAULT NULL,
  `requestCompletionDate` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblfoodrequests`
--

INSERT INTO `tblfoodrequests` (`id`, `requestNumber`, `foodId`, `fullName`, `mobileNumber`, `message`, `requestDate`, `status`, `donorRemark`, `requestCompletionDate`) VALUES
(1, 223505689, 2, 'Sanjeev', 8521479630, 'NA', '2022-01-22 10:44:28', NULL, NULL, NULL),
(2, 692624619, 3, 'Amit Kumar', 1122334455, 'Need the food for poor peoples', '2022-01-22 10:46:41', 'Food Take Away/ Request Completed', 'Food Picked up.', '2022-01-22 11:29:47'),
(3, 293916769, 4, 'Garima Singh', 7891232014, 'I need this for poor people', '2022-01-23 06:30:23', 'Food Take Away/ Request Completed', 'You can pickup the food', '2022-01-23 06:30:54');

-- --------------------------------------------------------

--
-- Table structure for table `tblpages`
--

CREATE TABLE `tblpages` (
  `ID` int(11) NOT NULL,
  `PageType` varchar(200) DEFAULT NULL,
  `PageTitle` mediumtext DEFAULT NULL,
  `PageDescription` mediumtext DEFAULT NULL,
  `UpdationDate` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblpages`
--

INSERT INTO `tblpages` (`ID`, `PageType`, `PageTitle`, `PageDescription`, `UpdationDate`) VALUES
(1, 'aboutus', 'About Us', '                                <div style=\"text-align: center;\"><b><font size=\"6\">Welcome to Food Waste Management System</font></b></div><div style=\"text-align: left;\"><br></div><div style=\"text-align: left;\"><p class=\"bodytext\" style=\"margin-bottom: 10px; color: rgb(33, 37, 41); line-height: 1.5; font-family: \" open=\"\" sans\",=\"\" sans-serif;=\"\" font-size:=\"\" 14px;\"=\"\"><span style=\"font-weight: 700;\">Food waste&nbsp;</span>refers to the decrease in the quantity or quality of food resulting from decisions and actions by retailers, food service providers and consumers. &nbsp;Food is wasted in many ways:</p><ul style=\"margin-bottom: 10px; padding-left: 1.5em; color: rgb(33, 37, 41); font-family: \" open=\"\" sans\",=\"\" sans-serif;=\"\" font-size:=\"\" 14px;\"=\"\"><li style=\"margin-bottom: 6px; position: relative; padding-right: 15px; line-height: 1.5;\">Fresh produce that deviates from what is considered optimal, for example in terms of shape, size and color, is often removed from the supply chain during sorting operations.</li><li style=\"margin-bottom: 6px; position: relative; padding-right: 15px; line-height: 1.5;\">Foods that are close to, at or beyond the â€œbest-beforeâ€ date are often discarded by retailers and consumers.</li><li style=\"margin-bottom: 6px; position: relative; padding-right: 15px; line-height: 1.5;\">Large quantities of wholesome edible food are often unused or left over and discarded from household kitchens and eating establishments.</li></ul><p class=\"bodytext\" style=\"margin-bottom: 10px; color: rgb(33, 37, 41); line-height: 1.5; font-family: \" open=\"\" sans\",=\"\" sans-serif;=\"\" font-size:=\"\" 14px;\"=\"\">Less food loss and waste would lead to more efficient land use and better water resource management with positive impacts on climate change and livelihoods.</p></div>', '2021-12-09 11:36:01'),
(2, 'contactus', 'Contact Us', '<b>Food Waste Management System</b><div><b>Contact Number:</b>+91-96784532145</div><div><b>email: </b>info@gmail.com</div><div><b>Address : </b>XYZ street ABC</div>', '2022-01-23 06:34:52');

-- --------------------------------------------------------

--
-- Table structure for table `tblstate`
--

CREATE TABLE `tblstate` (
  `ID` int(10) NOT NULL,
  `StateName` varchar(120) DEFAULT NULL,
  `RegState` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblstate`
--

INSERT INTO `tblstate` (`ID`, `StateName`, `RegState`) VALUES
(3, 'Uttar Pradesh', '2019-05-07 07:07:21'),
(4, 'Andra Pradesh', '2019-05-07 07:07:31'),
(5, 'Delhi/NCR', '2019-05-07 07:07:39'),
(6, 'Kerala', '2019-05-07 07:07:58'),
(7, 'Arunachal Pradesh', '2019-05-07 07:08:12'),
(8, 'Sikkim', '2019-05-07 07:08:37'),
(9, 'Maharastra', '2019-05-07 07:08:49'),
(10, 'Gujrat', '2019-05-07 07:09:16'),
(11, 'Tamilnadu', '2019-06-18 18:14:43'),
(12, 'Punjab', '2022-01-23 06:32:34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblcity`
--
ALTER TABLE `tblcity`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblcontact`
--
ALTER TABLE `tblcontact`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbldonor`
--
ALTER TABLE `tbldonor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblfood`
--
ALTER TABLE `tblfood`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblfoodrequests`
--
ALTER TABLE `tblfoodrequests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tblpages`
--
ALTER TABLE `tblpages`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblstate`
--
ALTER TABLE `tblstate`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tblcity`
--
ALTER TABLE `tblcity`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tblcontact`
--
ALTER TABLE `tblcontact`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbldonor`
--
ALTER TABLE `tbldonor`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tblfood`
--
ALTER TABLE `tblfood`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tblfoodrequests`
--
ALTER TABLE `tblfoodrequests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tblpages`
--
ALTER TABLE `tblpages`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tblstate`
--
ALTER TABLE `tblstate`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
