package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-02
 * Copyright  "Commercegate LTD"
 */
@Controller
public class HomeController {
    @GetMapping(value="/")
    public String index() {
        return "index";
    }
}
