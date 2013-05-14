/*
 * The MIT License
 *
 * Copyright 2012 jdmr.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mx.edu.um.mateo.general.web;

import mx.edu.um.mateo.general.dao.InicializaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jdmr
 */
@Controller
@RequestMapping("/inicializa")
public class InicializaController {

    private static final Logger log = LoggerFactory
            .getLogger(InicializaController.class);
    @Autowired
    private InicializaDao inicializaDao;

    @RequestMapping
    public String inicia() {
        return "/inicializa/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String guarda(@RequestParam String username,
            @RequestParam String password) {

        log.debug("Inicializando...");
        inicializaDao.inicializa(username, password);

        return "redirect:/";
    }
    
     @RequestMapping(value = "inicializaRoles")
    public String inicializaRoles() {
        return "/inicializa/guardaRoles";
    }
    
     @RequestMapping(value = "guardaRoles",method = RequestMethod.POST)
    public String guardaRoles(@RequestParam String username,
            @RequestParam String password,@RequestParam String roles) {

        log.debug("Inicializando roles...");
        inicializaDao.inicializaRoles(username, password, roles);

        return "redirect:/";
    }
}


