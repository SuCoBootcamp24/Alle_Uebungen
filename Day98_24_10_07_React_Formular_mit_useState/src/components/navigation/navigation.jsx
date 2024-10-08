import { Link } from "react-router-dom";
import './navigation.scss';

export default function Navigation() {
    return (
        <nav>
            <Link to="/">Home</Link>
            <Link to="/apiLoader">API Loader</Link>
            <Link to="/buttonClicker">Button Clicker</Link>
            <Link to="/formular">Formular</Link>
        </nav>
    );
};