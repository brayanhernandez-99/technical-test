package com.hackerrank.tradingplatform.controller;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.TraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/trading/traders")
public class TraderController {
    @Autowired
    private TraderService traderService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerTrader(@RequestBody @Valid Trader trader) {
        traderService.registerTrader(trader);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TraderDTO> getAllTraders() {
        return traderService.getAllTraders()
                .stream()
                .map(TraderDTO::new)
                .toList();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TraderDTO getTraderByEmail(@RequestParam("email") String email) {
        return new TraderDTO(traderService.getTraderByEmail(email));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateTrader(@RequestBody @Valid UpdateTraderDTO trader) {
        traderService.updateTrader(trader);
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addMoney(@RequestBody @Valid AddMoneyTraderDTO trader) {
        traderService.addMoney(trader);
    }
}
