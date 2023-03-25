package com.cgi.library.controller;

import com.cgi.library.model.CheckOutDTO;
import com.cgi.library.service.CheckOutService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {

    @Autowired
    private CheckOutService checkOutService;

    @GetMapping(value = "getCheckouts")
    public String getCheckOuts() throws JsonProcessingException {
        return checkOutService.getCheckOuts();
    }

    @GetMapping(value = "getCheckout")
    public ResponseEntity<CheckOutDTO> getCheckOut(@RequestParam(value = "checkOutId") UUID checkOutId) {
        return ResponseEntity.ok(checkOutService.getCheckOut(checkOutId));
    }

    @PostMapping(value = "checkout")
    public ResponseEntity<String> saveCheckOut(@RequestBody CheckOutDTO checkOutDTO) {
        checkOutService.saveCheckOut(checkOutDTO);
        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "checkout")
    public ResponseEntity<String> deleteCheckOut(@RequestParam(value = "checkOutId") UUID checkOutId) {
        checkOutService.deleteCheckOut(checkOutId);
        return ResponseEntity.ok("");
    }
}
