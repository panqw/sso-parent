package com.sso.user.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.user.model.User;
import com.sso.user.model.command.UserCommand;
import com.sso.user.service.UserService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author panqw
 * @since 2020-06-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @PostMapping("/findUserInfo1")
    public User findUserInfo(@RequestParam("username") String username) {
        return userService.findById(username);
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody @Valid UserCommand command){
        try {
            int i = userService.register(command);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
        return new Result(true, StatusCode.OK,"注册成功");
    }


    @PostMapping("/senndMq")
    public  Result sendMq() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String msg = "发送rocketMq";

        Message sendMsg = new Message("TopicTest", "TestTag", msg.getBytes());
        // 默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);

        return new Result(true, StatusCode.OK,"注册成功");
    }
}
