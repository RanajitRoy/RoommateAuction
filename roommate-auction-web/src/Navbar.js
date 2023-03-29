import "./Navbar.css"
import { NavLink } from "react-router-dom";

function Navbar() {
    return (
        <nav className="navbar navbar-dark bg-dark">
            <div className="container">
                <div className="d-flex flex-wrap align-items-center justify-content-start justify-content-lg-start w-100 p-2">
                    <NavLink to="/" className="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <img className="bi me-2" height="60" alt="logo" src="android-chrome-512x512.png" />
                    </NavLink>
                    <NavLink to="/" className="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <img className="bi mx-3 mt-3 mb-3" height="50" alt="logo" src="logo-text.png" />
                    </NavLink>

                    <ul className="nav justify-content-center align-items-center margin-left-auto me-2">
                        <li><NavLink href="/" className="nav-link px-2 text-secondary">Rooms</NavLink></li>
                        <li><NavLink href="/" className="nav-link px-2 text-white">Auction</NavLink></li>
                    </ul>

                    <div className="text-end">
                        <button type="button" className="btn btn-primary me-2">Login</button>
                        <button type="button" className="btn btn-primary me-2">Sign-up</button>
                    </div>
                </div>
            </div>
        </nav>
    );
}

export default Navbar;