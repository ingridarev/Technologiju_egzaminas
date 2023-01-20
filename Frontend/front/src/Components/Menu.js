import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';

export function Menu() {
    return (<div className="Menu">
        <Link to='/'><Button variant="outline-secondary m-2">Blog List</Button></Link>
        <Link to='/create'><Button variant="outline-secondary">Create New Blog</Button></Link>
    </div>);
}