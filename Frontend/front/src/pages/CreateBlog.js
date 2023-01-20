import { useState } from "react";
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
      document.getElementById('title').style.borderColor = "red";
      window.alert("Su tuscia antraste sukurti neleidziama. Klaidos statusas: " + result.status);
      
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
                <legend><b>Naujas irasas</b></legend>
            </fieldset>

            <Form>
                <Form.Group className="mb-3" controlId="formTitle">
                    <Form.Label htmlFor="title">Antraste</Form.Label>
                    <Form.Control
                    id="title"
                    placeholder="Naujas straipsnis"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formContent">
                    <Form.Label htmlFor="content">Tekstas</Form.Label>
                    <Form.Control
                    as="textarea" rows={5} 
                    id="content"
                    placeholder="Straipsnio tekstas..."
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formType">
                    <Button variant="outline-dark" onClick={createBlog}>
                    Publikuoti
                    </Button>
                </Form.Group>
            </Form>
        </Card.Body>
    </Card>
</Container>
)

}