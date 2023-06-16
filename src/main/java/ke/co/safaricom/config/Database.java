package ke.co.safaricom.config;

import org.sql2o.Sql2o;

public class Database {
    private static final Sql2o connect = new Sql2o(
            "jdbc:postgresql://localhost:5432/wildlife_tracker",
            "postgres",
            "22709689"
    );

    public static Sql2o getConnect() {

        return connect;
    }
}
