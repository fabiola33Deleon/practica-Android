package daniel.soriano.crudfabiola

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import modelo.claseConexion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rcvMusica)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
             //MANDAR A LLAMAR LOS ELEM
        val txtNombre = findViewById<EditText>(R.id.txtnombre)
        val txtduracion = findViewById<EditText>(R.id.txtduracion)
        val txtAutor = findViewById<EditText>(R.id.txtautor)
        val btnagregar= findViewById<Button>(R.id.btnagregar)

        //PROGRAMA EL BOTON
        btnagregar.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
                // crear objeto de la clase conexion
                val objconexion = claseConexion().cadenaConexion()

                //variable prepare stra....
                val addmusica = objconexion?.prepareStatement( "insert into tbMusica values (?,?,?)")!!
                addmusica.setString( 1,txtNombre.text.toString())
                addmusica.setInt(2,txtduracion.text.toString().toInt())
                addmusica.setString( 3,txtAutor.text.toString())
                addmusica.executeUpdate()
            }
        }
        }
    }
