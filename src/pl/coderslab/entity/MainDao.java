package pl.coderslab.entity;

public class MainDao {
    public static void main(String[] args) {
        System.out.println("CREATE USER");
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("waldek");
        user.setEmail("waldek04@o2.pl");
        user.setPassword("pass");
        userDao.create(user);
        System.out.println(user);

        User user2 = new User();
        user2.setUsername("marek");
        user2.setEmail("marek14@wp.pl");
        user2.setPassword("passwd");
        userDao.create(user2);
        System.out.println(user2);

        User user3 = new User();
        user3.setUsername("przemek");
        user3.setEmail("przemko@wp.pl");
        user3.setPassword("haslo");
        userDao.create(user3);
        System.out.println(user3);

        System.out.println("READ USERS");
        // pobieranie i edycja użytkownika
        System.out.println("READ USER 2");
        User userToUpdate = userDao.read(2);
        if (userToUpdate != null) {
            userToUpdate.setUsername("Waldemar");
            userToUpdate.setEmail("waldek.kusn@gmail.com");
            userToUpdate.setPassword("superPassword");
            userDao.update(userToUpdate);

            System.out.println("READ UPDATED USER 2");
            // sprawdzamy czy poprawnie uaktualnione
            User usr = userDao.read(2);
            if (usr != null) {
                System.out.println(usr);
            }
        } else {
            System.out.println("User 2 doesnt exist");
        }

        System.out.println("READ USER 26");
        User userToUpdate2 = userDao.read(26);
        if (userToUpdate != null) {
            userToUpdate.setUsername("Marian");
            userToUpdate.setEmail("marian@wp.pl");
            userToUpdate.setPassword("haselko");
            userDao.update(userToUpdate);

            System.out.println("READ UPDATED USER 26");
            // sprawdzamy czy poprawnie uaktualnione
            User usr2 = userDao.read(26);
            if (usr2 != null) {
                System.out.println(usr2);
            }
        } else {
            System.out.println("User 26 doesnt exist");
        }

        System.out.println("DELETE USER 6");
        // usuwanie i lista użytkowników
        userDao.delete(6);
        User userToDelete = userDao.read(6);
        if (userToDelete != null) {
            System.out.println("User 6 not deleted: " + userToDelete);
        }

        System.out.println("FIND ALL");
        User[] all = userDao.findAll();
        if (all != null && all.length > 0) {
            System.out.println("All users: ");
            for (User u : all) {
                System.out.println(u);
            }
        }
    }
}
