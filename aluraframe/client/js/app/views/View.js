class View {
    constructor(element) {
        this._element = element;
    }

    template(model) {
        throw new Error(
            "O método template deve ser implementado na classe filha"
        );
    }

    update(model) {
        this._element.innerHTML = this.template(model);
    }
}
