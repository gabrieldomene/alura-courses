class Conta{
    constructor(saldo){
        this._saldo = saldo;
    }

    get saldoConta(){
        return this._saldo;
    }

    atualiza(taxa){
        throw new Error('Não pode ser acessado diretamente')
    }
}