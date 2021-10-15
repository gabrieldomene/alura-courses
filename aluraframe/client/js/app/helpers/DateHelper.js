class DateHelper {
    constructor() {
        throw new Error("DateHelper não pode ser instanciada");
    }

    static dataParaTexto(data) {
        return `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`;
    }

    static textoParaData(text) {
        if (!/\d{4}-\d{2}-\d{2}/.test(text))
            throw new Error("Insira no formato aaaa-mm-dd");
        return new Date(
            ...text.split("-").map((ele, indice) => ele - (indice % 2))
        );
    }
}
