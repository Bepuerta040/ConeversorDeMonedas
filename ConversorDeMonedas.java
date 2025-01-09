import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorDeMonedas {
    private static final String API_KEY = "052ce869ef9167aa2b3cbc71"; // API Key
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("1. Convertir de USD a otra moneda");
            System.out.println("2. Convertir de otra moneda a USD");
            System.out.println("3. Mostrar todas las tasas de cambio");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirDeUsd(scanner);
                    break;
                case 2:
                    convertirAUsd(scanner);
                    break;
                case 3:
                    mostrarTasasDeCambio();
                    break;
                case 4:
                    System.out.println("Gracias por usar el conversor.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void convertirDeUsd(Scanner scanner) {
        System.out.print("Ingrese la cantidad en USD: ");
        double cantidad = scanner.nextDouble();
        System.out.print("Ingrese la moneda destino (ejemplo: MXN, EUR): ");
        String monedaDestino = scanner.next().toUpperCase();

        double tasaCambio = obtenerTasaDeCambio("USD", monedaDestino);
        if (tasaCambio != -1) {
            double resultado = cantidad * tasaCambio;
            System.out.println("Resultado: " + cantidad + " USD = " + resultado + " " + monedaDestino);
        } else {
            System.out.println("Error al obtener la tasa de cambio.");
        }
    }

    private static void convertirAUsd(Scanner scanner) {
        System.out.print("Ingrese la cantidad en la moneda origen: ");
        double cantidad = scanner.nextDouble();
        System.out.print("Ingrese la moneda origen (ejemplo: MXN, EUR): ");
        String monedaOrigen = scanner.next().toUpperCase();

        double tasaCambio = obtenerTasaDeCambio(monedaOrigen, "USD");
        if (tasaCambio != -1) {
            double resultado = cantidad * tasaCambio;
            System.out.println("Resultado: " + cantidad + " " + monedaOrigen + " = " + resultado + " USD");
        } else {
            System.out.println("Error al obtener la tasa de cambio.");
        }
    }

    private static void mostrarTasasDeCambio() {
        System.out.println("Obteniendo todas las tasas de cambio desde la API...");
        obtenerYMostrarTasas("USD"); // Base es USD, pero puedes cambiarla según necesites
    }

    private static double obtenerTasaDeCambio(String origen, String destino) {
        try {
            String urlStr = BASE_URL + API_KEY + "/latest/" + origen;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error en la conexión: Código " + responseCode);
                return -1;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");

            return conversionRates.getDouble(destino);
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return -1;
        }
    }

    private static void obtenerYMostrarTasas(String base) {
        try {
            String urlStr = BASE_URL + API_KEY + "/latest/" + base;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error en la conexión: Código " + responseCode);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");

            System.out.println("Tasas de cambio basadas en " + base + ":");
            for (String moneda : conversionRates.keySet()) {
                System.out.println(base + " -> " + moneda + ": " + conversionRates.getDouble(moneda));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}
