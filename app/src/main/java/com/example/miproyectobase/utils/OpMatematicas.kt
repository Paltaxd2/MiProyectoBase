package com.example.miproyectobase.utils

object OpMatematicas {

    /*
    * funcion sumar
    * recibe 2 parametros
    * retorna un Numero entero numerico
     */
    fun sumar(n1: Int, n2: Int): Int{
        return n1 + n2
    }

    fun restar(n1: Int, n2: Int): Int{
        return n1 - n2
    }

    fun dividir(n1: Int, n2: Int): Int{
        try {
            return n1 / n2
        }catch (e: ArithmeticException){
            return 0
        }finally {
            println("se ha producido un error aritmetico")
        }
    }
    fun multiplicar(n1: Int, n2: Int): Int{
        return n1 * n2
    }

}