-- =========================================================
-- BookMyShow Seed Data
-- Dialect: MySQL (adjust TRUNCATE/quoting for Postgres if needed)
-- Table names match current entities:
--   users, cities, theaters, screens, movies, shows,
--   seats, bookings, booking_id (many-to-many join table)
-- Enum values confirmed from source:
--   SeatType(REGULAR, PREMIUM, VIP), BookingStatus(CONFIRMED, CANCELLED)
-- =========================================================

-- Disable FK checks temporarily for a clean re-run (MySQL only)
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE booking_id;   -- bookings <-> seat join table
TRUNCATE TABLE bookings;
TRUNCATE TABLE seats;
TRUNCATE TABLE shows;
TRUNCATE TABLE movies;
TRUNCATE TABLE screens;
TRUNCATE TABLE theaters;
TRUNCATE TABLE cities;
TRUNCATE TABLE users;
SET FOREIGN_KEY_CHECKS = 1;

-- =========================================================
-- 1. CITIES
-- =========================================================
INSERT INTO cities (id, name, state) VALUES
(1, 'Delhi', 'Delhi'),
(2, 'Mumbai', 'Maharashtra'),
(3, 'Bangalore', 'Karnataka');

-- =========================================================
-- 2. THEATERS
-- =========================================================
INSERT INTO theaters (id, name, address, city_id) VALUES
(1, 'PVR Saket', 'Saket District Centre, New Delhi', 1),
(2, 'INOX R-City', 'Ghatkopar West, Mumbai', 2),
(3, 'PVR Forum Mall', 'Koramangala, Bangalore', 3);

-- =========================================================
-- 3. SCREENS
-- =========================================================
INSERT INTO screens (id, name, theater_id, total_seats) VALUES
(1, 'Audi 1', 1, 8),
(2, 'Audi 2', 1, 8),
(3, 'Audi 1', 2, 8),
(4, 'Audi 2', 2, 8),
(5, 'Audi 1', 3, 8),
(6, 'Audi 2', 3, 8);

-- =========================================================
-- 4. MOVIES
-- =========================================================
INSERT INTO movies (id, title, genre, language, duration_minutes, rating, release_date, posterurl) VALUES
(1, 'Pathaan Returns', 'Action', 'Hindi', 148, 4.2, '2026-01-10', 'https://example.com/posters/pathaan_returns.jpg'),
(2, 'Interstellar Odyssey', 'Sci-Fi', 'English', 165, 4.7, '2026-02-14', 'https://example.com/posters/interstellar_odyssey.jpg'),
(3, 'Kantara 2', 'Drama', 'Kannada', 138, 4.6, '2026-03-01', 'https://example.com/posters/kantara2.jpg'),
(4, 'Laugh Riot', 'Comedy', 'Hindi', 120, 3.9, '2026-03-20', 'https://example.com/posters/laugh_riot.jpg'),
(5, 'Midnight Chase', 'Thriller', 'English', 112, 4.1, '2026-04-05', 'https://example.com/posters/midnight_chase.jpg');

-- =========================================================
-- 5. SHOWS
-- =========================================================
INSERT INTO shows (id, movie_id, screen_id, show_date, start_time, end_time, ticket_price) VALUES
(1, 1, 1, '2026-08-20', '10:00:00', '12:28:00', 250.00),
(2, 1, 1, '2026-08-20', '18:00:00', '20:28:00', 300.00),
(3, 2, 3, '2026-08-20', '14:00:00', '16:45:00', 350.00),
(4, 3, 5, '2026-08-21', '11:00:00', '13:18:00', 220.00),
(5, 4, 2, '2026-08-21', '19:30:00', '21:30:00', 200.00),
(6, 5, 4, '2026-08-22', '21:00:00', '22:52:00', 280.00);

-- =========================================================
-- 6. USERS
-- (passwords are placeholder bcrypt-style hashes -- replace before real use)
-- =========================================================
INSERT INTO users (id, name, email, password, phone, created_at) VALUES
(1, 'Aarav Sharma', 'aarav.sharma@example.com', '$2a$10$abcdefghijklmnopqrstuv', '9876543210', '2026-08-01 09:15:00'),
(2, 'Diya Patel', 'diya.patel@example.com', '$2a$10$abcdefghijklmnopqrstuw', '9876543211', '2026-08-02 10:20:00'),
(3, 'Rohan Mehta', 'rohan.mehta@example.com', '$2a$10$abcdefghijklmnopqrstux', '9876543212', '2026-08-03 11:05:00'),
(4, 'Isha Reddy', 'isha.reddy@example.com', '$2a$10$abcdefghijklmnopqrstuy', '9876543213', '2026-08-04 08:40:00'),
(5, 'Kabir Singh', 'kabir.singh@example.com', '$2a$10$abcdefghijklmnopqrstuz', '9876543214', '2026-08-05 17:30:00');

