import React, { useState } from "react";
import { Link } from 'react-router-dom';
import { FiPower } from "react-icons/fi";

import "./styles.css";

export default function Contact() {
    const [activeContact, setActiveContact] = useState(null);

    const toggleDetails = (contactId) => {
        if (activeContact === contactId) {
            setActiveContact(null);
        } else {
            setActiveContact(contactId);
        }
    };

    return (
        <div>
            <header className="top-bar">
                <span className="user-greeting">Olá, Sicrano!</span>
                <div className="actions">
                    <input type="text" id="search" placeholder="Pesquisar contatos..." />
                    <FiPower className="button-off" size={40} color="#251fc5" />
                </div>
            </header>

            <div className="container">
                <h1>Contatos</h1>
                <p className="add-contact">Adicionar novo contato</p>
                <ul className="contact-list" id="contactList">
                    <li className="contact-item" onClick={() => toggleDetails("contato1")}>
                        <span>
                            <strong>João Silva</strong>
                        </span>
                        <span>Empresa X</span>
                    </li>
                    {activeContact === "contato1" && (
                        <div id="contato1" className="contact-details-active">
                            <p>
                                <strong>Celular:</strong> (11) 99999-1111
                            </p>
                            <p>
                                <strong>Email:</strong> joao@empresax.com
                            </p>
                            <p>
                                <strong>LinkedIn:</strong>{" "}
                                <a href="#">linkedin.com/in/joaosilva</a>
                            </p>
                            <div className="actions">
                                <button className="btn-edit">Editar</button>
                                <button className="btn-delete">Excluir</button>
                            </div>
                        </div>
                    )}

                    <li className="contact-item" onClick={() => toggleDetails("contato2")}>
                        <span>
                            <strong>Maria Souza</strong>
                        </span>
                        <span>Empresa Y</span>
                    </li>
                    {activeContact === "contato2" && (
                        <div id="contato2" className="contact-details-active">
                            <p>
                                <strong>Celular:</strong> (21) 98888-2222
                            </p>
                            <p>
                                <strong>Email:</strong> maria@empresay.com
                            </p>
                            <p>
                                <strong>LinkedIn:</strong>{" "}
                                <a href="#">linkedin.com/in/mariasouza</a>
                            </p>
                            <div className="actions">
                                <button className="btn-edit">Editar</button>
                                <button className="btn-delete">Excluir</button>
                            </div>
                        </div>
                    )}

                    <li className="contact-item" onClick={() => toggleDetails("contato3")}>
                        <span>
                            <strong>Carlos Lima</strong>
                        </span>
                        <span>Empresa Z</span>
                    </li>
                    {activeContact === "contato3" && (
                        <div id="contato3" className="contact-details active">
                            <p>
                                <strong>Celular:</strong> (31) 97777-3333
                            </p>
                            <p>
                                <strong>Email:</strong> carlos@empresaz.com
                            </p>
                            <p>
                                <strong>LinkedIn:</strong>{" "}
                                <a href="#">linkedin.com/in/carloslima</a>
                            </p>
                            <div className="actions">
                                <button className="btn-edit">Editar</button>
                                <button className="btn-delete">Excluir</button>
                            </div>
                        </div>
                    )}
                </ul>
            </div>
        </div>
    );
}
