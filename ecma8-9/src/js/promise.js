url = "https://www.boredapi.com/api/activity";
const newFact = () => {
    return fetch(url)
        .then((data) => data.json())
        .then((data) => {
            renderizarApi("promiseTypeActivity", data.type);
            renderizarApi("promiseActivity", data.activity);
        });
};

newFact();
