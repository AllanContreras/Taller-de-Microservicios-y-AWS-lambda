package co.edu.escuelaing.services;

public class MathServices {

    public static Integer square(Integer i) {
        return i * i;
    }

    // Ejemplo simple de "get user": retorna una representacion de usuario a partir de un id
    public static String getUser(Integer id) {
        return "User{" + "id=" + id + ", name='User" + id + "'}";
    }
}
