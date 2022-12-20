import { FaLinkedin } from 'react-icons/fa';
import { FaGithub } from 'react-icons/fa';

function Footer(){

    return(
        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; 2022 Biblioteca</p>
            <ul class="list-inline">
            <li class="list-inline-item"><a href="https://www.linkedin.com/in/william-henrique-campos-98568813a/"><FaLinkedin style={{fontSize: "3.5em", color:"gray"}} /></a></li>
            <li class="list-inline-item"><a href="https://github.com/willhc1984"><FaGithub style={{fontSize: "3.5em", color:"gray"}} /></a></li>
            </ul>
        </footer>
    )
}

export default Footer;