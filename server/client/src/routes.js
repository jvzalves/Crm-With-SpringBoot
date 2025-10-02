import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/login";
import Contact from "./pages/contact";

export default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/contacts" element={<Contact />} />
            </Routes>
        </BrowserRouter>
    );
}
