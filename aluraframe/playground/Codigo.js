class Codigo {
    constructor(expressao){
        this.expressao = expressao;
    }

    validar(codigo){
        if (this.expressao.test(codigo)){
            console.log('válido')
        } else console.log('inválido')
    }
}

c = new Codigo(/\D{3}-\D{2}-\d{2}/)
c.validar('GWZ-JJ-12')
c.validar('1X1-JJ-12')