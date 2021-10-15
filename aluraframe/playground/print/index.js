let funcionarios = [
    {
        "nome": "Douglas",
        "endereco" : "Rua da esquina, 123",
        "salario" : "4500"
    },
    {
        "nome": "Felipe",
        "endereco" : "Rua da virada, 456",
        "salario" : "5000"
    },
    {
        "nome": "Silvio",
        "endereco" : "Rua da aresta, 789",
        "salario" : "6000"
    }
];

let element = document.querySelector('tbody');

funcionarios.map( funcionario => {
    trFunc = document.createElement('tr')
    tdName = document.createElement('td');
    tdName.innerHTML = funcionario.nome;

    tdEnd = document.createElement('td');
    tdEnd.innerHTML = funcionario.endereco;

    tdSal = document.createElement('td');
    tdSal.innerHTML = funcionario.salario;
    trFunc.appendChild(tdName)
    trFunc.appendChild(tdEnd)
    trFunc.appendChild(tdSal)
    element.appendChild(trFunc)
})