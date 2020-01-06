package com.encurtador.msurlread.controller;

import com.encurtador.msurlread.domain.OriginalURLDTO;
import com.encurtador.msurlread.exception.URLNotFoundException;
import com.encurtador.msurlread.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/v1")
public class ShortURLRedirectController {

    @Autowired
    private ShortURLService shortURLService;

    @GetMapping(value = "/{shortURL}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView redirectToOriginalURL(@PathVariable("shortURL") String shortURL) throws URLNotFoundException {

        final OriginalURLDTO originalURLDTO = this.shortURLService.getOriginalURLForRedirect(shortURL);

        return new ModelAndView("redirect:" + originalURLDTO.getOriginalURL());
    }

}
