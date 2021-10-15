import { Client } from "./Client.js";
import { Gerente } from "./Funcionario/Gerente.js";
import { Diretor } from "./Funcionario/Diretor.js";
import { SistemaAuth } from "./SistemaAuth.js";

const diretor = new Diretor("Rodrigo", 10000, 341231);
diretor.cadastrarSenha("123456789");

const gerente = new Gerente("Ricardo", 5000, 84898);
gerente.cadastrarSenha("5855");

const cliente = new Client("Lais", 789456, 123)

const DisLogged = SistemaAuth.login(diretor, 123456789);
const GisLogged = SistemaAuth.login(gerente, 5855);
const CisLogged = SistemaAuth.login(cliente, 123);

console.log(DisLogged, GisLogged, CisLogged);