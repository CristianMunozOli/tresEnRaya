package com.cristian.TresEnRaya.infrastructure.data;

import com.cristian.TresEnRaya.domain.Tablero;
import com.cristian.TresEnRaya.domain.TableroRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableroRepositoryMysql implements TableroRepository {

    @Override
    public void movimiento(Tablero tablero) {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("INSERT INTO tablero (fila,columna,jugador) VALUES (?,?,?)");
            statement.setInt(1,tablero.getFila());
            statement.setInt(2,tablero.getColumna());
            statement.setInt(3,tablero.getJugador());
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void limpia() {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("delete from tablero");
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
