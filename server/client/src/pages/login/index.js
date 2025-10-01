import React from 'react';
import './styles.css';
import crmicon from '../../assets/crmicon.jpg';

export default function Login() {
    return (
        <div className="login-container">
            <section className="form">
                <form>
                    <h1>Preencha as informações abaixo</h1>
                    <input type="email" placeholder="E-mail" />
                    <input type="password" placeholder="Senha" />
                    <button type="submit">Entrar</button>
                </form>
            </section>
            <img src={crmicon} alt="login" />
        </div>
    )
}