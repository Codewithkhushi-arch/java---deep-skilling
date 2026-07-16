function Greeting(props) {
  return <h1>Hello, {props.name}! Welcome to {props.course}</h1>;
}

function App() {
  return (
    <div>
      <Greeting name="Java Developer" course="React Skilling" />
    </div>
  );
}
export default App;
