-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2025 at 01:59 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vrs_gamf`
--
CREATE DATABASE IF NOT EXISTS `vrs_gamf` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vrs_gamf`;

-- --------------------------------------------------------

--
-- Table structure for table `applied_parts`
--

CREATE TABLE `applied_parts` (
  `id` int(11) NOT NULL,
  `repair_order_id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `price` float(10,2) NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `appointment_requests`
--

CREATE TABLE `appointment_requests` (
  `id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `problem_description` varchar(255) NOT NULL,
  `recommended_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `street_number` varchar(100) DEFAULT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoices`
--

CREATE TABLE `invoices` (
  `id` int(11) NOT NULL,
  `repair_order_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `total_price` float(10,2) NOT NULL,
  `paid_by` varchar(200) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `m_parts`
--

CREATE TABLE `m_parts` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `base_price` float(10,2) DEFAULT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `m_parts`
--

INSERT INTO `m_parts` (`id`, `name`, `description`, `base_price`, `create_by`, `created_date`, `modified_by`, `modified_date`) VALUES
(7, 'Motor', '', 150000.00, 'balogh.norbert', '2025-04-15', NULL, NULL),
(8, 'Fagyálló', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(9, 'Olaj', '', 10000.00, 'balogh.norbert', '2025-04-15', NULL, NULL),
(10, 'Fékbetét', '', 50000.00, 'balogh.norbert', '2025-04-15', NULL, NULL),
(11, 'Gumi', '', 10000.00, 'balogh.norbert', '2025-04-15', NULL, NULL),
(12, 'Csavarok', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `m_services`
--

CREATE TABLE `m_services` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `base_price` float(10,2) DEFAULT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `m_services`
--

INSERT INTO `m_services` (`id`, `name`, `description`, `base_price`, `create_by`, `created_date`, `modified_by`, `modified_date`) VALUES
(1, 'teljes takarítás', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(2, 'Külső takarítás', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(3, 'belső takarítás', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(4, 'Kerékcsere', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(5, 'Olajcsere', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(6, 'fútómű beállítás', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(7, 'feényezés', '', 200000.00, 'balogh.norbert', '2025-04-15', NULL, NULL),
(8, 'Teljes átvizsgálás', '', 40000.00, 'balogh.norbert', '2025-04-15', NULL, NULL),
(9, 'Fékbetét csere', '', NULL, 'balogh.norbert', '2025-04-15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `provided_services`
--

CREATE TABLE `provided_services` (
  `id` int(11) NOT NULL,
  `repair_order_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `price` float(10,2) NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `repair_orders`
--

CREATE TABLE `repair_orders` (
  `id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `appointment_request_id` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `repair_description` varchar(500) NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `username` varchar(50) NOT NULL,
  `user_type_id` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `hashed_password` varchar(200) DEFAULT NULL,
  `salt` varchar(200) DEFAULT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `user_type_id`, `email`, `hashed_password`, `salt`, `create_by`, `created_date`, `modified_by`, `modified_date`) VALUES
(1, 'test admin', 'test_admin', 1, 'test@admin.com', NULL, NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(2, 'emp1', 'test_emp1', 2, 'emp1@admin.com', NULL, NULL, 'balogh.norbert', '2025-04-15', NULL, NULL),
(3, 'emp2', 'test_emp2', 2, 'emp2@admin.com', NULL, NULL, 'balogh.norbert', '2025-04-15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_types`
--

CREATE TABLE `user_types` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_types`
--

INSERT INTO `user_types` (`id`, `name`) VALUES
(1, 'ADMIN'),
(2, 'EMPLOYEE');

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `plate_number` varchar(10) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `vin_number` varchar(50) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `created_date` date DEFAULT curdate(),
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applied_parts`
--
ALTER TABLE `applied_parts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `repair_order_id` (`repair_order_id`),
  ADD KEY `part_id` (`part_id`);

--
-- Indexes for table `appointment_requests`
--
ALTER TABLE `appointment_requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicle_id` (`vehicle_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`id`),
  ADD KEY `repair_order_id` (`repair_order_id`);

--
-- Indexes for table `m_parts`
--
ALTER TABLE `m_parts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `m_services`
--
ALTER TABLE `m_services`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `provided_services`
--
ALTER TABLE `provided_services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `repair_order_id` (`repair_order_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `repair_orders`
--
ALTER TABLE `repair_orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicle_id` (`vehicle_id`),
  ADD KEY `appointment_request_id` (`appointment_request_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `user_type_id` (`user_type_id`);

--
-- Indexes for table `user_types`
--
ALTER TABLE `user_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plate_number` (`plate_number`),
  ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applied_parts`
--
ALTER TABLE `applied_parts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `appointment_requests`
--
ALTER TABLE `appointment_requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoices`
--
ALTER TABLE `invoices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `m_parts`
--
ALTER TABLE `m_parts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `m_services`
--
ALTER TABLE `m_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `provided_services`
--
ALTER TABLE `provided_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `repair_orders`
--
ALTER TABLE `repair_orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_types`
--
ALTER TABLE `user_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `applied_parts`
--
ALTER TABLE `applied_parts`
  ADD CONSTRAINT `applied_parts_ibfk_1` FOREIGN KEY (`repair_order_id`) REFERENCES `repair_orders` (`id`),
  ADD CONSTRAINT `applied_parts_ibfk_2` FOREIGN KEY (`part_id`) REFERENCES `m_parts` (`id`);

--
-- Constraints for table `appointment_requests`
--
ALTER TABLE `appointment_requests`
  ADD CONSTRAINT `appointment_requests_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`);

--
-- Constraints for table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `invoices_ibfk_1` FOREIGN KEY (`repair_order_id`) REFERENCES `repair_orders` (`id`);

--
-- Constraints for table `provided_services`
--
ALTER TABLE `provided_services`
  ADD CONSTRAINT `provided_services_ibfk_1` FOREIGN KEY (`repair_order_id`) REFERENCES `repair_orders` (`id`),
  ADD CONSTRAINT `provided_services_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `m_services` (`id`);

--
-- Constraints for table `repair_orders`
--
ALTER TABLE `repair_orders`
  ADD CONSTRAINT `repair_orders_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`),
  ADD CONSTRAINT `repair_orders_ibfk_2` FOREIGN KEY (`appointment_request_id`) REFERENCES `appointment_requests` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_type_id`) REFERENCES `user_types` (`id`);

--
-- Constraints for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
