import { Conta } from "./Conta.js";

export class ContaPoupanca extends Conta{
    constructor(saldoInicial, client, agencia){
        super(saldoInicial, client, agencia);

    }

    sacar(value) {
        const taxa = 1.02;
        return this._sacar(value, taxa);
    }
}