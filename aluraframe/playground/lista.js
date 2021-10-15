const exibeNoConsole = lista => {
    lista.forEach( item => console.log(item))
}

let lista1 = ['Flavin', 'ROdrigo', 'Joao'];
let lista2 = ['Gabriel', 'Maria', 'Marcelo'];

newList = [...lista1, ...lista2]
exibeNoConsole(newList)
