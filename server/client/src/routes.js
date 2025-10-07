import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Contact from "./pages/Contact";
import NewContact from "./pages/NewContact";

export default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/contacts" element={<Contact />} />
                <Route path="/contacts/new" element={<NewContact />} />
            </Routes>
        </BrowserRouter>
    );
}
