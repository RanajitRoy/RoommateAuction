import "./NotFound.css"
import svg404 from '../assets/404.svg'

export default function NotFound() {
    return (
        <div className="d-flex justify-content-center" >
            <img src={svg404} alt="404 Page not found" className="w-50" />
        </div>
    );
}