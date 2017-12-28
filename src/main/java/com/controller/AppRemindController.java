package com.controller;

import com.dao.model.AppRemind;
import com.dao.report.AppRemindReport;
import com.dao.repository.AppRemindJdbcRepository;
import com.dao.repository.AppRemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/remind")
public class AppRemindController {

    @Autowired
    private AppRemindRepository repository;
    @Autowired
    private AppRemindJdbcRepository jdbcRepository;

    @GetMapping(value = "/id/{id}")
    public AppRemind getAppRemind(@PathVariable(value = "id") Integer id) {
        return repository.findOne(id);
    }

    @GetMapping(value = "/appointment/{appointmentId}/person/{personId}")
    public List<AppRemind> getAppRemindByAppAndPeron(
            @PathVariable(value = "appointmentId") Integer appointmentId,
            @PathVariable(value = "personId") Integer personId) {
        return repository.findByAppointmentIdAndPersonId(appointmentId, personId);
    }

    @PostMapping("/")
    public AppRemind postAppRemind(@RequestBody AppRemind appRemind) {
        return repository.save(appRemind);
    }

    @PutMapping("/")
    public AppRemind putAppRemind(@RequestBody AppRemind appRemind) {
        return repository.save(appRemind);
    }
    @DeleteMapping("/")
    public void putAppRemind(@RequestBody Integer id) {
        repository.delete(id);
    }

    @GetMapping(value = "/list")
    public Page<AppRemindReport> list(@RequestParam(value = "msisdn", required = false) String msisdn, @PageableDefault(size = 20) Pageable pageable) {
        Integer total = jdbcRepository.countAllActive(msisdn);
        List<AppRemindReport> reminds = jdbcRepository.findAllActive(msisdn, pageable.getPageSize(), pageable.getOffset());
        Page<AppRemindReport> pages = new PageImpl<>(reminds, pageable, total);

        return pages;
    }
}
