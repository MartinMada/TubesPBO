-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Nov 2023 pada 09.57
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`) VALUES
(1),
(3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `book`
--

CREATE TABLE `book` (
  `isbn` varchar(255) NOT NULL,
  `year` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `genre` enum('ACTION','ROMANCE','SLICE OF LIFE','FANTASY','SCI-FI','HORROR','COMEDY') DEFAULT NULL,
  `category` enum('FICTION','NONFICTION') DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `pic_path` varchar(255) DEFAULT NULL,
  `sinopsis` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `book`
--

INSERT INTO `book` (`isbn`, `year`, `title`, `genre`, `category`, `author`, `stock`, `pic_path`, `sinopsis`) VALUES
('978-0-123-45678-9', '2022-01-01', 'The Spirit Glass', 'ACTION', 'FICTION', 'Author 1', 10, 'src\\\\gambar\\\\action\\\\The Spirit Glass.jpg', 'Ini adalah buku pertama.'),
('978-0-444-56789-0', '2022-04-01', 'Spy X Family', 'COMEDY', 'FICTION', 'Author 4', 15, 'src\\\\gambar\\\\comedy\\\\Spy×Family 12.jpg', 'Ini adalah buku kedua.'),
('978-0-555-12345-6', '2022-03-01', 'Sword Catcher', 'FANTASY', 'FICTION', 'Author 3', 8, 'src\\\\gambar\\\\fantasy\\\\Sword Catcher.jpg', 'Ini adalah buku ketiga'),
('978-0-666-78901-2', '2022-05-01', 'House Of Leaves', 'HORROR', 'FICTION', 'Author 5', 12, 'src\\\\gambar\\\\horror\\House Of Leaves.jpg', 'Ini adalah buku keempat.'),
('978-0-987-65432-1', '2022-02-01', 'Me Before You', 'ROMANCE', 'FICTION', 'Author 2', 5, 'src\\\\gambar\\\\romance\\\\Me Before You.jpg', 'Ini adalah buku kelima.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `bookqueue`
--

CREATE TABLE `bookqueue` (
  `isbn` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `bookqueue`
--

INSERT INTO `bookqueue` (`isbn`, `id_user`, `date`) VALUES
('978-0-444-56789-0', 1, '2022-05-01'),
('978-0-123-45678-9', 2, '2022-02-01'),
('978-0-666-78901-2', 3, '2022-06-01'),
('978-0-987-65432-1', 4, '2022-03-01'),
('978-0-555-12345-6', 5, '2022-04-01');

-- --------------------------------------------------------

--
-- Struktur dari tabel `collection`
--

CREATE TABLE `collection` (
  `id_collection` int(11) NOT NULL,
  `id_admin` int(11) DEFAULT NULL,
  `id_creator` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `collection_status` enum('SHOW','PENDING','DELETED') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `collection`
--

INSERT INTO `collection` (`id_collection`, `id_admin`, `id_creator`, `name`, `date`, `collection_status`) VALUES
(200, 1, 1, 'Recommended Collection 1', '2022-01-01', 'SHOW'),
(201, 3, 2, 'Fantasy Favorites 2', '2022-02-01', 'SHOW'),
(202, 1, 3, 'Science Wonders 3', '2022-03-01', 'PENDING'),
(203, 3, 4, 'Romantic Reads 4', '2022-04-01', 'DELETED'),
(204, 3, 5, 'Horror Haven 5', '2022-05-01', 'SHOW');

-- --------------------------------------------------------

--
-- Struktur dari tabel `collectionbook`
--

CREATE TABLE `collectionbook` (
  `id_collection` int(11) NOT NULL,
  `isbn` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `collectionbook`
--

INSERT INTO `collectionbook` (`id_collection`, `isbn`) VALUES
(200, '978-0-123-45678-9'),
(201, '978-0-987-65432-1'),
(202, '978-0-555-12345-6'),
(203, '978-0-444-56789-0'),
(204, '978-0-666-78901-2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `comment`
--

CREATE TABLE `comment` (
  `id_comment` int(11) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `id_creator` int(11) DEFAULT NULL,
  `id_commenter` int(11) DEFAULT NULL,
  `depth` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `comment`
--

INSERT INTO `comment` (`id_comment`, `isbn`, `id_creator`, `id_commenter`, `depth`, `date`, `content`) VALUES
(1, '978-0-123-45678-9', 2, 1, 0, '2022-02-20', 'I agree!'),
(2, '978-0-987-65432-1', 4, 3, 0, '2022-02-20', 'Great suggestion!'),
(3, '978-0-555-12345-6', 5, 2, 0, '2022-02-20', 'Fantasy is my favorite genre too.'),
(4, '978-0-444-56789-0', 3, 1, 0, '2022-02-20', 'I learned so much from this book.'),
(5, '978-0-666-78901-2', 1, 5, 0, '2022-02-20', 'Creepy but captivating.'),
(6, '978-0-123-45678-9', 2, 1, 0, '2022-02-20', 'I agree!'),
(7, '978-0-987-65432-1', 4, 3, 0, '2022-02-20', 'Great suggestion!'),
(8, '978-0-555-12345-6', 5, 2, 0, '2022-02-20', 'Fantasy is my favorite genre too.'),
(9, '978-0-444-56789-0', 3, 1, 0, '2022-02-20', 'I learned so much from this book.'),
(10, '978-0-666-78901-2', 1, 5, 0, '2022-02-20', 'Creepy but captivating.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `listborrow`
--

CREATE TABLE `listborrow` (
  `id_list_borrow` int(11) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `date_borrow` timestamp NULL DEFAULT NULL,
  `date_return` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `listborrow`
--

INSERT INTO `listborrow` (`id_list_borrow`, `isbn`, `id_user`, `date_borrow`, `date_return`) VALUES
(1, '978-0-123-45678-9', 2, '2022-03-01 03:00:00', '2022-03-15 03:00:00'),
(2, '978-0-987-65432-1', 4, '2022-04-01 02:00:00', '2022-04-15 02:00:00'),
(3, '978-0-555-12345-6', 5, '2022-05-01 05:00:00', '2022-05-15 05:00:00'),
(4, '978-0-444-56789-0', 3, '2022-06-01 07:00:00', '2022-06-15 07:00:00'),
(5, '978-0-666-78901-2', 1, '2022-07-01 09:00:00', '2022-07-15 09:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pic_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `person`
--

INSERT INTO `person` (`id`, `password`, `name`, `email`, `phone`, `pic_path`) VALUES
(1, 'pass123', 'John Doe', 'john.doe@example.com', '123-456-7890', 'path/to/pic1.jpg'),
(2, 'pass456', 'Jane Doe', 'jane.doe@example.com', '987-654-3210', 'path/to/pic2.jpg'),
(3, 'pass789', 'Alice Smith', 'alice.smith@example.com', '555-123-4567', 'path/to/pic3.jpg'),
(4, 'passabc', 'Bob Johnson', 'bob.johnson@example.com', '777-888-9999', 'path/to/pic4.jpg'),
(5, 'passxyz', 'Eva Davis', 'eva.davis@example.com', '444-555-6666', 'path/to/pic5.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `review`
--

CREATE TABLE `review` (
  `id_user` int(11) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `review`
--

INSERT INTO `review` (`id_user`, `isbn`, `content`, `rating`, `date`) VALUES
(1, '978-0-444-56789-0', 'Fascinating science facts!', 4, '2022-05-15'),
(2, '978-0-123-45678-9', 'Great book!', 5, '2022-02-15'),
(3, '978-0-666-78901-2', 'Spooky and thrilling!', 4, '2022-06-15'),
(4, '978-0-987-65432-1', 'Highly recommended!', 4, '2022-03-15'),
(5, '978-0-555-12345-6', 'Amazing fantasy story!', 5, '2022-04-15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `warning` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `bio`, `warning`) VALUES
(1, 'Aspiring writer and avid reader.', 0),
(2, 'I love reading!', 0),
(3, 'Exploring different genres.', 1),
(4, 'Bookworm since childhood.', 1),
(5, 'Passionate about fantasy novels.', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `wishlist`
--

CREATE TABLE `wishlist` (
  `id_user` int(11) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `date_added` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `wishlist`
--

INSERT INTO `wishlist` (`id_user`, `isbn`, `date_added`) VALUES
(1, '978-0-444-56789-0', '2022-04-15'),
(2, '978-0-987-65432-1', '2022-01-15'),
(3, '978-0-123-45678-9', '2022-05-15'),
(4, '978-0-555-12345-6', '2022-02-15'),
(5, '978-0-666-78901-2', '2022-03-15');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`isbn`);

--
-- Indeks untuk tabel `bookqueue`
--
ALTER TABLE `bookqueue`
  ADD PRIMARY KEY (`id_user`,`isbn`),
  ADD KEY `isbn` (`isbn`);

--
-- Indeks untuk tabel `collection`
--
ALTER TABLE `collection`
  ADD PRIMARY KEY (`id_collection`),
  ADD KEY `id_admin` (`id_admin`),
  ADD KEY `id_creator` (`id_creator`);

--
-- Indeks untuk tabel `collectionbook`
--
ALTER TABLE `collectionbook`
  ADD PRIMARY KEY (`id_collection`,`isbn`),
  ADD KEY `isbn` (`isbn`);

--
-- Indeks untuk tabel `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id_comment`),
  ADD KEY `isbn` (`isbn`),
  ADD KEY `id_creator` (`id_creator`),
  ADD KEY `id_commenter` (`id_commenter`);

--
-- Indeks untuk tabel `listborrow`
--
ALTER TABLE `listborrow`
  ADD PRIMARY KEY (`id_list_borrow`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `isbn` (`isbn`);

--
-- Indeks untuk tabel `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id_user`,`isbn`),
  ADD KEY `isbn` (`isbn`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id_user`,`isbn`),
  ADD KEY `isbn` (`isbn`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `collection`
--
ALTER TABLE `collection`
  MODIFY `id_collection` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT untuk tabel `comment`
--
ALTER TABLE `comment`
  MODIFY `id_comment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `listborrow`
--
ALTER TABLE `listborrow`
  MODIFY `id_list_borrow` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

--
-- Ketidakleluasaan untuk tabel `bookqueue`
--
ALTER TABLE `bookqueue`
  ADD CONSTRAINT `bookqueue_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `bookqueue_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);

--
-- Ketidakleluasaan untuk tabel `collection`
--
ALTER TABLE `collection`
  ADD CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id`),
  ADD CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`id_creator`) REFERENCES `person` (`id`);

--
-- Ketidakleluasaan untuk tabel `collectionbook`
--
ALTER TABLE `collectionbook`
  ADD CONSTRAINT `collectionbook_ibfk_1` FOREIGN KEY (`id_collection`) REFERENCES `collection` (`id_collection`),
  ADD CONSTRAINT `collectionbook_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);

--
-- Ketidakleluasaan untuk tabel `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `review` (`isbn`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`id_creator`) REFERENCES `review` (`id_user`),
  ADD CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`id_commenter`) REFERENCES `user` (`id`);

--
-- Ketidakleluasaan untuk tabel `listborrow`
--
ALTER TABLE `listborrow`
  ADD CONSTRAINT `listborrow_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `listborrow_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);

--
-- Ketidakleluasaan untuk tabel `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);

--
-- Ketidakleluasaan untuk tabel `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

--
-- Ketidakleluasaan untuk tabel `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `wishlist_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
