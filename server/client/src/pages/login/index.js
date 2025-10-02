import React from 'react';
import './styles.css';
import crmicon from '../../assets/crmicon.jpg';

export default function Login() {
    return (
        <div className="login-container">
            <div className="login-box">
                <img src={crmicon} alt="CRM" className="logo" />

                <h1>Entrar</h1>
                <p className="subtitle">Preencha suas informações abaixo</p>

                <form>
                    <input className="input-email" type="email" placeholder="Email" />
                    <input className="input-password" type="password" placeholder="Senha" />

                    <button className="button" type="submit">Entrar</button>
                </form>

                <a href="/" className="forgot-password">Esqueceu sua senha?</a>
            </div>
        </div>
    )
}
