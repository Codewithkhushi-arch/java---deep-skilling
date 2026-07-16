import { useState } from 'react';

function App() {
  const [name, setName] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Form submitted with Name: " + name);
  };

  return (
    <div>
      <h1>React Forms (Controlled Components)</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Name: 
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        </label>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
export default App;
