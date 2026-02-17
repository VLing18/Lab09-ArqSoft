import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class GimnasioApi {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Ruta para obtener miembros
        server.createContext("/api/miembros", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("GET".equals(exchange.getRequestMethod())) {
                    try {
                        DatabaseConexion db = new DatabaseConexion();
                        List<Miembro> miembros = db.obtenerMiembros();
                        
                        // Construir el JSON de la lista
                        StringBuilder json = new StringBuilder("[");
                        for (int i = 0; i < miembros.size(); i++) {
                            json.append(miembros.get(i).toJson());
                            if (i < miembros.size() - 1) json.append(",");
                        }
                        json.append("]");

                        byte[] response = json.toString().getBytes("UTF-8");
                        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                        exchange.sendResponseHeaders(200, response.length);
                        OutputStream os = exchange.getResponseBody();
                        os.write(response);
                        os.close();
                    } catch (Exception e) {
                        e.printStackTrace(); // Log del error en consola del servidor
                        String errorMsg = "{\"error\": \"Error interno del servidor\"}";
                        byte[] response = errorMsg.getBytes("UTF-8");
                        exchange.getResponseHeaders().set("Content-Type", "application/json");
                        exchange.sendResponseHeaders(500, response.length);
                        OutputStream os = exchange.getResponseBody();
                        os.write(response);
                        os.close();
                    }
                } else {
                    exchange.sendResponseHeaders(405, -1); // Método no permitido
                }
            }
        });

        server.setExecutor(null);
        System.out.println("API lista en http://localhost:8080/api/miembros");
        server.start();
    }
}