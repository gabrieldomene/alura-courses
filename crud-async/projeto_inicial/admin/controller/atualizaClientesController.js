import { clientService } from "../service/client-service.js";

( async () => {
    const getUrl = new URL(window.location);
    
    const id = getUrl.searchParams.get("id");
    
    const inputNome = document.querySelector("[data-nome]");
    const inputEmail = document.querySelector("[data-email]");
    try {
        const dados = await clientService.detalheCliente(id)
        inputNome.value = dados.nome;
        inputEmail.value = dados.email;
        const formulario = document.querySelector("[data-form]");
        formulario.addEventListener("submit", async (event) => {
            event.preventDefault();
            try{
                await clientService.atualizaCliente(id, inputNome.value, inputEmail.value)
                window.location.href = "../telas/edicao_concluida.html"
            }
            catch(erro){
                console.log(erro)
                window.location.href = "../telas/erro.html"
            }
        })
    }
    catch(erro){
        console.log(erro)
        window.location.href = "../telas/erro.html"
    }
})()


