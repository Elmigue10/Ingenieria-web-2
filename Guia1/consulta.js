const mysql = require('mysql2');
const express = require('express');
const app = express();
const port = 3000;

app.set('view engine', 'pug');

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


app.get('/', (req, res) =>{
    conexion.query("SELECT * FROM user", (err, rows)=>{
        if(err) {
            console.log("Conexión fallida. ", err)
            throw err
        } else{
            console.log("Consulta la información de la tabla")
            console.log(rows)
            res.render('index', { personas: rows })
            conexion.end()
        }
    })
})


app.listen(port, ()=>{ console.log("Servidor en el puerto: ", port) })