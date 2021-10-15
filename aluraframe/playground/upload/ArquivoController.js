class ArquivoController {

    constructor() {
        this._inputDados = document.querySelector('.dados-arquivo');
        this._dataInfo = new Arquivo();
    }

    envia() {
        //cria um Arquivo com as suas propriedades;
        let input = this._inputDados.value.split('/').map(element => element.toUpperCase());
        
        this._dataInfo._nome = input[0];
        this._dataInfo._tamanho = input[1];
        this._dataInfo._tipo = input[2];

        this._limpaFormulario();
    }

    _limpaFormulario() {
        this._inputDados.value = '';
        this._inputDados.focus();
    }
}