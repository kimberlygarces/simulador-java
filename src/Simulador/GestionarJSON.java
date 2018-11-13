package Simulador;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import vista.Simulacion;
import vista.Simulacion1;

public class GestionarJSON {

    public static void main(String[] args) {
        //Obtenemos el JSON
        //String json = realizarPeticion();
        //Lo mostramos
        //showJSON(json);
        //parseToProceso(json);
        
     
       Simulacion1 S = new Simulacion1();
       S.setVisible(true);
      
        
    }

    public static String realizarPeticion() throws IOException{

        StringBuffer response = null;


        URL obj = new URL("http://localhost/Simulador/webService.php");
        URLConnection con = (URLConnection) obj.openConnection();

        HttpURLConnection cone = (HttpURLConnection) obj.openConnection();

        //Añadimos la cabecera
       cone.setRequestMethod("POST");
        cone.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Enviamos la petición por POST
        con.setDoOutput(true);

        //Capturamos la respuesta del servidor
        int responseCode = cone.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + obj);

        //Recibimos los datos
        BufferedReader LeerJson = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        response = new StringBuffer();

        while ((inputLine = LeerJson.readLine()) != null) {
            response.append(inputLine);
        }
        //Mostramos la respuesta del servidor por consola
        System.out.println("Respuesta del servidor: " + response);
        System.out.println();
        //cerramos la conexión
        LeerJson.close();
        //Los mostramos por pantalla

 
        return response.toString();
    }

    public static Class<Proceso[]> ArrayProcesos(String json) {
        
        /// generamos un array para leer el JSON
        System.out.println("INFORMACIÓN OBTENIDA array");
        //Crear un Objeto JSON a partir del string JSON
        Object jsonObject = JSONValue.parse(json.toString());
        //Convertir el objeto JSON en un array
        JSONArray array = (JSONArray) jsonObject;
        //Iterar el array y extraer la información
       
        Class<Proceso[]> procesos = Proceso[].class;
        
        for (int i = 0; i < array.size(); i++) {
            
            JSONObject row = (JSONObject) array.get(i);
            
            String Pid = row.get("Pid").toString();
            String Nombre = row.get("Nombre").toString();
            String Prioridad = row.get("Prioridad").toString();
            String caracteres = row.get("caracteres").toString();
            //Mostrar la información en pantalla
            
            System.out.println("Pid: " + Pid + "|| Nombre: " + Nombre + "|| Prioridad: "
                    + Prioridad + "|| Caracteres: " + caracteres);

        }
               return procesos;

    }

    public static Proceso[] parseToProceso(String json) {

        //Generamos un vector para leer el JSON usamos las librerias de Gson
        Gson gson = new Gson();
        Proceso[] procesos;
        procesos = gson.fromJson(json,
                Proceso[].class);

        System.out.println("INFORMACIÓN OBTENIDA VECTOR");
        for (Proceso proceso : procesos) {
            System.out.println(proceso.calcularRafaga());
        }
        
        return procesos;
    }
    
    
        
 }

