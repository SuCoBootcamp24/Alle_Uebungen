import { useState } from "react";
import Person from "../person";
import "./formular.scss";

export default function Formular() {
   
    const [person, setPerson] = useState([])
    const [name, setName] = useState("");
    const [age, setAge] = useState("");
    const [toggle, setToggle] = useState(false)

    function add() {
        const p = {
            name,
            age
        };
        setPerson(old => [...old, p]);
        document.getElementById("nameInput").value="";
        document.getElementById("ageInput").value="";
    };

    return (
        <article id="formular">
            <h2>
                Formular mit useState
            </h2>
            
            <label htmlFor="nameInput">Name:</label>
            <input onChange={(event) => setName(event.target.value)} type="text" id="nameInput"/>

            <label htmlFor="ageInput">Alter:</label>
            <input onChange={(event) => setAge(event.target.value)} type="text" id="ageInput"/>

            <button onClick={() => {
                add()
                setToggle(true)
            }}>
                Submit
            </button>

            <div>

                {toggle ?
                <>
                    <h3>
                    Übermittelte Daten:
                    </h3>
                    {person.map(element => <Person name={element.name} age={element.age} />)}
                </>
                :
                <></>
                }
           
            </div>

        </article>

    );
};