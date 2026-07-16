import React, { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { message: 'Loading...' };
  }

  componentDidMount() {
    // Simulate an API call or initialization
    setTimeout(() => {
      this.setState({ message: 'Component successfully mounted!' });
    }, 1500);
  }

  render() {
    return (
      <div>
        <h1>Lifecycle Hooks Demonstration</h1>
        <p>{this.state.message}</p>
      </div>
    );
  }
}
export default App;
