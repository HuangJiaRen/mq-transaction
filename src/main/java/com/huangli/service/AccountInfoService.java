package com.huangli.service;

import com.huangli.dao.domain.AccountChangeEvent;

public interface AccountInfoService {

    //更新账户，增加金额
    public void addAccountInfoBalance(AccountChangeEvent accountChangeEvent);
}