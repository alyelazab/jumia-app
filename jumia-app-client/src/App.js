import React from "react";
import {AgGridColumn, AgGridReact} from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-balham-dark.css';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            customerInfo: []
        }

        this.getData = this.getData.bind(this);
    }

    componentDidMount() {
        const data = this.getData();

    }

    getData() {
        fetch('http://localhost:8080/customers/getInfo')
            .then(response => response.json())
            .then(
                (res => this.setState({
                    customerInfo: res.map((entry) => ({
                        id: entry.id,
                        name: entry.name,
                        number: entry.number,
                        countryCode: entry.countryCode,
                        country: entry.country,
                        state: entry.state
                    }))
                })))


    }

    render() {
        return (
            <div className="ag-theme-balham-dark" style={{height: 750, width: 1200}}>
                <AgGridReact rowData={this.state.customerInfo} pagination={true} paginationAutoPageSize={true}>

                    <AgGridColumn field="id"></AgGridColumn>
                    <AgGridColumn field="name" sortable={true} filter={true}></AgGridColumn>
                    <AgGridColumn field="number" sortable={true} filter={true}></AgGridColumn>
                    <AgGridColumn field="countryCode" sortable={true} filter={true}></AgGridColumn>
                    <AgGridColumn field="country" sortable={true} filter={true}></AgGridColumn>
                    <AgGridColumn field="state" sortable={true} filter={true}></AgGridColumn>
                </AgGridReact>
            </div>
        );
    }
}

export default App;
