package U9.transacciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfficeModel {
    /**
     * Método para insertar oficinas en la tabla offices
     * @param office
     * @throws SQLException
     */
    public static Integer insertOffice(Office office) throws SQLException {
        Integer rowsAffected = 0;

        Connection connection = ConnectionDataBase.getConnection();

        String sentenciaSQL = "INSERT INTO offices VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL);

        preparedStatement.setString(1, office.getOfficeCode());
        preparedStatement.setString(2, office.getCity());
        preparedStatement.setString(3, office.getPhone());
        preparedStatement.setString(4, office.getAddressLine1());
        preparedStatement.setString(5, office.getAddressLine2());
        preparedStatement.setString(6, office.getState());
        preparedStatement.setString(7, office.getCountry());
        preparedStatement.setString(8, office.getPostalCode());
        preparedStatement.setString(9, office.getTerritory());

        rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected;
    }
}
