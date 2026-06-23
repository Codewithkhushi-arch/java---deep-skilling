package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> getFacebookStocksInSeptember2019() {
        try {
            Date start = dateFormat.parse("2019-09-01");
            Date end = dateFormat.parse("2019-09-30");
            return stockRepository.findByCodeAndDateBetween("FB", start, end);
        } catch (ParseException e) {
            throw new RuntimeException("Date parsing failed", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Stock> getGoogleStocksGreaterThan1250() {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250.00"));
    }

    @Transactional(readOnly = true)
    public List<Stock> getTop3HighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional(readOnly = true)
    public List<Stock> getLowest3NetflixStocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
