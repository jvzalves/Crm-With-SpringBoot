import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css';
import { FiArrowLeft } from "react-icons/fi";

export default function NewContact() {
    return (
        <div className="container">
            <h1>Insira as informações abaixo</h1>

            <form action="submit">
                <div className="form-group">
                    <p>Nome do contato:</p>
                    <input type="text" name="name" />
                </div>

                <div className="form-group">
                    <p>Nome da empresa:</p>
                    <input type="text" name="company" />
                </div>

                <div className="form-group">
                    <p>Email:</p>
                    <input type="email" name="email" />
                </div>

                <div className="form-group">
                    <p>Site:</p>
                    <input type="url" name="site" />
                </div>

                <div className="form-group">
                    <p>LinkedIn:</p>
                    <input type="url" name="linkedin" />
                </div>

                <div className="form-group">
                    <p>Telefone:</p>
                    <input type="tel" name="phone" />
                </div>

                <div className="buttons">
                    <Link to="/contacts" className="btn-back">
                        <FiArrowLeft size={20} color="#28c76f" />
                        <span>Voltar para tela de contatos</span>
                    </Link>

                    <button type="submit" className="btn-save">
                        Salvar
                    </button>
                </div>
            </form>
        </div>
    );
}