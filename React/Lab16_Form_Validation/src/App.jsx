import { useState } from 'react';

function App() {
  const [email, setEmail] = useState("");
  const [error, setError] = useState("");

  const validate = (val) => {
    setEmail(val);
    if (!val.includes("@")) {
      setError("Invalid email address. Must contain '@'");
    } else {
      setError("");
    }
  };

  return (
    <div>
      <h1>Form Validation</h1>
      <input 
        type="email" 
        value={email} 
        onChange={(e) => validate(e.target.value)} 
        placeholder="Enter email"
      />
      {error && <p style={{color: "red"}}>{error}</p>}
    </div>
  );
}
export default App;
