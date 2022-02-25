const sql = require('./db.js');

const Cliente = function(cliente){
    this.email = cliente.email;
    this.nombre = cliente.nombre;
    this.activo = cliente.activo;
}

Cliente.create = (newCliente, result) => {
    sql.query("INSERT INTO cliente SET ?", newCliente, (err, res) => {
        if (err) {
            console.error("Error: ", err);
            result(err, null)
            return
        }

        console.log("Crear cliente: ", { id:res.insertId, ...newCliente })
        result(null, { id: res.insertId, ...newCliente })
    })
}

Cliente.findById = (clienteId, result) => {
    sql.query(`SELECT * FROM cliente WHERE id = ${clienteId}`, (err, res) => {
        if (err){
            console.log("Error: ", err);
            result(err, null)
            return
        }

        if(res.length){
            console.log("Hallar cliente: ", res[0])
            result(null, res[0])
            return
        }

        result({ kind: "no_encontrado" }, null)

    })
}

Cliente.getAll = result => {
    sql.query("SELECT * FROM cliente", (err, res) => {
        if(err){
            console.log("Error: ", err)
            result(null, res)
            return
        }

        console.log("Cliente: ", res)
        result(null, res)

    })
}

Cliente.updateById = (id, cliente, result) => {

    sql.query(
        "UPDATE cliente set ? WHERE id = ?", 
        [cliente , id],
        (err, res) => {
            if(err){
                console.log("Error: ", err)
                result(null, res)
                return
            }

            if(res.affectedRows == 0){
                result({ kind: "not_found" }, null)
                return
            }

            console.log("Modificar cliente: ", { id: id,  ...cliente})
            result(null, { id: id, ...cliente})

        }
    )

}

Cliente.remove = (id, result) => { 
    sql.query("DELETE FROM cliente WHERE id = ?", id, (err, res) => {
        if (err){
            console.log("Error: ", err)
            result(null, res)
            return
        }

        if(res.affectedRows == 0){
            result({ kind: "not_found" }, null)
            return
        }

        console.log("Cliente borrado con el id: ", id)
        result(null, res)
    })
}

Cliente.removeAll = result => {
    sql.query("DELETE FROM cliente", (err, res) => {
        if(err){
            console.log("Error:", err)
            result(null, res)
            return
        }

        console.log(`Borrados ${res.affectedRows} clientes`)

        result(null, res)

    })
}

module.exports = Cliente;