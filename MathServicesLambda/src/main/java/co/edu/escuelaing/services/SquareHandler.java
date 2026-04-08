package co.edu.escuelaing.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SquareHandler implements RequestHandler<Integer, Integer> {

    @Override
    public Integer handleRequest(Integer input, Context context) {
        // Usamos el servicio estatico para calcular el cuadrado
        return MathServices.square(input);
    }
}
