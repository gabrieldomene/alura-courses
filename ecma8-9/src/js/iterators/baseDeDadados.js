const tabelaAlimentos = () => {
    const tabelas = {
        alimentos: {
            1: { nome: "Feijao" },
            2: { nome: "Arroz" },
            3: { nome: "Batata" },
            4: { nome: "Carne" },
            5: { nome: "Ovo" },
        },
    };
    return {
        get: (nome, id) => tabelas[nome][id],
        asyncGet: (nome, id) => delay(500).then(() => tabelas[nome][id]),
    };
};

const delay = (ms) => {
    return new Promise((resolve) => setTimeout(resolve, ms));
};

const tabela = tabelaAlimentos();
