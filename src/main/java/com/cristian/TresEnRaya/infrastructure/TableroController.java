package com.cristian.TresEnRaya.infrastructure;

import com.cristian.TresEnRaya.application.TableroUseCases;
import com.cristian.TresEnRaya.domain.TableroRepository;
import com.cristian.TresEnRaya.infrastructure.data.TableroRepositoryMysql;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableroController {
    private TableroRepository tableroRepository;
    public TableroController() {
        this.tableroRepository = new TableroRepositoryMysql();
    }
    @GetMapping("/tictactoe")
    public String mostrarTablero(Model model){
        model.addAttribute("tablero", this.tableroRepository.mostrarTablero());
        return "tablero";
    }

}
