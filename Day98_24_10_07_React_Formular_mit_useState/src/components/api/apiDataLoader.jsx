import { useEffect, useState } from "react";
import "./apiDataLoader.scss";

export default function ApiDataLoader() {
    const [task, setTask] = useState("Task");
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            try {
            const response = await fetch('https://jsonplaceholder.typicode.com/todos/5');
            const data = await response.json();
            setTask(data);
            setLoading(false);
            } catch (error) {
                setLoading(false);
            } 
    };

    fetchData();
    return () => console.log(task);
}, []);

    console.log(task);
    return (
        <article id="apiLoader">
            <h2>API Daten:</h2>
            
            {loading ? 
            <p>
                Lädt...
            </p>
            
            :
            task.id == null ?
            
            <p>
                Keine Daten verfügbar
            </p>
            
            :
            
            <>
            <p>ID: {task.id}</p>
            <p>Title: {task.title}</p>
            <p>Status: {task.completed ? "Fertig" : "Unvollständig"}</p>
            </>

            }
            

            
        </article>

    );
};