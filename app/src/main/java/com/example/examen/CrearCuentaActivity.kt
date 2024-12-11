package com.example.examen

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CrearCuentaActivity : AppCompatActivity() {
    private lateinit var camponombre:TextInputLayout
    private lateinit var campocontraseña:TextInputLayout
    private lateinit var campoemail:TextInputLayout
    private lateinit var nombre: TextInputEditText
    private lateinit var contraseña: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var guardar: AppCompatButton
    private lateinit var Datoscuenta: SharedPreferences
    private lateinit var atras: ImageView
    private var checks=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear_cuenta)
        camponombre=findViewById(R.id.camponombre)
        campocontraseña=findViewById(R.id.campocontraseña)
        campoemail=findViewById(R.id.campoemail)
        nombre=findViewById(R.id.nombre)
        contraseña=findViewById(R.id.contraseña)
        email=findViewById(R.id.email)
        guardar=findViewById(R.id.guardar)
        Datoscuenta=getSharedPreferences("Datoscuenta", MODE_PRIVATE)
        atras=findViewById(R.id.atras)
        atras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        guardar.setOnClickListener {
            val nombre = nombre.text.toString()
            val contraseña = contraseña.text.toString()
            val email = email.text.toString()
            val editor = Datoscuenta.edit()
            if (nombre.isNotEmpty() && nombre.length < 16) {
                camponombre.error = null
                checks++
                editor.putString("nombre", nombre)
            }else{
                camponombre.error = "El campo no puede estar vacio o tener mas de 16 caracteres"
            }
            //si la contraseña esta vacia y si no encuentra una letra mayuscula, una minuscula y un numero y tiene que tener min 8 caracteres
            if (contraseña.isNotEmpty() && contraseña.length >= 8 &&
                contraseña.contains("[A-Z]".toRegex()) && contraseña.contains("[a-z]".toRegex()) && contraseña.contains("[0-9]".toRegex())) {
                campocontraseña.error =null
                checks++
                editor.putString("contraseña",contraseña)
            }else{
                campocontraseña.error = "El campo no puede estar vacio o no tiene un formato valido"

            }
            //el email no puede estar vacio y tiene que tener un formato de email valido
            if (email.isNotEmpty() && email.contains("@") && email.contains(".")) {
                campoemail.error =null
                checks++
                editor.putString("email", email)
            }else{
                campoemail.error = "El campo no puede estar vacio o no tiene un formato valido"
            }
            editor.apply()
            if (checks==3){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }



        }
    }
}