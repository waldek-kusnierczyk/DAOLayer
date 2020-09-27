package pl.coderslab.entity;

import java.util.Random;

public class MainDao {
    public static void main(String[] args) {
        System.out.println("CREATE USER");
        UserDao userDao = new UserDao();
        User user = new User();
        String name = "user"+new Random().nextInt(100);
        user.setUsername(name);
        user.setEmail(name+"@o2.pl");
        user.setPassword("pass");
        User createdUser = userDao.create(user);
        System.out.println("Created user: " + createdUser);

        User user2 = new User();
        String name2 = "user2_"+new Random().nextInt(100);
        user2.setUsername(name2);
        user2.setEmail(name2+"@wp.pl");
        user2.setPassword("passwd");
        User createdUser2 = userDao.create(user2);
        System.out.println("Created user: " + createdUser2);

        User user3 = new User();
        String name3 = "user3_"+new Random().nextInt(100);
        user3.setUsername(name3);
        user3.setEmail(name3+"@gmail.pl");
        user3.setPassword("haslo");
        User createdUser3 = userDao.create(user3);
        System.out.println("Created user: " + createdUser3);

        System.out.println("READ USERS");
        // pobieranie i edycja użytkownika
        System.out.println("READ USER 2");
        User userToUpdate = userDao.read(2);
        if (userToUpdate != null) {
            String name4 = "user_"+new Random().nextInt(100);
            userToUpdate.setUsername(name4);
            userToUpdate.setEmail(name4+"@gmail.com");
            userToUpdate.setPassword("superPassword");
            System.out.println("Users data to update to: " + userToUpdate);
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
        if (userToUpdate2 != null) {
            String name4 = "user_"+new Random().nextInt(100);
            userToUpdate2.setUsername(name4);
            userToUpdate2.setEmail(name4+"@gmail.com");
            userToUpdate2.setPassword("haselko");
            System.out.println("Users data to update to: " + userToUpdate);
            userDao.update(userToUpdate2);

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
