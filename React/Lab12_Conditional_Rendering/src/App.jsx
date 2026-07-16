import { useState } from 'react';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div>
      <h1>Conditional Rendering</h1>
      {isLoggedIn ? (
        <h2>Welcome back, User!</h2>
      ) : (
        <h2>Please log in.</h2>
      )}
      <button onClick={() => setIsLoggedIn(!isLoggedIn)}>
        Toggle Login State
      </button>
    </div>
  );
}
export default App;
