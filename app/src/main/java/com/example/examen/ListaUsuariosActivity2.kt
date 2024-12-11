package com.example.examen

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListaUsuariosActivity2 : AppCompatActivity() {
    private lateinit var Datoscuenta: SharedPreferences
    private lateinit var atras: ImageView
    private lateinit var eliminar: AppCompatButton
    private lateinit var datos: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_usuarios2)
        eliminar=findViewById(R.id.eliminar)
        Datoscuenta = getSharedPreferences("Datoscuenta", MODE_PRIVATE)
        atras = findViewById(R.id.atras)
        atras.setOnClickListener {
            finish()
        }
        datos = findViewById(R.id.datos)
        val nombre = Datoscuenta.getString("nombre", "")
        val email = Datoscuenta.getString("email", "")
        val keysToDisplay = listOf("nombre", "email") // List of keys to display
        var Cuentas = ""

        for (key in keysToDisplay) {
            Cuentas += "Nombre: $nombre\nEmail: $email\n"
        }
        //Haz que las sharedpreferences se muestren en el textview y guarden los datos
        datos.text = Cuentas
        eliminar.setOnClickListener {
            val editor = Datoscuenta.edit()
            editor.remove(email)
            editor.apply()
            finish()
        }


    }
}