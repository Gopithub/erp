import React from "react";
import './App.css';
class App extends React.Component {
   
    // Constructor 
    constructor(props) {
        super(props);
   
        this.state = {
            items: [],
            DataisLoaded: false
        };
    }
   
    // ComponentDidMount is used to
    // execute the code 
    componentDidMount() {
        fetch(
"http://localhost:8080/erp/individual/1")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    items: json,
                    DataisLoaded: true
                });
            })
    }
    render() {
        const { DataisLoaded, items } = this.state;
        if (!DataisLoaded) return <div>
            <h1> Pleses wait some time.... </h1> </div> ;
   
        return (
        <div className = "App">
            <h1> Fetch data from an api in react </h1>  {
                items.map((item) => ( 
                <ol key = { item.id } >
                    Individual Name: { item.firstName } {item.lastName}, 
                    Organisation: { item.name }, 
                    Location: { item.city.state } 
                    </ol>
                ))
            }
        </div>
    );
}
}
   
export default App;