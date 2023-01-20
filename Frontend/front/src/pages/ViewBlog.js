import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import { Link } from 'react-router-dom';
import { CommentListPage } from "./CommentList";

export function ViewBlog(){
    const [blog, setBlog] = useState({});

    const params = useParams();
  
    useEffect(() => {
      fetch("/api/v1/blogs/" + params.id)
        .then((response) => response.json())
        .then(setBlog);
    }, [params.id]);


    return (
    <Container style={{ width: "25rem" }}>
        <Card>
            <Card.Body>
            <div>
                <b>ID</b>
            </div>
                <div>{blog.id}</div>

            <Form>
                <Form.Group className="mb-3" controlId="formTitle">
                    {/* <Form.Label htmlFor="title">Antraste</Form.Label> */}
                    <Form.Control
                    id="title"
                    placeholder="Title"
                    value={blog.title}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formContent">
                    {/* <Form.Label htmlFor="content">Tekstas</Form.Label> */}
                    <Form.Control
                    id="content"
                    placeholder="Content"
                    value={blog.content}
                    />
                </Form.Group>
            </Form>

            <div>
                Publishing Date
            </div>
                <div>{blog.publishingDate}</div>

                <Link to='/createComment'><Button variant="outline-secondary m-2">Rasyti komentara</Button></Link>

            </Card.Body>
        </Card>

        <div><b>Komentarai:</b></div>
        <div>
            {/* <CommentListPage /> */}
        </div>
    </Container>
    )
}