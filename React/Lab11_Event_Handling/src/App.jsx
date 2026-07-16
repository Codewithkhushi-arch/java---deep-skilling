import { useState } from 'react';

function App() {
  const [msg, setMsg] = useState("");

  const handleClick = (e) => {
    // e is a React SyntheticEvent
    setMsg("Button clicked at " + new Date().toLocaleTimeString());
  };

  return (
    <div>
      <h1>Event Handling</h1>
      <button onClick={handleClick}>Click Me!</button>
      <p>{msg}</p>
    </div>
  );
}
export default App;
