package com.dao.service;

import com.dao.report.NotificationReport;
import com.dao.repository.AppRemindRepository;
import com.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-09-29
 * Copyright  "Commercegate LTD"
 */
@Service
@Transactional
public class NotificationService {
    @Autowired
    private AppRemindRepository appRemindRepository;
    @Autowired
    private OrderRepository orderRepository;

    public NotificationReport findAll() {
        NotificationReport report = new NotificationReport();
        report.setReminds(appRemindRepository.countAllByProcessed(false));
        report.setOrders(orderRepository.countAllByProcessed(false));

        return report;
    }

}