-- =========================================================
-- 7. SEATS (8 seats per screen: rows A-B, cols 1-4)
-- =========================================================
INSERT INTO seats (id, seat_number, seats_row, seats_col, seat_type, screen_id) VALUES
-- Screen 1 (Theater 1, Audi 1)
(1, 'A1', 'A', 1, 'REGULAR', 1),
(2, 'A2', 'A', 2, 'REGULAR', 1),
(3, 'A3', 'A', 3, 'PREMIUM', 1),
(4, 'A4', 'A', 4, 'PREMIUM', 1),
(5, 'B1', 'B', 1, 'REGULAR', 1),
(6, 'B2', 'B', 2, 'REGULAR', 1),
(7, 'B3', 'B', 3, 'VIP', 1),
(8, 'B4', 'B', 4, 'VIP', 1),
-- =========================
-- Screen 2 (Theater 1, Audi 2)
-- =========================
(21, 'A1', 'A', 1, 'REGULAR', 2),
(22, 'A2', 'A', 2, 'REGULAR', 2),
(23, 'A3', 'A', 3, 'PREMIUM', 2),
(24, 'A4', 'A', 4, 'PREMIUM', 2),
(25, 'B1', 'B', 1, 'REGULAR', 2),
(26, 'B2', 'B', 2, 'REGULAR', 2),
(27, 'B3', 'B', 3, 'VIP', 2),
(28, 'B4', 'B', 4, 'VIP', 2);

-- Screen 3 (Theater 2, Audi 1)
(9, 'A1', 'A', 1, 'REGULAR', 3),
(10, 'A2', 'A', 2, 'REGULAR', 3),
(11, 'A3', 'A', 3, 'PREMIUM', 3),
(12, 'A4', 'A', 4, 'PREMIUM', 3),
(13, 'B1', 'B', 1, 'REGULAR', 3),
(14, 'B2', 'B', 2, 'REGULAR', 3),
(15, 'B3', 'B', 3, 'VIP', 3),
(16, 'B4', 'B', 4, 'VIP', 3),
-- =========================
-- Screen 4 (Theater 2, Audi 2)
-- =========================
(29, 'A1', 'A', 1, 'REGULAR', 4),
(30, 'A2', 'A', 2, 'REGULAR', 4),
(31, 'A3', 'A', 3, 'PREMIUM', 4),
(32, 'A4', 'A', 4, 'PREMIUM', 4),
(33, 'B1', 'B', 1, 'REGULAR', 4),
(34, 'B2', 'B', 2, 'REGULAR', 4),
(35, 'B3', 'B', 3, 'VIP', 4),
(36, 'B4', 'B', 4, 'VIP', 4);
-- Screen 5 (Theater 3, Audi 1)
(17, 'A1', 'A', 1, 'REGULAR', 5),
(18, 'A2', 'A', 2, 'REGULAR', 5),
(19, 'A3', 'A', 3, 'PREMIUM', 5),
(20, 'A4', 'A', 4, 'PREMIUM', 5);

-- =========================================================
-- 8. BOOKINGS
-- =========================================================
INSERT INTO bookings (id, user_id, show_id, total_price, status, booked_at) VALUES
(1, 1, 1, 500.00, 'CONFIRMED', '2026-08-19 09:00:00'),
(2, 2, 3, 700.00, 'CONFIRMED', '2026-08-19 10:15:00'),
(3, 3, 4, 220.00, 'CONFIRMED', '2026-08-19 11:30:00'),
(4, 4, 1, 750.00, 'CONFIRMED', '2026-08-19 12:45:00'),
(5, 5, 3, 350.00, 'CANCELLED', '2026-08-19 13:10:00');

-- =========================================================
-- 9. BOOKING <-> SEAT join table
-- @JoinTable(name="booking_id") as defined in Booking entity
-- Columns: booking_id, seat_id
-- =========================================================
INSERT INTO booking_id (booking_id, seat_id) VALUES
(1, 1),
(1, 2),
(2, 9),
(2, 10),
(2, 11),
(3, 17),
(4, 3),
(4, 4),
(4, 5),
(5, 12);
