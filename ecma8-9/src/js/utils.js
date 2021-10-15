const renderizarLista = (...items) => {
    return (document.getElementById(items[0]).innerHTML = `<ul>${items[1].map(
        (item) => `<li>${item}</li>`
    )}</ul>`);
};

const renderizarApi = (id, data) => {
    return (document.getElementById(
        id
    ).innerHTML = `<ul>${`<li>${data}</li>`}</ul>`);
};
