const mysql = require('mysql2/promise');

const conn = mysql.createPool({
  host: 'localhost',
  user: 'root',
  password: 'Password@123',
  database: 'comment',
  waitForConnections: true,
  connectionLimit: 10, // Max number of concurrent connections
  queueLimit: 0        // No limit for queued requests
});

module.exports = conn;