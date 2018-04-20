package com.db.custodysupport.ccassservice.controller;

import com.db.custodysupport.ccassservice.model.Trade;
import com.db.custodysupport.ccassservice.model.TradeRequest;
import com.db.custodysupport.ccassservice.service.CcassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/")
public class CcassController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CcassController.class);

    @Autowired
    private CcassService ccassService;


    @GetMapping("test")
    public @ResponseBody String getTest(){
        LOGGER.info("The time is: {}", LocalDateTime.now());
        return "The time is: " + LocalDateTime.now();
    }


    @RequestMapping(value = "trade", method = RequestMethod.POST)
    public ResponseEntity<Trade> getTrade(@RequestBody TradeRequest request){
        LOGGER.info("The getTrade POST request: {}", request);
        Trade trade = null;

        //TODO: Add error conditions if trade is null
        if(request != null)
            trade = ccassService.getTrade(request);

        HttpStatus httpStatus;
        if(trade != null)
            httpStatus = HttpStatus.OK;
        else
            httpStatus = HttpStatus.NO_CONTENT;

        return new ResponseEntity<>(trade, httpStatus);
    }

    @GetMapping(value = "trade/{tradeId}")
    public ResponseEntity<Trade> getTrade(@PathVariable String tradeId){
        LOGGER.info("The getTrade GET request: {}", tradeId);
        Trade trade = null;

        //TODO: Add error conditions if trade is null
        if(tradeId != null)
            trade = ccassService.getTrade(tradeId);

        HttpStatus httpStatus;
        if(trade != null)
            httpStatus = HttpStatus.OK;
        else
            httpStatus = HttpStatus.NO_CONTENT;

        return new ResponseEntity<>(trade, httpStatus);
    }

}
