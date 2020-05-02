import React, { Component } from 'react';
import {instanceOf} from "prop-types";
import {Cookies} from "react-cookie";
import {Button, ButtonGroup, Container, Table} from "reactstrap";
import {Link} from "react-router-dom";
import AppNavbar from "./AppNavbar";
import NavLink from "react-router-dom/es/NavLink";

class CategoryList extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    constructor(props) {
        super(props);
        const {cookies} = props;
        this.state = {categories: [], isLoading: true};
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/categories', {credentials: 'include'})
            .then(response => response.json())
            .then(data => this.setState({categories: data, isLoading: false}))
            .catch(() => this.props.history.push('/'));
    }

    render(){
        const {categories, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const catList = categories.map(cat => {
            return <Button size="sm" color="primary" tag={Link} to={"/products/" + cat.id}>{cat.name}</Button>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        {/*<Button color="success" tag={Link} to="/groups/new">Add Group</Button>*/}
                    </div>
                    <h3>Categories: </h3>
                    {catList}
                </Container>
            </div>
        );

    }

}

export default CategoryList;