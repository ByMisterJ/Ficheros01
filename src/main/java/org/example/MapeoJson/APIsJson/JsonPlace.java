package org.example.MapeoJson.APIsJson;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.MapeoJson.personas.Personas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static org.example.MapeoJson.Constant.JSON_MAPPER;

public class JsonPlace {

    public static void main(String[] args) {
        try {
            // URL de la API JSONPlaceholder para obtener la lista de tareas
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

                // Procesar la respuesta JSON y almacenarla en ArrayList
                ArrayList<Todo> todoList = parseJsonResponse(response.toString());

                // Imprimir el ArrayList (opcional)
                for (Todo todo : todoList) {
                    System.out.println(todo);
                }
            } else {
                System.out.println("Error al realizar la solicitud. Código de respuesta: " + responseCode);
            }

            // Cerrar la conexión
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para analizar la respuesta JSON y crear objetos Todo
    private static ArrayList<Todo> parseJsonResponse(String jsonResponse) {
        ArrayList<Todo> todoList = new ArrayList<>();

        // Analizar la cadena JSON y crear objetos Todo
        // Aquí deberías implementar tu propio código de análisis JSON

        // Ejemplo simple de análisis (puede necesitar ajustes según la estructura exacta de tu JSON)
        String[] todoItems = jsonResponse.split("\\},\\s*\\{");
        for (String item : todoItems) {
            String[] fields = item.split(",");
            int userId = Integer.parseInt(fields[0].split(":")[1].trim());
            int id = Integer.parseInt(fields[1].split(":")[1].trim());
            String title = fields[2].split(":")[1].trim();
            boolean completed = Boolean.parseBoolean(fields[3].split(":")[1].trim());

            Todo todo = new Todo(userId, id, title, completed);
            todoList.add(todo);
        }

        return todoList;
    }

    // Clase para representar una tarea (Todo)
    private static class Todo {
        int userId;
        int id;
        String title;
        boolean completed;

        public Todo(int userId, int id, String title, boolean completed) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.completed = completed;
        }

        @Override
        public String toString() {
            return "Todo{" +
                    "userId=" + userId +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", completed=" + completed +
                    '}';
        }
    }
}