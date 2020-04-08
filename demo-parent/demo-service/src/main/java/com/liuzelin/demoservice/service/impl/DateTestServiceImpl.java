package com.liuzelin.demoservice.service.impl;

import com.liuzelin.demobase.util.DateUtil;
import com.liuzelin.demoservice.service.DateTestService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value="DateTestService")
public class DateTestServiceImpl implements DateTestService {

    @Override
    public String sayDate() {
        return DateUtil.dateToStr(new Date());
    }
}
