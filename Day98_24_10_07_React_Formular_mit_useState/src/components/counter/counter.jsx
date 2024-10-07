import { useState } from "react";
import "./counter.scss";
export default function Counter() {
    const [count, setCount] = useState(0);

    return (
        <article id="counterCard">
            <h2>
                Count:
            </h2>
            <h2>
                {count}
            </h2>

            <button onClick={() => setCount((count) => count +1)}>
                Increment
            </button>

        </article>
    );
};