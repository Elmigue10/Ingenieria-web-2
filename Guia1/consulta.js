const mysql = require('mysql2');

const conexion = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'secret',
    database: 'gestion',
    port: '3306'
})  

conexion.connect((err) =>{
    if(err) throw err
    console.log("Conexión exitosa")
})

conexion.query("SELECT * FROM user", (err, rows)=>{
    if(err) throw err
    console.log("Consulta la información de la tabla conexion")
    console.log(rows)
})