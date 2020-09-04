package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.CoinModel;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository crepos;

    NumberFormat currency = NumberFormat.getCurrencyInstance();

    //http://localhost:2020/coins/all
    @GetMapping(value = "coins/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCoins()
    {
        List<CoinModel> coinList = new ArrayList<>();

        crepos.findAll().iterator().forEachRemaining(coinList :: add);

        for ( CoinModel c: coinList)

        {
            if (c.getQuantity() > 1)
            {
                System.out.println(c.getQuantity() + c.getNameplural() + "\n");
            }
            else {
                System.out.println(c.getQuantity() + c.getCoinname() + "\n");
            }
        }

        return new ResponseEntity<>(coinList, HttpStatus.OK);
    }

    @GetMapping( value = "/coins/total", produces = {"application/json"})
    public ResponseEntity<?> getTotalBankValue()
    {
        List<CoinModel> coinModelList = new ArrayList<>();

        crepos.findAll().iterator().forEachRemaining( coinModelList :: add );

        double bankTotal = 0;

        for (CoinModel c : coinModelList)
        {
            bankTotal = bankTotal + c.getValue() * c.getQuantity();
        }

        System.out.println("The Piggy Bank Holds: " + currency.format(bankTotal));
        return new ResponseEntity<>(bankTotal, HttpStatus.OK);
    }
}
