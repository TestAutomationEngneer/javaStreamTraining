package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSqlScriptCommand implements ConnectionCommand {
    private String path;

    ExecuteSqlScriptCommand(String path) {
        this.path = path;
    }


    @Override
    public void using(Connection connection) throws SQLException {
        try(Statement statement = connection.createStatement())
        {
            String sqlScript = ResourceUtils.GetRecourceContent(path);
            statement.execute(sqlScript);

            if (!connection.getAutoCommit()) {
                connection.commit();
            }
        }
    }
}
