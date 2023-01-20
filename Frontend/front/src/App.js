import { HashRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BlogListPage } from './pages/BlogList';
import { CreateBlogPage } from './pages/CreateBlog';
import { Menu } from './Components/Menu';
import { ViewBlog} from './pages/ViewBlog';

function App() {
  return (
    <div className="App">
      <h2>Blogging platform</h2>
      <HashRouter>
        <Menu />
        <Routes>
          <Route path="/" element={<BlogListPage/>}/>
          <Route path="/create" element={<CreateBlogPage/>} />
          <Route path='/blogs/view/:id' element={<ViewBlog />} />
        </Routes>

      </HashRouter>
    </div>
  );
}

export default App;
