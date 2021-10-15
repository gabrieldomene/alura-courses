import { useState } from 'react';
import './style.css';

const FormCadastro = ({ createNote }) => {
    const [title, setTitle] = useState("");
    const [mesage, setMesage] = useState("");

    const changeTitle = (evt) => {
        setTitle(evt.target.value);
    }

    const handleMessage = (evt) => {
        setMesage(evt.target.value);
    }

    const handleSubmit = (evt) => {
        evt.preventDefault();
        createNote(title, mesage);
    }

    return (
        <form action="" className="form-cadastro" onSubmit={handleSubmit}>
            <input type="text"
             placeholder="Título"
              className="form-cadastro_input"
              onChange={changeTitle}/>

            <textarea  cols={1}
             rows={15} placeholder="Escreva sua nota"
              className="form-cadastro_input" 
              onChange={handleMessage}/>

            <button className="form-cadastro_input form-cadastro_submit">Criar Nota</button>
        </form>
    )
}

export default FormCadastro;