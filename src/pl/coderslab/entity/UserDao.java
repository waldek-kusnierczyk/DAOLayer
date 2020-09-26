package pl.coderslab.entity;

import java.sql.*;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    private static final String UPDATE_USER_QUERY =
            "UPDATE users set email=?, username=?, password=? WHERE id=?";

    private static final String READ_USER_QUERY =
            "SELECT email, username, password from users WHERE id=?";


    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id=?";


    private static final String READALL_USER_QUERY =
            "SELECT id, email, username, password FROM users";

    public String hashPassword(String password) {
        //return BCrypt.hashpw(password, BCrypt.gensalt());
        return password;
    }

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    // wczytanie użytkownika po jego id,
    public User read(int userId) {
    /*
    W ramach metody należy wykonać:
        pobrać z bazy danych wiersz dla zadanego identyfikatora
        utworzyć nowy obiekt klasy User
        uzupełnić obiekt danymi z bazy
        zwrócić uzupełniony obiekt
     */
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(userId);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    // edycja danych użytkownika
    public void update(User user) {
    /*
    Metoda przyjmuje obiekt klasy User, który powinien posiadać wypełnione atrybuty, (userName, email, password, id),
    Metoda nic nie zwraca.
    W ramach metody należy zmienić dane w bazie na podstawie danych z obiektu.
     */
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // usunięcia użytkownika
    public void delete(int userId) {
    /*
    Metoda przyjmuje identy kator na podstawie, którego należy w bazie danych pobrać wiersz.
    Metoda nic nie zwraca.
    W ramach metody należy usunąć wiersz z bazy danych na podstawie przekazanego identy katora.
     */
    }

    // wczytanie wszystkich użytkowników
    public User[] findAll() {
    /*
    W ramach metody należy wykonać:
        pobrać z bazy danych wszystkie wiersze z tabeli users
        na podstawie każdego wiersza utworzyć obiekt klasy User
        obiekty umieścić w tablicy
        zwrócić tablicę obiektów
        Będziemy również potrzebować mechanizmu, który pozwoli nam automatycznie powiększać tablicę.
     */
        return null;
    }
}
