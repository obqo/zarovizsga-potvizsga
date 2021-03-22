package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private final DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select ip_address from people where first_name = ? and last_name = ?")) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            return selectIpByNameByPS(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private String selectIpByNameByPS(PreparedStatement ps) {
        String result = null;
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result = rs.getString("ip_address");
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }
}
