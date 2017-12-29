package com.controller;

import com.dao.report.NotificationReport;
import com.dao.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-14
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "/all")
    public NotificationReport getAll() {
        return notificationService.findAll();
    }
}
