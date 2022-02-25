const express = require ("express")
const router = express.Router()
const cliente = require('../controllers/cliente.controller.js')

router.post('/clientes', cliente.create)

router.get('/clientes', cliente.findAll)

router.get('/clientes/:clienteId', cliente.findOne)

router.put('/clientes/:clienteId', cliente.update)

router.delete('/clientes/:clienteId', cliente.delete)

router.delete('/clientes', cliente.deleteAll)

module.exports = router