# Contador de pajas

Programa en Java para contar las pajas que os haceis en grupo (no necesariamente en persona) y comentáis en un grupo de whatsapp para presumir posteriormente en clase.
Para el caso, solo funciona si las pajas se marcan con el emoticono del tick verde en los mensajes.

## Requisitos de Configuración

1. **Clases Java**: Copia todos los archivos `.java` (clases) del proyecto original a la carpeta `src` de tu proyecto en Eclipse o en el entorno que prefieras.
2. **Archivos de Chat**: Ubica los archivos de chat exportados (normalmente en formato `_chat.txt`) en el directorio principal del proyecto, fuera de las carpetas `src` y `bin`.
3. **Archivo `version.txt`**: Crea un archivo vacío llamado `version.txt` en el directorio principal del proyecto. Este archivo es necesario para evitar problemas de compilación.

## Ejecución del Programa

1. Ejecuta el programa desde `Main.java`.
2. Cuando el programa inicie, solicitará el nombre del archivo del chat. Introduce el nombre del archivo sin la extensión `.txt` (por ejemplo, si el archivo se llama `_chat.txt`, solo ingresa `_chat`).
3. Una vez introducido el nombre del archivo, selecciona la opción **"Purgar"**. Esta opción filtrará todos los mensajes sin ticks verdes y procesará únicamente los mensajes relevantes.

## Exportación del Chat de WhatsApp

Para generar un archivo de entrada, exporta un chat de WhatsApp del grupo de interés y guarda el archivo exportado (en formato `_chat.txt`) en el directorio principal del proyecto.

---

