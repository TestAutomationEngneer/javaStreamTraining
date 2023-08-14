package DB;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ConnectionCommand {
    void using(Connection connection) throws SQLException;
}
