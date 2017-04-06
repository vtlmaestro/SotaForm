package dao;

public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";
    public static final String INSERT_MOVIE = "Insert into movie (title, description, duration, rent_start, rent_end, genre, rating) values (?,?,?,?,?,?,?)";
    public static final String UPDATE_MOVIE = "UPDATE movie SET title = ?, description = ?, duration = ?, rent_start = ?, rent_end = ?, genre = ?, rating = ?, WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE users SET login = ?, password = ?, first_name = ?, last_name = ?, email = ?, sex = ?, birthday = ?, role_id = ?, WHERE id = ?";
    public static final String INSERT_USER = "Insert into users (login, password, first_name, last_name, email, sex, birthday, role_id) values (?,?,?,?,?,?,?,?)";
}
