package com.lambdaschool.piggybank.repositories;

import com.lambdaschool.piggybank.models.CoinModel;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<CoinModel, Long>
{
}
