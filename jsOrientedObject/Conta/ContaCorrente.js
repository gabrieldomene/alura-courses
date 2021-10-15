import { Conta } from "./Conta.js";

export class ContaCorrente extends Conta{
    static numeroDeContas = 0;
    constructor(client, agencia){
        super(0, client, agencia);
        ContaCorrente.numeroDeContas += 1;
    }

    sacar(value) {
        const taxa = 1.1;
        return this._sacar(value, taxa);
    }
}