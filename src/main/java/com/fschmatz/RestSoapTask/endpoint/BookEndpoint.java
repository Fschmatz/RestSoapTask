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

    @Autowired
    private BookController bookController;

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service",localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBookRequest(@RequestPayload GetBookRequest request){
        GetBookResponse response = new GetBookResponse();
        response.setTitle(bookController.findByIdSoap(request.getId()));
        return response;
    }
}
