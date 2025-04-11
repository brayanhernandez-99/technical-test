package com.hackerrank.tradingplatform.service;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraderService {
    @Autowired
    private TraderRepository traderRepository;

    public void registerTrader(Trader trader) {
        if (traderRepository.findByEmail(trader.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trader with this email already exists");
        }
        trader.setCreatedAt(Timestamp.from(Instant.now()));
        trader.setUpdatedAt(null);
        traderRepository.save(trader);
    }

    public Trader getTraderByEmail(String email) {
        return traderRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trader not found"));
    }

    public List<Trader> getAllTraders() {
        return traderRepository.findAll()
                .stream()
                .sorted((t1, t2) -> Long.compare(t1.getId(), t2.getId()))
                .collect(Collectors.toList());
    }

    public void updateTrader(UpdateTraderDTO traderDTO) {
        Trader trader = traderRepository.findByEmail(traderDTO.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trader not found"));
        trader.setName(traderDTO.getName());
        trader.setUpdatedAt(Timestamp.from(Instant.now()));
        traderRepository.save(trader);
    }

    public void addMoney(AddMoneyTraderDTO traderDTO) {
        Trader trader = traderRepository.findByEmail(traderDTO.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trader not found"));
        trader.setBalance(trader.getBalance() + traderDTO.getAmount());
        trader.setUpdatedAt(Timestamp.from(Instant.now()));
        traderRepository.save(trader);
    }
}
