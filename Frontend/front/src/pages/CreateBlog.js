import { useState, useEffect } from "react";
import { useHref } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import Form from 'react-bootstrap/Form';


export function CreateBlogPage(props){
const [title, setTitle] = useState("");
const [content, setContent] = useState("");
const [publishingDate, setPublishingDate] = useState("");

const listUrl = useHref("/");

const clear = () => {
    setTitle("");
    setContent("");
    setPublishingDate("");
  };

  const applyResult = (result) => {
    if (result.ok) {
      clear();
    } else {
      window.alert("Nepavyko sukurti:" + result.status);
    }
  };

  const createBlog = () => {
    fetch("api/v1/blogs", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title,
        content,
        publishingDate,
      }),
    })
      .then(applyResult)
      .then(() => (window.location = listUrl));
  };

return(
<Container style={{width: "25rem"}}>
      <Card>
        <Card.Body>
            <fieldset id="create">
                <legend>Create New Holiday</legend>
            </fieldset>

            <Form>
                <Form.Group className="mb-3" controlId="formTitle">
                    <Form.Label htmlFor="title">Title</Form.Label>
                    <Form.Control
                    id="title"
                    placeholder="Title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formContent">
                    <Form.Label htmlFor="content">Content</Form.Label>
                    <Form.Control
                    id="content"
                    placeholder="Content"
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formType">
                    <Button variant="outline-dark" onClick={createBlog}>
                    Create
                    </Button>
                </Form.Group>
            </Form>
        </Card.Body>
    </Card>
</Container>
)

}