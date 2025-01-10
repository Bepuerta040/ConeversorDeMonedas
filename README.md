proyecto de conversor de monedas en GitHub:

markdown
Copy code
# Conversor de Monedas

Este proyecto es un **conversor de monedas** desarrollado en Java que utiliza la API de Exchange Rate para obtener tasas de cambio actualizadas. Permite convertir monedas de manera dinámica y realizar operaciones como:

- Convertir de USD a otras monedas.
- Convertir de otras monedas a USD.
- Mostrar todas las tasas de cambio disponibles.

## Características

- **Interfaz interactiva:** Menú para seleccionar la operación deseada.
- **Actualización en tiempo real:** Obtención de datos de cambio mediante una API.
- **Manejo de errores:** Validación de entradas y manejo de fallos en la conexión a la API.

## Requisitos

- **Java 17** o superior.
- **Maven** para la gestión de dependencias.
- Dependencia externa: `org.json` para el manejo de respuestas JSON de la API.

## Configuración del Proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/ConversorDeMonedas.git
   cd ConversorDeMonedas
Instalar dependencias con Maven: Asegúrate de que Maven esté configurado en tu entorno y ejecuta:

bash
Copy code
mvn install
Ejecutar el programa:

Ejecuta el archivo principal ConversorDeMonedas.java desde tu IDE o terminal.
Uso
Al iniciar el programa, selecciona una opción del menú:

Convertir de USD a otra moneda.
Convertir de otra moneda a USD.
Mostrar todas las tasas de cambio disponibles.
Ingresa los valores solicitados (por ejemplo, cantidad y código de moneda).

El programa mostrará los resultados de la conversión en pantalla.

API Utilizada
Este proyecto utiliza la Exchange Rate API para obtener las tasas de cambio. Es necesario obtener una API Key para su uso.

Cómo obtener una API Key:
Regístrate en Exchange Rate API.
Copia tu API Key y reemplázala en la variable API_KEY del archivo ConversorDeMonedas.java.
Estructura del Proyecto
bash
Copy code
ConversorDeMonedas/
│
├── src/
│   └── ConversorDeMonedas.java    # Archivo principal
│
├── pom.xml                        # Archivo de configuración de Maven
├── README.md                      # Este archivo
└── .gitignore                     # Archivos a ignorar en Git
Próximos Pasos
Ampliar compatibilidad con más monedas.
Agregar pruebas unitarias con JUnit.
Desplegar el proyecto como una aplicación web o móvil.
Contribuciones
¡Las contribuciones son bienvenidas! Si deseas colaborar, por favor abre un issue o envía un pull request.

Licencia
Este proyecto está licenciado bajo la Licencia MIT. Puedes usarlo libremente para propósitos educativos y personales.

Autor
Brayan Steven Puerta Gallego

GitHub: Bepuerta040
LinkedIn: www.linkedin.com/in/brayan-steven-puerta-gallego-892347222
