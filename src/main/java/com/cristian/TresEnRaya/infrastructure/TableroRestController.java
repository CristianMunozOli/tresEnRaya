package com.cristian.TresEnRaya.infrastructure;

import com.cristian.TresEnRaya.application.TableroUseCases;
import com.cristian.TresEnRaya.domain.Tablero;
import com.cristian.TresEnRaya.infrastructure.data.TableroRepositoryMysql;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableroRestController {
    private TableroUseCases tableroUseCases;

    public TableroRestController() {
        this.tableroUseCases=new TableroUseCases(new TableroRepositoryMysql());
    }
    @PostMapping(path ="/movimiento/{fila}/{columna}/{jugador}")
    public void movimiento(@PathVariable Integer fila,@PathVariable Integer columna,@PathVariable Integer jugador){
        Tablero tablero = new Tablero(fila,columna,jugador);
        this.tableroUseCases.movimiento(tablero);
    }
    @PostMapping(path ="/limpia")
    public void limpia(){
        this.tableroUseCases.limpia();
    }
}
