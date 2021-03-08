package id.co.mandiri.induction.springboot.service.impl;

import id.co.mandiri.induction.springboot.model.request.CalculateRequest;
import id.co.mandiri.induction.springboot.model.response.CalculateResponse;
import id.co.mandiri.induction.springboot.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Override
    public void calculateReturnEmpty(CalculateRequest calculateRequest) {
        CalculateResponse calculateResponse = calculate(calculateRequest);
        System.out.println("Total = "+calculateResponse.getTotalItem());
    }

    @Override
    public CalculateResponse calculateReturnOk(CalculateRequest calculateRequest) {
        return calculate(calculateRequest);
    }

    @Override
    public ResponseEntity<CalculateResponse> calculateReturnError(CalculateRequest calculateRequest) {
        System.out.println("Chair = "+calculateRequest.getChair());
        System.out.println("Table = "+calculateRequest.getTable());
        calculate(calculateRequest);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private CalculateResponse calculate(CalculateRequest calculateRequest) {
        return CalculateResponse.builder()
                .totalItem(calculateRequest.getChair()+calculateRequest.getTable())
                .build();
    }
}
