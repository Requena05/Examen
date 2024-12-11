package com.example.examen

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var emailInput: TextInputEditText
    private lateinit var contraseniaInput: TextInputEditText
    private lateinit var loginButton: AppCompatButton
    private lateinit var crearCuentaButton: AppCompatButton
    private lateinit var campoemail:TextInputLayout
    private lateinit var campocontrasenia:TextInputLayout
    private lateinit var DatosLogin: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        campoemail=findViewById(R.id.username)
        emailInput=findViewById(R.id.username_input)
        campocontrasenia=findViewById(R.id.password)
        contraseniaInput=findViewById(R.id.password_input)
        loginButton=findViewById(R.id.entrar)
        crearCuentaButton=findViewById(R.id.crearcuenta)
        DatosLogin=getSharedPreferences("Datoscuenta", MODE_PRIVATE)


        loginButton.setOnClickListener {
            var email = emailInput.text.toString()
            var contrasenia = contraseniaInput.text.toString()
            if(DatosLogin.getString("email",email)==email && DatosLogin.getString("contraseña",contrasenia)==contrasenia){
                val intent = Intent(this, ListaUsuariosActivity2::class.java)
                startActivity(intent)
            }

        }
        crearCuentaButton.setOnClickListener {
            val intent = Intent(this, CrearCuentaActivity::class.java)
            startActivity(intent)


        }


    }
}