-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2020 at 11:52 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stok_barang`
--

-- --------------------------------------------------------

--
-- Table structure for table `barangmasuk`
--

CREATE TABLE `barangmasuk` (
  `idbarang` varchar(8) NOT NULL,
  `tanggalmasuk` date DEFAULT NULL,
  `namabarang` varchar(30) NOT NULL,
  `qty` int(4) NOT NULL,
  `hargagrosir` int(7) NOT NULL,
  `hargaeceran` int(10) NOT NULL,
  `satuan` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barangmasuk`
--

INSERT INTO `barangmasuk` (`idbarang`, `tanggalmasuk`, `namabarang`, `qty`, `hargagrosir`, `hargaeceran`, `satuan`) VALUES
('B01', '2020-06-23', 'BOLT', 14, 15000, 25000, 'KG'),
('C01', '2020-06-23', 'CHOIZ HIJAU', 18, 15000, 25000, 'KG'),
('C02', '2020-06-23', 'CHOIZ KIDS', 14, 15000, 25000, 'KG'),
('WK JR', '2020-06-23', 'WHISKAS JUNIOR', 3, 5000, 7000, 'PCS'),
('WK KLG', '2020-07-19', 'WHISKAS KALENG', 20, 15000, 21000, 'PCS'),
('GROWSY', '2020-07-19', 'SUSU KUCING', 20, 5000, 7000, 'PCS'),
('FO', '2020-07-19', 'FISH OIL', 20, 15000, 18000, 'PCS'),
('SMP', '2020-07-19', 'SHAMPO KUCING&ANJING', 20, 10000, 15000, 'PCS'),
('KLG01', '2020-07-19', 'KALUNG KUCING COW-COW', 20, 7000, 10000, 'PCS'),
('KLG02', '2020-07-19', 'KALUNG KUCING BOO-BOO', 20, 9000, 13000, 'PCS'),
('OBT', '2020-07-19', 'OBAT KUCING DIARE', 20, 18000, 22000, 'PCS'),
('PRO', '2020-07-19', 'PROFELIN KALENG', 20, 17000, 20000, 'PCS'),
('FL', '2020-07-19', 'FELIBITE', 20, 14000, 17000, 'PCS'),
('OK', '2020-07-19', 'OBAT KUTU KUCING', 20, 13000, 17000, 'PCS'),
('MK', '2020-07-19', 'ME-O KALENG', 20, 15000, 20000, 'PCS'),
('ME', '2020-07-19', 'ME-O BUNGKUSAN', 20, 25000, 30000, 'KG'),
('SSR', '2020-07-19', 'SISIR KUCING BOO-BOO', 20, 15000, 20000, 'PCS'),
('EX', '2020-07-19', 'EXCEL', 20, 10000, 15000, 'KG'),
('TS', '2020-07-19', 'TAKARI & SAKURA IKAN', 20, 5000, 9000, 'PCS');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idcustomer` varchar(8) NOT NULL,
  `namacustomer` varchar(30) NOT NULL,
  `jeniskelamincustomer` varchar(9) NOT NULL,
  `notlpcustomer` varchar(12) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `biayahutang` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idcustomer`, `namacustomer`, `jeniskelamincustomer`, `notlpcustomer`, `alamat`, `biayahutang`) VALUES
('001', 'lukman', 'Laki-Laki', '085289171266', 'cinere depok', 30000),
('002', 'wildan', 'Laki-Laki', '08465728734', 'depok agung', 100000),
('003', 'laras', 'Perempuan', '09476263882', 'depok', 5000),
('004', 'ria', 'Perempuan', '0846251826', 'depok', 100000),
('005', 'olin', 'Perempuan', '08763516356', 'depok', 80000),
('006', 'isna', 'Perempuan', '0938625536', 'depok', 0),
('007', 'ica', 'Perempuan', '0874626776', 'depok', 0),
('008', 'ega', 'Perempuan', '0384663772', 'depok', 0),
('009', 'elis', 'Perempuan', '08374618293', 'depok', 0),
('010', 'chory', 'Laki-Laki', '084626489', 'jakarta barat', 0);

-- --------------------------------------------------------

--
-- Table structure for table `djual`
--

