package com.cristian.TresEnRaya.domain;

public class Tablero {
    private Integer fila,columna,jugador;

    public Tablero(Integer fila, Integer columna, Integer jugador) {
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }

    public Integer getFila() {
        return fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public Integer getJugador() {
        return jugador;
    }
}
