import { Client } from "../Client.js";
export class Conta {

    constructor(saldoInicial, cliente, agencia){
        if (this.constructor == Conta){
            throw new Error("Você não deveria instanciar \
            um objeto do tipo Conta diretamente, pois é uma classe Abstrata");
        }
        
        this._saldo = saldoInicial;
        this._cliente = cliente;
        this._agencia = agencia;
    }

    set cliente(newClient){
        if (newClient instanceof Client){
            this._cliente = newClient;
        }
    }

    get cliente(){
        return this._cliente;
    }

    get saldo(){
        return this._saldo;
    }

    sacar(value) {
        throw new Error("O método Sacar da conta é abstrato");
    }
    
    _sacar(value, taxa){
        const valorSacado = taxa * value;
        if (valorSacado <= this._saldo) {
            this._saldo -= valorSacado;
            return valorSacado;
        }

        return 0;
    }

    depositar(value) {
        if (value <= 0)
            return;

        this._saldo += value;
    }

    transferir(value, conta){
        if (value < 0) return;
        const valorSacado = this.sacar(value);
        conta.depositar(valorSacado);
    }
}