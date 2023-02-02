public class Methods {
    private static Utils utils = new Utils();

    public static void main(String[] args) {
        String result = connectToDB(utils.getConnectionString(), true, 3);
        System.out.println(result);

    }

    private static String connectToDB(String connectionString, boolean security, int threads) {
        return String.format("DB connected with details %s", connectionString);
    }
}
