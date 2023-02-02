
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

    class ConnectToBDJdbcTemplate {

        private static JdbcTemplate jdbcTemplate;
        private static DataSource datasource;


        private  void shouldConnectToDB() {

            jdbcTemplate = new JdbcTemplate(datasource);
            await().atMost(5, TimeUnit.SECONDS)
                    .until(this::isRecordLoaded);
        }

        private boolean isRecordLoaded() {
            return jdbcTemplate.queryForList("Select * from actor").size() > 1;
        }

        private List<Map<String, Object>> getLoadedRecords() {
            return jdbcTemplate.queryForList("Select * from actor");
        }

    }

