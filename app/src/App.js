import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GroupList from './GroupList';
import GroupEdit from './GroupEdit';
import { CookiesProvider } from 'react-cookie';
import CategoryList from "./CategoryList";
import ProductList from "./ProductList";

class App extends Component {
  render() {
    return (
      <CookiesProvider>
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/groups' exact={true} component={GroupList}/>
            <Route path='/groups/:id' component={GroupEdit}/>
            <Route path='/products/:id' component={ProductList}/>
            <Route path='/categories' exact={true} component={CategoryList}/>
          </Switch>
        </Router>
      </CookiesProvider>
    )
  }
}

export default App;