export class Client {
    get cpf(){
        return this._cpf;
    }

    constructor(name, cpf, senha){
        this.name = name;
        this._cpf = cpf;
        this._senha = senha;
    }

    autenticar(senha){
        return senha == this._senha;
    }
}
