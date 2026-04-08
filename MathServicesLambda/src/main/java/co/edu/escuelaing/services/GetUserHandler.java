package co.edu.escuelaing.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

/**
 * Handler Lambda para construir un "user" de ejemplo.
 *
 * Entrada: JSON con campos "name" y "email".
 * Salida: String con la representacion del usuario.
 */
public class GetUserHandler implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        String name = input.get("name");
        String email = input.get("email");
        return "User{" + "name='" + name + "', email='" + email + "'}";
    }
}
