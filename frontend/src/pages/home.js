import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import { IoLibrarySharp } from 'react-icons/io5';
import "./home.css";

function Home(){

    return(
        <div>
            <Navbar />
            <div className="logo">
                <IoLibrarySharp />
                <h1 style={{color:"black"}}>Sistema de gestão para biblioteca</h1>
            </div>
            
            <Footer />
        </div>
        
    )

}

export default Home;