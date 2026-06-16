PRAGMA foreign_keys = ON;

-- Table structure for table `clients`
CREATE TABLE IF NOT EXISTS `users` (
    `id` INTEGER PRIMARY KEY AUTOINCREMENT,
    `username` TEXT NOT NULL,
    `role` TEXT NOT NULL,
    `password_hash` TEXT NOT NULL
);