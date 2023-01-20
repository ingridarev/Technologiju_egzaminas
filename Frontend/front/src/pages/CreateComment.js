import { useState } from "react";
import { useHref } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import Form from 'react-bootstrap/Form';

export function CreateCommentPage(){

    const listUrl = useHref("/");

    const [author, setAuthor] = useState("");
    const [text, setText] = useState("");

    const clear = () => {
        setAuthor("");
        setText("");
      };
    
      const applyResult = (result) => {
        if (result.ok) {
          clear();
        } else {
          document.getElementById('title').style.borderColor = "red";
          window.alert("Be autoriaus vardo sukurti neleidziama. Klaidos statusas: " + result.status);
          
        }
      };
    
      const createComment = () => {
        fetch("api/v1/comments", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            author,
            text,
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
                <legend><b>Naujas komentaras</b></legend>
            </fieldset>

            <Form>
                <Form.Group className="mb-3" controlId="formAuthor">
                    <Form.Label htmlFor="author">Autorius</Form.Label>
                    <Form.Control
                    id="author"
                    placeholder="Komentaro autorius"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formText">
                    <Form.Label htmlFor="text">Tekstas</Form.Label>
                    <Form.Control
                    as="textarea" rows={5} 
                    id="text"
                    placeholder="Komentaro tekstas..."
                    value={text}
                    onChange={(e) => setText(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formType">
                <Button variant="outline-dark" onClick={createComment}>
                    Komentuoti
                </Button>
                </Form.Group>
            </Form>
        </Card.Body>
    </Card>
</Container>
        
    )
}