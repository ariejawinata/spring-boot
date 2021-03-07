package id.co.mandiri.induction.springboot.service;

import id.co.mandiri.induction.springboot.model.entity.CalculateRequest;
import id.co.mandiri.induction.springboot.model.entity.CalculateResponse;
import org.springframework.http.ResponseEntity;

public interface RoomService {

    void calculateReturnEmpty(CalculateRequest calculateRequest);
    CalculateResponse calculateReturnOk(CalculateRequest calculateRequest);
    ResponseEntity<CalculateResponse> calculateReturnError(CalculateRequest calculateRequest);

}
