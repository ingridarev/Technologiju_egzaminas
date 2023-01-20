import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Card from "react-bootstrap/Card";


const JSON_HEADERS = {
    "Content-Type": "application/json",
  };

export function BlogListPage(){

    const[blogs, setBlogs] = useState([]);

    const fetchBlogs = async => {
        fetch("/api/v1/blogs")
        .then((response) => response.json())
        .then((jsonResponse) => setBlogs(jsonResponse));
  };

  useEffect(() => {
    fetchBlogs();
  }, []);

  // const removeBlog = (id) => {
  //   fetch("/api/v1/blogs/" + id, {
  //     method: "DELETE",
  //     headers: JSON_HEADERS,
  //   }).then(fetchBlogs);
  // };

    return (
<Container style={{ width: "45rem" }}>
    <Card>
        <Card.Body>
            <div>
                <h3>Blog List</h3>
                
                <table className="">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Antraste</th>
                  <th>Tekstas</th>
                  <th>Publikuota</th>
                </tr>
              </thead>
              <tbody>
                {blogs.map((blog) => (
                  <tr key={blog.id}>
                    <td>
                      <Link to={"/blogs/view/" + blog.id}>
                        {blog.id} Skaityti daugiau
                      </Link>
                    </td>
                    <td>{blog.title}</td>
                    <td>{blog.content}</td>
                    <td>{blog.publishingDate}</td>
                    <td>
                      {/* <Link to={"/holidays/update/" + blog.id}>
                        <Button variant="outline-secondary m-2">Update</Button>
                      </Link>
                      <Button
                        variant="outline-danger"
                        onClick={() => removeBlog(blog.id)}>
                        Remove
                      </Button> */}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>

            </div>
        </Card.Body>
    </Card>
</Container>
    )
}