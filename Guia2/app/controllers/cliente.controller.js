const Cliente = require('../model/cliente.model.js')



exports.create = (req, res) => {
    if(!req.body){
        res.status(400).send({
            message: "El body no puede estar vacio"
        })
    } 

    const cliente = new Cliente({
        email: req.body.email,
        nombre: req.body.nombre, 
        activo: req.body.activo
    })

    Cliente.create(cliente, (err, data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "Ocurrió un error en la creación del cliente"
            })
        }
        else res.send(data)
    })

}

exports.findAll = (req, res) => {

    Cliente.getAll((err, data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "Ocurrió un error recuperando los clientes"
            })
        }
        else res.send(data)
    })

}

exports.findOne = (req, res) => {

    Cliente.findById(req.params.clienteId, (err, data) => {
        if(err){
            if(err.kind === "not_found"){
                res.status(404).send({
                    message: `Cliente no encontrado con el id: ${req.params.clienteId}`
                })
            } else {
                res.status(500).send({
                    message: "Error recuperando el cliente con el id: " + req.params.clienteId
                })
            }
        } 
        else res.send(data)
    })

}

exports.update = (req, res) => {

    if(!req.body){
        res.status(400).send({
            message: "El body no puede estar vacio"
        })
    } 

    const newCustomer = req.body

    Cliente.updateById(
        req.params.clienteId, 
        newCustomer,
        (err, data) =>{
            if(err){
                if(err.kind === "not_found"){
                    res.status(404).send({
                        message: `Cliente no encontrado con el id: ${req.params.clienteId}`
                    })
                } else {
                    res.status(500).send({
                        message: "Error actualizando el cliente con el id: " + req.params.clienteId
                    })
                }
            }
            else res.send(data)
        })
}

exports.delete = (req, res) => {
    Cliente.remove(req.params.clienteId, (err, data)=>{
        if(err){
            if(err.kind === "not_found"){
                res.status(404).send({
                    message: `Cliente no encontrado con el id: ${req.params.clienteId}`
                })
            } else {
                res.status(500).send({
                    message: "Error eliminando el cliente con el id: " + req.params.clienteId
                })
            }
        }
        else res.send({ message: "Cliente eliminado con exito!" })
    })
}

exports.deleteAll = (req, res) => {
    Cliente.removeAll((err, data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "Ocurrió un error"
            })
        } else res.send({ message: "Todos los clientes fueron eliminados con exito!"})
    })
}