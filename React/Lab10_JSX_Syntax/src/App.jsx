function App() {
  const title = "JSX Syntax Rules";
  const isImportant = true;

  return (
    <div style={{ padding: "20px", border: isImportant ? "2px solid red" : "1px solid gray" }}>
      <h1>{title}</h1>
      <p>JSX looks like HTML but is actually JavaScript. Expressions are evaluated inside curly braces.</p>
    </div>
  );
}
export default App;
