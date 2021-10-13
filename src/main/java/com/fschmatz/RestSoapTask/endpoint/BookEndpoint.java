package com.fschmatz.RestSoapTask.endpoint;

import com.fschmatz.RestSoapTask.controller.BookController;
import com.fschmatz.RestSoapTask.soap.GetBookRequest;
import com.fschmatz.RestSoapTask.soap.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {

    //private static final String NAMESPACE_URI = "http://localhost:8080/xml";

    @Autowired
    private BookController bookController;

    @PayloadRoot(localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request){
        GetBookResponse response = new GetBookResponse();
        response.setTitle(bookController.findById(request.getId()));
        return response;
    }
}
