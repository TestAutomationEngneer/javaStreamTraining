package DB;

public class ExecuteSql {

    public static ExecuteSqlScriptCommand script(String path) {
        return new ExecuteSqlScriptCommand(path);
    }
}
