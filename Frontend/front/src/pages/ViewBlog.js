import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { HolidayAgencyMover } from "../components/HolidayAgencyMover";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";

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

            <div>
                <b>Title</b>
            </div>
                <div>{blog.title}</div>

            <div>
                <b>Content</b>
            </div>
                <div>{blog.content}</div>

            <div>
                <b>Publishing Date</b>
            </div>
                <div>{blog.publishingDate}</div>
                
            </Card.Body>
        </Card>
    </Container>
    )
}