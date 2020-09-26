package pl.coderslab.entity;

public class MainDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUsername("waldek");
//        user.setEmail("waldek04@o2.pl");
//        user.setPassword("pass");
//        userDao.create(user);

        // pobieranie i edycja użytkownika
        User userToUpdate = userDao.read(1);
        userToUpdate.setUsername("Waldemar");
        userToUpdate.setEmail("waldek.kusn@gmail.com");
        userToUpdate.setPassword("superPassword");
        userDao.update(userToUpdate);

        // usuwanie i lista użytkowników
//        userDao.delete(1);
//        User[] all = userDao.findAll();
//        for (User u : all) {
//            System.out.println(u);
//        }
    }
}
