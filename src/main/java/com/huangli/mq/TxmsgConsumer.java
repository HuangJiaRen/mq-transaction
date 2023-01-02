package com.huangli.mq;

import com.huangli.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.huangli.dao.domain.AccountChangeEvent;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "consumer_group_txmsg_bank2",topic = "topic_txmsg")
public class TxmsgConsumer implements RocketMQListener<String> {

    @Autowired
    AccountInfoService accountInfoService;

    /**
     * 接收消息
     * @param message
     */
    @Override
    public void onMessage(String message) {
        log.info("start 消费消息:{}",message);
        //解析消息
        JSONObject jsonObject = JSONObject.parseObject(message);
        String accountChangeString = jsonObject.getString("accountChange");
        //转成AccountChangeEvent
        AccountChangeEvent accountChangeEvent = JSONObject.parseObject(accountChangeString, AccountChangeEvent.class);
        //设置账号为李四的
        accountChangeEvent.setAccountNo("2");
        //更新本地账户，增加金额
        accountInfoService.addAccountInfoBalance(accountChangeEvent);
        log.info("end 消费消息:{}",message);
    }
}