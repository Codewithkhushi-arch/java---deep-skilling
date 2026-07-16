function App() {
  const technologies = ["Java", "Spring Boot", "React", "Node.js"];

  return (
    <div>
      <h1>ES6 map() Demonstration</h1>
      <ul>
        {technologies.map((tech, index) => (
          <li key={index}>{tech}</li>
        ))}
      </ul>
    </div>
  );
}
export default App;
