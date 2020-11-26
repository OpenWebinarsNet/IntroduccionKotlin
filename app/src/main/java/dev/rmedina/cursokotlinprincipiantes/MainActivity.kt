package dev.rmedina.cursokotlinprincipiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

val TAG = ":::TAG"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        condicionalesIf()
//        condicionalesWhen()
//        listados()
//        bucleFor()
//        bucleWhile()
//        bucleDoWhile()
//        controlDeErrores()
        botDeSeguridad()
    }

    private fun condicionalesIf() {
        val firstNumber = 10
        val secondNumber = 5
        val booleanValue = false

        if (firstNumber < secondNumber) {
            Log.d(TAG, "Primera opcion")

            if (secondNumber == 4) {
            } else {
            }
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opcion")
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opcion")
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opcion")
        } else {
            Log.d(TAG, "Tercera opcion")
        }

        val edad: Int = if (!booleanValue) {
            17
        } else {
            26
        }

        Log.d(TAG, edad.toString())
    }

    private fun condicionalesWhen() {
//        val language = "Scala"
//
//        when (language) {
//            "Kotlin", "Scala" -> {
//                Log.d(TAG, "Se ha seleccionado Kotlin")
//            }
//            "Java" -> Log.d(TAG, "Se ha seleccionado Java")
//            "Python" -> Log.d(TAG, "Se ha seleccionado Python")
//            "Ruby" -> Log.d(TAG, "Se ha seleccionado Ruby")
//            else -> Log.d(TAG, "Se ha seleccionado otro lenguaje")
//        }

        val myNumber = 94
        when (myNumber) {
            in 0..10 -> {
                Log.d(TAG, "Se ha seleccionado Kotlin")
            }
            40 -> {
                Log.d(TAG, "Se ha seleccionado Java")
            }
            in 80..119 -> {
                Log.d(TAG, "Se ha seleccionado Python")
            }
            120 -> {
                Log.d(TAG, "Se ha seleccionado Ruby")
            }
            else -> Log.d(TAG, "Se ha seleccionado otro lenguaje")
        }
    }

    private fun listados() {
        val myList = listOf("Rodrigo", "Raquel", "David", "Lorena", "Allison")
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "David", "Lorena", "Allison")

        val listItem = myList[2]

        myArrayList[2] = "Sandra"
        val arrayListItem = myArrayList[2]

        myArrayList.removeAt(3)

        Log.d(TAG, myArrayList.toString())
    }

    private fun bucleFor() {
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "David", "Lorena", "Allison")

//        for (persona in myArrayList) {
//            Log.d(TAG, persona)
//        }

//        for (position in 0 until 5) {
//            Log.d(TAG, position.toString())
//        }

//        for (position in 0..10 step 3) {
//            Log.d(TAG, position.toString())
//        }

        for (position in 10 downTo 3 step 2) {
            Log.d(TAG, position.toString())
        }
    }

    private fun bucleWhile() {
        var myNumber = 0

        while (myNumber <= 10) {
            Log.d(TAG, myNumber.toString())
            myNumber += 3
        }
    }

    private fun bucleDoWhile() {
        var myNumber = 1

        do {
            Log.d(TAG, myNumber.toString())
            myNumber++
        } while (myNumber <= 10)
    }

    private fun controlDeErrores() {
        val myArrayList = arrayListOf(1, 2, 3, 4, 5)
        val myString: String = "Hola"

        try {
            for (position in 0..myArrayList.size) {
                Log.d(TAG, myString)
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            Log.d(TAG, "Catch")
        } finally {
            Log.d(TAG, "Finally")
        }
    }


/*
1.- Crear una funcion que se llame botDeSeguridad() y llamarla desde nuestro metodo onCreate()
2.- Crear una clase de datos llamada Persona

Reglas:
1.- La clase de datos debe incluir tres constantes llamadas name, age y hobbies (que es un listado de strings)
2.- Creamos una variable de tipo Persona con nuestra información (nombre, edad y un listado de hobbies)
3.- Mediante el uso de condicionales nuestro bot debe:
    - Mostrarnos un mensaje de error en caso de que el nombre que tenga la clase Persona no sea el nuestro y
    no dejarnos acceder, o de lo contrario, mostrar el mensaje de éxito y continuar
    - Manejar los siguientes rangos de edad:
        - En caso de que tengamos entre 0 y 17 años, el bot nos dirá que somos menores de edad, y que por tanto
        acceso denegado, en caso de tener entre 65 y 100 nos diría lo mismo pero por ser demasiado mayores y si
        tenemos entre 18 y 64 años dejarnos pasar y mostrar un mensaje de éxito.
    - Por último, recorrer con un bucle nuestros hobbies y mostrarlos por pantalla
*/

    private fun botDeSeguridad() {
        val persona = Persona("Rodrigo", 63, arrayListOf("Programar", "TV", "Deportes"))

        if (persona.name == "Rodrigo") {
            Log.d(TAG, "Bienvenido ${persona.name}")

            when (persona.age) {
                in 0..17 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres demasiado joven para acceder.")
                }
                in 18..64 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres mayor de edad, bienvenido.")

                    for (hobby in persona.hobbies) {
                        Log.d(TAG, "Te gusta $hobby")
                    }
                }
                in 65..100 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres demasiado mayor para acceder.")
                }
            }
        } else {
            Log.d(TAG, "Largo de aquí ${persona.name}!")
        }
    }

    data class Persona(
            val name: String,
            val age: Int,
            val hobbies: ArrayList<String>
    )


}