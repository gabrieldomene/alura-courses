import { useState } from 'react';
import ListaNota from '../../components/ListaNota/ListaNotas';
import FormCadastro from '../../components/FormCadastro/';

const Landing = () => {

    const [note, setNote] = useState([])

    const createNote = (title, mesage) => {
        const newNote = {title: title, mesage: mesage}
        setNote([...note, newNote])
    }

    return (
        <div className="landing">
            <section className="conteudo">
            <FormCadastro createNote={createNote}/>
            <ListaNota data={note}/>
            </section>
        </div>
    )
}

export default Landing;