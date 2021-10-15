import { Conta } from "./Conta.js";

export class ContaSalario extends Conta{
    constructor(client){
        super(0, client, 100);
    }

    sacar(value){
        let taxa = 1.01;
        return this._sacar(value, taxa);
    }
}