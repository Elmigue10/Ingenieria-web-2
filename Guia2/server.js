const express = require('express');
const bodyParser = require('body-parser');
const port = 3000;

const app = express();

const clienteRoutes = require("./app/routes/cliente.routes.js")

app.use(bodyParser.json());


app.use(bodyParser.urlencoded({ extended: true}))

app.use("/", clienteRoutes)

app.get("/", (req, res) => {
    res.json({ message: 'Welcome the application'})
})

app.listen(port, (req, res) => {
    console.log('App en el puerto: ', port)
})