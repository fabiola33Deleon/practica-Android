package modelo

import java.sql.Connection
import java.sql.DriverManager

class claseConexion {

    fun cadenaConexion(): Connection? {
        try{
            val ip ="jdbc:oracle:thin:@ 10.10.1.126:1521:xe"
            val usuario = "system"
            val contrasena = "desarrollo"

            val conexion = DriverManager.getConnection(ip, usuario,contrasena)
            return conexion
        }  catch (e: Exception){
            println("Este es el error:$e")
            return null
        }
    }
}