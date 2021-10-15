url = "https://www.boredapi.com/api/activity";

const asyncBoredApi = async () => {
    try {
        const response = await fetch(url);

        const dados = await response.json();
        renderizarApi("asyncAwaitType", dados.type);
        renderizarApi("asyncAwaitActivity", dados.activity);
    } catch (error) {
        console.error("Deu ruim", error);
    } finally {
        console.log("fim do async await");
    }
};

asyncBoredApi();