CREATE TABLE `djual` (
  `id_djual` int(11) NOT NULL,
  `no_jual` varchar(100) NOT NULL,
  `kdbrg` char(5) NOT NULL DEFAULT '',
  `harga_jual` float DEFAULT NULL,
  `jumlah` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `djual`
--

INSERT INTO `djual` (`id_djual`, `no_jual`, `kdbrg`, `harga_jual`, `jumlah`) VALUES
(12100132, 'RF/20200717/000001', 'B01', 25000, '1'),
(12100133, 'RF/20200717/000001', 'C01', 25000, '2'),
(12100134, 'RF/20200718/000001', 'B01', 25000, '3'),
(12100135, 'RF/20200830/000001', 'PRO', 20000, '2'),
(12100136, 'RF/20200830/000001', 'SMP', 15000, '1');

--
-- Triggers `djual`
--
DELIMITER $$
CREATE TRIGGER `djual2` AFTER INSERT ON `djual` FOR EACH ROW BEGIN 
UPDATE tblbrg 
SET jumlah = jumlah - NEW.jumlah 
WHERE 
kdbrg = NEW.kdbrg; 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `jual`
--

CREATE TABLE `jual` (
  `id_jual` int(11) NOT NULL,
  `no_jual` varchar(100) NOT NULL,
  `tgl_jual` date DEFAULT NULL,
  `total` varchar(10) DEFAULT NULL,
  `bayar` varchar(10) DEFAULT NULL,
  `kembalian` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jual`
--

INSERT INTO `jual` (`id_jual`, `no_jual`, `tgl_jual`, `total`, `bayar`, `kembalian`) VALUES
(30, 'RF/20200717/000001', '2020-07-17', '50000.0', '50000', '0.0'),
(31, 'RF/20200717/000001', '2020-07-17', '50000.0', '', ''),
(32, 'RF/20200718/000001', '2020-07-18', '75000.0', '100000', '25000.0'),
(33, 'RF/20200808/000001', '2020-08-08', '21000.0', '25000', '4000.0'),
(34, 'RF/20200808/000002', '2020-08-08', '21000.0', '25000', '4000.0'),
(35, 'RF/20200830/000001', '2020-08-30', '15000.0', '60000', '5000.0');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(11) NOT NULL,
  `password` varchar(10) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `level`) VALUES
('admin', '123', 'admin'),
('petugas', '123', 'petugas');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `idpetugas` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `namapetugas` varchar(20) NOT NULL,
  `jeniskelamin` varchar(9) NOT NULL,
  `notlp` varchar(12) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`idpetugas`, `password`, `namapetugas`, `jeniskelamin`, `notlp`, `alamat`) VALUES
('P001', '1234', 'Tirta Ayu', 'Perempuan', '083804630282', 'depok'),
('P002', '123', 'supri', 'Laki-Laki', '0838987800', 'simpangan depok'),
('P003', '123', 'yogi ridho', 'Laki-Laki', '0898984782', 'depok'),
('P004', '123', 'dede', 'Perempuan', '09826356787', 'simpangan');

-- --------------------------------------------------------

--
-- Table structure for table `retur`
--

CREATE TABLE `retur` (
  `noretur` varchar(20) NOT NULL,
  `tanggalretur` date NOT NULL,
  `idbarang` varchar(20) NOT NULL,
  `namabarang` varchar(20) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `jumlahretur` varchar(20) NOT NULL,
  `total` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `retur`
--

INSERT INTO `retur` (`noretur`, `tanggalretur`, `idbarang`, `namabarang`, `harga`, `jumlahretur`, `total`) VALUES
('OUT/20200625/000001', '2020-06-24', 'B01', 'BOLT', '15000.0', '3', '45000.0'),
('OUT/20200625/000002', '2020-06-24', 'WK JR', 'WHISKAS JUNIOR', '5000.0', '5', '25000.0');

-- --------------------------------------------------------

--
-- Table structure for table `tblbrg`
--

CREATE TABLE `tblbrg` (
  `kdbrg` varchar(10) NOT NULL,
  `nmbrg` varchar(100) DEFAULT NULL,
  `satuan` varchar(20) DEFAULT NULL,
  `harga` text,
  `jumlah` varchar(20) DEFAULT NULL,
  `stokmin` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `djual`
--
ALTER TABLE `djual`
  ADD PRIMARY KEY (`id_djual`);

--
-- Indexes for table `jual`
--
ALTER TABLE `jual`
  ADD PRIMARY KEY (`id_jual`);

--
-- Indexes for table `tblbrg`
--
ALTER TABLE `tblbrg`
  ADD PRIMARY KEY (`kdbrg`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `djual`
--
ALTER TABLE `djual`
  MODIFY `id_djual` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12100137;

--
-- AUTO_INCREMENT for table `jual`
--
ALTER TABLE `jual`
  MODIFY `id_jual` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
