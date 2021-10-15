import React from 'react';

import CardNota from '../CardNota';
import './style.css';

const ListaNotas = ({ data }) => {

    return (
        <ul className="lista-notas">
            {data.map((sample, idx) => {
                    return (
                        <li className="lista-notas_item" key={idx}>
                            <CardNota info={sample}/>
                        </li>
                    )
                })
            }
        </ul>
    )
}

export default ListaNotas;