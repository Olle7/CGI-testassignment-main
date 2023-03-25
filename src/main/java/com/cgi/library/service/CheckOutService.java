package com.cgi.library.service;

import com.cgi.library.entity.CheckOut;
import com.cgi.library.model.CheckOutDTO;
import com.cgi.library.repository.CheckOutRepository;
import com.cgi.library.util.ModelMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CheckOutService {

    @Autowired
    private CheckOutRepository checkOutRepository;

    public String getCheckOuts() throws JsonProcessingException {
        List<CheckOut> checkOuts = checkOutRepository.findAll();
        String json = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(checkOuts);
        return json;
    }

    public CheckOutDTO getCheckOut(UUID checkOutId) {
        CheckOut checkOut = checkOutRepository.getOne(checkOutId);
        return ModelMapperFactory.getMapper().map(checkOut, CheckOutDTO.class);
    }

    public void saveCheckOut(CheckOutDTO checkOutDTO) {
        checkOutRepository.save(ModelMapperFactory.getMapper().map(checkOutDTO, CheckOut.class));
    }

    public void deleteCheckOut(UUID checkOutId) {
        checkOutRepository.deleteById(checkOutId);
    }
}
