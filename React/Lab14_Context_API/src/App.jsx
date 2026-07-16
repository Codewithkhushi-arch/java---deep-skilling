import React, { createContext, useContext, useState } from 'react';

const ThemeContext = createContext();

function ChildComponent() {
  const theme = useContext(ThemeContext);
  return <p>The current theme is: <strong>{theme}</strong></p>;
}

function App() {
  const [theme, setTheme] = useState("dark");

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Context API</h1>
        <ChildComponent />
        <button onClick={() => setTheme(theme === "dark" ? "light" : "dark")}>
          Toggle Theme
        </button>
      </div>
    </ThemeContext.Provider>
  );
}
export default App;
