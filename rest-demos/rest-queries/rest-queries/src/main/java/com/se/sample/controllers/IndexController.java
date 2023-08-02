package com.se.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/index")
public class IndexController {

  //  @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping
    public   Map<String, Object>  getParameters(HttpServletRequest request) {
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String)enumeration.nextElement();
            modelMap.put(parameterName, request.getParameter(parameterName));
        }

        ModelAndView modelAndView = new ModelAndView("sample");
        modelAndView.addObject("parameters", modelMap);


        return modelMap;
    }
}

