package app;

import app.model.ImageLinks;

public class Response {
    public String message;
    public ImageLinks imageLinks;

    public Response(String message, ImageLinks imageLinks) {
        this.message = message;
        this.imageLinks = imageLinks;
    }
}