package dzz.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Objects;

/**
 * @author dzz
 */

public class JdbcUtil {
    public static void main(String[] args) throws SQLException {
        JdbcUtil jdbcUtil = new JdbcUtil("jdbc:mysql://localhost:3306/week_time", "root", "123456");
        Connection connection = jdbcUtil.connect();
        String sql = "select * from student";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getMetaData().getColumnName(1));
        }
    }

    private String url;
    private String username;
    private String password;

    public JdbcUtil(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * <p> 获取DataSource使用Hikari </p>
     *
     */
    public DataSource getHikariDataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(this.url);
        configuration.setUsername(this.username);
        configuration.setPassword(this.password);
        return new HikariDataSource(configuration);
    }

    /**
     * <p> 建立连接 </p>
     *
     */
    private Connection connect() throws SQLException {
        return getHikariDataSource().getConnection();
    }

    /**
     * <p> 回滚 </p>
     *
     */
    public void rollback(Connection connection) {
        if (Objects.nonNull(connection)) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeJDBCResourceQuiet(Connection connection, Statement preparedStatement, ResultSet resultSet) {
        if (Objects.nonNull(resultSet)) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (Objects.nonNull(preparedStatement)) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
