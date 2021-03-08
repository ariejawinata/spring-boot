package id.co.mandiri.induction.springboot.service;

import id.co.mandiri.induction.springboot.model.request.CalculateRequest;
import id.co.mandiri.induction.springboot.model.response.CalculateResponse;
import org.springframework.http.ResponseEntity;

public interface RoomService {

    void calculateReturnEmpty(CalculateRequest calculateRequest);
    CalculateResponse calculateReturnOk(CalculateRequest calculateRequest);
    ResponseEntity<CalculateResponse> calculateReturnError(CalculateRequest calculateRequest);

}
