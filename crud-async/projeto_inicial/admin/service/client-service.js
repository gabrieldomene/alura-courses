const listaClientes = async () => {
    return fetch(`http://localhost:3000/profile`)
    .then(response => {
        if(response.ok){
            return response.json()
        }
        throw new Error("Não foi possível listar os clientes")
    })
}

const criaCliente = (nome, email) => {
    return fetch(`http://localhost:3000/profile`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: nome,
            email: email
        })
    })
    .then( response => {
        if(response.ok){
            return response.body
        }
        throw new Error("Não foi possível criar um cliente")
    })
}

const detalheCliente = (id) => {
    return fetch(`http://localhost:3000/profile/${id}`)
    .then( response => {
        if(response.ok){
            return response.json();
        }
        throw new Error("Não foi possível detalhar um cliente")
    })
}

const removeCliente = (id) => {
    return fetch(`http://localhost:3000/profile/${id}`, {
        method: "DELETE"
    }).then (response => {
        if(!responsta.ok) {
        throw new Error("Não foi possível remover um cliente")
        }
    })
}

const atualizaCliente = (id, nome, email) => {
    return fetch(`http://localhost:3000/profile/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: nome,
            email: email
        })
    }).then( response =>{
        if(response.ok){
            return response.json()
        }
        throw new Error("Não foi possível atualizar um cliente")
    }) 
}

export const clientService = {
    listaClientes,
    criaCliente,
    removeCliente,
    detalheCliente,
    atualizaCliente
}