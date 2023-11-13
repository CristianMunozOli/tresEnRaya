package com.cristian.TresEnRaya.infrastructure.data;

import com.cristian.TresEnRaya.domain.Tablero;
import com.cristian.TresEnRaya.domain.TableroRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    @Override
    public String[][] mostrarTablero() {
        String[][] partida=new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                partida[i][j]="";
            }
        }
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from tablero");
            while (rs.next()){
                Tablero tablero = new Tablero(
                        rs.getInt("fila"),
                        rs.getInt("columna"),
                        rs.getInt("jugador")
                );
                if(tablero.getJugador()==1)
                    partida[tablero.getFila()-1][tablero.getColumna()-1]="O";
                else
                    partida[tablero.getFila()-1][tablero.getColumna()-1]="X";
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return partida;
    }

}
