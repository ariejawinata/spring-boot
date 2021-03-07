package id.co.mandiri.induction.springboot.controller;

import id.co.mandiri.induction.springboot.model.entity.CalculateRequest;
import id.co.mandiri.induction.springboot.model.entity.CalculateResponse;
import id.co.mandiri.induction.springboot.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/{variable}")
    public String variable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/param/{variable}")
    public String param(@PathVariable String variable, @RequestParam(defaultValue = "ikea") String chair) {
        return variable + " " + chair;
    }

    @PostMapping(value = "/calculate-empty", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void calculateReturnEmpty(@RequestBody CalculateRequest request) {
        roomService.calculateReturnEmpty(request);
    }

    @PostMapping(value = "/calculate-ok", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CalculateResponse calculateReturnOk(@RequestBody CalculateRequest request) {
        return roomService.calculateReturnOk(request);
    }

    @PostMapping(value = "/calculate-error", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculateResponse> calculateReturnError(@RequestBody CalculateRequest request) {
        return roomService.calculateReturnError(request);
    }

}
