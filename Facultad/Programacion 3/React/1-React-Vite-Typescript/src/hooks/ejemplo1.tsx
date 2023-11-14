import { useState } from "react";

function Counter() {
    const [count, setCount] = useState(0)
    return(
        <>
        <p>Contador: {count}</p>
        <button onClick={() => setCount(count => count + 1 )}>Aumentar</button>
        </>
    )
}