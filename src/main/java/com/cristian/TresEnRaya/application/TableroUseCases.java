package com.cristian.TresEnRaya.application;
import com.cristian.TresEnRaya.domain.Tablero;
import com.cristian.TresEnRaya.domain.TableroRepository;

public class TableroUseCases {
    private final TableroRepository tableroRepository;
    public TableroUseCases(TableroRepository tableroRepository){this.tableroRepository=tableroRepository;}
    public void movimiento(Tablero tablero){this.tableroRepository.movimiento(tablero);}
    public void limpia(){this.tableroRepository.limpia();}
}
