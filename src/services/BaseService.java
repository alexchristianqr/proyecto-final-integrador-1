package services;

import core.services.MysqlDBService;

public abstract class BaseService {

    public MysqlDBService db;
    public String querySQL_1, querySQL_2, querySQL_3, querySQL_4;
}
