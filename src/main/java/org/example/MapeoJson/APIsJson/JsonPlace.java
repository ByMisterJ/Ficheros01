package org.example.MapeoJson.APIsJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonPlace {

    public static void main(String[] args) {
        try {
            // URL de la API JSONPlaceholder para obtener la lista de usuarios
            URL url = new URL("https://jsonplaceholder.typicode.com/todos");

            // Abrir la conexión
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la solicitud
            connection.setRequestMethod("GET");

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Imprimir la respuesta JSON
                System.out.println(response.toString());
            } else {
                System.out.println("Error al realizar la solicitud. Código de respuesta: " + responseCode);
            }

            // Cerrar la conexión
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
