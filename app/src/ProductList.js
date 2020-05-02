import React, { Component } from 'react';
import {instanceOf} from "prop-types";
import {Cookies} from "react-cookie";
import {Button, ButtonGroup, Container, Table} from "reactstrap";
import {Link} from "react-router-dom";
import AppNavbar from "./AppNavbar";

class ProductList extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    constructor(props) {
        super(props);
        const {cookies} = props;
        this.state = {products: [], isLoading: true};
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/products', {credentials: 'include'})
            .then(response => response.json())
            .then(data => this.setState({products: data, isLoading: false}))
            .catch(() => this.props.history.push('/'));
    }

    render(){
        // const {products, isLoading} = this.state;
        //
        // if (isLoading) {
        //     return <p>Loading...</p>;
        // }
        //
        // const catList = products.map(cat => {
        //     return <p>
        //         {cat.name}
        //     </p>
        // });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        {/*<Button color="success" tag={Link} to="/groups/new">Add Group</Button>*/}
                    </div>
                    <h3>Products by id:  </h3>
                    {/*{products}*/}
                </Container>
            </div>
        );

    }

}

export default ProductList;