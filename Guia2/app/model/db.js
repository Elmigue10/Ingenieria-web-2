const mysql = require('mysql2')
const dbConfig = require('../config/db.config.js')

const connection = mysql.createConnection({
    host: dbConfig.HOST,
    user: dbConfig.USER,
    password: dbConfig.PASSWORD,
    database: dbConfig.DB,
    port: dbConfig.PORT
})

connection.connect((err) =>{
    if(err) throw err
    console.log("Conexión exitosa")
})

module.exports = connection