import { useState, useEffect } from "react";
import Container from "react-bootstrap/Container";
import Card from "react-bootstrap/Card";


export function CommentListPage(){

    const[comments, setComments] = useState([]);

    const fetchBlogs = async => {
        fetch("/api/v1/comments")
        .then((response) => response.json())
        .then((jsonResponse) => setComments(jsonResponse));
  };

  useEffect(() => {
    fetchBlogs();
  }, []);



    return (
<Container style={{ width: "45rem" }}>
    <Card>
        <Card.Body>
            <div>
                <h3>Komentarai</h3>
                
                <table className="">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Autorius</th>
                  <th>Komentaras</th>
                  <th>Publikuota</th>
                </tr>
              </thead>
              <tbody>
                {comments.map((comment) => (
                    <tr key={comment.id}>
                        <td>{comment.author}</td>
                        <td>{comment.text}</td>
                        <td>{comment.publishingDate}</td>
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