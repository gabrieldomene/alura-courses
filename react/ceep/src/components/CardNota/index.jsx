import './style.css'

const Card = ({ info }) => {

    return (
        <section className="card-nota">
            <header className="card-nota_cabecalho">
                <h3 className="card-nota_titulo">{info.title}</h3>
            </header>
            <p className="card-nota_texto">{info.mesage}</p>
        </section>
    )
}

export default Card;